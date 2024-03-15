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
import java.util.Objects;

public class Programa4 {
    private int indice = 0;
    static ArrayList<String> JOpane = new ArrayList<>();
    public static int numeracion = 0;
    public int Estado = 0;
    public static String Error = "-1";
    Matriz matriz = new Matriz();

    public static void main(String[] args) throws IOException {
        List<String> cadena = new ArrayList<>();
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
        numeracion = 0;
        for (String s : cadena) {
            char caracter = ' ';
            Programa4 programa4 = new Programa4();
            programa4.siguienteCaracter(s, s.length());
        }
        String message = "";
        for (String p : JOpane) {
            message += p +"\n";
        }
        JOptionPane.showMessageDialog(null, message);


    }
    private void siguienteCaracter(String token, int j) throws IOException {
        String[][]  mati= matriz.llenarMatriz("Matriz");
        Programa4 programa4 = new Programa4();
        for (int i = 0; i < j; i++) {
            char caracter = ' ';
            if (i < token.length()) {
                caracter = token.charAt(indice);
                if (Herramienta.letra(caracter)){
                    if (programa4.Estado == 0){
                        programa4.Estado = 3;
                    }else if (programa4.Estado == 1){
                        programa4.Estado = 3;
                    }else if(programa4.Estado == 2){
                        programa4.Estado = 2;
                    } else if (programa4.Estado == 3) {
                        programa4.Estado = 3;
                    }
                }

                if (Herramienta.numero(caracter)){
                    if (programa4.Estado == 0){
                        programa4.Estado = 1;
                    }else if (programa4.Estado == 1){
                        programa4.Estado = 2;
                    }else if(programa4.Estado == 2){
                        programa4.Estado = 2;
                    } else if (programa4.Estado == 3) {
                        programa4.Estado = 3;
                    }
                }
                if (Herramienta.especiales(caracter)){
                    Estado = Integer.parseInt(Error);
                }
                if(Estado == -1){
                    System.out.println("Estado = -1" +token);
                    System.out.println("Caracter no valido");
                    JOpane.add("Estado = -1 de: " +token);
                    numeracion++;
                    break;
                }
                if ( i == token.length()-1) {
                    //System.out.println();
                    String resultado = mati[programa4.Estado][matriz.Horizontal-1];
                   // System.out.println( resultado);
                    if(Objects.equals(resultado, Error)){
                        System.out.println(numeracion + ": " + token + " -> Cadena no valida");
                        JOpane.add( numeracion + ": " + token + " -> Cadena no valida");
                        numeracion++;
                    }else {
                        System.out.println(numeracion +": " + token +" -> Cadena Valida");
                        JOpane.add( numeracion + ": " + token + " -> Cadena valida");
                        numeracion++;
                    }
                }
                indice++;
            }
        }

    }

}
