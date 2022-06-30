package clases;

import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
	
	protected static ArrayList<Cliente> clientes;

	protected static ArrayList<Articulo> articulos;
	protected static ArrayList<Servicio> servicios;//UNA VISITA GENERA UN SERVICIO
	protected static ArrayList<Factura> facturas;
	protected static double precioAlmorzar;
	protected static double precioCombustible;
	protected static ArrayList<Visita> visitas;
	protected static ArrayList<Tecnico> tecnicos;
	protected static ArrayList<TipoTecnico> tipoTecnicos;
	protected static ArrayList<Administrativo> administrativos;
	protected static ArrayList<Operador> operadores;
	protected static ArrayList<Administrador> administradores;
	
	//LA EMPRESA NO NECESITA EL ARRAYLIST DE AGENDAS.solo en de visitas y servicios
	protected static ArrayList<Agenda> agendas;
	//el stock es un diccionario(articulo, cantidad(puede ser en metros))
	protected static HashMap<TipoArticulo, Double> StockTotal;
	protected static HashMap<TipoArticulo, Double> CostodeMaterial;
	protected static HashMap<TipoTecnicoEnum, Double> CostoPorModulo;
	public Empresa() {
		Empresa.clientes = new ArrayList<>();
		Empresa.articulos = new ArrayList<>();
		Empresa.servicios = new ArrayList<>();
		Empresa.facturas = new ArrayList<>();
		Empresa.visitas = new ArrayList<>();
		Empresa.tecnicos = new ArrayList<>();
		Empresa.tipoTecnicos = new ArrayList<>();
		Empresa.administrativos = new ArrayList<>();
		Empresa.operadores = new ArrayList<>();
		Empresa.administradores = new ArrayList<>();
		Empresa.agendas = new ArrayList<>();
		//al crear la empresa
		//Empresa.StockTotal =StockTotalInicial();
		Empresa.StockTotal=new HashMap<TipoArticulo, Double>(); 
		Empresa.CostoPorModulo=CostosHoraInicial();
		Empresa.CostodeMaterial=new HashMap<TipoArticulo, Double>();
	}

	private HashMap<TipoArticulo, Double> CostosMaterialInicial() {
		//cargo a mano los costos iniciales
		
		HashMap<TipoArticulo, Double> CostodeMaterial=new HashMap<>();
		CostodeMaterial.put(TipoArticulo.CABLE, 200.0); //precio por metro
		CostodeMaterial.put(TipoArticulo.CONECTORES, 20.0);
		CostodeMaterial.put(TipoArticulo.DECODIFICADOR, 1000.0);
		CostodeMaterial.put(TipoArticulo.DIVISORES, 40.0);
		CostodeMaterial.put(TipoArticulo.MODEM, 600.0);
		
		return CostodeMaterial;
	}

	private HashMap<TipoTecnicoEnum, Double> CostosHoraInicial() {
		//"stock iniciales de la hora trabajada"
		HashMap<TipoTecnicoEnum, Double> CostosHoraInicial=new HashMap<>();
		CostosHoraInicial.put(TipoTecnicoEnum.JUNIOR, 300.0);
		CostosHoraInicial.put(TipoTecnicoEnum.SEMI_SENIOR, 600.0);
		CostosHoraInicial.put(TipoTecnicoEnum.SENIOR, 1200.0);
		
		return CostosHoraInicial;
	}

	private HashMap<TipoArticulo, Double> StockTotalInicial() {
		
		//"stock inicial_"
		HashMap<TipoArticulo, Double> Stocktotal=new HashMap<>();
		Stocktotal.put(TipoArticulo.CABLE, 2000.0);//metros
		Stocktotal.put(TipoArticulo.DECODIFICADOR, 800.0);
		Stocktotal.put(TipoArticulo.MODEM, 600.0);
		Stocktotal.put(TipoArticulo.DIVISORES, 1600.0);
		Stocktotal.put(TipoArticulo.CONECTORES, 1000.0);
	
		return Stocktotal;
		
	}

	public static void setearStockTotal(ArrayList<Articulo> articulos2) {
		// setea el stock total
		
		for(Articulo art:articulos) {
			TipoArticulo tipo =art.getTipo();
			double cant=art.getCantidad();
			Empresa.StockTotal.put(tipo, cant);
		}
		
	}

	public static void setearCostosMaterial(ArrayList<Articulo> articulos2) {

		for(Articulo art:articulos) {
			TipoArticulo tipo =art.getTipo();
			double costo=art.getCostos();
			Empresa.CostodeMaterial.put(tipo, costo);
		}
		
	}

	


}
