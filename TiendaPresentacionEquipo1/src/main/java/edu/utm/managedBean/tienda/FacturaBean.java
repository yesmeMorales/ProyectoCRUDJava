package edu.utm.managedBean.tienda;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import edu.utm.bd.domain.Factura;
import edu.utm.services.FacturaService;



@Named
public class FacturaBean {
	@Inject
	FacturaService facturaService;
	private String facturaNombre;
	private int idFactura;
	private String nombreCliente;
	
	
	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getFacturaNombre() {
		return facturaNombre;
	}

	public void setFacturaNombre(String facturaNombre) {
		this.facturaNombre = facturaNombre;
	}
	
	public List<Factura> getClienteByNombre(){
		return facturaService.findFacturaByNombre(getFacturaNombre());
	}
	
	public void setFacturaId(Factura fact) {
		System.out.println(fact.getIdFactura());
		System.out.println(fact.getClient());
		setIdFactura(fact.getIdFactura());
		setClienteNombre(fact.getClient());
	}
	
	public List<Factura> mostrarFactura(){
		return facturaService.findProductosByIdFactura(getIdFactura());
	}
	
	public void setClienteNombre(String nombreCliente ) {
		this.nombreCliente =  nombreCliente;
	}
	
	public String getClienteNombre() {
		return nombreCliente; 
	}
}
