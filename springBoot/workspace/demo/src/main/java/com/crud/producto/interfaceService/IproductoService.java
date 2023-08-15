package com.crud.producto.interfaceService;

import java.util.ArrayList;
import java.util.List;
import com.crud.producto.model.Productos;

public interface IproductoService {

	public ArrayList<Productos> consultarListaProductos();
	public Productos consultarProductoId(int id);
	public int guardar(Productos producto);
	public void eliminar(int id);
	
}
