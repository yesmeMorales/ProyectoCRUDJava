package edu.utm.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import edu.utm.bd.domain.Detalle;
import edu.utm.dao.tienda.DetalleDao;


@Named
public class DetalleServiceImpl implements DetalleService{
	@Inject
	DetalleDao detalleDao;

	public List<Detalle> findAllDetalles(){
		return detalleDao.findAllDetalles();
	}
	
	public void updateDetalle(Detalle detalle) {
		detalleDao.updateDetalle(detalle);
	}
	
	public List<Detalle> findDetalleByIdFactura(int id_factura){
		return detalleDao.findDetalleByIdFactura(id_factura);
	}
	
	public Detalle findDetalleByIdDetalle(int id_detalle) {
		return detalleDao.findDetalleByIdDetalle(id_detalle);
	}
	
	public void insertarDetalle(Detalle detalle) {
		detalleDao.insertarDetalle(detalle);
	}
	
	
	
}
