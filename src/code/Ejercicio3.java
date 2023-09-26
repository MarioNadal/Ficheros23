package code;

import libs.Leer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio3 {
    public static void leerFichero(){
        //Path p1 = Path.of("src/resources/ejercicio3.txt");
        String ruta = libs.Leer.introduceString("Introduce la ruta: ");
        Path p1 = Path.of(ruta);
        if(Files.exists(p1)){
            if(p1.toString().endsWith(".txt")){
                try{
                    //Recorremos la lista de Strings con la variable line
                    Files.readAllLines(p1).forEach((line)->{
                        System.out.println(line);});

                }catch(SecurityException ex){
                    System.out.println("No tiene permiso de lectura de este fichero");
                }
                catch(IOException ex){
                    System.out.println("No se ha podido leer el fichero");
                }
            }else{
                System.out.println("La ruta no corresponde a un archivo de texto");
            }
        }else{
            System.out.println("La ruta no existe");
        }
    }
}
