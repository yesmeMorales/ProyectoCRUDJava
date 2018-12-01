package edu.utm.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;






import edu.utm.bd.domain.Vendedor;
import edu.utm.dao.tienda.VendedorDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendedorDaoImplTest {
	@Inject
	VendedorDao vendedorDao;
	
	@Test
	public void prueba1ConsultarTodo(){
		
		try{
			List<Vendedor> lista = vendedorDao.findAllVendedores();
			assertNotNull(lista);
		}catch(Exception ex){
			System.out.println("Error "+ex);
		}
	}
	@Test
	public void prueba2ConsultaUsername(){
		try{
			Vendedor v = vendedorDao.findVendedorByUsername("capibara");
			assertNotNull(v);
		}catch(Exception ex){
			System.out.println("Error "+ex);
		}
	}
	
	
	@Test
	public void prueba4EliminarVendedor(){
		try{
			
			vendedorDao.deleteVendedor(4);
			
			
		}catch(Exception ex){
			System.out.println("Error "+ex);
		}
	}
	@Test
	public void prueba5Editar(){
		try{
			Vendedor v= new Vendedor();
			v.setIdVendedor(2);
			v.setNombre("Carlos");
			v.setApellido("Martinez");
			v.setUsername("pinguino");
			v.setContrasena("m4fe");
			v.setCorreo("carlos@gmail.com");
			v.setAdministrador(false);
			v.setEstadoVendedor(true);
			vendedorDao.updateVendedor(v);
		} catch(Exception ex){
			System.out.println("Error: " + ex);
		}
	}
	

}
