public class Largo {
    public static void main(String[] args) {
        String palabra= "00111 000001 011101 01010011aX";
        String[] separacion = palabra.split(" ");
        int columna = 1;
        boolean error = false;

        for (int i = 0; i < separacion.length; i++) {
            //columna ++;
            int estado  = 0;
            int indice = 0;
            String cadenita = separacion[i];
            while (indice < cadenita.length()){
                char c = cadenita.charAt(indice);
                switch (estado){
                    case 0:
                        if(c == '1'){
                            estado = 1;
                        }else if(c == '0'){
                            estado = 0;
                        }else{
                            error = true;
                            //columna--;
                        }
                        break;
                    case 1:
                        if(c == '1'){
                            estado = 0;
                        }else if( c == '0'){
                            estado = 1;
                        }else{
                            error = true;
                            //columna--;
                        }
                        break;
                }
                columna++;
                indice++;
            }
            if(!error){
                if(estado == 0){
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
