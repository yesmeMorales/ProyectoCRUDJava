package edu.utm.dao.tienda;

import edu.utm.bd.domain.Detalle;
import edu.utm.bd.mappers.DetalleMapper;

import java.util.List;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;


@Named
public class DetalleDaoImpl implements DetalleDao {

SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Detalle> findAllDetalles(){
		List<Detalle> list = null;
		try {
			DetalleMapper detalleMapper = sqlSession.getMapper(DetalleMapper.class);
			list = detalleMapper.findAllDetalles();
			System.out.println("*************** Test findAllDetalle *************");
			for(Detalle c:list) {
				System.out.println("Id: " + c.getIdDetalle());
				System.out.println("cantidad: " + c.getCantidad());
				System.out.println("Monto: " + c.getMonto());
			}
			return list;
		}catch(Exception e) {
			System.out.println("Error: "+ e);
		}
		return null;
	}
	
	@Override
	public void updateDetalle(Detalle detalle) {
		try {
			DetalleMapper detalleMapper = sqlSession.getMapper(DetalleMapper.class);
			detalleMapper.updateDetalle(detalle);
		}catch(Exception e) {
			System.out.println("Error: "+ e);
		}
	}

	@Override
	public List<Detalle> findDetalleByIdFactura(int id_factura) {
		// TODO Auto-generated method stub
		List<Detalle> detalle = null;
		try {
			
			DetalleMapper detalleIdFactura = sqlSession.getMapper(DetalleMapper.class);
			detalle = detalleIdFactura.findDetalleByIdFactura(id_factura);
			System.out.println("*************** Test findDetalleByIdFactura *************");
			for(Detalle c:detalle) {
				System.out.println("Id_Factura: " + c.getIdFactura());
				System.out.println("Cantidad: " + c.getCantidad());
				System.out.println("Monto: " +c.getMonto());
			}
			return detalle;
			
		}catch(Exception e) {
			System.out.println("Error: "+ e);
		}
		return null;
	}

	@Override
	public Detalle findDetalleByIdDetalle(int id_detalle) {
		Detalle detalle = null;
		try {
			DetalleMapper detalleIdDetalle = sqlSession.getMapper(DetalleMapper.class);
			detalle = detalleIdDetalle.findDetalleByIdDetalle(id_detalle);
			System.out.println("*************** Test findDetalleByIdDetalle *************");
			System.out.println("Id_Detalle: " + detalle.getIdDetalle());
			System.out.println("Cantidad: " + detalle.getCantidad());
			System.out.println("Monto: " +detalle.getMonto());
			return detalle;
		}catch(Exception e) {
			System.out.println("Error: "+ e);
		}
		return null;
	}

	@Override
	public void insertarDetalle(Detalle detalle) {
		try {
			DetalleMapper detalleMapper = sqlSession.getMapper(DetalleMapper.class);
			detalleMapper.insertarDetalle(detalle);
			System.out.println("*************** Test insertarDetalle *************");
			System.out.println("Detalles ingresados correctamente en la base de datos");
		}catch(Exception e) {
			System.out.println("Error: "+ e);
		}
		
	}
	
	
	
	
		
}
