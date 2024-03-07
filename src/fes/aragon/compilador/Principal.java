package fes.aragon.compilador;

public class Principal {
    private int indice = 0;
    private  int error = -1;
    private  int aceptar = -1;
    private boolean vacio = false;
    //variables de AFD
    private  int estado = 0;
    private  int entrada = -1;
    private int[][] matriz = {{2,1,-1},{1,1,-1},{2,2,1}};
    private  String token;

    public Principal() {
    }
    public void setToken(String token) {
        this.token = token;
    }

    private char siguienteCaracter() {
        char caracter = ' ';
        if (indice < token.length()) {
            caracter = token.charAt(indice);
            indice++;
        }
        return caracter;
    }
    public int inicio() throws Exception {
        char c = ' ';
        do {
            c=siguienteCaracter();
            if(Herramienta.letra(c) && vacio == false){
                entrada = 0;
            }else if(Herramienta.numero(c) && vacio == false){
                entrada = 1;
            }else if(Herramienta.finCadena(c) && vacio == false){
                vacio = true;
                entrada = 2;
            }else if(vacio == true){
                error = 0;
            }
            if(error!=0){
                estado = matriz[estado][entrada];
            }else{
                throw  new Exception("Palabra no valida");
            }
        }while (!Herramienta.finCadena(c));
        return estado;
    }

}
