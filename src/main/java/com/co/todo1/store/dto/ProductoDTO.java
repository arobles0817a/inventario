/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author AROBLES
 */
@Getter
@Setter
@Builder
public class ProductoDTO {

    private String proNombre;
    private String proEstado;

}
