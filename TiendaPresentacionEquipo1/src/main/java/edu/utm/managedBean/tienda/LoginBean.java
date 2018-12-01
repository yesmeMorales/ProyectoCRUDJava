package edu.utm.managedBean.tienda;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import edu.utm.bd.domain.Vendedor;
import edu.utm.services.VendedorService;

@Named
public class LoginBean implements Serializable{
	private static final long serialVersionUID = -2152389656664659476L;
	
	@Inject
	VendedorService vendedorService;
	private String username;
	private String password;
	private boolean logueado = false;
	private Vendedor datos;
	
	public Vendedor getDatos() {
		return datos;
	}

	public void setDatos(Vendedor datos) {
		this.datos = datos;
	}

	public boolean estaLogueado(){
		return logueado;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void testLogin(){
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage msg = null;
		logueado = true;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido", username);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		context.addCallbackParam("estaLogueado", logueado);
		if (logueado)
			context.addCallbackParam("view", "tabView.xhtml");
	}
	public void login(){
		RequestContext context = RequestContext.getCurrentInstance();
		FacesContext context2 = FacesContext.getCurrentInstance();
		FacesMessage msg = null;
		System.out.println(getUsername());
		
		if( username != null && password != null){
			try{
				datos = vendedorService.findVendedorByUsername(getUsername());
				if(datos.getContrasena().equals(getPassword())){
					logueado = true;
					msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido", username);
				}else{
					logueado = false;
					msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", 
							"Password incorrecto");
				}
			}catch(Exception ex){
				logueado = false;
				msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", 
						"Credenciales no válidas");
			}
		}else{
			logueado = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", 
										"Introduzca sus datos");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		context.addCallbackParam("estaLogueado", logueado);
		
		if (logueado){
		    context2.getExternalContext().getSessionMap().put("username", getUsername());
		    context2.getExternalContext().getSessionMap().put("idVendedor", datos.getIdVendedor());
		    context2.getExternalContext().getSessionMap().put("nombre", datos.getNombre());
		    context2.getExternalContext().getSessionMap().put("apellido", datos.getApellido());
			if(datos.getAdministrador()){
				context.addCallbackParam("view", "PROYECTO_pages/PROYECTO_secure/primefaces/index_administrador.xhtml");
			}else{
				context.addCallbackParam("view", "PROYECTO_pages/PROYECTO_secure/primefaces/index_vendedor.xhtml");
			}
		}
			
	}
	
	public void logout(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
											.getExternalContext().getSession(false);
		System.out.println(session);
		session.invalidate();
		logueado = false;
	}
	
}
