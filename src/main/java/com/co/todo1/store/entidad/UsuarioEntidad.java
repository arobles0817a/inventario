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
@Table(name = "usuario")
@Getter
@Setter
@Builder

public class UsuarioEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long id;

    @Column(name = "usu_documento")
    private Integer documento;

    @Column(name = "usu_nombre")
    private String nombre;

    @Column(name = "usu_apellido")
    private String apellido;

    @Column(name = "usu_usuario")
    private String usuario;

    @Column(name = "usu_contrasena")
    private String contrasena;

    @Column(name = "usu_estado")
    private String estado;

}
