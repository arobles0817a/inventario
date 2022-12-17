/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.servicio;

import com.co.todo1.store.entidad.KardexDetalleEntidad;
import com.co.todo1.store.entidad.KardexEntidad;
import com.co.todo1.store.entidad.ProductoEntidad;
import com.co.todo1.store.entidad.TipoOperacionEntidad;

/**
 *
 * @author AROBLES
 */
public interface ProductoServicio {

    public ProductoEntidad registrarProducto(ProductoEntidad productoEntidad);

    public TipoOperacionEntidad verificarOperacion(long idOperacion);

    public KardexEntidad kardexEncabezado(KardexEntidad kardexEntidad);

    public KardexDetalleEntidad kardexDetalle(KardexDetalleEntidad detalleEntidad);

    public ProductoEntidad buscarProducto(long idProdcuto);

    public ProductoEntidad actualizarProducto(ProductoEntidad productoEntidad);

}
