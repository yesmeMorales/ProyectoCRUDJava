package edu.utm.services;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import edu.utm.bd.domain.Factura;
import edu.utm.dao.tienda.FacturaDao;
import edu.utm.services.FacturaService;

@Named
public class FacturaServiceImpl implements FacturaService{
	@Inject
	FacturaDao facturaDao;
	
	public List<Factura> findFacturaByNombre(String nombreCliente){
		return facturaDao.findFacturaByNombre(nombreCliente);
	}
	
	public List<Factura> findProductosByIdFactura(int id_factura){
		return facturaDao.findProductosByIdFactura(id_factura);
	}
	@Override
	public List<Factura> findFacturaDay(String fecha) {
		return facturaDao.findFacturaDay(fecha);
	}

	@Override
	public List<Factura> findFacturaWeek(Map<String, String> fechas) {
		
		return facturaDao.findFacturaWeek(fechas);
	}
	
	public void insertFactura(Factura factura) {
		facturaDao.insertFactura(factura);
	}
	
	public int lastIdFact() {
		return facturaDao.lastIdFact();
	}
}
