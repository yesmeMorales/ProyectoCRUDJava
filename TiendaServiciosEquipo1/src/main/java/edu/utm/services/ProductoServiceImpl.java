package edu.utm.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import edu.utm.bd.domain.Producto;
import edu.utm.dao.tienda.ProductoDao;

@Named
public class ProductoServiceImpl implements ProductoService{
	@Inject
	ProductoDao productoDao;
	
	@Override
	public List<Producto> findAllProductos() {
		return productoDao.findAllProductos();
	}
	@Override
	public Producto findProductoById(int id) {
		return productoDao.findProductoById(id);
	}
	@Override
	public void insertProducto(Producto producto) {
		productoDao.insertProducto(producto);
	}
	@Override
	public void deleteProducto(int id) {
		productoDao.deleteProducto(id);
	}
	@Override
	public void updateProducto(Producto producto) {
		productoDao.updateProducto(producto);
	}
	@Override
	public void updateListaProductos(List<Producto> listaproductos) {
		productoDao.updateListaProductos(listaproductos);
		
	}
	@Override
	public List<Producto> findAllProductosVentas() {
		return productoDao.findAllProductosVentas();
	}
}