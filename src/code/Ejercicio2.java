package code;

import java.io.File;
import java.util.Scanner;

//Muestra los ficheros de un directorio.
public class Ejercicio2 {
    public static void checkDirectory(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta de el directorio:");
        String rutaDirectorio = sc.next();
        File f1 = new File(rutaDirectorio);
        //Comprueba si existe la ruta
        if(f1.exists()){
            //Comprueba si la ruta te lleva a un directorio
            if(f1.isDirectory()){
                //Recorre el directorio
                for(File i : f1.listFiles()){
                    //Escribe el nombre de cada objeto que encuentra
                    System.out.println(i.getName());
                }
            }else{
                System.out.println("Esta ruta no es un directorio");
            }
        }else{
            System.out.println("Esta ruta no contiene un directorio existente");
        }
    }
}
