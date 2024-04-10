package com.crud.producto.model;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Productos")
public class Productos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id", nullable=false)
	private int id;
	@Column( name="nombre", nullable = false, length = 35)
	private String nombre;
	@Column( name="descripcion", nullable = false, length = 255)
	private String descripcion;
	@Column(name="precio", nullable = false, length = 11)
	private double precio;
	@Column( name="cantidad", nullable = false, length = 11)
	private int cantidad;
	@Column( name="imagen_base", nullable = true)
	private String  imagen_base;
	@Column( name="imagen_url", nullable = true, length = 35 )
	private String imagen_url;
	
	public Productos() {
	}

	
	
	public Productos(int id, String nombre, String descripcion, double precio, int cantidad, String  imagen_base,
			String imagen_url) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.imagen_base = "data:image/jpeg;base64,"+ imagen_base;
		this.imagen_url = imagen_url;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public String  getImagen_base() {
		return imagen_base;
	}



	public void setImagen_base(String  imagen_base) {
		this.imagen_base = imagen_base;
	}



	public String getImagen_url() {
		return imagen_url;
	}



	public void setImagen_url(String imagen_url) {
		this.imagen_url ="data:image/jpeg;base64,"+ imagen_url;
	}

	
		
	
	
}
