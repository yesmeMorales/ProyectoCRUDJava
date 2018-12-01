package edu.utm.dao.tienda;

import java.util.List;

import edu.utm.bd.domain.Detalle;

public interface DetalleDao {
	List <Detalle> findAllDetalles();
	void updateDetalle(Detalle detalle);
	List <Detalle> findDetalleByIdFactura(int id_factura);
	Detalle findDetalleByIdDetalle(int id_detalle);
	void insertarDetalle(Detalle detalle);
}

