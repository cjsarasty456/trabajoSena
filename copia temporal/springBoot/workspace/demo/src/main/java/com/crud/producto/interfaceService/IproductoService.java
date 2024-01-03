package com.crud.producto.interfaceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.crud.producto.model.Productos;

public interface IproductoService {

	public ArrayList<Productos> consultarListaProductos();
	public Optional<Productos> consultarProductoId(int id);
	public int guardar(Productos producto);
	public void eliminar(int id);
	
}
