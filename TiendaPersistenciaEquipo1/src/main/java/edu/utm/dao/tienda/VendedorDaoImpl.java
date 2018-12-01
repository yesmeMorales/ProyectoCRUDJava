package edu.utm.dao.tienda;

import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;












import edu.utm.bd.domain.Vendedor;
import edu.utm.bd.mappers.VendedorMapper;


@Named
public class VendedorDaoImpl implements VendedorDao{
	
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Vendedor> findAllVendedores() {
		// TODO Auto-generated method stub
		List<Vendedor> list = null;
		
		try{
			VendedorMapper vendedorMapper = sqlSession.getMapper(VendedorMapper.class);
			list = vendedorMapper.findAllVendedores();
			System.out.println("**********BUSQUEDA DE TODOS LOS VENDEDORES**********");
			for(Vendedor v:list){
				System.out.println("ID: " + v.getIdVendedor());
				System.out.println("Nombre: "+ v.getNombre());
			}
			return list;
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
		return null;
	}
	@Override
	public void updateVendedor(Vendedor vendedor) {
		try{
			
			VendedorMapper vendedorMapper = sqlSession.
					getMapper(VendedorMapper.class);
			vendedorMapper.updateVendedor(vendedor);
			System.out.println("Se ha editado un vendedor");
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
		
	}
	@Override
	public void insertVendedor(Vendedor vendedor) {
		
		try{
			
			VendedorMapper vendedorMapper = sqlSession.
					getMapper(VendedorMapper.class);
			vendedorMapper.insertVendedor(vendedor);
			System.out.println("Se ha insertado un vendedor");
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
		
	}

	@Override
	public Vendedor findVendedorByUsername(String usernameVendedor) {
		Vendedor v=null;
		try{
			VendedorMapper vendedorMapper = sqlSession.getMapper(VendedorMapper.class);
			v = vendedorMapper.findVendedorByUsername(usernameVendedor);
			System.out.println("**********BUSQUEDA POR USERNAME DE VENDEDOR**********");
			System.out.println("Nombre: "+ v.getNombre());
			System.out.println("Nombre: "+ v.getUsername());
		return v;
		}catch(Exception e){
			System.out.println("Error:" +e);
		}
		return null;
	}

	@Override
	public void deleteVendedor(int id) {
		try{
			VendedorMapper vendedorMapper = sqlSession.getMapper(VendedorMapper.class);
			vendedorMapper.deleteVendedor(id);
			
			System.out.println("Se ha eliminado el Vendedor"+id);
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
		
	}
	
	
}
