/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Admin
 */
@SpringBootTest
public class DatosUtilTests {

    private DatosUtil datosUtil;

    @Test
    void desencriptarDatosWhenTextoEncriptadoThenResponseEntityNoNulo() throws Exception {
        //Given
        final String textoEncriptado = "aGQ4SAHc+SMYo8OGEo82jw==";
        //When
        final String datosDesencriptados = datosUtil.desencriptarDatos(textoEncriptado);
        //Then
        assertNotNull(datosDesencriptados);
    }

}
