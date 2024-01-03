package com.sena.demo.controller;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sena.demo.interfaceService.IproductoService;
import com.sena.demo.model.Productos;
import com.sena.demo.model.respuesta;

import jakarta.servlet.http.HttpServletResponse;

@Controller

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
		
	    @GetMapping("/generar-pdf")
	    public void generarPdf(HttpServletResponse response) throws IOException, DocumentException {
	        // Configura la respuesta HTTP para generar un archivo PDF
	        response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "inline; filename=mi_documento.pdf");

	        // Crea un documento PDF utilizando OpenPDF
	        Document document = new Document();
	        PdfWriter.getInstance(document, response.getOutputStream());

	        // Abre el documento
	        document.open();
	               
	        //tabla
	        List<Productos> listaProductos= service.consultarListaProductos();
	    	PdfPTable tablaProductos=new PdfPTable(5);
	    	tablaProductos.addCell("ID");
			tablaProductos.addCell("Nombre");
			tablaProductos.addCell("Descripción");
			tablaProductos.addCell("Cantidad");
			tablaProductos.addCell("Precio");
			listaProductos.forEach(producto->{
				tablaProductos.addCell(String.valueOf(producto.getId()));
				tablaProductos.addCell(producto.getNombre());
				tablaProductos.addCell(producto.getDescripcion());
				tablaProductos.addCell(String.valueOf(producto.getCantidad()));
				tablaProductos.addCell(String.valueOf(producto.getPrecio()));
			});
			document.add(tablaProductos);
	        
	        
	        // Cierra el documento
	        document.close();
	    }
		
		@GetMapping("/nuevoProducto")
		public String nuevoProducto(Model model) {
			
			return "formAgregar";
		}
		
		
		@PostMapping("/guardarProducto")
		public String guardarProducto(
				Productos producto, 
				Model model /*, 
				@RequestParam("archivo") MultipartFile imagen,
				HttpServletRequest request*/) {
			//var extension=imagen.getOriginalFilename().substring(imagen.getOriginalFilename().lastIndexOf("."));
			//producto.setImagen("imagen"+extension);
			producto=service.guardar(producto);
			/*Path directorioBase=Paths.get("src//main//resources//static/imagen");
			String rutaAbsoluta=directorioBase.toFile().getAbsolutePath();
			try {
			byte[] bytesImg=imagen.getBytes();
			String ruta=rutaAbsoluta+"/"+producto.getId()+"/";
			
			Path rutaCompleta=Paths.get(ruta+"imagen"+extension);
			Files.createDirectories(Paths.get(ruta));///
			Files.write(rutaCompleta, bytesImg);
			}catch (IOException e) {
			
				// TODO: handle exception
			}
			*/
			return "redirect:/listarweb";
		}
		
		@GetMapping("/formEditar/{id}")
		public String formEditar(@PathVariable int id, Model model) {
			Optional<Productos>Producto=service.consultarProductoId(id);
			model.addAttribute("producto",Producto);
			return "formEditar";
		}
		
		public Optional<Productos> consultarProductoPorId(int id) {
			Optional<Productos>Producto=service.consultarProductoId(id);
			return Producto;
			
		}
		/*
		 @GetMapping("imagenProducto/{id}")
		    public ResponseEntity<Object> getImage(@PathVariable int id) throws IOException {
			 Optional<Productos> producto=consultarProductoPorId(id);
			  ClassPathResource imgFile = new ClassPathResource("static/imagen/"+producto.get().getId()+"/" + producto.get().getImagen());
			  
			 
		        // Verifica si el archivo existe
		        if (imgFile.exists()) {
		        	var extension=producto.get().getImagen().substring(producto.get().getImagen().lastIndexOf("."));
		  		  extension=extension.toLowerCase();
		  		  var mediaType=MediaType.ALL;
		  		  if(extension.equals(".jpg") || extension.equals(".jpeg"))
		  			  mediaType=MediaType.IMAGE_JPEG;
		  		  if(extension.equals(".png"))
		  			  mediaType=MediaType.IMAGE_PNG;
		  		  if(extension.equals(".gif"))
		  			  mediaType=MediaType.IMAGE_GIF;
		            try (InputStream in = imgFile.getInputStream()) {
		                // Lee el contenido del archivo y devuelve una respuesta con el contenido de la imagen
		                byte[] imageBytes = in.readAllBytes();
		                return ResponseEntity.ok().contentType(mediaType).body(imageBytes);
		            }
		        } else {
		            // Manejar si la imagen no se encuentra
		            return ResponseEntity.notFound().build();
		        }
		    }
		*/
		//json
		@GetMapping("/listarJson")
		public ResponseEntity<Object> consulistarJsonltarListaProductosJson() {
			List<Productos> listaProductos= service.consultarListaProductos();
			
			return new ResponseEntity<> (listaProductos, HttpStatus.OK);
		}
		@GetMapping("/consultarjson/{id}")
		public ResponseEntity<Object> consultarProductoJson(@PathVariable int id) {
			Optional<Productos> listaProductos= service.consultarProductoId(id);
			
			return new ResponseEntity<> (listaProductos, HttpStatus.OK);
		}
		
		@PostMapping("/guardarproductojson")
		public ResponseEntity<Object> guardarProductoJson(Productos producto) {
			producto=service.guardar(producto);
			if(producto.getId()!=0) {	
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
				return new ResponseEntity<> (respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		@GetMapping("/eliminarJson/{id}")
		public ResponseEntity<Object> eliminarProductoJson(@PathVariable int id) {
			service.eliminar(id);
			respuesta respuesta=new respuesta(
					"ok",
					"Se Elimino correctamente"
					);
				return new ResponseEntity<> (respuesta, HttpStatus.OK);
		}

}
