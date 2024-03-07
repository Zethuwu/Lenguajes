package fes.aragon.compilador;

import Recursivo.Lexico;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programa4 {
    private  String token;
    private int indice = 0;
    public static void main(String[] args) throws IOException {
        List<String> cadena = new ArrayList<>();
        Matriz matriz = new Matriz();
        String[][] mati= matriz.llenarMatriz();
        File f = new File(System.getProperty("user.dir") + File.separator + "LetrasODigito");
        if(f.exists()){
            System.out.println("Si existe");
            BufferedReader obj = new BufferedReader(new FileReader(f));
            String string;
            while ((string = obj.readLine())!=null){
                System.out.println(string);
                cadena.add(string);
            }
        }
    }
    private char siguienteCaracter() {
        char caracter = ' ';
        if (indice < token.length()) {
            caracter = token.charAt(indice);
            indice++;
        }
        return caracter;
    }

}
