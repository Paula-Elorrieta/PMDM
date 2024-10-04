package com.example.kotlin_calculadora;

import java.util.ArrayList;

public class Operations {

    public static String doOperation(String operacion) {

        String[] result = operacion.split("[+-]");
        int num1 = Integer.parseInt(result[0]);
        int num2 = Integer.parseInt(result[1]);
        // Operator es un array que contiene los operadores de la operacion. En la
        String[] operator = operacion.split("[0-9]");
        int res = 0;

        if (operator[1].equals("+")) {
            res = num1 + num2;
        } else if (operator[1].equals("-")) {
            res =  num1 - num2;
        }

        return res + "";
    }
}
