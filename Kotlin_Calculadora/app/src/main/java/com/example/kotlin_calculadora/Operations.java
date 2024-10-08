package com.example.kotlin_calculadora;

import android.util.Log;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operations {

    public static String doOperation(String operacion) {

        try {
            String[] result = operacion.split("[+-]");
            Log.d("TAG", "operacion: " + operacion);

            if (result.length < 2) {
                for (String s : result) {
                    return s;
                }
            }

            int num1 = Integer.parseInt(result[0]);
            int num2 = Integer.parseInt(result[1]);

            // EL pattern es para buscar el operador siguiendo el patron de + o -
            Pattern pattern = Pattern.compile("[+-]");
            // El matcher es para buscar el patron en la operacion
            Matcher matcher = pattern.matcher(operacion);

            // Si encuentra el patron, lo guarda en operator. Find() busca el patron en la operacion
            String operator = "";
            if (matcher.find()) {
                // group() devuelve el patron encontrado
                operator = matcher.group();
            }

            int res = 0;

            if (operator.equals("+")) {
                res = num1 + num2;
            } else if (operator.equals("-")) {
                res = num1 - num2;
            }

            return res + "";

        } catch (Exception e) {
            return R.string.error + "";
        }
    }
}
