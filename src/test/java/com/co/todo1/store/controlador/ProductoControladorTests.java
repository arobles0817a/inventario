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
import com.co.todo1.store.entidad.ProductoEntidad;
import com.co.todo1.store.util.MetodosUtil;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author AROBLES
 */
@SpringBootTest
public class ProductoControladorTests {

    @Autowired
    private ProductoControlador productoControlador;

    @Test
    void registraProductoWhenProductoDTOThenResponseEntityNoNulo() throws Exception {
        //Given
        final ProductoDTO productoDTO = ProductoDTO.builder().
                nombre("hojas").
                precio(100).
                fecha(MetodosUtil.fechaACalendar("17/12/2022")).
                estado("A").
                usuId(2).
                saldo(0).
                stock(30).
                build();
        //When
        final ResponseEntity<ProductoEntidad> responseEntity = productoControlador.registrarProducto(productoDTO);
        //Then
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void registraMovimientoWhenEsEntradaThenResponseEntityNoNulo() throws Exception {
        //Given
        final KardexDTO kardexDTO = KardexDTO.builder().
                fecha(MetodosUtil.fechaACalendar("17/12/2022")).
                idUsuario(2).
                idOperacion(3).
                productos(Arrays.asList(new KardexDetalleDTO(4, 10), new KardexDetalleDTO(8, 10))).build();
        //When
        final ResponseEntity<MovimientoDTO> responseEntity = productoControlador.movimientoProductos(kardexDTO);
        //Then
        assertNotNull(responseEntity.getBody());

    }

    @Test
    void registraMovimientoWhenEsSalidaThenResponseEntityNoNulo() throws Exception {
        //Given
        final KardexDTO kardexDTO = KardexDTO.builder().
                fecha(MetodosUtil.fechaACalendar("17/12/2022")).
                idUsuario(2).
                idOperacion(4).
                productos(Arrays.asList(new KardexDetalleDTO(4, 10), new KardexDetalleDTO(8, 10))).build();
        //When
        final ResponseEntity<MovimientoDTO> responseEntity = productoControlador.movimientoProductos(kardexDTO);
        //Then
        assertNotNull(responseEntity.getBody());

    }

    @Test
    void registraMovimientoWhenEsEntradaInvalidaThenResponseMesagge() throws Exception {
        //Given
        final KardexDTO kardexDTO = KardexDTO.builder().
                fecha(MetodosUtil.fechaACalendar("17/12/2022")).
                idUsuario(2).
                idOperacion(5).
                productos(Arrays.asList(new KardexDetalleDTO(4, 10), new KardexDetalleDTO(8, 10))).build();
        //When
        final ResponseEntity<MovimientoDTO> responseEntity = productoControlador.movimientoProductos(kardexDTO);
        //Then
        assertNotNull(responseEntity.getBody());

    }
}
