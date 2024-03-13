package fes.aragon.compilador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Programa5 {
    private  int indice = 0;

    public static int numeracion = 0;
    static public int Estado = 0;
    public static String Error = "-1";
    Matriz matriz = new Matriz();
    public static void main(String[] args) throws IOException {
        List<String> cadena = new ArrayList<>();
        File f = new File(System.getProperty("user.dir") + File.separator + "NotacionCientifica");
        if(f.exists()){
            System.out.println("Si existe");
            BufferedReader obj = new BufferedReader(new FileReader(f));
            String string;
            while ((string = obj.readLine())!=null){
                System.out.println(numeracion+ ": "+ string);
                cadena.add(string);
                numeracion++;
            }
        }
        numeracion = 0;
        for (String s : cadena) {
            char caracter = ' ';
            Programa5 programa5 = new Programa5();
            programa5.siguienteCaracter(s, s.length());
        }
    }

    private void siguienteCaracter(String token, int j) throws IOException {
        String[][]  mati= matriz.llenarMatriz();
        Programa5 programa5 = new Programa5();
        Estado = 0;
        for (int i = 0; i < j; i++) {
            char caracter = ' ';
            if (i < token.length()) {
                caracter = token.charAt(indice);
                if (Herramienta.numero(caracter)){
                    if (Estado == 0){
                        Estado = Integer.parseInt(mati[Estado][0]);
                    }else if (Estado == 1){
                        Estado = Integer.parseInt(mati[Estado][0]);
                    }else if(Estado == 2){
                        Estado = Integer.parseInt(mati[Estado][0]);
                    } else if (Estado == 3) {
                        Estado = Integer.parseInt(mati[Estado][0]);
                    } else if (Estado == 4) {
                        Estado = Integer.parseInt(mati[Estado][0]);
                    } else if (Estado == 5) {
                        Estado = Integer.parseInt(mati[Estado][0]);
                    } else if (Estado == 6) {
                        Estado = Integer.parseInt(mati[Estado][0]);
                    }
                }
                if (Herramienta.punto(caracter)){
                    if (Estado == 1){
                        Estado = Integer.parseInt(mati[Estado][1]);
                    }else {
                        Estado = Integer.parseInt(mati[Estado][1]);
                    }
                }
                if (Herramienta.e(caracter)){
                    if (Estado == 1){
                        Estado = Integer.parseInt(mati[Estado][2]);
                    }else if (Estado == 3){
                        Estado = Integer.parseInt(mati[Estado][2]);
                    }
                }
                if (Herramienta.mas(caracter)){
                    if (Estado == 4){
                        Estado = Integer.parseInt(mati[Estado][3]);
                    }else {
                        Integer.parseInt(mati[Estado][3]);
                    }
                }
                if (Herramienta.menos(caracter)){
                    if (Estado == 4){
                        Estado = Integer.parseInt(mati[Estado][4]);
                    }else {
                        Integer.parseInt(mati[Estado][4]);
                    }
                }
                if(Estado == -1){
                    System.out.println("Estado = -1");
                    System.out.println("Caracter no valido o Notacion no Cientifica");
                    break;
                }
                if ( i == token.length()-1) {
                    //System.out.println();
                    String resultado = mati[programa5.Estado][matriz.Horizontal-1];
                    // System.out.println( resultado);
                    if(Objects.equals(resultado, Error)){
                        System.out.println( numeracion + ": Cadena no valida");
                        numeracion++;
                    }else {
                        System.out.println(numeracion +": Cadena Valida");
                        numeracion++;
                    }
                }
                indice++;
            }

        }

    }
}
