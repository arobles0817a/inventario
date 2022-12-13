/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.controlador;

import com.co.todo1.store.dto.ProductoDTO;
import com.co.todo1.store.entidad.ProductoEntidad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.co.todo1.store.servicio.ProductoServicio;

/**
 *
 * @author AROBLES
 */
@RestController
@RequestMapping(value = "producto")
public class ProductoControlador {

    private static final Logger log = LoggerFactory.getLogger(ProductoControlador.class);
    private final ProductoServicio productosServicio;

    public ProductoControlador(ProductoServicio productosServicio) {
        this.productosServicio = productosServicio;
    }

    @PostMapping(value = "regisrarProducto")
    public ResponseEntity<ProductoEntidad> registrarProducto(@RequestBody ProductoDTO productoDTO) {
        boolean esRegistrado = false;
        ProductoEntidad productoEntidadRespuesta = null;
        ProductoEntidad productoEntidad = new ProductoEntidad();
        try {
            productoEntidad.setNombre(productoDTO.getProNombre());
            productoEntidad.setEstado(productoDTO.getProEstado());
            productoEntidadRespuesta = productosServicio.registrarProducto(productoEntidad);
            if (productoEntidadRespuesta != null) {
                esRegistrado = true;
            }
        } catch (Exception e) {
            log.error("Error inesperperado al intentar ejecutar la peticion: {}", e);

        }
        return new ResponseEntity<>(productoEntidadRespuesta, esRegistrado ? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }
}
