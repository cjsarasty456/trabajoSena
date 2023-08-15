package com.crud.producto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.producto.interfaceService.IproductoService;
import com.crud.producto.model.Productos;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

import jakarta.persistence.Entity;
import netscape.javascript.JSObject;

@Controller
@RequestMapping
public class productoController {
	
	@Autowired
	private IproductoService service;
	
	//web
	@GetMapping("/listarweb")
	public String consultarListaProductos(Model model) {
		List<Productos> listaProductos= service.consultarListaProductos();
		model.addAttribute("productos",listaProductos);
		return "listarproductos";
	}
	@GetMapping("/nuevoProducto")
	public String nuevoProducto(Model model) {
		
		return "agregar";
	}
	
	@GetMapping("/guardarProducto")
	public String guardarProducto(@Validated Productos producto, Model model) {
		service.guardar(producto);
		return "redirect:/listarweb";
	}
	
	//json
	@GetMapping("/listarjson")
	public ResponseEntity<Object> consultarListaProductosJson(Model model) {
		List<Productos> listaProductos= service.consultarListaProductos();
		
		return new ResponseEntity<> (listaProductos, HttpStatus.OK);
	}
	
	@GetMapping("/guardarProductoJson")
	public String guardarProductoJson(@Validated Productos producto, Model model) {
		service.guardar(producto);
		HashMap<String, String> retorno=new HashMap<String,String>();
		retorno.put("status","Ok");
		retorno.put("message","Se guardó correctamente");
		return "redirect:/listarweb";
	}

}
