/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.controlador;

import com.co.todo1.store.dto.KardexDTO;
import com.co.todo1.store.dto.KardexDetalleDTO;
import com.co.todo1.store.dto.MovimientoDTO;
import com.co.todo1.store.dto.ProductoDTO;
import com.co.todo1.store.entidad.KardexDetalleEntidad;
import com.co.todo1.store.entidad.KardexEntidad;
import com.co.todo1.store.entidad.ProductoEntidad;
import com.co.todo1.store.entidad.TipoOperacionEntidad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.co.todo1.store.servicio.ProductoServicio;
import javax.transaction.Transactional;

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
        try {
            ProductoEntidad productoEntidad = ProductoEntidad.builder().
                    nombre(productoDTO.getNombre()).
                    precio(productoDTO.getPrecio()).
                    fecha(productoDTO.getFecha()).
                    estado(productoDTO.getEstado()).
                    idUsuario(productoDTO.getUsuId()).
                    saldo(productoDTO.getSaldo()).
                    stokMinimo(productoDTO.getStock()).
                    build();
            productoEntidadRespuesta = productosServicio.registrarProducto(productoEntidad);
            if (productoEntidadRespuesta != null) {
                esRegistrado = true;
            }
        } catch (Exception e) {
            log.error("Error inesperperado al intentar ejecutar la peticion: {}", e);

        }
        return new ResponseEntity<>(productoEntidadRespuesta, esRegistrado ? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }

    @PostMapping(value = "movimiento/productos")
    @Transactional
    public ResponseEntity<MovimientoDTO> movimientoProductos(@RequestBody KardexDTO kardexDTO) {
        boolean esRegistrado = false;
        String respuesta = "";
        Integer saldo = 0;
        Integer cantidad = 0;
        try {
            KardexEntidad kardexEntidad = KardexEntidad.builder().
                    idOperacion(kardexDTO.getIdOperacion()).
                    idUsuario(kardexDTO.getIdUsuario()).
                    fecha(kardexDTO.getFecha()).
                    build();
            TipoOperacionEntidad tipoOperacionEntidad = productosServicio.verificarOperacion(kardexEntidad.getIdOperacion());
            if (tipoOperacionEntidad != null) {
                KardexEntidad kardexEntidadRespuesta = productosServicio.kardexEncabezado(kardexEntidad);
                if (kardexEntidadRespuesta != null) {
                    for (KardexDetalleDTO kardexDetalleDTO : kardexDTO.getProductos()) {
                        esRegistrado = false;
                        KardexDetalleEntidad kardexDetalleEntidad = KardexDetalleEntidad.builder().
                                idKardex(Integer.parseInt(kardexEntidadRespuesta.getId().toString())).
                                idProducto(kardexDetalleDTO.getIdProducto()).
                                cantidad(kardexDetalleDTO.getCantidad()).
                                build();
                        KardexDetalleEntidad resDetalleEntidad = productosServicio.kardexDetalle(kardexDetalleEntidad);
                        if (resDetalleEntidad != null) {
                            ProductoEntidad productoEntidad = productosServicio.buscarProducto(kardexDetalleEntidad.getIdProducto().longValue());
                            saldo = productoEntidad.getSaldo();
                            cantidad = kardexDetalleEntidad.getCantidad();
                            if (tipoOperacionEntidad.getSigno().equals("+")) {
                                saldo = saldo + cantidad;
                            } else {
                                saldo = saldo - cantidad;
                            }
                            productoEntidad.setSaldo(saldo);
                            ProductoEntidad respuestaProducto = productosServicio.actualizarProducto(productoEntidad);
                            if (respuestaProducto != null) {
                                esRegistrado = true;
                            }
                        }
                    }
                    if (esRegistrado) {
                        respuesta = "Moviminto registrado correctamente";
                    }
                }
            } else {
                respuesta = "El tipo de movimiento que intenta realizar no es valido.";
            }
        } catch (Exception e) {
            log.error("Error inesperperado al intentar ejecutar la peticion: {}", e);
        }

        return new ResponseEntity<>(MovimientoDTO.builder().mensaje(respuesta).build(), esRegistrado ? HttpStatus.OK : HttpStatus.FORBIDDEN);

    }
}
