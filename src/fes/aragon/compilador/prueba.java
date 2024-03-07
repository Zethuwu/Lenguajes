package fes.aragon.compilador;

public class prueba {
    public static void main(String[] args) {
        int estado =0;
        //la primera linea
        int[][] tabla ={{2,1,-1},{2,1,-1},{1,1,-1},{2,2,1}};
        //segunda columna
        char[] columnas = {'L','D',';'};
        char c ='A';
        int entrada = -1;
        //lectura
        if (Herramienta.letra(c)){
            c='L';
        }else if (Herramienta.numero(c)){
            c='D';
        }
        for(int indice=0;indice<columnas.length;indice++){
            if (c == columnas[indice]) {
                entrada =indice;
                break;
            }
        }
        estado = tabla[estado][entrada];
        System.out.println(estado);
    }
}
