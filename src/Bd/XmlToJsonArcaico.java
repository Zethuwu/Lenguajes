package Bd;

import java.io.*;

public class XmlToJsonArcaico {
    public static void main(String[] args) {
        try {
            String var10002 = System.getProperty("user.dir");
            BufferedReader reader = new BufferedReader(new FileReader(var10002 + File.separator + "ClienteBanco.xml"));
            StringBuilder xmlBuilder = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                xmlBuilder.append(linea.trim());
            }
            reader.close();

            String xml = xmlBuilder.toString();

            // Simplemente sustituimos las etiquetas XML por las claves JSON
            String json = xml
                    .replaceAll("<([^>]+)>([^<]+)</\\1>", "\"$1\": \"$2\",\n") // Etiquetas con contenido
                    .replaceAll("<([^>]+)/>", "\"$1\": null,\n") // Etiquetas sin contenido
                    .replaceAll(",\n$", ""); // Eliminar la última coma y salto de línea

            // Agregar formato de indentación
            json = "{\n" + json + "\n}";

            // Escribimos el JSON resultante en un archivo
            FileWriter writer = new FileWriter("archivo.JSON");
            writer.write(json);
            writer.close();

            System.out.println("Se ha convertido el archivo XML a JSON correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
