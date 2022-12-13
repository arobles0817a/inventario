/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.repositorio;

import com.co.todo1.store.entidad.ProductoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


/**
 *
 * @author AROBLES
 */
@Repository
public interface ProductoRepositorio extends JpaRepository<ProductoEntidad, Long> {


}
