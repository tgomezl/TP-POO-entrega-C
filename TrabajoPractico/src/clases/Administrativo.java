package clases;

public class Administrativo extends Empleado {

	@Override
	public String toString() {
		return "Administrativo [idAdministrativo=" + idAdministrativo + ", activo=" + activo + ", legajo=" + legajo
				+ ", usuario=" + usuario + ", contrase�a=" + contrasenia + ", estado=" + estado + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", dni=" + dni + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento
				+ ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
	private int idAdministrativo;
	private boolean activo;
	
	public Administrativo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administrativo(int legajo, String nombre, String apellido, long dni, char sexo, int fechaNacimiento, String direccion,
			String telefono, String usuario, String contraseña) {
		super(legajo, nombre, apellido, dni, sexo, fechaNacimiento, direccion, telefono, usuario, contraseña);
		// TODO Auto-generated constructor stub
		this.idAdministrativo= Controlador.buscarIdMaximo("Administrativo").get(0);
		this.activo = true;
	}
	public int getIdAdministrativo() {
		return idAdministrativo;
	}
	public void setIdAdministrativo(int idAdministrativo) {
		this.idAdministrativo = idAdministrativo;
	}
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
