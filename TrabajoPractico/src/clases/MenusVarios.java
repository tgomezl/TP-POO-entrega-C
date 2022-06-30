package clases;

public class MenusVarios {
	public static void MenuPrincipal() {
		System.out.println(" ");
		System.out.println("--------   MENU PPAL            -------");
		System.out.println("por favor identifiquese----------------");
		System.out.println("0-SALIR--------------------------------");
		System.out.println("1- soy personal administrativo   ------");
		System.out.println("2- soy tecnico     --------------------");
		System.out.println("3- soy el Admin      ------------------");
		System.out.println("4- soy del Call Center  ---------------");
		System.out.print("por favor ingrese una opcion: ");
		
	}

	public static void menuCallCenter() {
		System.out.println(" ");
		System.out.println("---------MENU CALLCENTER---------------");
		System.out.println("0-volver atras  -----------------------");
		System.out.println("1- listar tecnicos        -------------");
		System.out.println("2- listar clientes --------------------");
		System.out.println("3- buscar tecnico por dni--------------");
		System.out.println("4- mostrar semana de un tecnico--------");
		System.out.println("5- buscar cliente por dni     --------");
		System.out.println("6- agendar un turno            --------");
		System.out.println("7- crear cliente nuevo         --------");
		System.out.println("8- listar Todas las visitas    --------");
		System.out.println("9- mostrar semana de un cliente--------");
		System.out.print("por favor ingrese una opcion: ");
		
	}
	
	public static void menuTecnico() {
		System.out.println(" ");
		System.out.println("---------MENU TECNICO   ---------------");
		System.out.println("0-volver atras  -----------------------");
		System.out.println("1- listar visitas pendientes  ---------");
		System.out.println("2- modificar ESTADO de una visita      ");
		System.out.println("3- listar visitas finalizadas          ");
		System.out.print("por favor ingrese una opcion: ");
		
	}
	
	public static void menuAdministrativo() {
		System.out.println(" ");
		System.out.println("---------MENU ADMINISTRATIVO  ----------           -");
		System.out.println("0-volver atras  --------------  -------           --");
		System.out.println("1-generar un SERVICIO(usando una visita terminada)  ");
		System.out.println("2-listar SERVICIOS( visitas terminadas)             ");
		System.out.println("3-modificar valores de un servicio                   ");
		System.out.println("4-facturar un servicio (crear factura)               ");
		System.out.println("5-imprimr una factura                                ");
		System.out.println(" NOTA: visita, servicio y factura tendran el mismo ID");
		System.out.print("por favor ingrese una opcion: ");
		
	}
	
	public static void menuAdmin() {
		System.out.println(" ");
		System.out.println("---------MENU ADMIN--------------------");
		System.out.println("0-volver atras  ------------------------");
		System.out.println("1- modificar costo de horas       ------");
		System.out.println("2- modificar costo de materiales -- ----");
		System.out.println("3- modificar stock total de materiales --");
		System.out.println("4- ver stock global              -- ----");
		System.out.println("5- ver COSTO de hora             -- ----");
		System.out.println("6- ver COSTO de materiales        -- ----");
		System.out.print("por favor ingrese una opcion: ");
		
	}
}
