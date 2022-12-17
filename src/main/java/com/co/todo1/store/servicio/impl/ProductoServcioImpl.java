/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.servicio.impl;

import com.co.todo1.store.entidad.KardexDetalleEntidad;
import com.co.todo1.store.entidad.KardexEntidad;
import com.co.todo1.store.entidad.ProductoEntidad;
import com.co.todo1.store.entidad.TipoOperacionEntidad;
import com.co.todo1.store.repositorio.KardexDetalleRepositorio;
import com.co.todo1.store.repositorio.KardexRepositorio;
import com.co.todo1.store.repositorio.ProductoRepositorio;
import com.co.todo1.store.repositorio.TipoOperacionRepositorio;
import org.springframework.stereotype.Service;
import com.co.todo1.store.servicio.ProductoServicio;

/**
 *
 * @author AROBLES
 */
@Service
public class ProductoServcioImpl implements ProductoServicio {

    private final ProductoRepositorio productoRepositorio;
    private final KardexRepositorio kardexRepositorio;
    private final KardexDetalleRepositorio kardexDetalleRepositorio;
    private final TipoOperacionRepositorio tipoOperacionRepositorio;

    public ProductoServcioImpl(ProductoRepositorio productoRepositorio, KardexRepositorio kardexRepositorio, KardexDetalleRepositorio kardexDetalleRepositorio, TipoOperacionRepositorio tipoOperacionRepositorio) {
        this.productoRepositorio = productoRepositorio;
        this.kardexRepositorio = kardexRepositorio;
        this.kardexDetalleRepositorio = kardexDetalleRepositorio;
        this.tipoOperacionRepositorio = tipoOperacionRepositorio;
    }

    @Override
    public ProductoEntidad registrarProducto(ProductoEntidad productoEntidad) {
        return this.productoRepositorio.save(productoEntidad);
    }

    @Override
    public KardexEntidad kardexEncabezado(KardexEntidad kardexEntidad) {
        return this.kardexRepositorio.save(kardexEntidad);

    }

    @Override
    public KardexDetalleEntidad kardexDetalle(KardexDetalleEntidad detalleEntidad) {
        return this.kardexDetalleRepositorio.save(detalleEntidad);

    }

    @Override
    public ProductoEntidad actualizarProducto(ProductoEntidad productoEntidad) {
        return this.productoRepositorio.save(productoEntidad);

    }

    @Override
    public ProductoEntidad buscarProducto(long idProdcuto) {
        return this.productoRepositorio.findById(idProdcuto);
    }

    @Override
    public TipoOperacionEntidad verificarOperacion(long idOperacion) {
        return this.tipoOperacionRepositorio.findById(idOperacion);
    }

}
