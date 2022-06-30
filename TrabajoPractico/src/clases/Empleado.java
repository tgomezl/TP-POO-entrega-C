package clases;


public class Empleado extends Persona{
	
	protected int legajo;
	protected String usuario;
	protected String contrasenia;
	protected boolean estado;
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Empleado(int legajo, String nombre, String apellido, long dni, char sexo, int fechaNacimiento, String direccion,
			String telefono, String usuario, String contrasenia) {
		super(nombre, apellido, dni, sexo, fechaNacimiento, direccion, telefono);
		// TODO Auto-generated constructor stub
		this.legajo= legajo;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.estado = true;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContraseña(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}	
	
	
}