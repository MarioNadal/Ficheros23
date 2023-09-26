package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio5 {
    public static void escribirFicherosTextoGuardado() throws IOException {
        Path p1 = Path.of("src/resources/ejercicio4.txt");
        String frase;
        StringBuilder guardarLineas = new StringBuilder();
        if(Files.exists(p1)){
            if(p1.toString().endsWith(".txt")){
                if(Files.isWritable(p1)){
                    guardarLineas.append(Files.readAllLines(p1));
                    do {
                        frase = libs.Leer.introduceString("Introduce una frase: ");
                        try{
                            Files.writeString(p1, frase);
                            guardarLineas.append(Files.readAllLines(p1));
                        }catch(IOException ex){
                            System.out.println("No se ha podido leer el directorio");
                        }
                    } while (!frase.equals("fin"));
                    Files.writeString(p1, guardarLineas.toString());
                    Files.readAllLines(p1).forEach((line)-> System.out.println(line));
                }else{
                    System.out.println("No se puede escribir en el fichero");
                }
            }else{
                System.out.println("La ruta no es un fichero");
            }
        }else{
            System.out.println("La ruta no existe");
        }
    }
}
