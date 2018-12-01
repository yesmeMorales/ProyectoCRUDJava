package edu.utm.dao.tienda;

import java.util.List;
import java.util.Map;

import edu.utm.bd.domain.Factura;

public interface FacturaDao {
	List<Factura> findProductosByIdFactura(int id_factura);
	List<Factura> findFacturaDay(String fecha);
	List<Factura> findFacturaWeek(Map<String, String> fechas);
	void insertFactura(Factura factura);
	int lastIdFact();
	List<Factura> findFacturaByNombre(String nombreCliente);
}
