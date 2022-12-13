/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.controlador;

import com.co.todo1.store.dto.ProductoDTO;
import com.co.todo1.store.entidad.ProductoEntidad;
import com.co.todo1.store.servicio.ProductoServicio;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.Mockito.mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author AROBLES
 */
@SpringBootTest
public class ProductoControladorTest {

    @Autowired
    private ProductoControlador productoControlador;


    @Test
    void registraProductoWhenProductoDTOThenResponseEntityNoNulo() throws Exception {
        //Given
        final ProductoDTO productoDTO = ProductoDTO.builder().proNombre("Hojas").proEstado("A").build();
        //When
        final ResponseEntity<ProductoEntidad> responseEntity = productoControlador.registrarProducto(productoDTO);
        //Then
        assertNotNull(responseEntity.getBody());
    }
}
