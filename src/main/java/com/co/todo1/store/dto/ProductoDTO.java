/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.dto;

import java.util.Calendar;
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

    private String nombre;
    private Integer precio;
    private Calendar fecha;
    private String estado;
    private Integer usuId;
    private Integer saldo;
    private Integer stock;

}
