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

import edu.utm.bd.domain.Cliente;
import edu.utm.services.ClienteService;

@Named
@ViewScoped
public class ClienteFormBean implements Serializable{
	private static final long serialVersionUID=6472377493921731095L;
	@Inject
	ClienteService clienteService;
	private List<Cliente> listaCliente;
	private List<Cliente> filteredClienteList;
	
	private Cliente cliente;
	
	@PostConstruct
	public void init(){
		if(listaCliente==null)
			listaCliente=new ArrayList<Cliente>();
		if(cliente==null)
			
			cliente=new Cliente();
		setlistaCliente(clienteService.findAllClientes());
	}
	
	//metodo que registra nuevo cliente
	public void registrar(){
		
		System.out.println("cliente con direccion!!!");
		//invocar al servicio
		clienteService.insertCliente(getCliente());
		FacesMessage msg=new FacesMessage("Cliente agregado",getCliente().getNombre());
		FacesContext.getCurrentInstance().addMessage(null,msg);
		//limpia los valores del objeto
		setCliente(new Cliente());
		//se actualiza los valores de la tabla
		setlistaCliente(clienteService.findAllClientes());
		getlistaCliente();
	}
	public Cliente getCliente(){
		return cliente;
	}
	private void setCliente(Cliente cliente) {
		this.cliente=cliente;
		
	}
	
	public List<Cliente> getlistaCliente(){
		return listaCliente;
	}

	

	private void setlistaCliente(List<Cliente> listaCliente) {
		this.listaCliente=listaCliente;
		
	}
	public void eliminar(Cliente clienteEliminar){
		
		System.out.println(clienteEliminar.getNombre());
		//invocar al servicio
		clienteService.deleteCliente(clienteEliminar.getIdCliente());
		FacesMessage msg=new FacesMessage("Cliente eliminado",clienteEliminar.getIdCliente().toString());
		FacesContext.getCurrentInstance().addMessage(null,msg);
		
		//se actualiza los valores de la tabla
		setlistaCliente(clienteService.findAllClientes());
		getlistaCliente();
	}
	
	public List<Cliente> getFilteredClienteList() {
	    return filteredClienteList;
	}

	public void setFilteredClienteList(List<Cliente> filteredClienteList) {
	    this.filteredClienteList = filteredClienteList;
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
