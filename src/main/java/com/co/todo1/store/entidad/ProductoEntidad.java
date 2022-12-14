/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.entidad;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author AROBLES
 */
@Entity
@Table(name = "productos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProductoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Long id;

    @Column(name = "pro_nombre")
    private String nombre;

    @Column(name = "pro_precio")
    private Integer precio;

    @Column(name = "pro_fecha_creacion")
    private Calendar fecha;

    @Column(name = "pro_estado")
    private String estado;

    @Column(name = "usu_id")
    private Integer idUsuario;

    @Column(name = "pro_saldo")
    private Integer saldo;

    @Column(name = "pro_stock_minimo")
    private Integer stokMinimo;

}
