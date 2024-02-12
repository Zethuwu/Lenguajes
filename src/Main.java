public class Main {
    public static void main(String[] args) {
        String palabra= "0100100101";
        int indice = 0;
        int estado  = 0;
        boolean error = false;
        while (indice <= palabra.length() -1){
            char c = palabra.charAt(indice);
            switch (estado){
                case 0:
                    if(c == '1'){
                        estado = 1;
                    }else if(c == '0'){
                        estado = 0;
                    }else{
                        error = true;
                    }
                    break;
                case 1:
                    if(c == '1'){
                        estado = 0;
                    }else if( c == '0'){
                        estado = 1;
                    }else{
                        error = true;
                    }
                    break;
            }
            indice++;
        }
        if(!error){
            if(estado == 0){
                System.out.println("Valida");
            }else{
                System.out.println("Invalido");
            }
        }else{
            System.out.println("Caracter no valido");
        }
    }
}