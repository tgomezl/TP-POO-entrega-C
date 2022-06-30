package clases;

public class Administrador extends Empleado{
	
	@Override
	public String toString() {
		return "Administrador [idAdmin=" + idAdmin + ", activo=" + activo + ", legajo=" + legajo + ", usuario="
				+ usuario + ", contrasenia=" + contrasenia + ", estado=" + estado + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dni=" + dni + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", direccion="
				+ direccion + ", telefono=" + telefono + "]";
	}
	private int idAdmin;
	private boolean activo;
	
	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administrador(int legajo, String nombre, String apellido, long dni, char sexo, int fechaNacimiento, String direccion,
			String telefono, String usuario, String contrasenia) {
		super(legajo, nombre, apellido, dni, sexo, fechaNacimiento, direccion, telefono, usuario, contrasenia);
		// TODO Auto-generated constructor stub
		this.idAdmin= Controlador.buscarIdMaximo("Administrador").get(0);
		this.activo = true;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
