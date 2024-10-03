package com.example.kotlin_calculadora;

import java.util.ArrayList;

public class Operations {

    public static String doOperation(String operacion) {

        String[] result = operacion.split("[+\\-]");
        String[] operator = operacion.split("[0-9]");
        int res = 0;

        if (operator[1].equals("+")) {
            res = Integer.parseInt(result[0] + result[1]);
        } else if (operator[1].equals("-")) {
            res = Integer.parseInt(result[0]) - Integer.parseInt(result[1]);
        }

        return res + "";
    }
}
