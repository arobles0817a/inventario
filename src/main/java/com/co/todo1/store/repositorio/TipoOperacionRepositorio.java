/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.repositorio;

import com.co.todo1.store.entidad.TipoOperacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Admin
 */
public interface TipoOperacionRepositorio extends JpaRepository<TipoOperacionEntidad, Object> {

    public TipoOperacionEntidad findById(long idProducto);

}
