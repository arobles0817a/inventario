/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.servicio.impl;

import com.co.todo1.store.dto.ProductoDTO;
import com.co.todo1.store.entidad.ProductoEntidad;
import com.co.todo1.store.repositorio.ProductoRepositorio;
import org.springframework.stereotype.Service;
import com.co.todo1.store.servicio.ProductoServicio;

/**
 *
 * @author AROBLES
 */
@Service
public class ProductoServcioImpl implements ProductoServicio {

    private final ProductoRepositorio productoRepositorio;

    public ProductoServcioImpl(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @Override
    public ProductoEntidad registrarProducto(ProductoEntidad productoEntidad) {
        return this.productoRepositorio.save(productoEntidad);
    }

}
