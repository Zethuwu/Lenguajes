package Recursivo;

import javax.swing.*;

public class Lexico_Segundo {
    private final int error = -1;
    private final int aceptado = 1;
    private int indice = 0;
    private String cadena = "";

    public static void main(String[] args) {

        Lexico_Segundo app = new Lexico_Segundo();
        app.cadena = JOptionPane.showInputDialog("Dame la cadena");
        int valor = app.estado_A();
        if (valor == app.aceptado) {
            JOptionPane.showMessageDialog(null, "Cadena Valida");
        } else {
            JOptionPane.showMessageDialog(null, "Cadena Invalida");
        }
    }
    private char siguienteCaracter() {
        char caracter = ' ';
        if (indice < cadena.length()) {
            caracter = cadena.charAt(indice);
            indice++;
        }
        return caracter;
    }

    private int estado_A() {
        char c = siguienteCaracter();
        return switch (c) {
            case '0' -> estado_B();
            case '1' -> estado_C();
            default -> error;
        };
    }

    private int estado_B() {
        char c = siguienteCaracter();
        switch (c){
            case '0': return estado_B();
            case '1': return estado_C();
            default: return error;
        }
    }

    private int estado_C() {
        char c = siguienteCaracter();
        switch (c){
            case '0': return estado_D();
            case '1': return estado_E();
            default: return error;
        }
    }

    private int estado_D() {
        char c = siguienteCaracter();
        switch (c){
            default: return error;
        }
    }
    private int estado_E() {
        char c = siguienteCaracter();
        switch (c) {
            case '0': return estado_F();
            case '1': return estado_D();
            case ' ': return aceptado;
            default: return error;
        }
    }
    private int estado_F() {
        char c = siguienteCaracter();
        switch (c) {
            case '0': return estado_F();
            case '1': return estado_D();
            case ' ': return aceptado;
            default: return error;
        }
    }
}
