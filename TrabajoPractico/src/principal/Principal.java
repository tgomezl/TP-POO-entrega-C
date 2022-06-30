package principal;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Administrativo;
import clases.Cliente;
import clases.Controlador;
import clases.Empleado;
import clases.Empresa;
import clases.Factura;
import clases.MenusVarios;
import clases.Servicio;
import clases.Tecnico;
import clases.TipoEstado;
import clases.TipoServicio;
import clases.TipoTecnicoEnum;
import clases.Visita;

public class Principal {

	public static void main(String[] args) {
		
		// creo la empresa y lleno algunos atributos de empresa
		scriptInicio();
		System.out.println(" ");
		System.out.println(" *************************************************************************************");
		System.out.println(" *************************************************************************************");
		System.out.println("                    <<<<voy a precargar algunas visitas>>> ");
		precargarAlgunasVisitas();
		
		//----------------APARTIR DE ACA ESTA EL MENU:
		int opcion=14;
		boolean salir=false;
		Scanner entrada=new Scanner(System.in);
		while(!salir) {
			try {
				MenusVarios.MenuPrincipal();
				opcion=entrada.nextInt();
				switch(opcion) {
					case 0:{
						salir=true;
						break;
					}
					case 1:{
						//menu personal administrativo
						
						int opc=1;
						while (opc!=0) {
							MenusVarios.menuAdministrativo();
							opc=entrada.nextInt();
							switch(opc) {
								case 0:{
									System.out.println(" ");
									System.out.println("volviendo al menu ppal");
									opc=0;
									break;
								}
								case 1:{
									System.out.println(" ");
									System.out.println("1-generar un SERVICIO(usando una visita terminada)");
									Controlador.generarUnServicio();
									break;
								}case 2:{
									System.out.println(" ");
									System.out.println("listar Servicios");
									Controlador.listarServicios();
									break;
								}
								case 3:{
									System.out.println(" ");
									System.out.println(" FALTA IMPLEMENTAR.(es muy parecido a modificar valores de visita)");
									System.out.println("modificar valores de un servicio");
									//TO DO
									//Controlador.ModificarServicios();
									break;
								}case 4:{
									System.out.println(" ");
									System.out.println("generar una factura ");
									Controlador.GenerarFactura();
									break;
								}case 5:{
									System.out.println(" ");
									System.out.println("imprimir una factura ");
									int idfactura=Controlador.pedirIdFactura();
									Controlador.mostrarFactura(idfactura);
									break;
								}
								
								
							
							}
						}
						break;
					}	
							
					case 2:{
						//menu tecnicos
						int opc=2;
						while (opc!=0) {
							MenusVarios.menuTecnico();
							opc=entrada.nextInt();
							switch(opc) {
								case 0:{
									System.out.println(" ");
									System.out.println("volviendo al menu ppal");
									opc=0;
									break;
								}
								case 1:{
									System.out.println(" ");
									System.out.println("listar visitas pendientes");
									Controlador.listarVisitasPendientes();
									break;
								}
								case 2:{
									System.out.println(" ");
									System.out.println("modificar el ESTADO de una visita");
									System.out.print("ingrese el id de la visita: ");
									int idvisita=Controlador.pedirIdVisita();
									Controlador.modificarEstadoVisita(idvisita); 
									//modifica la visita una vez que termino
									//le da los valores finales a la vista
									//ahora ya se pueden crear servicio y factura
									break;
								}
								case 3:{
									System.out.println(" ");
									System.out.println("listar visitas finalizadas");
									Controlador.listarVisitasFinalizadas();
									break;
								}
							}
						}
						break;
					}	
					case 3:{
						//menu del Admin
						int opc=3;
						while (opc!=0) {
							MenusVarios.menuAdmin();
							opc=entrada.nextInt();
							switch(opc) {
								case 0:{
									System.out.println(" ");
									System.out.println("volviendo al menu ppal");
									opc=0;
									break;
								}
								case 1:{
									System.out.println(" ");
									System.out.println("modificar costo de horas ");
									Controlador.ModificarCostoHoras();
									break;
								}
								case 2:{
									System.out.println(" ");
									System.out.println("modificar costo de materiales ");
									Controlador.ModificarCostoMateriales();
									break;
								}
								case 3:{
									System.out.println(" ");
									System.out.println("modificar stock total ");
									Controlador.ModificarStockMateriales();
									break;
								}
								case 4:{
									System.out.println(" ");
									System.out.println("ver stock total ");
									Controlador.verStockMateriales();
									break;
								}
								
								case 5:{
									System.out.println(" ");
									System.out.println("ver COSTO de hora");
									Controlador.verCostosDeHora();
									break;
								}
								case 6:{
									System.out.println(" ");
									System.out.println("ver COSTO de materiales ");
									Controlador.verCostoMateriales();
									break;
								}
							}
						}
						break;
					}
					case 4:{
						//menu call center
						int opc=4;
						while (opc!=0) {
							MenusVarios.menuCallCenter();
							opc=entrada.nextInt();
							switch(opc) {
								case 0:{
									System.out.println(" ");
									System.out.println("volviendo al menu ppal");
									opc=0;
									break;
								}
								case 1:{
									System.out.println(" ");
									System.out.println("----listar tecnicos");
									Controlador.listarTecnicos();
									break;
								}
								case 2:{
									System.out.println(" ");
									System.out.println("----listar clientes");
									Controlador.listarClientes();
									break;
								}
								case 3:{
									System.out.println(" ");
									System.out.println("- buscar tecnico por dni");
									long dni=Controlador.pedirDNI();
									Tecnico tec=Controlador.buscarTecnico(dni);
									System.out.println(tec);
									break;
								}
								case 4:{
									System.out.println(" ");
									System.out.println("MOSRTAR LA SEMANA/AGENDA DE UN TECNICO");
									System.out.println("- ingrese dni del TECNICO ");
									long dni=Controlador.pedirDNI();
									Tecnico tec=Controlador.buscarTecnico(dni);
									Controlador.mostrarSemana(tec);
									break;
								}
								case 5:{
									System.out.println(" ");
									System.out.println("- buscar cliente por dni");
									long dni=Controlador.pedirDNI();
									Cliente cli=Controlador.buscarCliente(dni);
									System.out.println(cli);
									break;
		
								}
								
								case 6:{
									System.out.println(" ");
									System.out.println("agendando turno");
									Controlador.PedirDatosparaTurno();
									break;
								}
								case 7:{
									System.out.println(" ");
									System.out.println("creando nuevo cliente ");
									Controlador.PedirDatosparaCrearCliente();
									break;
								}
								case 8:{
									System.out.println(" ");
									System.out.println("listar todas las VISITAS ");
									Controlador.listarVisitas();
									break;
								}
								case 9:{
									System.out.println(" ");
									System.out.println("MOSRTAR LA SEMANA/AGENDA DE UN cliente");
									System.out.println("- ingrese dni del CLIENTE ");
									long dni=Controlador.pedirDNI();
									Cliente cli=Controlador.buscarCliente(dni);
									Controlador.mostrarSemanaCliente(cli);
									break;
								}
							}
						}
						break;
					}//fin del menu call center	
					
				}//fin del whitch grande
			
			
			}
			catch(NullPointerException exc) {
				System.out.println(" ");
				System.out.println(" inexistente ");
			}
			catch(Exception exce) {
				System.out.println(" ");
				System.out.println(" ocurrio un error en el sistema");
			}
			
		}//fin del while grande
		System.out.println(" ");
		System.out.println(" saliendo ");
		System.exit(0);
	

	}
	
	

	public static void precargarAlgunasVisitas() {
		long dnicliente=40997301;
		Cliente cliente=Controlador.buscarCliente(dnicliente);
		int fechavisita=1; //lunes
		int horainicio=800;
		TipoServicio tipo=TipoServicio.INSTALACION;
		Controlador.AgendarVisitaACliente(fechavisita, horainicio,tipo,cliente);
		
		
		//intento agendar OTRA visita al primer cliente EL DIA MIERCOLES
		dnicliente=40997301;
		cliente=Controlador.buscarCliente(dnicliente);
		fechavisita=3; //miercoles
		horainicio=1030;
		tipo=TipoServicio.INSTALACION;
		Controlador.AgendarVisitaACliente(fechavisita, horainicio,tipo,cliente);
		
		//intento agendar OTRA visita al primer cliente EL DIA MIERCOLES
		dnicliente=40997301;
		cliente=Controlador.buscarCliente(dnicliente);
		fechavisita=3; //miercoles
		horainicio=1030;
		tipo=TipoServicio.INSTALACION;
		Controlador.AgendarVisitaACliente(fechavisita, horainicio,tipo,cliente);
		
		
		
		System.out.println(" ");
		System.out.println("                     <<<<<termine de precargar algunas visitas>>> ");
		System.out.println(" *************************************************************************************");
		System.out.println(" *************************************************************************************");
		System.out.println(" ");
	}
	
	
	
	
	public static void probandoCreacion() {
		
		Administrativo a = new Administrativo();
		
		int dni = 40997301;
		String user = "User1";
		
		a = Controlador.crearAdministrativo("Alejandro","Salgado",dni,'M',19980803,"Las Heras 1184","1156937106",user,
				"passwd1");
		
		if(a.getDni()!=-1 && a.getUsuario()!= "-1")
			System.out.println("DNI " + a.getDni() + " CON USUARIO: " + a.getUsuario() + " CREADO CON EXITO");
		else if(a.getDni()==-1 && a.getUsuario() == "-1")
			System.out.println("YA EXISTE UN ADMINISTRATIVO CON EL DNI: " + dni +  " Y USUARIO: " + user);
		else if(a.getDni() == -1)
			System.out.println("YA EXISTE UN ADMINISTRATIVO CON EL DNI: " + dni);
		else
			System.out.println("YA EXISTE UN ADMINISTRATIVO CON EL USUARIO: " + user);
		
		user = "user2";
		
		a = Controlador.crearAdministrativo("Alejandro","Salgado",dni,'M',19980803,"Las Heras 1184","1156937106",user,
				"passwd1");
		
		if(a.getDni()!=-1 && a.getUsuario()!= "-1")
			System.out.println("DNI " + a.getDni() + " CON USUARIO: " + a.getUsuario() + " CREADO CON EXITO");
		else if(a.getDni()==-1 && a.getUsuario() == "-1")
			System.out.println("YA EXISTE UN ADMINISTRATIVO CON EL DNI: " + dni +  " Y USUARIO: " + user);
		else if(a.getDni() == -1)
			System.out.println("YA EXISTE UN ADMINISTRATIVO CON EL DNI: " + dni);
		else
			System.out.println("YA EXISTE UN ADMINISTRATIVO CON EL USUARIO: " + user);
	}


	
	public static void scriptInicio() {
		Controlador.script();
	}

}
