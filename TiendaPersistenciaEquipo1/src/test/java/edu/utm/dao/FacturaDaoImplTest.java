package edu.utm.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.utm.bd.domain.Factura;
import edu.utm.dao.tienda.FacturaDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacturaDaoImplTest {
		@Inject
		FacturaDao facturaDao;
		
		@Test
		public void prueba1ConsultarByIdFactura() {
			try { 
				 facturaDao.findProductosByIdFactura(1);
			}catch(Exception ex) {
				System.out.println("Error "+ ex);
			}
		}
		
		@Test
		public void prueba2ConsultarByNombreFactura() {
			try { 
				 facturaDao.findFacturaByNombre("Miguel");
			}catch(Exception ex) {
				System.out.println("Error "+ ex);
			}
		}
		
		@Test
		public void prueba4ConsultarPerWeek(){
			try{
				Map<String, String> fechas = new HashMap<String, String>();
				fechas.put("fechai", "2018-02-14");
				fechas.put("fechaf", "2018-04-26");
				facturaDao.findFacturaWeek(fechas);
			}catch(Exception ex){
				System.out.println("Error " + ex);
			}
		}
		
		@Test
		public void prueba5Insertar(){
			try{
				String inputString = "2018-06-15";
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date inputDate = dateFormat.parse(inputString);
				
				Factura f = new Factura();
				f.setIdCliente(2);
				f.setIdVendedor(2);
				f.setFecha(inputDate);
				f.setMontoTotal((long) 8000.20);
				facturaDao.insertFactura(f);
			}catch(Exception e){
				System.out.println("Error " + e);
			}
		}
		
		@Test
		public void prueba6ConsultarUltIdFactura() {
			try { 
				 facturaDao.lastIdFact();
			}catch(Exception ex) {
				System.out.println("Error "+ ex);
			}
		}
}
