/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "kardex_detalle")
@Getter
@Setter
@Builder
public class KardexDetalleEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kde_id")
    private Long id;

    @Column(name = "kar_id")
    private Integer idKardex;

    @Column(name = "pro_id")
    private Integer idProducto;

    @Column(name = "kde_cantidad")
    private Integer cantidad;

}
