package edu.utm.dao.tienda;

import java.util.List;

import edu.utm.bd.domain.Cliente;

public interface ClienteDao {
	List <Cliente>findAllClientes();
	void updateCliente(Cliente cliente);
	void insertCliente(Cliente cliente);
	Cliente findClienteByNombre(String nombreCliente);
	void deleteCliente(int id);
}
