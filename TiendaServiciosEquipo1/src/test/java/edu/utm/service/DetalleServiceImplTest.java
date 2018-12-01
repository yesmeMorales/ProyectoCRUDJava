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

import edu.utm.bd.domain.Detalle;
import edu.utm.services.DetalleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DetalleServiceImplTest {

	@Inject
	DetalleService detalleService;
	
	@Test
	public void prueba1ConsultarTodo() {
		try {
			List<Detalle> lista = 
					detalleService.findAllDetalles();
			assertNotNull(lista);
		}catch(Exception ex) {
			System.out.println("Error "+ ex);
		}
	}
	
	@Test
	public void prueba2ConsultarByIdFactura() {
		try { 
			 detalleService.findDetalleByIdFactura(1);
		}catch(Exception ex) {
			System.out.println("Error "+ ex);
		}
	}
	
	@Test
	public void prueba3ConsultarByIdDetalle() {
		try {
			detalleService.findDetalleByIdDetalle(1);
		}catch(Exception ex) {
			System.out.println("Error: "+ ex);
		}
	}
	
	
}
