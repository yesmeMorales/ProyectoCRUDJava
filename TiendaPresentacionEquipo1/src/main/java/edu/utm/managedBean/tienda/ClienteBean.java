package edu.utm.managedBean.tienda;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import edu.utm.bd.domain.Cliente;
import edu.utm.services.ClienteService;

@Named
public class ClienteBean {
	@Inject
	ClienteService clienteService;
	private List<Cliente>clienteList;
	private String nombreCliente;
	
	public List<Cliente> getClienteList(){
		if(clienteList==null)
			setClienteList(clienteService.findAllClientes());
		return clienteList;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public Cliente getClienteByNombre(){
		return clienteService.findClienteByNombre(getNombreCliente());
		 
	}
	public void setClienteList(List<Cliente> clienteList){
		this.clienteList=clienteList;
	}
	public void onRowEdit(RowEditEvent event){
		Cliente cliente=((Cliente) event.getObject());
		System.out.println("datos cliente:"+cliente.getIdCliente());
		clienteService.updateCliente(cliente);
		FacesMessage msg=new FacesMessage("Cliente editado",cliente.getIdCliente().toString());
		FacesContext.getCurrentInstance().addMessage(null,msg);
	}
	public void onRowCancel(RowEditEvent event){
		FacesMessage msg=new FacesMessage("Edicion cancelada",((Cliente) event.getObject()).getIdCliente().toString());
		FacesContext.getCurrentInstance().addMessage(null,msg);
	}
	public void onCellEdit(CellEditEvent event){
		Object oldValue=event.getOldValue();
		Object newValue=event.getNewValue();
		System.out.println("verfica:" +newValue);
		if(newValue!=null && !newValue.equals(oldValue)){
			FacesMessage msg =new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente modificado","antes:"+oldValue+",ahora:"+newValue);
			FacesContext.getCurrentInstance().addMessage(null,msg);
		}
	}
}
