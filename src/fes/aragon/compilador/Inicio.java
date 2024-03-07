package fes.aragon.compilador;

public class Inicio {
    public static void main(String[] args) {
        Principal app = new Principal();
        app.setToken("MIKE HOLA");
        try {
            int verifica = app.inicio();
            if(verifica == 1){
                System.out.println("Valido");
            }else {
                System.out.println("No valido");
            }
        } catch (Exception e) {
            System.out.println("No valido --> Caracter Ivalido");
        }

    }
}
