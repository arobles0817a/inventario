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
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author AROBLES
 */
@Entity
@Table(name = "kardex")
@Getter
@Setter
@Builder
public class KardexEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kar_id")
    private Long id;

    @Column(name = "tip_id")
    private Integer idOperacion;

    @Column(name = "usu_id")
    private Integer idUsuario;

    @Column(name = "kar_fecha_creacion")
    private Calendar fecha;

}
