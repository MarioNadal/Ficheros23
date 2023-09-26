package code;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio2NIO {
    public static void checkDirectory() {
        String rutaDirectorio  = libs.Leer.introduceString("Introduce la ruta: ");
        Path p1 = Path.of(rutaDirectorio);
        //Comprueba si existe la ruta
        if(Files.exists(p1)){
            if(Files.isDirectory(p1)){
               try(DirectoryStream<Path> cont = Files.newDirectoryStream(p1)){
                   for(Path p : cont){
                       System.out.println(p.getFileName());
                   }
               }catch(IOException ex){
                   System.out.println("No se ha podido leer el directorio");
               }catch(SecurityException ex){
                   System.out.println("No tiene permisos para leer este directorio");
               }
            }else{
                System.out.println("Esta ruta no es un directorio");
            }
        }else{
            System.out.println("Esta ruta no contiene un directorio existente");
        }
    }
}
