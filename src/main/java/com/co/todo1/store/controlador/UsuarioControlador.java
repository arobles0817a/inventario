/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.controlador;

import com.co.todo1.store.dto.UsuarioDTO;
import com.co.todo1.store.entidad.UsuarioEntidad;
import com.co.todo1.store.servicio.UsuarioServicio;
import com.co.todo1.store.util.DatosUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping(value = "usuario")
public class UsuarioControlador {

    private static final Logger log = LoggerFactory.getLogger(UsuarioControlador.class);
    private final UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping(value = "registrar")
    public ResponseEntity<UsuarioEntidad> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        boolean esRegistrado = false;
        UsuarioEntidad resUsuarioEntidad = null;

        try {
            UsuarioEntidad usuarioEntidad = UsuarioEntidad.builder().
                    documento(usuarioDTO.getDocumento()).
                    nombre(usuarioDTO.getNombre()).
                    apellido(usuarioDTO.getApellido()).
                    usuario(usuarioDTO.getUsuario()).
                    contrasena(DatosUtil.encriptar(usuarioDTO.getContrasena())).
                    estado(usuarioDTO.getEstado()).build();
            resUsuarioEntidad = usuarioServicio.registrarUsuario(usuarioEntidad);
            if (resUsuarioEntidad != null) {
                esRegistrado = true;
            }

        } catch (Exception e) {
            log.error("Error inesperperado al intentar ejecutar la peticion: {}", e);
        }
        return new ResponseEntity<>(resUsuarioEntidad, esRegistrado ? HttpStatus.OK : HttpStatus.FORBIDDEN);

    }

}
