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






import edu.utm.bd.domain.Vendedor;
import edu.utm.services.VendedorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= { "/applicationContext.xml"})
//Sirve para ejecutar lo metodos en orden ascendente de acuerdo al nombre
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class VendedorServiceImplTest {
	@Inject
	VendedorService vendedorService;
	
	@Test
	public void prueba1ConsultarTodo(){
		try{
			List<Vendedor> lista=vendedorService.findAllVendedores();
			assertNotNull(lista);
			
		}catch(Exception e){
			System.out.println("error:" +e);
		}
	}
	@Test
	public void prueba2ConsultaUsername(){
		try{
			Vendedor v = vendedorService.findVendedorByUsername("capibara");
			assertNotNull(v);
		}catch(Exception ex){
			System.out.println("Error "+ex);
		}
	}
	
	@Test
	public void prueba4EliminarVendedor(){
		try{
			
			
			vendedorService.deleteVendedor(4);
			
			
		}catch(Exception ex){
			System.out.println("Error "+ex);
		}
	}
	@Test
	public void prueba5Editar(){
		try{
			Vendedor v= new Vendedor();
			v.setIdVendedor(2);
			v.setNombre("Martin");
			v.setApellido("Martinez");
			v.setUsername("pinguino");
			v.setContrasena("m4fe");
			v.setCorreo("martin@gmail.com");
			v.setAdministrador(false);
			v.setEstadoVendedor(true);
			vendedorService.updateVendedor(v);
			System.out.println("Vendedor editado.");
		} catch(Exception ex){
			System.out.println("Error: " + ex);
		}
	}
	
}
