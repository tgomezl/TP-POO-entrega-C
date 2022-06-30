package clases;

public class Operador extends Empleado{
	
	@Override
	public String toString() {
		return "Operador [idOperador=" + idOperador + ", activo=" + activo + ", legajo=" + legajo + ", usuario="
				+ usuario + ", contrase�a=" + contrasenia + ", estado=" + estado + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dni=" + dni + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", direccion="
				+ direccion + ", telefono=" + telefono + "]";
	}
	private int idOperador;
	private boolean activo;
	
	
	public Operador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operador(int legajo, String nombre, String apellido, long dni, char sexo, int fechaNacimiento, String direccion,
			String telefono, String usuario, String contraseña) {
		super(legajo, nombre, apellido, dni, sexo, fechaNacimiento, direccion, telefono, usuario, contraseña);
		// TODO Auto-generated constructor stub
		this.idOperador= Controlador.buscarIdMaximo("Operador").get(0);
		this.activo = true;
	}
	public int getIdOperador() {
		return idOperador;
	}
	public void setIdOperador(int idOperador) {
		this.idOperador = idOperador;
	}
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

}
