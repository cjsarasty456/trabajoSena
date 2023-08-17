package com.crud.producto.interces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.producto.model.Productos;

@Repository
public interface IProducto extends CrudRepository<Productos, Integer> {

}
