package edu.utm.services;

import java.util.List;

import edu.utm.bd.domain.Vendedor;

public interface VendedorService {
	List<Vendedor> findAllVendedores();
	void updateVendedor(Vendedor vendedor);
	void insertVendedor(Vendedor vendedor);
	Vendedor findVendedorByUsername(String usernameVendedor);
	void deleteVendedor(int id);
}
