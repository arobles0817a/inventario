/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.dto;

import java.util.Calendar;
import java.util.List;
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
public class KardexDTO {

    private Integer idOperacion;
    private Integer idUsuario;
    private Calendar fecha;
    private List<KardexDetalleDTO> productos;
 
}
