package com.sena.demo.interces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.demo.model.Productos;

@Repository
public interface IProducto extends CrudRepository<Productos, Integer> {

}
