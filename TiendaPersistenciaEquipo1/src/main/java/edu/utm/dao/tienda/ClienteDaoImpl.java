package edu.utm.dao.tienda;

import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utm.bd.domain.Cliente;
import edu.utm.bd.mappers.ClienteMapper;




@Named
public class ClienteDaoImpl implements ClienteDao{
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Cliente> findAllClientes() {
		// TODO Auto-generated method stub
		List<Cliente> list = null;
		
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			list = clienteMapper.findAllClientes();
			System.out.println("**********BUSQUEDA DE TODOS LOS CLIENTES**********");
			for(Cliente c:list){
				System.out.println("ID: " + c.getIdCliente());
				System.out.println("Nombre: "+ c.getNombre());
			}
			return list;
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
		return null;
	}

	@Override
	public void updateCliente(Cliente cliente) {
		try{
			ClienteMapper clienteMapper = sqlSession.
					getMapper(ClienteMapper.class);
			clienteMapper.updateCliente(cliente);
			System.out.println("Se ha editado un cliente");
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
	}

	@Override
	public void insertCliente(Cliente cliente) {
		try{
			
			ClienteMapper clienteMapper = sqlSession.
					getMapper(ClienteMapper.class);
			clienteMapper.insertCliente(cliente);
			System.out.println("Se ha insertado un cliente");
			
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	

	@Override
	public void deleteCliente(int id) {
		try{
			ClienteMapper clienteMapper = sqlSession.
					getMapper(ClienteMapper.class);
			clienteMapper.deleteCliente(id);
			System.out.println("Se ha eliminado el cliente" +id);
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
	}

	@Override
	public Cliente findClienteByNombre(String nombreCliente) {
		Cliente c = null;
		try{
			ClienteMapper clienteMapper=sqlSession.getMapper(ClienteMapper.class);
			c = clienteMapper.findClienteByNombre(nombreCliente);
			System.out.println("**********BUSQUEDA POR NOMBRE DE CLIENTE**********");
			System.out.println("Nombre: "+ c.getNombre());
			System.out.println("Apellido: "+ c.getApellido());
		return c;
		}catch(Exception e){
			System.out.println("Error:" +e);
		}
		return null;
	}
	
	
}
