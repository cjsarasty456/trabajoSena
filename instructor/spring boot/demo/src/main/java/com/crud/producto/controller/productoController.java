package com.crud.producto.controller;


import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crud.producto.interfaceService.IproductoService;
import com.crud.producto.service.FileStorageService;
import com.crud.producto.model.Productos;
import com.crud.producto.model.respuesta;


@RestController
@RequestMapping("/api/v1/productos")
public class productoController {
	
	@Autowired
	private IproductoService service;

	@Autowired
	private FileStorageService fileStorageService;
	
	
	//json
	@GetMapping("/")
	public ResponseEntity<Object> consultarListaProductosJson() {
		List<Productos> listaProductos= service.consultarListaProductos();
		String blob="";
		listaProductos.get(0).setImagen_base(blob);
		return new ResponseEntity<> (listaProductos, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> consultarProductoJson(@PathVariable int id) {
		Optional<Productos> listaProductos= service.consultarProductoId(id);
		
		return new ResponseEntity<> (listaProductos, HttpStatus.OK);
	}
	
	@PostMapping("/")
	//eliminar @RequestBody 
	public ResponseEntity<Object> guardarProductoJson(Productos producto, @RequestParam("file") MultipartFile file) throws IOException  {

		try {
			String fileName = fileStorageService.storeFile(file);
			producto.setImagen_url("http://localhost:8080/api/downloadFile/" + fileName);
            
            // return ResponseEntity.ok().body("File uploaded successfully: " + file.getOriginalFilename());
        } catch (IOException e) {
            // return ResponseEntity.status(500).body("Failed to upload file: " + file.getOriginalFilename());
        }

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
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminarProductoJson(@PathVariable int id) {
		service.eliminar(id);
		respuesta respuesta=new respuesta(
				"ok",
				"Se Elimino correctamente"
				);
			return new ResponseEntity<> (respuesta, HttpStatus.OK);
	}
}
