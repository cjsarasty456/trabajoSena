package com.crud.producto.controller;


import java.io.IOException;
import java.sql.Blob;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.crud.producto.interfaceService.IproductoService;
import com.crud.producto.model.Productos;
import com.crud.producto.model.respuesta;


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
		
		return "formAgregar";
	}
	
	@GetMapping("/guardarProducto")
	public String guardarProducto(@Validated Productos producto, Model model) {
		service.guardar(producto);
		return "redirect:/listarweb";
	}
	
	@GetMapping("/formEditar/{id}")
	public String formEditar(@PathVariable int id, Model model) {
		Optional<Productos>Producto=service.consultarProductoId(id);
		model.addAttribute("producto",Producto);
		return "formEditar";
	}
	
	//json
	@GetMapping("/listarjson")
	public ResponseEntity<Object> consultarListaProductosJson() {
		List<Productos> listaProductos= service.consultarListaProductos();
		String blob="";
		listaProductos.get(0).setImagen_base(blob);
		return new ResponseEntity<> (listaProductos, HttpStatus.OK);
	}
	@GetMapping("/consultarjson/{id}")
	public ResponseEntity<Object> consultarProductoJson(@PathVariable int id) {
		Optional<Productos> listaProductos= service.consultarProductoId(id);
		
		return new ResponseEntity<> (listaProductos, HttpStatus.OK);
	}
	
	@PostMapping("/guardarProductoJson")
	//eliminar @RequestBody 
	public ResponseEntity<Object> guardarProductoJson(Productos producto, @RequestParam("file") MultipartFile file) throws IOException  {
		producto.setImagen_base(Base64.getEncoder().encodeToString(file.getBytes()));
		int retorno=service.guardar(producto);
		if(retorno==0) {	
			respuesta respuesta=new respuesta(
				"ok",
				"Se guardó correctamente"
				);
			return new ResponseEntity<> (respuesta, HttpStatus.OK);
		}else {
			respuesta respuesta=new respuesta(
						"error",
						"Error al guardar"
						);
			return new ResponseEntity<> (respuesta, HttpStatus.OK);
		}
		
	}
	@GetMapping("/eliminarjson/{id}")
	public ResponseEntity<Object> eliminarProductoJson(@PathVariable int id) {
		service.eliminar(id);
		respuesta respuesta=new respuesta(
				"ok",
				"Se Elimino correctamente"
				);
			return new ResponseEntity<> (respuesta, HttpStatus.OK);
	}
}
