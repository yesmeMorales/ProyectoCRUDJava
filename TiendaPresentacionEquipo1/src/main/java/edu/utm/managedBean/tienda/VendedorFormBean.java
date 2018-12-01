package edu.utm.managedBean.tienda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;




import edu.utm.bd.domain.Vendedor;
import edu.utm.services.VendedorService;

@Named
@ViewScoped
public class VendedorFormBean implements Serializable{
	private static final long serialVersionUID=6472377493921731094L;

	@Inject
	VendedorService vendedorService;
	private List<Vendedor> listaVendedor;
	private List<Vendedor> filteredVendedorList;
	
	
	private Vendedor vendedor;
	
	
	@PostConstruct
	public void init(){
		if(listaVendedor==null)
			listaVendedor=new ArrayList<Vendedor>();
		if(vendedor==null)
			vendedor=new Vendedor();
		setlistaVendedor(vendedorService.findAllVendedores());
	}
	
	
	//metodo que registra nuevo cliente
	public void registrar(){
		System.out.println("vendedor con direccion!!!");
		//invocar al servicio
		vendedorService.insertVendedor(getVendedor());
		FacesMessage msg=new FacesMessage("Vendedor agregado",getVendedor().getNombre());
		FacesContext.getCurrentInstance().addMessage(null,msg);
		//limpia los valores del objeto
		setVendedor(new Vendedor());
		//se actualiza los valores de la tabla
		setlistaVendedor(vendedorService.findAllVendedores());
		getlistaVendedor();
	}
	public Vendedor getVendedor(){
		return vendedor;
		
	}
	private void setVendedor(Vendedor vendedor) {
		this.vendedor=vendedor;
		
	}
	
	public List<Vendedor> getlistaVendedor(){
		return listaVendedor;
		
	}

	

	private void setlistaVendedor(List<Vendedor> listaVendedor) {
		this.listaVendedor=listaVendedor;
		
	}
	public void eliminar(Vendedor vendedorEliminar){
		
		System.out.println(vendedorEliminar.getNombre());
		//invocar al servicio
		vendedorService.deleteVendedor(vendedorEliminar.getIdVendedor());
		FacesMessage msg=new FacesMessage("Vendedor eliminado",vendedorEliminar.getIdVendedor().toString());
		FacesContext.getCurrentInstance().addMessage(null,msg);
		//se actualiza los valores de la tabla
		setlistaVendedor(vendedorService.findAllVendedores());
		getlistaVendedor();
	}
	
	public List<Vendedor> getFilteredVendedorList() {
	    return filteredVendedorList;
	}

	public void setFilteredVendedorList(List<Vendedor> filteredVendedorList) {
	    this.filteredVendedorList = filteredVendedorList;
	}
	
	public void onRowEdit(RowEditEvent event){
		Vendedor vendedor=((Vendedor) event.getObject());
		System.out.println("datos vendedor:"+vendedor.getIdVendedor());
		vendedorService.updateVendedor(vendedor);
		FacesMessage msg=new FacesMessage("Vendedor editado",vendedor.getIdVendedor().toString());
		FacesContext.getCurrentInstance().addMessage(null,msg);
	}
	public void onRowCancel(RowEditEvent event){
		
		FacesMessage msg=new FacesMessage("Edicion cancelada",((Vendedor) event.getObject()).getIdVendedor().toString());
		FacesContext.getCurrentInstance().addMessage(null,msg);
	}
	public void onCellEdit(CellEditEvent event){
		Object oldValue=event.getOldValue();
		Object newValue=event.getNewValue();
		System.out.println("verfica:" +newValue);
		if(newValue!=null && !newValue.equals(oldValue)){
			FacesMessage msg =new FacesMessage(FacesMessage.SEVERITY_INFO,"Vendedor modificado","antes:"+oldValue+",ahora:"+newValue);
			FacesContext.getCurrentInstance().addMessage(null,msg);
		}
	}
	
}
