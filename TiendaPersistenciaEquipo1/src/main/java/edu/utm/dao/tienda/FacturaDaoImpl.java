package edu.utm.dao.tienda;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utm.bd.domain.Factura;
import edu.utm.bd.mappers.FacturaMapper;


@Named
public class FacturaDaoImpl implements FacturaDao{
SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public List<Factura> findFacturaByNombre(String nombreCliente){
		try {
			List<Factura> factura = null;
			FacturaMapper resCliente = sqlSession.getMapper(FacturaMapper.class);
			factura = resCliente.findFacturaByNombre(nombreCliente);
			System.out.println("*************** Test findFacturaByCliente *************");
			//System.out.println(factura);
			for(Factura c:factura) {
				System.out.println("Cliente:"+ c.getClient());
				System.out.println("Vendedor: "+ c.getVendedo());
				System.out.println("Fecha: "+ c.getFecha());
				System.out.println("Monto total: "+ c.getMontoTotal());
				System.out.println("ID factura: "+ c.getIdFactura());
				System.out.println("*******************************************************");
				
			}
			return factura;
			
		}catch(Exception e) {
			System.out.println("Error: "+ e);
		}
		return null;
	}

	public List<Factura> findProductosByIdFactura(int id_factura){
		try {
			List<Factura> factura = null;
			FacturaMapper idFactura = sqlSession.getMapper(FacturaMapper.class);
			factura = idFactura.findProductosByIdFactura(id_factura);
			System.out.println("*************** Test findProductosByIdFactura *************");
			for(Factura c:factura) {
				System.out.println("Cliente:"+ c.getClient());
				System.out.println("Correo cliente: "+ c.getClienteDatos().getCorreo());
				
				System.out.println("Vendedor: "+ c.getVendedo());
				
				System.out.println("Nombre producto: "+ c.getProductoDatos().getNombre());
				System.out.println("Precio unitario: "+ c.getProductoDatos().getPrecio());
				
				System.out.println("Cantidad: "+ c.getDetalleDatos().getCantidad());
				System.out.println("Monto total: "+ c.getMontoTotal());
				System.out.println("*******************************************************");
				
			}
			return factura;
			
		}catch(Exception e) {
			System.out.println("Error: "+ e);
		}
		return null;
	}

	@Override
	public List<Factura> findFacturaDay(String fecha) {
		
		List<Factura> list = null;
		try{
			FacturaMapper facturaMapper =
					sqlSession.getMapper(FacturaMapper.class); 
			list = facturaMapper.findFacturaDay(fecha);
			
			System.out.println("*** TEST SEARCH FACTURA PER DAY ***");
			for(Factura f:list){
				System.out.println("Id " + f.getIdFactura());
				System.out.println("monto_total " + f.getMontoTotal());
			}
			return list;
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
		return null;
	}

	@Override
	public List<Factura> findFacturaWeek(Map<String, String> fechas) {
		List<Factura> list = null; 
		try{
			FacturaMapper facturaMapper =
					sqlSession.getMapper(FacturaMapper.class); 
			list = facturaMapper.findFacturaWeek(fechas);
			
			System.out.println("*** TEST SEARCH FACTURA PER WEEK ***");
			for(Factura f:list){
				System.out.println("Hola");
				System.out.println("Id " + f.getIdFactura());
				System.out.println("monto_total " + f.getMontoTotal());
			}
			return list;
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
		return null;
	}
	
	public void insertFactura(Factura factura) {
		try{
			FacturaMapper facturaMapper =
					sqlSession.getMapper(FacturaMapper.class);
			facturaMapper.insertFactura(factura);
			System.out.println("La factura se ha insertado de forma correcta :) ");
			
		}catch(Exception e){
			System.out.println("Error " + e);
		}
		
	}
	
	public int lastIdFact() {
		try{
			FacturaMapper facturaMapper =
					sqlSession.getMapper(FacturaMapper.class);
			int idFact = facturaMapper.lastIdFact();
			System.out.println("El ultimo ID es: "+idFact);
			return idFact;
		}catch(Exception e){
			System.out.println("Error " + e);
		}
		return 0;
	}
	
	
}
