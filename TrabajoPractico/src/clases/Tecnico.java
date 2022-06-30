package clases;

import java.util.ArrayList;

public class Tecnico extends Empleado{


	private int idTecnico;
	private TipoTecnicoEnum tipo;
	private	TipoTurno turno;
	private boolean activo;
	
	private Agenda agenda;
	private Visita[][] MatrizSemana;
	
	
	public Tecnico() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tecnico(int legajo, String nombre, String apellido, long dni, char sexo, int fechaNacimiento, String direccion,
			String telefono, String usuario, String contraseña, TipoTecnicoEnum tipo, TipoTurno turno) {
		super(legajo,nombre, apellido, dni, sexo, fechaNacimiento, direccion, telefono, usuario, contraseña);
		// TODO Auto-generated constructor stub
		this.idTecnico= Controlador.buscarIdMaximo("Tecnico").get(0);
		this.activo = true;
		this.tipo = tipo;
		this.turno = turno;//maniana o tarde
		this.agenda=new Agenda();
		this.MatrizSemana =agenda.getSemana(); //cada tecnico tiene una agenda semanal
	}
	public int getIdTecnico() {
		return idTecnico;
	}
	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}
	public TipoTecnicoEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoTecnicoEnum tipo) {
		this.tipo = tipo;
	}
	public TipoTurno getTurno() {
		return turno;
	}
	public void setTurno(TipoTurno turno) {
		this.turno = turno;
	}
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public Visita[][] getMatrizSemana() {
		return MatrizSemana;
	}
	
	@Override
	public String toString() {
		return "Tecnico [id=" + idTecnico + ", dni= " + dni + ", tipo= " + tipo.toString() + ", turno=" + turno.toString() + ", activo=" + activo
				+ ", legajo=" + legajo + ", usuario=" + usuario + ", contrase�a=" + contrasenia + ", estado=" + estado
				+ ", nombre=" + nombre + ", apellido=" + apellido  + ", sexo=" + sexo +"]";
	}
	/*
	 * 	MatrizSemana se ve asi:
	 *		   	     0	     1	     2	    3	     4	    5
					lunes	martes	mier	juev	viern  sabado
		0	800		null	null	null	null	null	null
		1	830		null	null	null	null	null	null
		2	900		null	null	null	null	null	null
		3	930		null	null	null	null	null	null
		4	1000	null	null	null	null	null	null
		5	1030	null	null	null	null	null	null
		6	1100	null	null	null	null	null	null
		7	1130	null	null	null	null	null	null
		8	1200	null	null	null	null	null	null
		9	1230	null	null	null	null	null	null
		10	1300	null	null	null	null	null	null
		11	1330	null	null	null	null	null	null
		12	1400	null	null	null	null	null	null
		13	1430	null	null	null	null	null	null
		14	1500	null	null	null	null	null	null
		15	1530	null	null	null	null	null	null
		16	1600	null	null	null	null	null	null
		17	1630	null	null	null	null	null	null
		18	1700	null	null	null	null	null	null
		19	1730	null	null	null	null	null	null
		20	1800	null	null	null	null	null	null
		21	1830	null	null	null	null	null	null
		22	1900	null	null	null	null	null	null
		23	1930	null	null	null	null	null	null
		24	2000	null	null	null	null	null	null
	 * 
	 * 
	 * 
	 */
	public TipoTecnicoEnum getSeniority() {
		// TODO Auto-generated method stub
		return tipo;
	}
	
	
	
}

