package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Ejercicio6 {
    public static void backUpFichero(){
        Path p1 = Path.of("src/resources/ejercicio4.txt");
        Path p2 = Path.of("src/resources/ejercicio6/copiaDeSeguridadEj5.txt");
        if(Files.exists(p1)){
            if(p1.toString().endsWith(".txt")){
                try{
                    Files.copy(p1,p2, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Back Up Completado");
                }catch(IOException ex) {
                    System.out.println("No se ha podido copiar el fichero");
                }
            }else{
                System.out.println("El fichero no es del tipo correcto");
            }
        }else{
            System.out.println("El fichero no existe");
        }
    }
}
