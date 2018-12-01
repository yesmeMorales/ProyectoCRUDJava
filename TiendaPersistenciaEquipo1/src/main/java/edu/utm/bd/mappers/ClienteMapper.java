package edu.utm.bd.mappers;

import java.util.List;

import edu.utm.bd.domain.Cliente;

public interface ClienteMapper {
	List<Cliente>findAllClientes();
	void updateCliente(Cliente cliente);
	void insertCliente(Cliente cliente);
	Cliente findClienteByNombre(String nombreCliente);
	void deleteCliente(int id);

}
