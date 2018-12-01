package edu.utm.managedBean.tienda;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import edu.utm.bd.domain.Cliente;
import edu.utm.bd.domain.Detalle;
import edu.utm.bd.domain.Factura;
import edu.utm.bd.domain.Producto;
import edu.utm.bd.domain.Vendedor;
import edu.utm.services.ClienteService;
import edu.utm.services.DetalleService;
import edu.utm.services.FacturaService;
import edu.utm.services.ProductoService;
import edu.utm.services.VendedorService;


@Named
@ViewScoped
public class ProductoFormBean implements Serializable{
	private static final long serialVersionUID=6572377493921731095L;
	
	@Inject
	ProductoService productoService;
	@Inject
	VendedorService vendedorService;
	@Inject
	ClienteService clienteService;
	@Inject
	FacturaService facturaService;
	@Inject
	DetalleService detalleService;
	
	private List<Producto> productoList;
	private List<Producto> filteredProductoList;
	private Producto producto;
	
	private List<Producto> productoVentasList;
	private List<Producto> filteredProductoVentasList;
	
	private Map<Integer, Integer> cantidadProd;
	private List<Producto> carritoProductoList;
	private List<Producto> productoFacturaImprimir;
	

	private double total;
	
	@PostConstruct
	public void init(){
		vendedoresV = vendedorService.findAllVendedores();
		clientesV = clienteService.findAllClientes();
		if(productoList==null)
			productoList=new ArrayList<Producto>();
		if(producto==null)
			producto=new Producto();
		if(carritoProductoList == null)
			carritoProductoList = new ArrayList<>();
		if(cantidadProd == null)
			cantidadProd = new HashMap<Integer, Integer>();
		
		setProductoList(productoService.findAllProductos());
		setProductoVentasList( productoService.findAllProductosVentas() );
	}
	
	private List<Vendedor> vendedoresV;
	private List<Cliente> clientesV;
	
	private int idVen;
	private int idCli;
	
	public int getIdVen() {
		return idVen;
	}

	public void setIdVen(int idVen) {
		this.idVen = idVen;
	}

	public int getIdCli() {
		return idCli;
	}

	public void setIdCli(int idCli) {
		this.idCli = idCli;
	}

	public List<Vendedor> getVendedoresV() {
		return vendedorService.findAllVendedores();
	}

	public void setVendedoresV(List<Vendedor> vendedoresV) {
		this.vendedoresV = vendedoresV;
	}
	
	public List<Cliente> getClientesV() {
		return clienteService.findAllClientes();
		
	}

	public void setClientesV(List<Cliente> clientesV) {
		this.clientesV = clientesV;
	}
	
	//metodo que registra nuevo cliente
	public void registrar(){
		System.out.println("Producto con direccion!!!");
		//invocar al servicio
		productoService.insertProducto(getProducto());
		FacesMessage msg=new FacesMessage("Producto agregado",getProducto().getNombre());
		FacesContext.getCurrentInstance().addMessage(null,msg);
		//limpia los valores del objeto
		setProducto(new Producto());
		//se actualiza los valores de la tabla
		setProductoList(productoService.findAllProductos());
		getProductoList();
		
		setProductoVentasList( productoService.findAllProductosVentas() );
		getProductoVentasList();
	}
	public Producto getProducto(){
		return producto;
	}
	private void setProducto(Producto producto) {
		this.producto=producto;	
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
	
	public void eliminar(Producto productoEliminar){	
		System.out.println(productoEliminar.getNombre());
		//invocar al servicio
		productoService.deleteProducto(productoEliminar.getIdProducto());
		FacesMessage msg=new FacesMessage("Producto eliminado",productoEliminar.getNombre().toString());
		FacesContext.getCurrentInstance().addMessage(null,msg);
		//se actualiza los valores de la tabla
		setProductoList(productoService.findAllProductos());
		getProductoList();
		setProductoVentasList( productoService.findAllProductosVentas() );
		getProductoVentasList();
	}

	public void onRowEdit(RowEditEvent event){
		Producto producto= ((Producto) event.getObject());
		System.out.println("datos producto: " + producto.getIdProducto());
		productoService.updateProducto(producto);
		setProductoVentasList( productoService.findAllProductosVentas() );
		getProductoVentasList();
		
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
	
	public List<Producto> getCarritoProductoList() {
		return carritoProductoList;
	}

	public void setcarritoProductoList(List<Producto> carritoProductoList) {
		this.carritoProductoList = carritoProductoList;
	}
	
	public void agregarCarrito(Producto producto) {
		System.out.println(producto.getNombre());
		if( getCantidadProd(producto) < producto.getStock()  ) {
			this.carritoProductoList.add(producto);
			setTotal(getTotal() + producto.getPrecio());
			setCantidadProd(producto,1);
			FacesMessage msg = new FacesMessage("Producto agregado al carrito", producto.getNombre().toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);	
		} else {
			FacesMessage msg = new FacesMessage("No hay más productos disponibles", producto.getNombre().toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}
	
	public void eliminarCarrito(Producto producto) {
		this.carritoProductoList.remove(producto);
		setTotal(getTotal() - producto.getPrecio());
		setCantidadProd(producto,-1);
		FacesMessage msg = new FacesMessage("Producto eliminado del carrito", producto.getNombre().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void cobrarProductos() {
		FacesContext context=FacesContext.getCurrentInstance();
		int idVendedorLogueado=(int)context.getExternalContext().getSessionMap().get("idVendedor");
		if (this.carritoProductoList.isEmpty()) {
			FacesMessage msg = new FacesMessage("No hay productos en el carrito", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			Calendar c = Calendar.getInstance();
    		String dia = Integer.toString(c.get(Calendar.DATE));
    		String mes = Integer.toString(c.get(Calendar.MONTH)+1);
    		String annio = Integer.toString(c.get(Calendar.YEAR));
    		
    		productoFacturaImprimir=carritoProductoList;
    		
    		System.out.println("El dia es: "+ dia+"El mes es: " + mes+"El annio es: "+ annio);
        	
    		//aqui iba un try
    		
			try {
				int idFact;
				String inputString = annio+"-"+mes+"-"+dia;
	    		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    		Date inputDate;
				inputDate = dateFormat.parse(inputString);
				Factura f = new Factura();
	    		f.setIdCliente(getIdCli());
				f.setIdVendedor(idVendedorLogueado);
				f.setFecha(inputDate);
				f.setMontoTotal((long) getTotal());
				facturaService.insertFactura(f);
				
				idFact = facturaService.lastIdFact();
				
				System.out.println("El id de esta factura es: "+ idFact);
				productoService.updateListaProductos(this.carritoProductoList);
				
				for(Producto p: this.carritoProductoList) {
					Detalle deta = new Detalle();
					deta.setIdProducto(p.getIdProducto());
					deta.setCantidad(1);
					deta.setMonto((long)p.getPrecio());
					deta.setIdFactura(idFact);
					detalleService.insertarDetalle(deta);
					System.out.println(p.getNombre());
					System.out.println(p.getPrecio());
					
				}
				FacesMessage msg = new FacesMessage("Compra exitosa", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				setProductoVentasList( productoService.findAllProductosVentas() );
				getProductoVentasList();
				this.carritoProductoList = new ArrayList<>();
				this.cantidadProd= new HashMap<Integer, Integer>();
				setTotal(0);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    		//try
			
			
			
		}
	}

	public int getCantidadProd(Producto producto) {
		int id= producto.getIdProducto();
		if( cantidadProd.containsKey(id) ){
			return cantidadProd.get(id);
		} else{
			return 0;
		}
	}
	public void setCantidadProd(Producto producto, int cant) {
		int id= producto.getIdProducto();
		if( cantidadProd.containsKey( id ) ){
			cantidadProd.replace( id , (cantidadProd.get(id) + cant) );
		} else{
			cantidadProd.put( producto.getIdProducto() , cant);
		}
	}
	
	public void limpiaTicket(){
		System.out.println("Hola desde limpiarticket");
		this.productoFacturaImprimir = new ArrayList<>();
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}

	public List<Producto> getProductoVentasList() {
		return productoVentasList;
	}

	public void setProductoVentasList(List<Producto> productoVentasList) {
		this.productoVentasList = productoVentasList;
	}

	public List<Producto> getFilteredProductoVentasList() {
		return filteredProductoVentasList;
	}

	public void setFilteredProductoVentasList(List<Producto> filteredProductoVentasList) {
		this.filteredProductoVentasList = filteredProductoVentasList;
	}
	public void vendedorChange() {
		System.out.println("Prueba del ajax vendedor");
	}
	public void clienteChange() {
		System.out.println("Prueba del ajax cliente");
	}
	
	public List<Producto> getProductoFacturaImprimir() {
		return productoFacturaImprimir;
	}

	public void setProductoFacturaImprimir(List<Producto> productoFacturaImprimir) {
		this.productoFacturaImprimir = productoFacturaImprimir;
	}
}
