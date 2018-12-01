package edu.utm.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.utm.bd.domain.Cliente;
import edu.utm.dao.tienda.ClienteDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteDaoImplTest {
	@Inject
	ClienteDao clienteDao;
	
	@Test
	public void prueba1ConsultarTodo(){
		
		try{
			List<Cliente> lista = clienteDao.findAllClientes();
			assertNotNull(lista);
			
		}catch(Exception ex){
			System.out.println("Error "+ex);
		}
	}
	@Test
	public void prueba2ConsultaByNombre(){
		try{
			Cliente c = clienteDao.findClienteByNombre("Alma");
			assertNotNull(c);
		}catch(Exception ex){
			System.out.println("Error "+ex);
		}
	}

	@Test
	public void prueba4EliminarCliente(){
		try{
			
			
			clienteDao.deleteCliente(4);
			
			
		}catch(Exception ex){
			System.out.println("Error "+ex);
		}
	}
	@Test
	public void prueba5Editar(){
		try{
			Cliente c= new Cliente();
			c.setIdCliente(2);
			c.setNombre("Miguel");
			c.setApellido("Martinez");
			c.setCorreo("miguelMo@gmail.com");
			c.setEstadoCliente(true);
			clienteDao.updateCliente(c);
		} catch(Exception ex){
			System.out.println("Error: " + ex);
		}
	}
	

}
