public class impar {
    public static void main(String[] args) {
        impar mpar = new impar();
        String palabra= "01001001010";
        mpar.imparMetodo(palabra);
    }

    public boolean imparMetodo(String cadena){
        boolean bandera = false;
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
                // System.out.println("Valida");
                bandera = true;
            }else{
                //System.out.println("Invalido");
                bandera = false;
            }
        }else{
            System.out.println("Caracter no valido");
            bandera = false;
        }
        return bandera;
    }
}
