/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.servicio;

import com.co.todo1.store.dto.ProductoDTO;
import com.co.todo1.store.entidad.ProductoEntidad;

/**
 *
 * @author AROBLES
 */
public interface ProductoServicio {

    public ProductoEntidad registrarProducto(ProductoEntidad productoEntidad);

}
