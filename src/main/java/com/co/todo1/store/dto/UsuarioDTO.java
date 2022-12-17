/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templatess
 * and open the template in the editor.
 */
package com.co.todo1.store.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@Getter
@Setter
@Builder
public class UsuarioDTO {

    private Integer documento;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    private String estado;

}
