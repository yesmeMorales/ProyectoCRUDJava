package edu.utm.managedBean.tienda;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import edu.utm.bd.domain.Producto;
import edu.utm.services.ProductoService;

@Named
public class VentasBean {

	@Inject
	ProductoService productoService;
	
	private List<Producto> productoList;
	private List<Producto> filteredProductoList;
	private List<Producto> carritoProductoList;
	
	private double total;
	
	@PostConstruct
    public void postConstruct() {
		setProductoList(productoService.findAllProductos());
		carritoProductoList= new ArrayList<>();
		setTotal(0);
    }
	
	public List<Producto> getProductoList() {
		return productoList;
	}
	
	public void setProductoList(List<Producto> productoList){
		this.productoList= productoList;
	}

    public List<Producto> getFilteredProductoList() {
        return filteredProductoList;
    }

    public void setFilteredProductoList(List<Producto> filteredProductoList) {
        this.filteredProductoList = filteredProductoList;
    }
    
    public List<Producto> getCarritoProductoList() {
        return carritoProductoList;
    }

    public void setcarritoProductoList(List<Producto> carritoProductoList) {
        this.carritoProductoList = carritoProductoList; 
    }
    
    public void agregarCarrito(Producto producto) {
    	System.out.println(producto.getNombre());
		if (this.carritoProductoList.contains(producto)) {
			FacesMessage msg = new FacesMessage("El producto ya se encuentra en el carrito",
					producto.getNombre().toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			this.carritoProductoList.add(producto);
			setTotal(getTotal() + producto.getPrecio());
			FacesMessage msg = new FacesMessage("Producto agregado al carrito", producto.getNombre().toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
    }
    public void eliminarCarrito(Producto producto) {
		System.out.println("+ " + producto.getNombre());
		this.carritoProductoList.remove(producto);
		setTotal(getTotal() - producto.getPrecio());
		FacesMessage msg = new FacesMessage("Producto eliminado del carrito", producto.getNombre().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void cobrarProductos() {
    	System.out.println(" - ");
    	if( this.carritoProductoList.isEmpty() ) {
    		FacesMessage msg= new FacesMessage("No hay productos en el carrito","");
    		FacesContext.getCurrentInstance().addMessage(null, msg);
    	} else {
    		productoService.updateListaProductos( this.carritoProductoList );
    		FacesMessage msg= new FacesMessage("Compra exitosa","");
    		FacesContext.getCurrentInstance().addMessage(null, msg);
    		this.carritoProductoList= new ArrayList<>();
    		setTotal(0);
    	}
    }
	
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
