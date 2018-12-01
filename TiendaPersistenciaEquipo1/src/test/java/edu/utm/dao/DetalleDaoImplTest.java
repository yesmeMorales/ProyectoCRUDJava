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

import edu.utm.bd.domain.Detalle;
import edu.utm.dao.tienda.DetalleDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DetalleDaoImplTest {
	@Inject
	DetalleDao detalleDao;
	
	@Test
	public void prueba1ConsultarTodo() {
		try {
			List<Detalle> lista = 
					detalleDao.findAllDetalles();
			assertNotNull(lista);
		}catch(Exception ex) {
			System.out.println("Error "+ ex);
		}
	}
	
	@Test
	public void prueba2ConsultarByIdFactura() {
		try { 
			 detalleDao.findDetalleByIdFactura(1);
		}catch(Exception ex) {
			System.out.println("Error "+ ex);
		}
	}
	
	@Test
	public void prueba3ConsultarByIdDetalle() {
		try {
			detalleDao.findDetalleByIdDetalle(1);
		}catch(Exception ex) {
			System.out.println("Error: "+ ex);
		}
	}
	
	@Test
	public void prueba4InsertarDetalle() {
		try {
			Detalle detalle = new Detalle();
//			detalle.setIdDetalle(14);
			detalle.setIdProducto(2);
			detalle.setCantidad(3);
			detalle.setMonto((long)1350.50);
			detalle.setIdFactura(4);		
			detalleDao.insertarDetalle(detalle);
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
}


