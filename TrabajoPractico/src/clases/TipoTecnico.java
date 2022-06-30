package clases;

public class TipoTecnico {
	
	@Override
	public String toString() {
		return "TipoTecnico [idTipo=" + idTipo + ", tipo=" + tipo.toString() + ", valorHora=" + valorHora + ", valorCombustible="
				+ valorCombustible + ", costoViaje=" + costoViaje + ", estado=" + estado + "]";
	}

	private int idTipo;
	private TipoTecnicoEnum tipo;
	private double valorHora;
	private double valorCombustible;
	private double costoViaje;
	private boolean estado;
	
	public TipoTecnico() {
		
	}
	
	public TipoTecnico(TipoTecnicoEnum tipo, double valorHora, double valorCombustible, double costoViaje,
			boolean estado) {
		super();
		this.idTipo = Controlador.buscarIdMaximo("Tipo Tecnico").get(0);
		this.tipo = tipo;
		this.valorHora = valorHora;
		this.valorCombustible = valorCombustible;
		this.costoViaje = costoViaje;
		this.estado = estado;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public TipoTecnicoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoTecnicoEnum tipo) {
		this.tipo = tipo;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getValorCombustible() {
		return valorCombustible;
	}

	public void setValorCombustible(double valorCombustible) {
		this.valorCombustible = valorCombustible;
	}

	public double getCostoViaje() {
		return costoViaje;
	}

	public void setCostoViaje(double costoViaje) {
		this.costoViaje = costoViaje;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
