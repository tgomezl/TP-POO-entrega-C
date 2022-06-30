package clases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;

public class Controlador extends Empresa {

	private static Cliente cliente;
	private static Tecnico tecnico;
	private static Operador operador;
	private static Administrativo administrativo;
	private static Administrador administrador;
	private static Articulo articulo;
	private static TipoTecnico tipoTecnico;
	private static Visita visita;
	

	public static void crearServicio(int dni) {

	}

	public static void crearVisita() {

	}

	public static Administrador crearAdministrador(String nombre, String apellido, int dni, char sexo,
			int fechaNacimiento, String direccion, String telefono, String usuario, String contrasena) {

		administrador = buscarAdministrador(dni);
		boolean existeUsuario = buscarUsuario(usuario);

		if (administrador == null && existeUsuario == false) {
			administrador = new Administrador(buscarIdMaximo("Administrador").get(1), nombre, apellido, dni, sexo,
					fechaNacimiento, direccion, telefono, usuario, contrasena);
			administradores.add(administrador);
			return administrador;
		} else if (administrador != null && existeUsuario == true) {
			administrador = new Administrador();
			administrador.setDni(-1);
			administrador.setUsuario("-1");
			return administrador;
		} else if (existeUsuario == true) {
			administrador = new Administrador();
			administrador.setUsuario("-1");
			return administrador;
		} else {
			administrador = new Administrador();
			administrador.setDni(-1);
			return administrador;
		}

	}

	public static Administrativo crearAdministrativo(String nombre, String apellido, int dni, char sexo,
			int fechaNacimiento, String direccion, String telefono, String usuario, String contrasena) {

		administrativo = buscarAdministrativo(dni);
		boolean existeUsuario = buscarUsuario(usuario);

		if (administrativo == null && existeUsuario == false) {
			administrativo = new Administrativo(buscarIdMaximo("Administrador").get(1), nombre, apellido, dni, sexo,
					fechaNacimiento, direccion, telefono, usuario, contrasena);
			administrativos.add(administrativo);
			return administrativo;
		} else if (administrativo != null && existeUsuario == true) {
			administrativo = new Administrativo();
			administrativo.setDni(-1);
			administrativo.setUsuario("-1");
			return administrativo;
		} else if (existeUsuario == true) {
			administrativo = new Administrativo();
			administrativo.setUsuario("-1");
			return administrativo;
		} else {
			administrativo = new Administrativo();
			administrativo.setDni(-1);
			return administrativo;
		}

	}

	public static Operador crearOperador(String nombre, String apellido, int dni, char sexo, int fechaNacimiento,
			String direccion, String telefono, String usuario, String contrasenia) {

		operador = buscarOperador(dni);
		boolean existeUsuario = buscarUsuario(usuario);

		if (operador == null && existeUsuario == false) {
			operador = new Operador(buscarIdMaximo("Operador").get(1), nombre, apellido, dni, sexo, fechaNacimiento,
					direccion, telefono, usuario, contrasenia);
			operadores.add(operador);
			return operador;
		} else if (operador != null && existeUsuario == true) {
			operador = new Operador();
			operador.setDni(-1);
			operador.setUsuario("-1");
			return operador;
		} else if (existeUsuario == true) {
			operador = new Operador();
			operador.setUsuario("-1");
			return operador;
		} else {
			operador = new Operador();
			operador.setDni(-1);
			return operador;
		}

	}

	public static Tecnico crearTecnico(String nombre, String apellido, int dni, char sexo, int fechaNacimiento,
			String direccion, String telefono, String usuario, String contrasenia, TipoTecnico tipo, TipoTurno turno) {

		// Tecnico tecnico = new Tecnico();

		tecnico = buscarTecnico(dni);
		boolean existeUsuario = buscarUsuario(usuario);

		TipoTecnicoEnum tt = null;

		for (TipoTecnicoEnum t : TipoTecnicoEnum.values()) {
			if (tipo.getTipo().toString().equals(t.toString()))
				tt = t;
		}

		if (tecnico == null && existeUsuario == false) {
			System.out.println("CUMPLE LAS CONDICIONES");
			tecnico = new Tecnico(buscarIdMaximo("Tecnico").get(1), nombre, apellido, dni, sexo, fechaNacimiento,
					direccion, telefono, usuario, contrasenia, tt, turno);
			tecnicos.add(tecnico);
			return tecnico;
		} else if (tecnico != null && existeUsuario == true) {
			tecnico = new Tecnico();
			tecnico.setDni(-1);
			tecnico.setUsuario("-1");
			return tecnico;
		} else if (existeUsuario == true) {
			tecnico = new Tecnico();
			tecnico.setUsuario("-1");
			return tecnico;
		} else {
			tecnico = new Tecnico();
			tecnico.setDni(-1);
			return tecnico;
		}

	}

	public static Cliente crearCliente(String nombre, String apellido, int dni, char sexo, int fechaNacimiento,
			String direccion, String telefono) {

		cliente = buscarCliente(dni);

		if (cliente == null) {
			cliente = new Cliente(nombre, apellido, dni, sexo, fechaNacimiento, direccion, telefono);
			clientes.add(cliente);
			return cliente;
		} else {
			return null;
		}

	}

	public static Articulo crearArticulo(TipoArticulo tipoArt, int cantidades, double metros) {

		articulo = new Articulo(tipoArt, cantidades, metros);
		articulos.add(articulo);
		return articulo;

	}

	public static TipoTecnico crearTipoTecnico(TipoTecnicoEnum tipo, double valorHora, double valorCombustible,
			double costoViaje, boolean estado) {

		tipoTecnico = new TipoTecnico(tipo, valorHora, valorCombustible, costoViaje, estado);
		tipoTecnicos.add(tipoTecnico);
		return tipoTecnico;

	}

	public static Cliente buscarCliente(long dnicliente) {

		for (Cliente c : clientes) {
			if (c.getDni() == dnicliente)
				return c;
		}

		return null;

	}

	public static Tecnico buscarTecnico(long dni) {

		for (Tecnico t : tecnicos) {
			if (t.getDni() == dni)
				return t;
		}

		return null;

	}

	public static Administrativo buscarAdministrativo(int dni) {

		for (Administrativo a : administrativos) {
			if (a.getDni() == dni)
				return a;

		}

		return null;

	}

	public static Administrador buscarAdministrador(int dni) {

		for (Administrador a : administradores) {
			if (a.getDni() == dni)
				return a;
		}

		return null;

	}

	public static Operador buscarOperador(int dni) {

		for (Operador o : operadores) {
			if (o.getDni() == dni)
				return o;
		}

		return null;

	}
	


	public static String diaSemana(int dia, int mes, int ano) {
		String letraD = "";
		TimeZone timezone = TimeZone.getDefault();
		Calendar calendar = new GregorianCalendar(timezone);
		calendar.set(ano, mes - 1, dia);
		int nD = calendar.get(Calendar.DAY_OF_WEEK);
		// System.out.println("result","diaSemana: "+nD+" dia:"+dia+" mes:"+mes+ "a�o:"
		// +ano);
		switch (nD) {
		case 1:
			letraD = "D";
			break;
		case 2:
			letraD = "L";
			break;
		case 3:
			letraD = "M";
			break;
		case 4:
			letraD = "X";
			break;
		case 5:
			letraD = "J";
			break;
		case 6:
			letraD = "V";
			break;
		case 7:
			letraD = "S";
			break;
		}

		return letraD;
	}

	// carga los datos de la empresa al iniciarse
	public static void script() {
		Empresa empresa = new Empresa();

		// CLIENTES INICIALES

		Cliente cliente;
		cliente = new Cliente("Alejandro", "Salgado", 40997301, 'M', 19980308, "Lima 747", "1156937106");
		clientes.add(cliente);
		cliente = new Cliente("Tahiel", "Gomez", 40997302, 'M', 19980308, "Lima 747", "1156937106");
		clientes.add(cliente);
		cliente = new Cliente("Nehuen", "Perez", 40997303, 'M', 19980308, "Lima 747", "1156937106");
		clientes.add(cliente);
		cliente = new Cliente("Sol", "Begna", 40997304, 'F', 19980308, "Lima 747", "1156937106");
		clientes.add(cliente);
		cliente = new Cliente("Deborah", "Sanchez", 40997305, 'F', 19980308, "Lima 747", "1156937106");
		clientes.add(cliente);
		cliente = new Cliente("Horacio", "Ritondo", 40997306, 'M', 19980308, "Lima 747", "1156937106");
		clientes.add(cliente);

		// TIPO TECNICOS INICIALES
		TipoTecnico tipo;
		tipo = new TipoTecnico(TipoTecnicoEnum.JUNIOR, 500, 1000, 250, true);
		tipoTecnicos.add(tipo);
		tipo = new TipoTecnico(TipoTecnicoEnum.SEMI_SENIOR, 1500, 1000, 250, true);
		tipoTecnicos.add(tipo);
		tipo = new TipoTecnico(TipoTecnicoEnum.SENIOR, 2000, 1000, 250, true);
		tipoTecnicos.add(tipo);

		// TECNICOS INICIALES

		Tecnico tecnico;
		tecnico = new Tecnico(buscarIdMaximo("Tecnico").get(1), "Mario", "Santos", 75899456, 'M', 19820605, "brigada A",
				"0303456", "tec01", "1111", TipoTecnicoEnum.SENIOR, TipoTurno.TARDE);
		tecnicos.add(tecnico);
		tecnico = new Tecnico(buscarIdMaximo("Tecnico").get(1), "Pablo", "Lampone", 75899457, 'M', 19820605,
				"brigada A", "0303456", "tec02", "2222", TipoTecnicoEnum.SEMI_SENIOR, TipoTurno.TARDE);
		tecnicos.add(tecnico);
		tecnico = new Tecnico(buscarIdMaximo("Tecnico").get(1), "Emilio", "Ravenna", 75899458, 'M', 19820605,
				"brigada A", "0303456", "tec03", "2222", TipoTecnicoEnum.JUNIOR, TipoTurno.MANIANA);
		tecnicos.add(tecnico);
		tecnico = new Tecnico(buscarIdMaximo("Tecnico").get(1), "facundo", "campazzo", 75899459, 'M', 19820605, "brigada A",
				"0303456", "tec01", "1111", TipoTecnicoEnum.SENIOR, TipoTurno.MANIANA);
		tecnicos.add(tecnico);
		tecnico = new Tecnico(buscarIdMaximo("Tecnico").get(1), "juan martin", "delpotro", 75899460, 'M', 19820605, "brigada A",
				"0303456", "tec01", "1111", TipoTecnicoEnum.SEMI_SENIOR, TipoTurno.MANIANA);
		tecnicos.add(tecnico);
		tecnico = new Tecnico(buscarIdMaximo("Tecnico").get(1), "federico", "delbonis", 75899461, 'M', 19820605, "brigada A",
				"0303456", "tec01", "1111", TipoTecnicoEnum.SEMI_SENIOR, TipoTurno.MANIANA);
		tecnicos.add(tecnico);

		// ADMINISTRATIVOS INICIALES:
		Administrativo admin = new Administrativo(buscarIdMaximo("Administrativo").get(1), "Gabriel", "Medina",
				75899400, 'M', 19820605, "brigada A", "0303456", "admin01", "1111");
		administrativos.add(admin);
		admin = new Administrativo(buscarIdMaximo("Administrativo").get(1), "Maximo", "Cozetti", 75899401, 'M',
				19820605, "brigada A", "0303456", "admin02", "2222");
		administrativos.add(admin);

		// OPERADORES INICIALES:
		Operador ope = new Operador(buscarIdMaximo("Operador").get(1), "Gabriel", "Medina", 75899419, 'M', 19820605,
				"brigada A", "0303456", "oper01", "1111");
		operadores.add(ope);
		ope = new Operador(buscarIdMaximo("Operador").get(1), "Maximo", "Cozetti", 75899417, 'M', 19820605, "brigada A",
				"0303456", "oper02", "2222");
		operadores.add(ope);

		// ADMINITRADOR INICIAL:
		Administrador adminSistema = new Administrador(buscarIdMaximo("Administrador").get(1), "Alejandro", "Salgado",
				40997354, 'M', 19980803, "Las Heras 1184", "1156937106", "admin", "admin");
		administradores.add(adminSistema);
		
		//ARTICULOS INICIALES
		Double cantidad;
		Articulo articulo;
		TipoArticulo tipo1;
		Double costo;
		
		//CABLE
		tipo1=TipoArticulo.CABLE;
		cantidad=2000.0; //metros
		costo=200.0;
		articulo=new Articulo(tipo1, cantidad, costo);
		articulos.add(articulo);
		
		//DECO
		tipo1=TipoArticulo.DECODIFICADOR;
		cantidad=800.0; 
		costo=1000.0;
		articulo=new Articulo(tipo1, cantidad, costo);
		articulos.add(articulo);
		
		//MODEM
		tipo1=TipoArticulo.MODEM;
		cantidad=600.0; 
		costo=700.0;
		articulo=new Articulo(tipo1, cantidad, costo);
		articulos.add(articulo);
		
		//DIVISORES
		tipo1=TipoArticulo.DIVISORES;
		cantidad=1600.0; 
		costo=100.0;
		articulo=new Articulo(tipo1, cantidad, costo);
		articulos.add(articulo);
		
		//CONECTORES
		tipo1=TipoArticulo.CONECTORES;
		cantidad=1000.0; 
		costo=500.0;
		articulo=new Articulo(tipo1, cantidad, costo);
		articulos.add(articulo);
		//System.out.println("     STOCK EMPRESA: "+Empresa.StockTotal);
		Empresa.setearStockTotal(articulos);
		//System.out.println("     STOCK EMPRESA: "+Empresa.StockTotal);
		//System.out.println("     costo stock : "+Empresa.CostodeMaterial);
		Empresa.setearCostosMaterial(articulos);
		//System.out.println("     costo stock : "+Empresa.CostodeMaterial);
		

		
	}

	

	private static boolean chequearVisitaConAgenda(Visita visitaAchequear) {
		// TODO Auto-generated method stub
		// recorrer la agenda y ver si se puede o no guardar la visita
		return true;
	}

	private static int calcularHoraFinalizacion(int horainicio, TipoServicio tipo) {
		// TODO Auto-generated method stub
		return horainicio + 3;
	}

	private static double calcularGastos(TipoServicio tipo) {
		// TODO Auto-generated method stub
		return 4000;
	}

	private static double calcularCostos(TipoServicio tipo) {
		// TODO Auto-generated method stub
		return 8000;
	}

	private static ArrayList<Tecnico> calcularTecnicosDisponibles() {
		// TODO Auto-generated method stub
		ArrayList<Tecnico> tecnicosDisponibles = new ArrayList<>();
		tecnicosDisponibles.add(tecnicos.get(0));
		// hay que implementar esta logica!!!!!!
		return tecnicosDisponibles;
	}

	public static int calcularTiempo(TipoServicio tipo) {
		int tiempo = 0;
		if (tipo == TipoServicio.INSTALACION)
			tiempo = 3; // 3 horas
		else if (tipo == TipoServicio.REPARACION)
			tiempo = 2; // 2 horas.
		return tiempo;
	}

	public static ArrayList<Articulo> calcularMateriales(TipoServicio tipo) {
		ArrayList<Articulo> articulosnecesarios = new ArrayList<>();

		if (tipo == TipoServicio.INSTALACION)
			// vas a necesitar

			articulosnecesarios.add(articulos.get(0));
		else if (tipo == TipoServicio.REPARACION)
			articulosnecesarios.add(articulos.get(1));
		return articulosnecesarios;
	}

	public static ArrayList<TipoTecnico> obtenerTiposTecnicos() {
		return tipoTecnicos;
	}

	public static void listarTecnicos() {
		System.out.println(" ");
		System.out.println("lista de tecnicos en la empresa:");
		for (Tecnico t : tecnicos) {
			System.out.println(t.toString());
		}
	}

	public static void listarAdministrativos() {
		for (Administrativo a : administrativos) {
			System.out.println(a.toString());
		}
	}

	public static void listarAdministradores() {
		for (Administrador a : administradores) {
			System.out.println(a.toString());
		}
	}

	public static void listarTiposTecnicos() {
		for (TipoTecnico t : tipoTecnicos) {
			System.out.println(t.toString());
		}
	}

	public static void listarOperadores() {
		for (Operador o : operadores) {
			System.out.println(o.toString());
		}
	}

	public static void verServicios() {
		for (Servicio servicio : servicios) {
			System.out.println(servicio);
		}

	}

	public static void listarVisitas() {
		// TODO Auto-generated method stub
		
		if(!visitas.isEmpty()) {
			System.out.println("mostrando todas las visitas  ");
			for (Visita visita : visitas) {
				System.out.println("----------------------------------");
				System.out.println("id de visita : " + visita.getIdVisita());
				System.out.println("cliente: "+visita.getCliente().getNombre() +" con dni: "+visita.getCliente().getDni());
				System.out.println(" horainicio: "+ visita.getHoraInicio());
				System.out.println(" horafin " + visita.getHoraFin());
				System.out.println("dia : "+visita.getFechaVisita());
				System.out.println("ESTADO : "+visita.getEstado());
				ArrayList<Tecnico> tecnicosAsignados=visita.getTecnicos();
				for(Tecnico tec:tecnicosAsignados) {
					System.out.println("el tecnico de esta visita  es "+tec.getNombre() +" su dni es: "+tec.getDni());
				}
			}
		}else {
			System.out.println("no hay visitas ");
		}
		
	}

	public static void agregarVisita(Visita visita) {
		visitas.add(visita);

	}

	public static void agregarFactura(Factura factura) {
		facturas.add(factura);

	}

	public static void verFacturas() {
		for (Factura factura : facturas) {
			System.out.println(facturas);
		}

	}

	public static ArrayList<Integer> buscarIdMaximo(String tipo) {

		ArrayList<Integer> idCliente = new ArrayList<>();
		ArrayList<Integer> legajo = new ArrayList<>();
		ArrayList<Integer> datos = new ArrayList<>();
		int idMaximo = 0;
		int legajoMax = 0;

		for (Tecnico t : tecnicos) {
			legajo.add(t.getLegajo());
		}

		for (Operador o : operadores) {
			legajo.add(o.getLegajo());
		}

		for (Administrativo a : administrativos) {
			legajo.add(a.getLegajo());
		}

		for (Administrador a : administradores) {
			legajo.add(a.getLegajo());
		}

		switch (tipo) {

		case "Cliente":
			for (Cliente c : clientes) {
				idCliente.add(c.getIdCliente());
			}
			break;

		case "Tecnico":
			for (Tecnico t : tecnicos) {
				idCliente.add(t.getIdTecnico());
				// legajo.add(t.getLegajo());
			}
			break;

		case "Administrativo":
			for (Administrativo a : administrativos) {
				idCliente.add(a.getIdAdministrativo());
				// legajo.add(a.getLegajo());
			}
			break;

		case "Administrador":
			for (Administrador a : administradores) {
				idCliente.add(a.getIdAdmin());
				// legajo.add(a.getLegajo());
			}
			break;

		case "Operador":
			for (Operador o : operadores) {
				idCliente.add(o.getIdOperador());
				// legajo.add(o.getLegajo());
			}
			break;

		case "Articulo":
			for (Articulo a : articulos) {
				// idCliente.add(a.getIdArticulo());
			}
			break;

		case "Tipo Tecnico":
			for (TipoTecnico t : tipoTecnicos) {
				idCliente.add(t.getIdTipo());
			}
			break;

		}

		for (Integer i : idCliente) {
			if (i >= idMaximo)
				idMaximo = i;
		}

		for (Integer i : legajo) {
			if (i >= legajoMax)
				legajoMax = i;
		}

		datos.add(0, idMaximo + 1);
		datos.add(1, legajoMax + 1);

		return datos;
	}

	public static String nombreUsuario(String usuario) {

		String nombreUsuario = "";

		for (Operador o : operadores) {
			if (o.getUsuario().equals(usuario))
				nombreUsuario = o.getNombre() + " " + o.getApellido();
		}

		for (Administrativo a : administrativos) {
			if (a.getUsuario().equals(usuario))
				nombreUsuario = a.getNombre() + " " + a.getApellido();
		}

		for (Administrador a : administradores) {
			if (a.getUsuario().equals(usuario))
				nombreUsuario = a.getNombre() + " " + a.getApellido();
		}

		for (Tecnico t : tecnicos) {

			if (t.getUsuario().equals(usuario))
				nombreUsuario = t.getNombre() + " " + t.getApellido();

		}

		return nombreUsuario;

	}

	public static String loguin(String usuario, String contrasenia) {

		String tipoUsuario = "";

		for (Operador o : operadores) {
			if (o.getUsuario().equals(usuario) && o.getContrasenia().equals(contrasenia))
				tipoUsuario = "Operador";
		}

		for (Administrativo a : administrativos) {
			if (a.getUsuario().equals(usuario) && a.getContrasenia().equals(contrasenia))
				tipoUsuario = "Administrativo";
		}

		for (Administrador a : administradores) {
			if (a.getUsuario().equals(usuario) && a.getContrasenia().equals(contrasenia))
				tipoUsuario = "Administrador";
		}

		for (Tecnico t : tecnicos) {

			if (t.getUsuario().equals(usuario) && t.getContrasenia().equals(contrasenia))
				tipoUsuario = "Tecnico";

		}

		return tipoUsuario;

	}

	public static boolean buscarUsuario(String usuario) {

		boolean existeUsuario = false;

		for (Operador o : operadores) {
			if (o.getUsuario().equals(usuario))
				existeUsuario = true;
		}

		for (Administrativo a : administrativos) {
			if (a.getUsuario().equals(usuario))
				existeUsuario = true;
		}

		for (Administrador a : administradores) {
			if (a.getUsuario().equals(usuario))
				existeUsuario = true;
		}

		for (Tecnico t : tecnicos) {
			if (t.getUsuario().equals(usuario))
				existeUsuario = true;
		}

		return existeUsuario;

	}
	/*
	 * ****************************************************************
	 * ****************************************************************
	 * a partir de aca los cambios:
	 */
	
	//muestra la semana de UN tecnico en especifico
	public static void mostrarSemanaTecnico(long dni) {
		Tecnico tec=buscarTecnico(dni);
		if(tec!=null){
			System.out.println(" ");
			System.out.println("mostrando la semana del tecnico "+ tec.getNombre()+" con dni: "+dni);
			//imprime por pantalla su semana
			mostrarSemana(tec);
		}else {
			System.out.println("no existe ese tecnico");
		}
	}

	public static void mostrarSemana(Tecnico tec) {
		
		Visita[][] MatrizSemana = tec.getMatrizSemana();
		//filas
		int filaMax=MatrizSemana.length;
		//columnas
		int colMax=MatrizSemana[0].length;
		System.out.println(" ");
		System.out.println("mostrando la semana del tecnico "+ tec.getNombre()+" con dni: "+tec.getDni());
		System.out.println("********************************************");
		for(int fila=0; fila<filaMax; fila++) {
			for(int col=0; col<colMax; col++) {
				if(MatrizSemana[fila][col]!=null) {
					System.out.print( "ID-" +MatrizSemana[fila][col].getIdVisita() +"   ");
				}else {
					System.out.print(MatrizSemana[fila][col] + "   ");
				}
				
			}
			System.out.println("");
		}
		System.out.println("********************************************");

	}
	
	public static Visita AgendarVisitaACliente(int fechavisita, int horainicio,TipoServicio tipo,Cliente cliente) {
		System.out.println("  ");
		System.out.println("####################################################################");
		System.out.println("     intentando agendar una visita el dia " +fechavisita +" a las "+ horainicio);
		System.out.println(" el cliente es: "+cliente.getNombre()+ " su dni es " +cliente.getDni());
		Visita nuevavisita=null;
		//la duracion(cant de modulos) se calcula en base al tipoServicio
		int cantModulos=calcularDuracionVisita(tipo);
		int col=fechavisita;//valores entre(0y5)
			 //fechavista=0---->col=0---->lunes
			//fechavista=1---->col=1---->martes
			
			//fechavista=5---->col=5---->sabado
		
		System.out.println("la hora de inicio es "+horainicio);
		int filainicio=convertirHoraInicioAfila(horainicio);
		int filafin=filainicio+cantModulos;
		//System.out.println("la fila de fin es "+filafin);
		int horafin=convertirFilaFinAHora(filafin);
		
		//la horafin se calcula en base a la duracion
		//la cantidad de tecnicos se calcula en base al tiposervicio
		
		int cantTecnicosNecesarios=calcularCantTecnicosNecesarios();
		//veo la agenda del cleinte
			
		boolean clienteDisponible=true;
		clienteDisponible=verDisponibilidadCliente(cliente,col, filainicio, filafin);
		//System.out.println(" semana DEL CLEINTE ANTES");
		//mostrarSemanaCliente(cliente);
		//veo la agenda de el o los tecnicos necesarios
		TipoTurno turno;
		if(horainicio<1400) {
			turno=TipoTurno.MANIANA;
		}else {
			turno=TipoTurno.TARDE;
		}
		//System.out.println("el turno es: "+turno);
		ArrayList<Tecnico> tecnicosDisponibles=new ArrayList<>();
		tecnicosDisponibles= verTecnicosDisponibles(col, filainicio, filafin,tipo,turno);
		
		if(!tecnicosDisponibles.isEmpty() && clienteDisponible) {
			//muestro los tecnicos disponibles
			System.out.println(" ");
			System.out.println("los tecnicos disponibles para ese dia son: ");
			for(Tecnico tec:tecnicosDisponibles) {
				System.out.println(  tec.getNombre() + " con dni: " +tec.getDni() );
			}
			if(tecnicosDisponibles.size()>=cantTecnicosNecesarios) {
//#####################################
//#####################################
//#####################################
//#####################################
//ACA RECIEN CREO LA VISITA	.se crea como programada por defecto		
//#####################################
//#####################################
//#####################################
//creo la visita.inicialmente se crea SIN TECNICOS!!
				nuevavisita=new Visita(tipo,fechavisita,horainicio,horafin,TipoEstado.PROGRAMADO,cliente,cantModulos);
				
				
		//una visita implica crear un servicio(costos,materiales y demas)
				int cont=0;
				System.out.println(" ");
				for(Tecnico tec:tecnicosDisponibles) {
					if(cont<cantTecnicosNecesarios) {
						//agrego un tecnico a la visita
						
						System.out.println("el tecnico "+tec.getNombre() + " se asigno a la visita numero "+nuevavisita.getIdVisita());
						nuevavisita.agregarTecnicos(tec);
						nuevavisita.agregarTiempoTrabajado(cantModulos);
						nuevavisita.agergarCostoTiempoTrabajado(tec.getSeniority(),cantModulos);
						//A CADA tecnico que participa en la visita le modifico la matriz Agenda
						AgendarVisitaATecnico(tec,nuevavisita, col, filainicio, filafin);
						cont++;//necesito un tecnico menos
						
						//muestro como se modifica su semana
						//mostrarSemanaTecnico(tec.getDni());
					}
				
				}
				System.out.println("######### VISITA numero "+nuevavisita.getIdVisita()+ " CREADA CON EXITO ########### " );
				//le modifico la agenda al cliente
				ModificarAgendaACliente(cliente,nuevavisita, col, filainicio, filafin);
				//aca tengo que:
				//dado el tipo de instalacion,calcular el stock minimo necesario
				HashMap<TipoArticulo,Double> stockminimo=calcularStockminimoNecesario(tipo);
				//ver si hay stock necesario
				boolean haystock =chequearCantidadStock(stockminimo);
				nuevavisita.agregarCostoMateriales(stockminimo);
				//sino hay lo informo, pero la visita se crea igualmente
				
				//la visita PROGRMADA se crea igual.haya o no stock
				//---->puede haber stock negativo
				
			
				//el stock minimo que necesita la visita
				nuevavisita.setStockminimoNecesario(stockminimo);
				//agregar la visita al array list de visitas
				visitas.add(nuevavisita);
				
			}else {
				System.out.println("        no contamos con la cantidad suficiente de tecnicos para ese dia y horario");
			}
			
		}else {
			//veo que condicion fue la que fallo
			if(tecnicosDisponibles.isEmpty()) {
				System.out.println(" ");
				System.out.println("no hay NINGUN tecnico disponibles en ese horario");
				
			}else {
				System.out.println(" ");
				System.out.println("     NO SE PUDO AGENDAR LA VISITA");
				System.out.println("ya que el cliente tiene ese horario ocupado");
			}
			
		}
		
		return nuevavisita;
	}

	

	

	private static void ModificarAgendaACliente(Cliente cliente, Visita nuevavisita, int col, int filainicio,
			int filafin) {
		Visita[][] MatrizSemana=cliente.getMatrizSemana();
		
		for(int fila=filainicio; fila<filafin; fila++) {
			if(MatrizSemana[fila][col]==null) {
				MatrizSemana[fila][col]=nuevavisita;
			}
		}
		
	}

	public static void mostrarSemanaCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println(" ");
		System.out.println("semana del cliente con id: "+cliente.getIdCliente());
		Visita[][] MatrizSemana=cliente.getMatrizSemana();
		int filaMax=MatrizSemana.length;
		//columnas
		int colMax=MatrizSemana[0].length;
		System.out.println(" ");
		System.out.println("mostrando la semana del cliente "+ cliente.getNombre()+" con dni: "+cliente.getDni());
		System.out.println("********************************************");
		for(int fila=0; fila<filaMax; fila++) {
			for(int col=0; col<colMax; col++) {
				if(MatrizSemana[fila][col]!=null) {
					System.out.print( "ID-" +MatrizSemana[fila][col].getIdVisita() +"   ");
				}else {
					System.out.print(MatrizSemana[fila][col] + "   ");
				}
				
			}
			System.out.println("");
		}
		System.out.println("********************************************");
	}

	private static boolean verDisponibilidadCliente(Cliente cliente, int col, int filainicio, int filafin) {
		// recorro la agenda DEL cliente;
		boolean disponible=true;
		
		Visita[][] MatrizSemana=cliente.getMatrizSemana();
		
		int filamaxima=24;
		if(col==5) {
			//el sabado puedo recorrer menos filas
			//System.out.println("----------es sabado");
			filamaxima=12;
		}
		if(filainicio<0 || filafin>filamaxima) {
			//estas filas son imposbiles
			System.out.println("horarios fuera de rango ");
			disponible=false;
		}
		if(col<0 || col>5) {
			//estas columnas son imposbiles
			System.out.println("dias fuera de rango ");
			disponible=false;
		}
		for(int fila=filainicio;fila<filafin;fila++) {
			
			if(MatrizSemana[fila][col]!=null) {
				disponible=false;
			}
		}
		return disponible;
	}

	private static boolean chequearCantidadStock(HashMap<TipoArticulo, Double> stockminimo) {
		//compara los dos diccionarios
		boolean haystock=true;
		//convierto los dos diccionarios a set y los comparo entre si
		Set<TipoArticulo> necesito=stockminimo.keySet();
//este es el de la empresa!!!
		Set<TipoArticulo> tengo=StockTotal.keySet();
		
		for (TipoArticulo nece : necesito) {
			for (TipoArticulo hay : tengo) {
				if(nece==hay) {
					//cuando coinciden comparo las cantidades
					//sacadas de los diccionarios reales
					if(stockminimo.get(nece)>StockTotal.get(hay)) {
						haystock=false;
						System.out.println(" ");
						System.out.println("falta stock de "+nece);
						System.out.println(" COMPRAR");
						
						
					}else {
						//System.out.println("hay stock" );
					/*
					System.out.println("--------------------voy a necesitar ");
					System.out.println(stockminimo.get(nece));
					System.out.println("de " + nece+ " y tengo");
					System.out.println(StockTotal.get(hay));
					System.out.println("de " + hay);
					*/
					}
					//###########################################################
					//haya o no stock la visita se agenda igual---->entonces tiene sentido
					//que pueda haber stock negativo.
					//############################################################
		//decrmento el Stock:esto al final lo hace el admin
					//StockTotal.replace(hay, StockTotal.get(hay)-stockminimo.get(nece));
					//mostrarStockActual();
				}
			}
			
		}
		
		return haystock;
	}

	private static HashMap<TipoArticulo,Double> calcularStockminimoNecesario(TipoServicio tipo) {
		// TODO Auto-generated method stub
		HashMap<TipoArticulo,Double> stockminimo=new HashMap<>();
		if(tipo==tipo.INSTALACION) {
			//necesita metros
			//metros cable coaxial, canti decos,cant modems,cant divisor,cant conectores
			stockminimo.put(TipoArticulo.CABLE, 4.5);
			stockminimo.put(TipoArticulo.DECODIFICADOR, 1.0);
			stockminimo.put(TipoArticulo.MODEM, 1.0);
			stockminimo.put(TipoArticulo.DIVISORES, 1.0);
			stockminimo.put(TipoArticulo.CONECTORES, 6.0);
			
		}else {
			//reparacion. no especifica cual es el stock minimo
			stockminimo.put(TipoArticulo.CABLE, 2.0);
			stockminimo.put(TipoArticulo.DECODIFICADOR, 0.0);
			stockminimo.put(TipoArticulo.MODEM, 1.0);
			stockminimo.put(TipoArticulo.DIVISORES, 1.0);
			stockminimo.put(TipoArticulo.CONECTORES, 2.0);
		}
		return stockminimo;
	}

	private static void AgendarVisitaATecnico(Tecnico tec,Visita visita, int col, int filainicio, int filafin) {
		// TODO Auto-generated method stub
		Visita[][] MatrizSemana=tec.getMatrizSemana();
		for(int fila=filainicio;fila<filafin;fila++) {
			 MatrizSemana[fila][col]=visita;
		}
		
	}

	private static ArrayList<Tecnico> verTecnicosDisponibles(int col, int filainicio, int filafin,
			TipoServicio tipo,TipoTurno turno) {
		ArrayList<Tecnico> tecnicosDisponibles=new ArrayList<>();
			//recorro el arraylist "tecnicos" de la empresa
			//tener en cuenta el turno en que trabaja cada tecnico
			//accedo a la matriz semana de cada tecnico 
			//tener en cuenta los indices maximos y minimos de la matriz semana de cada tecnico
				
		int filamaxima=24;
		if(col==5) {
			//el sabado puedo recorrer menos filas
			//System.out.println("----------es sabado");
			filamaxima=12;
		}
		if(filainicio<0 || filafin>filamaxima) {
			//estas filas son imposbiles
			System.out.println("horarios fuera de rango ");
			return tecnicosDisponibles;
		}
		if(col<0 || col>5) {
			//estas columnas son imposbiles
			System.out.println("dias fuera de rango ");
			return tecnicosDisponibles;
		}
		
		
		
		for(Tecnico tec:tecnicos) {
			if(tec.getTurno()==turno) {
				//este tecnico paso el primer control
				Visita[][] SemanadeEsteTecnico=tec.getMatrizSemana();
				//recorro la semana de este tecnico, si esta disponible
				//lo agrego a "tecnicosDisponibles"
				boolean disponible=true;
				
				for(int fila=filainicio;fila<filafin;fila++) {
					if(SemanadeEsteTecnico[fila][col]!=null) {
						disponible=false;
					}
				}
				if(disponible) {
					tecnicosDisponibles.add(tec);
				}
				
			}//fin del for
		}	
		return tecnicosDisponibles;
	}

	private static int calcularCantTecnicosNecesarios() {
		//devuelve una cantidad al azar de tecnicos
		int cantTecnicos[] ={1,2};
		int num=(int) (Math.random()*2);
		System.out.println("se necesitan "+cantTecnicos[num]+" tecnicos para esta visita");
		return cantTecnicos[num];
	}

	private static int convertirHoraInicioAfila(int horainicio) {
		//mapea una hora con una fila de la matriz
		int[] listahoras= {800,830,900,930,1000,1030,1100,1130,1200,1230,1300,1330,
				1400,1430,1500,1530,1600,1630,1700,1730,1800,1830,1900,1930,2000};
		int fila=44;
		//un valor imposible;
		for(int i=0;i<listahoras.length;i++) {
			
			if(listahoras[i]==horainicio) {
				fila=i;
				//System.out.println("   la hora es "+horainicio + " la fila es "+fila);
				return fila;
			}
			
		}
		//System.out.println("la hora es "+horainicio + " la fila es "+fila);
		return fila;
		
		
		
	}
	
	private static int convertirFilaFinAHora(int filafin) {
		//mapea una fila de la matriz con la hora de fin
		int[] listahoras= {800,830,900,930,1000,1030,1100,1130,1200,1230,1300,1330,
						1400,1430,1500,1530,1600,1630,1700,1730,1800,1830,1900,1930,2000};
		System.out.println("la hora de fin es: "+ listahoras[filafin]);
		return listahoras[filafin];
		
	}

	private static int calcularDuracionVisita(TipoServicio tipo) {
		int cantmodulos=444;//valor imposible
		
		switch (tipo){
	        case INSTALACION:{
	            cantmodulos=3;
	            break;
	        }

	        case REPARACION:{
	        	cantmodulos=3;
	            break;
	        }
		}
		System.out.println("cantidad de modulos necesarios: " +cantmodulos);
		return cantmodulos;
	}

	public static void listarClientes() {
		System.out.println(" ");
		System.out.println("mostrnando clientes de la empresa");
		for(Cliente cli:clientes) {
			System.out.println("nombre: "+ cli.getNombre() +" dni: "+cli.getDni());
		}
		
	}
	public static void mostrarStockActual() {
		System.out.println(" ");
		System.out.println("mostrando el stock actual");
		System.out.println(StockTotal);
	}

	public static void PedirDatosparaTurno() {
		System.out.print("ingrese DNI del cliente: ");
		long dni=pedirDNI();
		Cliente cliente=buscarCliente(dni);
		if(cliente!=null) {
			//pedir fecha, hora y tipo instalacion
			int fechavisita=pedirFechaVisita();
					//int fechavisita, int horainicio,TipoServicio tipo,Cliente cliente
			int horainicio=pedirHoraInicio();
			TipoServicio tipo=pedirTipoServicio();
			AgendarVisitaACliente(fechavisita, horainicio,tipo,cliente);
		}else {
			System.out.println(" no existe ese cliente ");
			System.out.println(" primero debera crearlo!!! ");
		}
		
	}

	private static TipoServicio pedirTipoServicio() {
		Scanner entrada=new Scanner(System.in);
		TipoServicio tipo=null;
		
		System.out.println(" ");
		System.out.println("0-para instalacion");
		System.out.println("1-para reparacion ");
		System.out.print("ingrese una opcion: ");
		int opcion=entrada.nextInt();
		if(opcion==0) {
			tipo=TipoServicio.INSTALACION;
		}else if(opcion==1) {
			tipo=TipoServicio.INSTALACION;
		}
		return tipo;
	}

	private static int pedirHoraInicio() {
		Scanner entrada=new Scanner(System.in);
		int horainicio;
		System.out.println(" ");
		System.out.println("formato de hora necesario: ");
		System.out.println("800-830-900-930-1000...1900-1930-2000");
		System.out.print("ingrese una hora de inicio: ");
		horainicio=entrada.nextInt();
		
		return horainicio;
	}

	private static int pedirFechaVisita() {
		Scanner entrada=new Scanner(System.in);
		int fecha;
		System.out.println(" ");
		System.out.println("formato de fecha necesario: ");
		System.out.println("0-lunes, 1-martes, 2-miercoles...5-sabado");
		System.out.print("ingrese una fecha: ");
		fecha=entrada.nextInt();
		
		return fecha;
	}

	public static long pedirDNI() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese el dni : ");
		long dni=entrada.nextLong();
		
		return dni;
	}

	public static void PedirDatosparaCrearCliente() {
		String nombre=pedirNombre();
		String apellido=pedirApellido();
		long dni=pedirDNI();
		char sexo=pedirSexo();
		int fechanac=pedirFechaNacimiento();
		String direccion=pedirDireccion();
		String telefono=pedirTelefono();
		
		
		//creo el cliente y lo agrego a la lista de clientes
		Cliente cliente=new Cliente(nombre,apellido,dni,sexo,fechanac,direccion,telefono);
		System.out.println("cliente creado con exito ");
		clientes.add(cliente);
	}

	private static String pedirTelefono() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese su telefono: ");
		String tel=entrada.nextLine();
		return tel;
	}

	private static String pedirDireccion() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese su direccion: ");
		String direccion=entrada.nextLine();
		return direccion;
	}

	private static int pedirFechaNacimiento() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.println(" formato requerido YYYYMMDD ");
		System.out.print("ingrese su fecha de nacimiento: ");
		int fechanac=entrada.nextInt();
		
		return fechanac;
	}

	private static char pedirSexo() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.println("formato de sexo: ");
		System.out.println("0-Hombre     1-Mujer ");
		System.out.print("ingresa su sexo: ");
		int opcion;
		char sexo;
		opcion=entrada.nextInt();
		if(opcion==0) {
			sexo='H';
		}else {
			sexo='M';
		}
		
		return sexo;
	}

	private static String pedirApellido() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese su apellido: ");
		String ape=entrada.nextLine();
		
		return ape;
	}

	private static String pedirNombre() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese su nombre: ");
		String nombre=entrada.nextLine();
		
		return nombre;
	}

	public static void listarVisitasPendientes() {
		if(!visitas.isEmpty()) {
			System.out.println("mostrando visitas PENDIENTES  ");
			for (Visita visita : visitas) {
				if(visita.getEstado()==TipoEstado.PROGRAMADO) {
					System.out.println("----------------------------------");
					System.out.println("id de visita : " + visita.getIdVisita());
					System.out.println("cliente: "+visita.getCliente().getNombre() +" con dni: "+visita.getCliente().getDni());
					System.out.println(" horainicio: "+ visita.getHoraInicio());
					System.out.println(" horafin " + visita.getHoraFin());
					System.out.println("dia : "+visita.getFechaVisita());
					System.out.println("ESTADO : "+visita.getEstado());
					ArrayList<Tecnico> tecnicosAsignados=visita.getTecnicos();
					for(Tecnico tec:tecnicosAsignados) {
						System.out.println("el tecnico de esta visita  es "+tec.getNombre() +" su dni es: "+tec.getDni());
					}
				}
				
			}
		}else {
			System.out.println("no hay visitas ");
		}
		
	}

	public static void modificarEstadoVisita(int idvisita) {
		Visita visita=buscarVisitaPorID(idvisita);
		if(visita!=null) {
			TipoEstado estado=pedirNuevoEstado();
	//ACA MODIFICO EL ESTADO
			visita.setEstado(estado);
			if(estado==TipoEstado.FINALIZADO) {
				//modificar los valores de la visita finalizada
				/*
				System.out.println(" ");
				System.out.println("visita antes de modificarla: ");
				System.out.println("id: "+visita.getIdVisita());
				System.out.println("estado: "+visita.getEstado());
				System.out.println(" ");
				System.out.println("stock antes de modificarla: ");
				System.out.println(visita.getStockInicial());
				*/
		//ingresar los valores a modificar
				System.out.println("--MODIFICAR VALORES FINALES DE LA VISITA --");
				//modifica el combustible
				double cantcombustible=pedirCombustible();
				visita.setCombustible(cantcombustible);
				
				//modifica costos
				double costos=pedirCostos();
				visita.setOtrosCostos(costos);
				
				//modifica gastos
				double gastos=pedirGastos();
				visita.setOtrosGastos(gastos);
				
				//modifica tiempo trabajado
				Double TiempoTrabajado=pedirTiempotrabajado();
				visita.setTiempo(TiempoTrabajado);
				
				

				//informa tiempo de almuerzo
				int tiempoAlmuerzo=pedirTiempoAlmuerzo();
				visita.setTiempoAlmuerzo(tiempoAlmuerzo);
				
	//modifica stockinicial usado
	//OJO ACA xq ya reste el stock inicial del stock total de
	//la empresa
				//
				HashMap<TipoArticulo,Double> stockAdicional=pedirStockAdicional();
				
				//le sumo a lo que ya tengo en la visita
				//ojo. el adicional ya lo resto del total de la empresa
				visita.AgregarStockAdicional(stockAdicional);
				
				/*
				System.out.println(" ");
				System.out.println("visita  DESPUES de modificarla: ");
				System.out.println("id: "+visita.getIdVisita());
				System.out.println("estado: "+visita.getEstado());
				System.out.println(" ");
				System.out.println("stock DESPUES DE modificado: ");
				System.out.println(visita.getStockInicial());
				*/
		//#################################################		
		//#################################################			
		//#################################################		
		//CON LA VISITA YA TERMINADA CREO EL SERVICIO
		//la visita YA tiene todos los valores finales
				
		//las facturas las crean los administradores usando los SERVICIOS
		//no las visitas
			}
			else if(estado==TipoEstado.CANCELADO) {
				//hay que eliminar la visita de todos lados.
				//de la agenda del cliente y los tecnicos
				//de la lista de visitas 
				Cliente cli=visita.getCliente();
				Visita[][] MatrizSemana=cli.getMatrizSemana();
				eliminarVisitaDeLaAgenda(MatrizSemana,visita);
				ArrayList<Tecnico>tecnicos=visita.getTecnicos();
				for(Tecnico tecnico: tecnicos) {
					Visita[][] MatrizSemanaTec=tecnico.getMatrizSemana();
					eliminarVisitaDeLaAgenda(MatrizSemanaTec,visita);
				}
				//quitarlo TAMBIEN de la lista de visitas
				visitas.remove(visita);
				System.out.println(" ");
				System.out.println(" SE BORRO ES VISITA "+visita.getIdVisita() +" DE LA BBDD");
			}
			
		}else {
			System.out.println(" ");
			System.out.println("no existe esa visita ");
		}
		
		
	}

	private static void eliminarVisitaDeLaAgenda(Visita[][] matrizSemana, Visita visita) {
		// recorro y elimino
		for(int f=0;f<matrizSemana.length;f++) {
			for(int c=0;c<matrizSemana[0].length;c++) {
				if(matrizSemana[f][c]!=null) {
					if(matrizSemana[f][c].getIdVisita()==visita.getIdVisita() ) {
						matrizSemana[f][c]=null;
					}
				}
				
			}
		}
		
	}

	private static TipoEstado pedirNuevoEstado() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.println("0-encurso, 1-finalizada, 2-cancelada");
		System.out.print("ingrese el nuevo estado de la visita: ");
		TipoEstado estado=TipoEstado.PROGRAMADO;
		int opcion=entrada.nextInt();
		switch(opcion) {
			case 0:{
				estado=TipoEstado.EN_CURSO;
				break;
			}
			case 1:{
				estado=TipoEstado.FINALIZADO;
				break;
			}
			case 2:{
				estado=TipoEstado.CANCELADO;
				//no se si esta contemplado dentro del tp
				//pero habria que volver a modificar el stock total de la empresa
				break;
			}
		}
		return estado;
		//PROGRAMADO,EN_CURSO,CANCELADO,FINALIZADO;

	}

	private static HashMap<TipoArticulo, Double> pedirStockAdicional() {
		System.out.println("ingrese los valores adicionales ");
		System.out.println("!!si no hubo, ingrese cero");
		HashMap<TipoArticulo,Double> stockAdicional=new HashMap<>();
		double metrosCable=pedirMetrosCable();
		stockAdicional.put(TipoArticulo.CABLE, metrosCable);
		
		double cantDecos=pedirCantDecos();
		stockAdicional.put(TipoArticulo.DECODIFICADOR, cantDecos);
		
		double cantModem=pedirCantModem();
		stockAdicional.put(TipoArticulo.MODEM,cantModem);
		double cantDivi=pedirCantDivi();
		stockAdicional.put(TipoArticulo.DIVISORES, cantDivi);
		double cantConectores=pedirCantConectores();
		stockAdicional.put(TipoArticulo.CONECTORES, cantConectores);
		
		//se lo tengo que agregar a la visita.esto lo hago AFUERA
		
		//y lo tengo que descontar del stock total de la empresa.esto lo hago ACA
		chequearCantidadStock(stockAdicional);
		//aprovecho este metodo"chequearcantidadStock" que ya use
		//para restarle al stock de la empresa
		return stockAdicional;
	}

	private static double pedirCantConectores() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese cant conectores: ");
		double cant=entrada.nextDouble();
		
		return cant;
	}

	private static double pedirCantDivi() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese cant divisores: ");
		double cant=entrada.nextDouble();
		
		return cant;
	}

	private static double pedirCantModem() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese cant modems: ");
		double cant=entrada.nextDouble();
		
		return cant;
	}

	private static double pedirCantDecos() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese cant decodificadores: ");
		double cant=entrada.nextDouble();
		
		return cant;
	}

	private static double pedirMetrosCable() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese metros cable: ");
		double metros=entrada.nextDouble();
		
		return metros;
	}

	private static int pedirTiempoAlmuerzo() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("tuve que almorzar durante la visita? ");
		System.out.print("ingrese 0 para NO y 1 para SI: ");
		int tiempo=entrada.nextInt();
		
		return tiempo;
	}



	private static Double pedirTiempotrabajado() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("cada modulo es de media hora: ");
		System.out.println("ingrese la cantidad real de modulos trbajados: ");
		Double tiempo=entrada.nextDouble();
		
		return tiempo;
	}

	private static double pedirGastos() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese gastos extra: ");
		double gastos=entrada.nextDouble();
		
		return gastos;
	}

	private static double pedirCostos() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese costos extra: ");
		double costos=entrada.nextDouble();
		
		return costos;
	}

	private static double pedirCombustible() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese cantidad de combustible: ");
		double combus=entrada.nextDouble();
		
		return combus;
	}

	public static Visita buscarVisitaPorID(int idvisita) {
		Visita encontrada=null;
		for (Visita visita:visitas) {
			if(visita.getIdVisita()==idvisita) {
				encontrada=visita;
				break;
			}
		}
		return encontrada;
	}

	public static int pedirIdVisita() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese id de la visita: ");
		int idvisita=entrada.nextInt();
		
		return idvisita;
	}

	public static void listarVisitasFinalizadas() {
		// TODO Auto-generated method stub
		if(!visitas.isEmpty()) {
			System.out.println("mostrando visitas FINALIZADAS  ");
			for (Visita visita : visitas) {
				if(visita.getEstado()==TipoEstado.FINALIZADO) {
					System.out.println("----------------------------------");
					System.out.println("id de visita : " + visita.getIdVisita());
					System.out.println("cliente: "+visita.getCliente().getNombre() +" con dni: "+visita.getCliente().getDni());
					System.out.println(" horainicio: "+ visita.getHoraInicio());
					System.out.println(" horafin " + visita.getHoraFin());
					System.out.println("dia : "+visita.getFechaVisita());
					System.out.println("ESTADO : "+visita.getEstado());
					ArrayList<Tecnico> tecnicosAsignados=visita.getTecnicos();
					for(Tecnico tec:tecnicosAsignados) {
						System.out.println("el tecnico de esta visita fue "+tec.getNombre() +" su dni es: "+tec.getDni());
					}
				}
				
			}
		}else {
			System.out.println("no hay visitas ");
		}
	}

	public static void verStockMateriales() {
		System.out.println(" ");
		System.out.println("mostrando stok actual");
		System.out.println(StockTotal);
		
	}

	public static void ModificarStockMateriales() {
		//esto lo hace el admin
		System.out.println(" ");
		System.out.println(" ingrese una cantidad positiva para agregar stock ");
		System.out.println(" ingrese una cantidad negativa para quitar stock ");
		double cant=pedirMetrosCable();
		StockTotal.replace(TipoArticulo.CABLE, StockTotal.get(TipoArticulo.CABLE)+cant);
		cant=pedirCantConectores();
		StockTotal.replace(TipoArticulo.CONECTORES, StockTotal.get(TipoArticulo.CONECTORES)+cant);
		cant=pedirCantDivi();
		StockTotal.replace(TipoArticulo.DIVISORES, StockTotal.get(TipoArticulo.DIVISORES)+cant);
		cant=pedirCantModem();
		StockTotal.replace(TipoArticulo.MODEM, StockTotal.get(TipoArticulo.MODEM)+cant);
		cant=pedirCantDecos();
		StockTotal.replace(TipoArticulo.DECODIFICADOR, StockTotal.get(TipoArticulo.DECODIFICADOR)+cant);
		//CABLE,CONECTORES,DIVISORES,MODEM,DECODIFICADOR;
		
		
	}

	public static void ModificarCostoHoras() {
		//esto lo hace el admin
		System.out.println(" ");
		System.out.println(" ingrese los nuevos costos de las horas: ");
		
		System.out.println("nuevo valor para hora JUNIOR: ");
		double costo=pedirNuevoCosto();
		CostoPorModulo.replace(TipoTecnicoEnum.JUNIOR, costo);
		System.out.println("nuevo valor para hora SEMISENIoR: ");
		costo=pedirNuevoCosto();
		CostoPorModulo.replace(TipoTecnicoEnum.SEMI_SENIOR, costo);
		System.out.println("nuevo valor para hora SENIOR: ");
		costo=pedirNuevoCosto();
		CostoPorModulo.replace(TipoTecnicoEnum.SENIOR, costo);
		
	}

	private static double pedirNuevoCosto() {
		Scanner entrada=new Scanner(System.in);
		System.out.print("ingrese nuevo costo: ");
		double costo=entrada.nextDouble();
		
		return costo;
	}

	public static void ModificarCostoMateriales() {
		//esto lo hace el admin
		System.out.println(" ");
		System.out.println(" ingrese los nuevos costos de los materiales: ");
				
		System.out.println("nuevo costo para metro de cable: ");
		double costo=pedirNuevoCosto();
		CostodeMaterial.replace(TipoArticulo.CABLE, costo);
		
		System.out.println("nuevo costo por conector: ");
		costo=pedirNuevoCosto();
		CostodeMaterial.replace(TipoArticulo.CONECTORES, costo);
		
		System.out.println("nuevo costo por divisor: ");
		costo=pedirNuevoCosto();
		CostodeMaterial.replace(TipoArticulo.DIVISORES, costo);
		
		System.out.println("nuevo costo por modem: ");
		costo=pedirNuevoCosto();
		CostodeMaterial.replace(TipoArticulo.MODEM, costo);
		
		System.out.println("nuevo costo por decodificador: ");
		costo=pedirNuevoCosto();
		CostodeMaterial.replace(TipoArticulo.DECODIFICADOR, costo);
	}

	public static void verCostosDeHora() {
		System.out.println(CostoPorModulo);
		
		
	}

	public static void verCostoMateriales() {
	
		System.out.println(	CostodeMaterial);
		
	}

	public static void generarUnServicio() {
		// TODO Auto-generated method stub
		Visita visita=null;
		int idvisita=pedirIdVisita();
		visita=buscarVisitaPorID(idvisita);
		if(visita!=null) {
			Servicio serv=new Servicio(visita);
			System.out.println("servicio CREADO con exito");
			servicios.add(serv);
		}else {
			System.out.println(" no se genero el servicio ");
		}
	}

	public static void listarServicios() {
		// TODO Auto-generated method stub
		System.out.println("mostrando servicios ");
		for(Servicio servi:servicios) {
			System.out.println(servi.getIdServicio());
		}
	}

	public static void GenerarFactura() {
		Servicio serv=null;
		int idserv=pedirIdServicio();
		serv=buscarServicioPorID(idserv);
		if(serv!=null) {
			Factura factura=new Factura(serv);
			System.out.println("FActura CREADa con exito");
			facturas.add(factura);
		}else {
			System.out.println(" no se genero la factura ");
		}
		
	}

	private static Servicio buscarServicioPorID(int idserv) {
		Servicio serv=null;
		for(Servicio s:servicios) {
			if(serv.getIdServicio()==idserv) {
				serv=s;
		
			}
		}return serv;
	}

	private static int pedirIdServicio() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese id del servicio: ");
		int id=entrada.nextInt();
		
		return id;
	}

	public static void mostrarFactura(int idfactura) {
		// TODO Auto-generated method stub
		for(Factura factu:facturas) {
			if (factu.getId()==idfactura) {
				System.out.println(factu);
			}
		}
	}

	public static int pedirIdFactura() {
		Scanner entrada=new Scanner(System.in);
		System.out.println(" ");
		System.out.print("ingrese id de la factura: ");
		int id=entrada.nextInt();
		
		return id;
	}

	
	
	
}//fin de clase controlador
