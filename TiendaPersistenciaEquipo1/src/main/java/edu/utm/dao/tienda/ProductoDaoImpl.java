package edu.utm.dao.tienda;

import java.util.List;
import javax.inject.Named;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utm.bd.domain.Producto;
import edu.utm.bd.mappers.ProductoMapper;

@Named
public class ProductoDaoImpl implements ProductoDao {
	
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession= sqlSession;
	}

	@Override
	public List<Producto> findAllProductos() {
		List<Producto> list = null;
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			list = productoMapper.findAllProductos();
			for ( Producto p : list)
				System.out.println("Id: " + p.getIdProducto() + " Nombre: " + p.getNombre());
			return list;
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	@Override
	public Producto findProductoById(int id) {
		Producto prod = null;
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			prod = productoMapper.findProductoById(id);
			System.out.println("Id: " + prod.getIdProducto() + " Nombre: " + prod.getNombre());
			return prod;
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	@Override
	public void updateListaProductos(List<Producto> listaproductos) {
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			for ( Producto p : listaproductos) {
				p.setStock( p.getStock()-1 );
				productoMapper.updateProducto(p);
				System.out.println("Id: " + p.getIdProducto() + " Nombre: " + p.getNombre());
			}
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	

	@Override
	public void insertProducto(Producto producto) {
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			productoMapper.insertProducto(producto);
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
	}

	@Override
	public void deleteProducto(int id) {
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			productoMapper.deleteProducto(id);
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
		
	}

	@Override
	public void updateProducto(Producto producto) {
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			productoMapper.updateProducto(producto);
		} catch(Exception e){
			System.out.println("Error: " + e);
		}		
	}
	
	@Override
	public List<Producto> findAllProductosVentas() {
		List<Producto> list = null;
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			list = productoMapper.findAllProductosVentas();
			System.out.println("Lista de venta");
			return list;
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

}