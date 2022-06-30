package clases;

import java.util.ArrayList;
import java.util.HashMap;

public class Servicio {

	private static int idServicio;
	private static TipoServicio tiposervicio;
	private Visita visita;
	private Factura factura;
	private static Cliente cliente;
	private double tiempoTrabajado;
	private double tiempoAlmuerzo;
	private double cantcombustible;
	private  HashMap<TipoArticulo,Double> stockfinalservicio;	
	private double CostoFinal;
	private static double gastos;
	private static double Otrosgastos;
	private TipoEstado estado; //programado en curso etc
	
	private TipoServicio tipo;//instalacion o reparacion
	//OJO:la visita se crea SIN tecnicos en un principio
	private ArrayList<Tecnico> tecnicos;
	private int fechaVisita;
	private int horaInicio;
	private int horaFin;
	private int cantModulos;
	private static  double costosMateriales;
	private static  double otroscostos;
	
	private double TiempoTrabajado;
	private static double CostoPorTiempoTrabajado;
	private  HashMap<TipoArticulo,Double> stockminimo;

	public Servicio(Visita visita) {
		
		this.idServicio = visita.getIdVisita();
		this.tiposervicio = visita.getTipo();
		this.visita = visita;
		this.factura = null; //se crea despues
		this.cliente = visita.getCliente();
		this.tiempoTrabajado = visita.getTiempoTrabajado();
		this.tiempoAlmuerzo = visita.getTiempoAlmuerzo();
		this.cantcombustible = visita.getCombustle();
		this.stockfinalservicio = visita.getStockInicial();
		
		this.gastos = visita.getGastos();
		this.estado = visita.getEstado();
		
		this.tipo = visita.getTipo();
		this.tecnicos = visita.getTecnicos();
		this.fechaVisita = visita.getFechaVisita();
		this.horaInicio = visita.getHoraInicio();
		this.cantModulos = visita.getCantModulos();
		this.costosMateriales = visita.getCostoMateriales();
		this.otroscostos = visita.getOtrosCostos();
		this.Otrosgastos = visita.getOtrosGastos();
		TiempoTrabajado = cantModulos*30;
		CostoPorTiempoTrabajado = visita.getCostoPorTiempoTrabajado();
		
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", tiposervicio=" + tiposervicio + ", visita=" + visita.getIdVisita()
				+ ", factura=" + factura + ", cliente=" + cliente + ", tiempoTrabajado=" + tiempoTrabajado
				+ ", tiempoAlmuerzo=" + tiempoAlmuerzo + ", cantcombustible=" + cantcombustible
				+ ", stockfinalservicio=" + stockfinalservicio + ", CostoFinal=" + CostoFinal + ", gastos=" + gastos
				+ ", estado=" + estado + ", tipo=" + tipo + ", tecnicos=" + tecnicos + ", fechaVisita=" + fechaVisita
				+ ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", cantModulos=" + cantModulos
				+ ", costosMateriales=" + costosMateriales + ", otroscostos=" + otroscostos + ", otrosgastos="
				+ Otrosgastos  + ", TiempoTrabajado=" + TiempoTrabajado
				+ ", CostoPorTiempoTrabajado=" + CostoPorTiempoTrabajado + ", stockminimo=" + stockminimo + "]";
	}

	public static int getIdServicio() {
		// TODO Auto-generated method stub
		return idServicio;
	}

	public static TipoServicio getTipoServicio() {
		// TODO Auto-generated method stub
		return tiposervicio;
	}

	public static Cliente getCliente() {
		// TODO Auto-generated method stub
		return cliente;
	}

	public static double calcularCostoTotal() {
		// TODO Auto-generated method stub
		return costosMateriales + otroscostos +	CostoPorTiempoTrabajado;
		
		
	}

	public static double calcularGastoTotal() {
		// TODO Auto-generated method stub
		return gastos +Otrosgastos;
	}	
	
//HAY QUE MODIFICAR LA CREACION DEL SERVOCIO!!!!!
	

	
}

