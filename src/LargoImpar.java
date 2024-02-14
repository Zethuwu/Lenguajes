import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LargoImpar {

    public static void main(String[] args) throws IOException {
        //String palabra = "00111 01001 0101 010100110";
        //String[] separacion = palabra.split(" ");
        List<String> cadena = new ArrayList<>();
        int columna = 1;
        boolean error = false;

        File f = new File(System.getProperty("user.dir") + File.separator + "Fuente");
        if(f.exists()){
            System.out.println("Si existe");
            BufferedReader obj = new BufferedReader(new FileReader(f));
            String string;
            while ((string = obj.readLine())!=null){
                System.out.println(string);
                cadena.add(string);
            }
        }

        for (int i = 0; i < cadena.size(); i++) {
            //columna ++;
            int estado = 0;
            int indice = 0;
            String cadenita = cadena.get(i);
            //System.out.println(cadena.get(i));
            while (indice < cadenita.length()) {
                char c = cadenita.charAt(indice);
                switch (estado){
                    case 0:
                        if(c == '1'){
                            estado = 0;
                        }else if(c == '0'){
                            estado = 1;
                        }else{
                            error = true;
                        }
                        break;
                    case 1:
                        if(c == '1'){
                            estado = 1;
                        }else if( c == '0'){
                            estado = 0;
                        }else{
                            error = true;
                        }
                        break;
                }
                columna++;
                indice++;
            }
            if(!error){
                if(estado == 1){
                    System.out.println("Valida");
                }else{
                    System.out.println("Invalido");
                }
            }else{
                System.out.println("Caracter no valido: columna: "+ columna );
            }

        }
    }
}
