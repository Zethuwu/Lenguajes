public class impar {
    public static void main(String[] args) {
        String palabra= "01001001010";
        imparMetodo(palabra);
    }

     public static void imparMetodo(String cadena){
        int indice = 0;
        int estado  = 0;
        boolean error = false;
        while (indice < cadena.length() ){
            char c = cadena.charAt(indice);
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
            indice++;
        }
        if(!error){
            if(estado == 1){
                System.out.println("Valida");
            }else{
                System.out.println("Invalido");
            }
        }else{
            System.out.println("Caracter no valido");
        }
    }
}
