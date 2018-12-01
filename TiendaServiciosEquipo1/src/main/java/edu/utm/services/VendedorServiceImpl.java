package edu.utm.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import edu.utm.bd.domain.Vendedor;
import edu.utm.dao.tienda.VendedorDao;

@Named
public class VendedorServiceImpl implements VendedorService {
	@Inject
	VendedorDao vendedorDao;

	@Override
	public List<Vendedor> findAllVendedores() {
		// TODO Auto-generated method stub
		return vendedorDao.findAllVendedores();
	}

	@Override
	public void updateVendedor(Vendedor vendedor) {
		// TODO Auto-generated method stub
		vendedorDao.updateVendedor(vendedor);
		
	}

	@Override
	public void insertVendedor(Vendedor vendedor) {
		// TODO Auto-generated method stub
		vendedorDao.insertVendedor(vendedor);
	}

	@Override
	public Vendedor findVendedorByUsername(String usernameVendedor) {
		// TODO Auto-generated method stub
		return vendedorDao.findVendedorByUsername(usernameVendedor);
	}

	@Override
	public void deleteVendedor(int id) {
		// TODO Auto-generated method stub
		vendedorDao.deleteVendedor(id);
	}
	
	
	
	
}
