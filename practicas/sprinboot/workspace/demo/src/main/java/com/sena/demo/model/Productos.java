package com.sena.demo.model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.core.io.ClassPathResource;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

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
	
	@Column( name="imagen", nullable = true, length = 255)
	private String imagen;
			
	public Productos() {
		super();
	}
	public Productos(int id, String nombre, String descripcion, double precio, int cantidad, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.imagen=imagen;
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
