package edu.utm.dao.tienda;
import java.util.List;
import edu.utm.bd.domain.Producto;

public interface ProductoDao {
	List <Producto> findAllProductos();
	List <Producto> findAllProductosVentas();
	Producto findProductoById(int id);
	void insertProducto(Producto producto);
	void deleteProducto(int id);
	void updateProducto(Producto producto);
	void updateListaProductos(List<Producto> listaproductos);
}