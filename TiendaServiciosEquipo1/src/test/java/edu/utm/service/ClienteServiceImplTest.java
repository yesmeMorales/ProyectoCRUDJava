package edu.utm.service;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.utm.bd.domain.Cliente;
import edu.utm.services.ClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= { "/applicationContext.xml"})
//Sirve para ejecutar lo metodos en orden ascendente de acuerdo al nombre
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteServiceImplTest {
	@Inject
	ClienteService clienteService;
	
	@Test
	public void prueba1ConsultarTodoClientes(){
		try{
			List<Cliente> lista= clienteService.findAllClientes();
			assertNotNull(lista);
		}catch(Exception ex){
			System.out.println("error:" + ex);
		}
	}
	@Test
	public void prueba2consultaNombreCliente(){
		try{
			Cliente c= clienteService.findClienteByNombre("Alma");
			assertNotNull(c);
		}catch(Exception ex){
			System.out.println("error:" + ex);
			
		}
	}
	
	@Test
	public void prueba4EliminarCliente(){
		try{
			
			
			clienteService.deleteCliente(4);
			
			
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
			c.setCorreo("miguelMa@gmail.com");
			c.setEstadoCliente(true);
			clienteService.updateCliente(c);
		} catch(Exception ex){
			System.out.println("Error: " + ex);
		}
	}
}
