/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.controlador;

import com.co.todo1.store.dto.UsuarioDTO;
import com.co.todo1.store.entidad.UsuarioEntidad;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Admin
 */
@SpringBootTest
public class UsuarioControladorTests {

    @Autowired
    private UsuarioControlador usuarioControlador;

    @Test
    void registraProductoWhenProductoDTOThenResponseEntityNoNulo() throws Exception {
        //Given
        final UsuarioDTO usuarioDTO = UsuarioDTO.builder().
                documento(1002129747).
                nombre("Andres Felipe").
                apellido("Robles Solano").
                usuario("arobles").
                contrasena("1002129747").
                estado("A").
                build();
        //When
        final ResponseEntity<UsuarioEntidad> responseEntity = usuarioControlador.registrarUsuario(usuarioDTO);
        //Then
        assertNotNull(responseEntity.getBody());

    }

}
