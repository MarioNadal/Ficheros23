package code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio2NIO {
    public static void checkDirectory() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta de el directorio");
        String rutaDirectorio  = sc.next();
        Path p1 = Path.of(rutaDirectorio);
        //Comprueba si existe la ruta
        if(Files.exists(p1)){
            if(Files.isDirectory(p1)){
                /*for(String i {
                    System.out.println(i);
                }*/
            }else{
                System.out.println("Esta ruta no es un directorio");
            }
        }else{
            System.out.println("Esta ruta no contiene un directorio existente");
        }
    }
}
