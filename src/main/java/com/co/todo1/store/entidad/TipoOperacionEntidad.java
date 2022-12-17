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
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tipo_operacion")
@Getter
@Setter
public class TipoOperacionEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tip_id")
    private Long id;

    @Column(name = "tip_nombre")
    private String nombre;

    @Column(name = "tip_signo")
    private String signo;

    @Column(name = "tip_fecha_creacion")
    private String fecha;

    @Column(name = "tip_estado")
    private String estado;

}
