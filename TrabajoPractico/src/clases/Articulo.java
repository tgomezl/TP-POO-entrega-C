package clases;

import java.util.HashMap;

public class Articulo {
	private static int idArticuloStatic=0;
	private int idArticulo;
	private TipoArticulo tipo;
	private double cantidades;
	private double costos;
	

	
	public Articulo(TipoArticulo tipo, double cantidades, double costos) {
		super();
		this.tipo = tipo;
		this.cantidades = cantidades;
		this.costos = costos;
		this.idArticulo= idArticuloStatic;
		idArticuloStatic++;
		
	}





	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public TipoArticulo getTipo() {
		return tipo;
	}

	public void setTipo(TipoArticulo tipo) {
		this.tipo = tipo;
	}


	
	

	public double getCostos() {
		return costos;
	}

	public void setCostos(double costos) {
		this.costos = costos;
	}





	public double getCantidad() {
		// TODO Auto-generated method stub
		return cantidades;
	}

	
	

}
