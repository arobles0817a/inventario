/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.servicio.impl;

import com.co.todo1.store.entidad.UsuarioEntidad;
import com.co.todo1.store.repositorio.UsuarioRepositorio;
import com.co.todo1.store.servicio.UsuarioServicio;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public UsuarioEntidad registrarUsuario(UsuarioEntidad usuarioEntidad) {
        return this.usuarioRepositorio.save(usuarioEntidad);
    }

}
