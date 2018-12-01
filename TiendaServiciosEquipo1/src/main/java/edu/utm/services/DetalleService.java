package edu.utm.services;

import java.util.List;

import edu.utm.bd.domain.Detalle;

public interface DetalleService {
	List <Detalle> findAllDetalles();
	void updateDetalle(Detalle detalle);
	List <Detalle> findDetalleByIdFactura(int id_factura);
	Detalle findDetalleByIdDetalle(int id_detalle);
	void insertarDetalle(Detalle detalle);
}
