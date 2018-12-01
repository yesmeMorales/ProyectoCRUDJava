package edu.utm.managedBean.tienda;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;





import edu.utm.bd.domain.Vendedor;
import edu.utm.services.VendedorService;

@Named
public class VendedorBean {
	@Inject
	VendedorService vendedorService;
	private List<Vendedor>vendedorList;
	private String usernameVendedor;
	
	public List<Vendedor> getVendedorList(){
		if(vendedorList==null)
			setVendedorList(vendedorService.findAllVendedores());
		return vendedorList;
	}
	public String getUsernameVendedor() {
		return usernameVendedor;
	}
	public void setUsernameVendedor(String usernameVendedor) {
		this.usernameVendedor = usernameVendedor;
	}
	
	public Vendedor getVendedorByUsername(){
		return vendedorService.findVendedorByUsername(getUsernameVendedor());
		 
	}
	public void setVendedorList(List<Vendedor> vendedorList){
		this.vendedorList=vendedorList;
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
