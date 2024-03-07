package fes.aragon.compilador;

public class Herramienta {
    public static boolean letra(char c){
        boolean letra = false;
        if((c >= 97 && c<=122) || (c >= 65 && c<=98)){
            return true;
        }
        return letra;
    }
    public static boolean numero(char c){
        boolean numero = false;
        if((c >= 48 && c<=57)){
            return true;
        }
        return numero;
    }
    public static boolean especiales(char c){
        boolean especiales = false;
        if((c >= 1 && c<=47) || (c >= 58 && c<=64) || (c >= 91 && c<=96)){
            return true;
        }
        return especiales;
    }

    public static boolean finCadena(char c){
        boolean fc = false;
        if(c == 32){
            return true;
        }
        return fc;
    }


}
