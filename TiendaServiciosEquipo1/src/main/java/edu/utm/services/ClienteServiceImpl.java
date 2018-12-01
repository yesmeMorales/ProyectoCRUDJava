package edu.utm.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import edu.utm.bd.domain.Cliente;
import edu.utm.dao.tienda.ClienteDao;
@Named
public class ClienteServiceImpl implements ClienteService{
	@Inject
	ClienteDao clienteDao;
	
	@Override
	public List<Cliente> findAllClientes() {
		// TODO Auto-generated method stub
		return clienteDao.findAllClientes();
	}

	@Override
	public void updateCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.updateCliente(cliente);
	}

	@Override
	public void insertCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.insertCliente(cliente);
	}

	@Override
	public Cliente findClienteByNombre(String nombreCliente) {
		// TODO Auto-generated method stub
		return clienteDao.findClienteByNombre(nombreCliente);
	}

	@Override
	public void deleteCliente(int id) {
		// TODO Auto-generated method stub
		clienteDao.deleteCliente(id);
	}

}
