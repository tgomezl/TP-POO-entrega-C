package clases;

public class Cliente extends Persona {
	
	private int idCliente;
	private boolean estado;
	//ES UNA MATRIZ QUE GUARDA OBJETOS DE TIPO Visita
	private Agenda agenda;
	private Visita[][] MatrizSemana;
		
	public Cliente(String nombre, String apellido, long dni, char sexo, int fechaNacimiento, String direccion,
			String telefono) {
		super(nombre, apellido, dni, sexo, fechaNacimiento, direccion, telefono);
		this.idCliente= Controlador.buscarIdMaximo("Cliente").get(0);
		this.estado = true;
		this.agenda=new Agenda();
		this.MatrizSemana=agenda.getSemana(); //se crea con todo en null
		
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dni=" + dni + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", direccion="
				+ direccion + ", telefono=" + telefono + "]";
	}

	public Visita[][] getMatrizSemana() {
		// TODO Auto-generated method stub
		return MatrizSemana;
	}
	
	

}
