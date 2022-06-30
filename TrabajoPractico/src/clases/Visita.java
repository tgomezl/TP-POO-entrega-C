package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Visita {
	
//estosNO los modifica el tecnico
	private static int idVisitastatic=0;
	private int idVisita;
	private TipoServicio tipo;//instalacion o reparacion
	//OJO:la visita se crea SIN tecnicos en un principio
	private ArrayList<Tecnico> tecnicos;
	private int fechaVisita;
	private int horaInicio;
	private int horaFin;
	private TipoEstado estado; //programado en curso etc
	private Cliente cliente;
	private int cantModulos;

/*estos parametros son temporales. 
*el tecnico los modificara al terminar la visita
*/	private  double costosMateriales;
	private  double otroscostos;
	private double otrosgastos;
	private double gastos;
	private double TiempoTrabajado;
	private double CostoPorTiempoTrabajado;
	private  double cantcombustible;
	private  HashMap<TipoArticulo,Double> stockminimo;	
	private int tiempoAlmuerzo;
	
	
	
	public Visita(TipoServicio tipo, int fechaVisita, int horaInicio,
			int horaFin, TipoEstado estado, Cliente cliente,int cantModulos) {
		//la visita se crea SIN tecnicos, por eso el tiempo trabajado lo calculo despues 
		idVisitastatic++;
		this.idVisita = idVisitastatic;
		
		this.tipo = tipo;
		
		this.tecnicos =new ArrayList<>(); //se crea vacio!!!!!!
		this.fechaVisita = fechaVisita;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.estado = estado;
		this.cliente = cliente;
		this.otroscostos = 0;
		this.otrosgastos = 0;
		this.cantcombustible = 5;  //5 litros por defecto
		gastos=cantcombustible*Empresa.precioCombustible;
		this.costosMateriales=0;
		this.TiempoTrabajado = 0;//
		this.CostoPorTiempoTrabajado=0;
		
		this.tiempoAlmuerzo = 0; //por defecto
		this.stockminimo = new HashMap<TipoArticulo, Double>();
		this.cantModulos=cantModulos;
	}


	public static int getIdVisitastatic() {
		return idVisitastatic;
	}


	public static void setIdVisitastatic(int idVisitastatic) {
		Visita.idVisitastatic = idVisitastatic;
	}


	public int getIdVisita() {
		return idVisita;
	}


	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}


	public TipoServicio getTipo() {
		return tipo;
	}


	public void setTipo(TipoServicio tipo) {
		this.tipo = tipo;
	}


	public ArrayList<Tecnico> getTecnicos() {
		return tecnicos;
	}


	public int getFechaVisita() {
		return fechaVisita;
	}


	public int getHoraInicio() {
		return horaInicio;
	}

	public int getHoraFin() {
		return horaFin;
	}


	public void setHoraFin(int horaFin) {
		this.horaFin = horaFin;
	}


	public TipoEstado getEstado() {
		return estado;
	}


	public void setEstado(TipoEstado estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Visita [idVisita=" + idVisita + ", tipo=" + tipo +  ", fechaVisita="
				+ fechaVisita + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", estado=" + estado + 
				", tecnicos=" + tecnicos +" ]";
	}	
	public void agregarTecnicos(Tecnico tecnico) {
		//agrega un tecnico al ararylist de tecnicos
		 tecnicos.add(tecnico);
		
	}


	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return cliente;
	}


	public double getTiempoTrabajado() {
		// TODO Auto-generated method stub
		return TiempoTrabajado;
	}


	public void setStockminimoNecesario(HashMap<TipoArticulo, Double> stockminimo) {
		// seteo el stock minimo que necesita la visita
		this.stockminimo=stockminimo;
	}



	//ACONTINUACION LOS SETTERS PARA QUE LOS USE EL TECNICO
	//AL FINALIZAR LA VISITA
	
	public void setCombustible(double combustible) {
		// TODO Auto-generated method stub
		this.cantcombustible=combustible;
		gastos=gastos+combustible*Empresa.precioCombustible;
	}





	public void setTiempo(Double tiempoTrabajado) {
		// TODO Auto-generated method stub
		this.TiempoTrabajado=TiempoTrabajado;
	}


	public void setTiempoAlmuerzo(int tiempoAlmuerzo) {
		// TODO Auto-generated method stub
		this.tiempoAlmuerzo=tiempoAlmuerzo;
		if (tiempoAlmuerzo!=0) {
			gastos=gastos+Empresa.precioAlmorzar;
		}
	}


	public HashMap<TipoArticulo, Double> getStockInicial() {
		// TODO Auto-generated method stub
		return stockminimo;
	}


	public void AgregarStockAdicional(HashMap<TipoArticulo, Double> stockAdicional) {
		//se lo agrego al minimo que ya calcule
	
		//uso un set para recorrer el stock inicial!!!
		Set<TipoArticulo> tengo=stockminimo.keySet();		
		for (TipoArticulo hay : tengo) {
			stockminimo.replace(hay, stockminimo.get(hay)+stockAdicional.get(hay));
		}	
		//con el stock final puedo calcular el precio de materiales REAL
		agregarCostoMateriales(stockAdicional);
	}



	public double getTiempoAlmuerzo() {
		// TODO Auto-generated method stub
		return tiempoAlmuerzo;
	}


	public double getCombustle() {
		// TODO Auto-generated method stub
		return cantcombustible;
	}


	public void setOtrosCostos(double otroscostos) {
		// TODO Auto-generated method stub
		this.otroscostos=otroscostos;
		
	}


	public void setOtrosGastos(double gastos) {
		// TODO Auto-generated method stub
		this.otrosgastos=otrosgastos;
	}


	public void agregarCostoMateriales(HashMap<TipoArticulo, Double> stockminimo) {
		// usa el stock inicial para calcular un costo inicial de materiales
		//lo hace usando el diccionario de costos de la empresa
		Set<TipoArticulo> necesito= stockminimo.keySet();
		//System.out.println(necesito);
		double costo=0;
		for(TipoArticulo nece:necesito) {
			
			costo=costo+Empresa.CostodeMaterial.get(nece);
		}
		//System.out.println("------------------EL COSTO MINIMO de materiales PARA ESTA VISITA ES "+costo);
		costosMateriales=costo;
	}


	public void agregarTiempoTrabajado(int cantModulos) {
		// agrega
		this.TiempoTrabajado=this.TiempoTrabajado+ (double)cantModulos*30;
		//System.out.println("------------------------agregando tiempo trabajado");
		
	}


	public void agergarCostoTiempoTrabajado(TipoTecnicoEnum seniority, int cantModulos) {
		//agrega
		double cant=(double)cantModulos;
		//System.out.println("este tecnico cobra: "+Empresa.CostoPorModulo.get(seniority));
		//System.out.println("y va a trbajar "+cant + " modulos");
		double costoPorSeniority=Empresa.CostoPorModulo.get(seniority)*cant;
		this.CostoPorTiempoTrabajado=this.CostoPorTiempoTrabajado+costoPorSeniority;
		//System.out.println("--EL COSTO actual POR HORA DE ESTE SERVICIO ES: "+CostoPorTiempoTrabajado);
		
	}


	public int getCantModulos() {
		// TODO Auto-generated method stub
		return cantModulos;
	}


	public double getCostoMateriales() {
		// TODO Auto-generated method stub
		return costosMateriales;
	}


	public double getOtrosCostos() {
		// TODO Auto-generated method stub
		return otroscostos;
	}


	public double getOtrosGastos() {
		// TODO Auto-generated method stub
		return otrosgastos;
	}


	public double getCostoPorTiempoTrabajado() {
		// TODO Auto-generated method stub
		return CostoPorTiempoTrabajado;
	}


	public double getGastos() {
		// TODO Auto-generated method stub
		return gastos;
	}


	

	
}
