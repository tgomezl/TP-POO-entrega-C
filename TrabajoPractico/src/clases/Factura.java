package clases;

import java.util.HashMap;

public class Factura {
	
	//al cliente no se le facturan los gastos adicionales.
	//solo los costos del servicio+ganancia+iva
	private int idFactura;
	private TipoServicio tipoServicio;
	private Cliente cliente;
	private double tiempoTrabajado;
	private HashMap<TipoArticulo, Double> materialesfinal;
	private double costototal;
	private double gastototal;
	private double gananciaNeta;
	private double subTotal;
	private double IVA;
	private double total;
	
	

	public Factura(Servicio servicio) {
		idFactura=Servicio.getIdServicio();
		this.tipoServicio = Servicio.getTipoServicio();
		this.cliente = Servicio.getCliente();
		this.costototal = Servicio.calcularCostoTotal();
		this.gastototal = Servicio.calcularGastoTotal();
		this.gananciaNeta = costototal*0.3;
		this.subTotal = costototal+gastototal+gananciaNeta;
		this.IVA = this.subTotal*0.21;
		this.total = this.subTotal+IVA;
	}

	/*
	public Factura(int idServicio,TipoServicio tipoServicio,Cliente cliente2, HashMap<TipoArticulo, Double> stockfinalservicio, double tiempoTrabajado2, double Costos) {
		idFactura=idServicio; //factura servicio y visita tendran el mismo ID
		tipoServicio=tipoServicio;
		cliente=cliente;
		this.costototal=Costos; //tiempo trabajado + costos de cada material usado
		gananciaNeta=0.3*costototal;
		this.subTotal=gananciaNeta+Costos;
		IVA=0.21*subTotal;
		total=subTotal+IVA;
		materialesfinal=stockfinalservicio;
		
	}
*/
	private int getIdFactura() {
		return idFactura;
	}

	private void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}


	private Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private double getTiempoTrabajado() {
		return tiempoTrabajado;
	}

	private void setTiempoTrabajado(double tiempoTrabajado) {
		this.tiempoTrabajado = tiempoTrabajado;
	}

	

	private double getSubTotal() {
		return subTotal;
	}

	private void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	private double getIVA() {
		return IVA;
	}

	private void setIVA(double iVA) {
		IVA = iVA;
	}

	private double getTotal() {
		return total;
	}

	private void setTotal(double total) {
		this.total = total;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return idFactura;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", tipoServicio=" + tipoServicio + ", cliente: "+cliente.getNombre()+ " con dni =" + cliente.getDni()
				+ ", tiempoTrabajado=" + tiempoTrabajado + ", materialesfinal=" + materialesfinal + ", costototal="
				+ costototal + ", gastototal=" + gastototal + ", gananciaNeta=" + gananciaNeta + ", subTotal="
				+ subTotal + ", IVA=" + IVA + ", total=" + total + "]";
	}

	
	
}
