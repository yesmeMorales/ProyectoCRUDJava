package edu.utm.bd.domain;

public class Producto {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column producto.id_producto
     *
     * @mbggenerated Wed Apr 25 18:29:14 CDT 2018
     */
    private Integer idProducto;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column producto.nombre
     *
     * @mbggenerated Wed Apr 25 18:29:14 CDT 2018
     */
    private String nombre;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column producto.precio
     *
     * @mbggenerated Wed Apr 25 18:29:14 CDT 2018
     */
    private Long precio;
    private Long precioCompra;

   

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column producto.stock
     *
     * @mbggenerated Wed Apr 25 18:29:14 CDT 2018
     */
    private Integer stock;
    private Boolean estadoProducto;
  

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column producto.id_producto
     *
     * @return the value of producto.id_producto
     *
     * @mbggenerated Wed Apr 25 18:29:14 CDT 2018
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column producto.id_producto
     *
     * @param idProducto the value for producto.id_producto
     *
     * @mbggenerated Wed Apr 25 18:29:14 CDT 2018
     */
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column producto.nombre
     *
     * @return the value of producto.nombre
     *
     * @mbggenerated Wed Apr 25 18:29:14 CDT 2018
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column producto.nombre
     *
     * @param nombre the value for producto.nombre
     *
     * @mbggenerated Wed Apr 25 18:29:14 CDT 2018
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column producto.precio
     *
     * @return the value of producto.precio
     *
     * @mbggenerated Wed Apr 25 18:29:14 CDT 2018
     */
    public Long getPrecio() {
        return precio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column producto.precio
     *
     * @param precio the value for producto.precio
     *
     * @mbggenerated Wed Apr 25 18:29:14 CDT 2018
     */
    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column producto.stock
     *
     * @return the value of producto.stock
     *
     * @mbggenerated Wed Apr 25 18:29:14 CDT 2018
     */
    
    public Long getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(Long precioCompra) {
		this.precioCompra = precioCompra;
	}
    
    public Integer getStock() {
        return stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column producto.stock
     *
     * @param stock the value for producto.stock
     *
     * @mbggenerated Wed Apr 25 18:29:14 CDT 2018
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    public Boolean getEstadoProducto() {
  		return estadoProducto;
  	}

  	public void setEstadoProducto(Boolean estadoProducto) {
  		this.estadoProducto = estadoProducto;
  	}
}