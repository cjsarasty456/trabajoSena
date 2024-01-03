package com.sena.demo.interfaceService;

import java.util.ArrayList;
import java.util.Optional;

import com.sena.demo.model.Productos;

public interface IproductoService {

	public ArrayList<Productos> consultarListaProductos();
	public Optional<Productos> consultarProductoId(int id);
	public Productos guardar(Productos producto);
	public void eliminar(int id);
	
}
