package edu.utm.managedBean.tienda;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import edu.utm.bd.domain.Producto;
import edu.utm.services.ProductoService;

@Named
public class ProductoBean {
	@Inject
	ProductoService productoService;
	private List<Producto> productoList;
	private String nombrefiltro;
	
	public List<Producto> getProductoList() {
		if(productoList == null)
			setProductoList(productoService.findAllProductos());
		return productoList;
	}

	
	public String getNombreFiltro(){
		return this.nombrefiltro;
	}
	
	public void setProductoList(List<Producto> productoList){
		this.productoList= productoList;
	}
	
	
	public void onRowEdit(RowEditEvent event){
		Producto producto= ((Producto) event.getObject());
		System.out.println("datos producto: " + producto.getIdProducto());
		productoService.updateProducto(producto);
		
		FacesMessage msg= new FacesMessage("Producto editado",producto.getNombre().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowCancel(RowEditEvent event){
		FacesMessage msg= new FacesMessage("Edición cancelada", ((Producto) event.getObject()).getNombre().toString() );
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onCellEdit(CellEditEvent event){
		Object oldValue= event.getOldValue();
		Object newValue= event.getNewValue();
		System.out.println("Verifica" + newValue);
		
		if(newValue != null && !newValue.equals(oldValue)){
			FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto modificado","antes: " + oldValue + ", Ahora: " + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);	
		}
	}
}

