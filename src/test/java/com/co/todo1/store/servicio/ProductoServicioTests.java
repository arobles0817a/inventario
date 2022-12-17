/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.servicio;

import com.co.todo1.store.entidad.ProductoEntidad;
import com.co.todo1.store.util.MetodosUtil;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Admin
 */
@SpringBootTest
public class ProductoServicioTests {

    @Autowired
    private ProductoServicio productoServicio;

    @Test
    void registraProductoWhenProductoEntidadThenPRoductoEntidadNoNulo() throws Exception {
        //Given
        final ProductoEntidad productoEntidad = ProductoEntidad.builder().
                nombre("hojas").
                precio(100).
                fecha(MetodosUtil.fechaACalendar("17/12/2022")).
                estado("A").
                idUsuario(2).
                saldo(0).
                stokMinimo(30).
                build();
        //When
        ProductoEntidad productoEntidadRespuesta = productoServicio.registrarProducto(productoEntidad);
        //Then
        assertNotNull(productoEntidadRespuesta);
    }

}
