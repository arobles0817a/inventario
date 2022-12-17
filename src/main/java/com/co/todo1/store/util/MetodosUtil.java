/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.todo1.store.util;

import java.util.Calendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Admin
 */
public class MetodosUtil {

    private static final Logger log = LoggerFactory.getLogger(MetodosUtil.class);

    public static Calendar fechaACalendar(String fecha) {
        int anyo = 0;
        int mes = 0;
        int dia = 0;
        Calendar c = Calendar.getInstance();
        try {
            if (fecha.length() == 10) {
                if (fecha.indexOf("-") == 4 || fecha.indexOf("/") == 4) {//YYYY-MM-DD es el formato de fecha esperada
                    anyo = Integer.parseInt(fecha.substring(0, 4));
                    mes = Integer.parseInt(fecha.substring(5, 7)) - 1;
                    dia = Integer.parseInt(fecha.substring(8, 10));
                } else if (fecha.indexOf("-") == 2 || fecha.indexOf("/") == 2) {//DD-MM-YYYY
                    dia = Integer.parseInt(fecha.substring(0, 2));
                    mes = Integer.parseInt(fecha.substring(3, 5)) - 1;
                    anyo = Integer.parseInt(fecha.substring(6, 10));
                }
            }
            c.set(anyo, mes, dia);
        } catch (Exception e) {
            log.error("Error inesperperado al intentar ejecutar la peticion: {}", e);

        }
        return c;
    }
}
