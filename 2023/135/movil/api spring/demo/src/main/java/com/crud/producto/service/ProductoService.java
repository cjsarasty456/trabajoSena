package com.crud.producto.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.producto.interces.IProducto;
import com.crud.producto.interfaceService.IproductoService;
import com.crud.producto.model.Productos;

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
	public int guardar(Productos p) {
		int res=0;
		Productos producto=data.save(p);
		if(producto.equals(null)) {
			res=1;
		}
		return res;
	}
	
	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		data.deleteById(id);
		
	}

}
