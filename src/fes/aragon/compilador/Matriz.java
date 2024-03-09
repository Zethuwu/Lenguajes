package fes.aragon.compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Matriz {

    int Horizontal = 0;

    public String[][] llenarMatriz() throws IOException {
        int x = 0,y = 0;
        int estado =0;
        String[][] matriz = new String[x][y];

        String var10002 = System.getProperty("user.dir");
        File f = new File(var10002 + File.separator + "Matriz");
        if (f.exists()) {
            //System.out.println("Si existe");
            BufferedReader obj = new BufferedReader(new FileReader(f));
            String string;
            BufferedReader obj2 = null;
            try {
                obj2 = new BufferedReader(new FileReader(var10002 + File.separator + "Matriz"));
                String string2 = obj2.readLine(); // Lee la primera línea del archivo

                // Aquí puedes procesar la primera línea como lo deseas
                String[] fragmentos = string2.split(",");
                for (String fragmento : fragmentos) {
                   // System.out.println(fragmento);
                }
                x = Integer.parseInt(fragmentos[0]);
                y = Integer.parseInt(fragmentos[1]);
                Horizontal = Integer.parseInt(fragmentos[1]);
                // matriz = new int[Integer.parseInt(fragmentos[0])][Integer.parseInt(fragmentos[1])];
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Asegúrate de cerrar el BufferedReader solo si no es nulo
                if (obj2 != null) {
                    try {
                        obj2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            matriz = new String[x][y];
            int variable = 0;
            int indice = 0;
            while((string = obj.readLine()) != null) {
                //System.out.println("2 "+string);
                if(indice == 0){
                    /*String[] fragmentos = string.split(",");
                    for (String fragmento : fragmentos) {
                        System.out.println(fragmento);
                    }
                    matriz = new int[Integer.parseInt(fragmentos[0])][Integer.parseInt(fragmentos[1])];
                     */
                } else if (indice == 1) {
                   /*  String[] fragmentos = string.split(",");
                    for (String fragmento : fragmentos) {

                        System.out.println(fragmento);
                    }*/
                }else{
                    //System.out.println("2 else"+string);
                    String[] fragmentos = string.split(",");

                    for (int j = 0; j < fragmentos.length ; j++) {
                        matriz[variable][j] = fragmentos[j];
                    }
                    variable++;

                }
                indice++;
            }
            //System.out.println(Arrays.deepToString(matriz));
            return matriz;
        }
        return matriz;
    }

}
