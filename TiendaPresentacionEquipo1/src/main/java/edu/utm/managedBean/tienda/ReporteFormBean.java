package edu.utm.managedBean.tienda;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.utm.bd.domain.Factura;
import edu.utm.services.FacturaService;

@Named
@ViewScoped
public class ReporteFormBean implements Serializable{
	private static final long serialVersionUID=6475867749392173105L;
	@Inject
	FacturaService facturaService;
	
	
	private Date fechaInicio;
	//private Date fechaFinal;
	private Date fechaIni;
	private Date fechaFin;
	private float gananciasDia;
	private float gananciasSemana;

	private List<Factura> facturasDia;
	private List<Factura> facturasSemana;
	
	public List<Factura> getFacturasDia() {
		return facturasDia;
	}

	public void setFacturasDia(List<Factura> facturasDia) {
		this.facturasDia = facturasDia;
	}
	

	public Date getFecha() {
		return fechaInicio;
	}

	public void setFecha(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public float getGananciasDia() {
		return gananciasDia;
	}

	public void setGananciasDia(float gananciasDia) {
		this.gananciasDia = gananciasDia;
	}
	
	public float getGananciasSemana() {
		return gananciasSemana;
	}

	public void setGananciasSemana(float gananciasSemana) {
		this.gananciasSemana = gananciasSemana;
	}
	
	
	public void reporteDia(){
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String fecha = df.format(getFecha());
		System.out.println("hola");
		facturasDia = facturaService.findFacturaDay(fecha);
		
		gananciasDia = 0;
		
		for(Factura f: facturasDia){
			System.out.println("precio compra "+ f.getProductoDatos().getPrecioCompra() );
			gananciasDia += f.getDetalleDatos().getMonto()-(f.getDetalleDatos().getCantidad()* f.getProductoDatos().getPrecioCompra());
		}
		
		
	}
	
	
	public void reporteSemana(){
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		
		
		String fechai = df.format(fechaIni);
		String fechaf = df.format(fechaFin);
		Map<String, String> fechas = new HashMap<String, String>();
		fechas.put("fechai", fechai);
		fechas.put("fechaf", fechaf);
		facturasSemana = facturaService.findFacturaWeek(fechas);
		
		gananciasSemana = 0;
		
		for(Factura f: facturasSemana){
			gananciasSemana += f.getDetalleDatos().getMonto()-(f.getDetalleDatos().getCantidad()* f.getProductoDatos().getPrecioCompra());
		}
		System.out.println("ganancias semana "+gananciasSemana);
		
	}
	
	
	public List<Factura> getFacturasSemana() {
		return facturasSemana;
	}

	public void setFacturasSemana(List<Factura> facturasSemana) {
		this.facturasSemana = facturasSemana;
	}

	public Date getFechaInicio() {
		return fechaIni;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaIni() {
		
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	
	
	
    
}
