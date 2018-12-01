package edu.utm.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.utm.bd.domain.Producto;
import edu.utm.services.ProductoService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductoServiceImplTest {
	@Inject
	ProductoService productoService;
	
	@Test
	public void prueba1ListarTodo(){
		try{
			
			List<Producto> lista= productoService.findAllProductos();
			assertNotNull(lista);
		} catch(Exception ex){
			System.out.println("Error: " + ex);
		}
	}
	
	@Test
	public void prueba3ListarUno(){
		try{
	
			Producto p= productoService.findProductoById(12);
			assertNotNull(p);
		} catch(Exception ex){
			System.out.println("Error: " + ex);
		}
	}
	
	
	@Test
	public void prueba4Eliminar(){
		try{
			System.out.println("++++++++++ Producto con id 31 eliminado ++++++++++");
			productoService.deleteProducto(31);
		} catch(Exception ex){
			System.out.println("Error: " + ex);
		}
	}
	
	@Test
	public void prueba5Editar(){
		try{
			System.out.println("++++++++++ Producto con id 10 editado ++++++++++");
			Producto p= new Producto();
			p.setIdProducto(10);
			p.setNombre("PSP");
			p.setPrecio((long)1000);
			p.setPrecioCompra((long)500);
			p.setStock(10);
			p.setEstadoProducto(true);
			productoService.updateProducto(p);
		} catch(Exception ex){
			System.out.println("Error: " + ex);
		}
	}

}
