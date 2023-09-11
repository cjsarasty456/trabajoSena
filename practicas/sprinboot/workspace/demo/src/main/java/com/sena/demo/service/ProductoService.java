package com.sena.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.demo.interces.IProducto;
import com.sena.demo.interfaceService.IproductoService;
import com.sena.demo.model.Productos;

@Service
public class ProductoService implements IproductoService {

	@Autowired
	private IProducto data;
	
	@Override
	public ArrayList<Productos> consultarListaProductos() {

		return (ArrayList<Productos>) data.findAll();
	}

	@Override
	public Optional<Productos> consultarProductoId(int id) {
		
		return data.findById(id);
	}
	
	@Override
	public Productos guardar(Productos p) {
		Productos producto=data.save(p);
		return producto;
	}
	
	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		data.deleteById(id);
		
	}

}
