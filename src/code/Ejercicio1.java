package code;

import java.io.File;

public class Ejercicio1 {
    public static void checkFiles(){
        File f1 = new File("src/resources/fileE1.txt");
        File f2 = new File("src/resources/fileE2.txt");
        File f3 = new File("src/resources/ej1");
        File f4 = new File("src/resources/ej2.txt");
        comprobadorExistenciaYTipo(f1);
        comprobadorExistenciaYTipo(f2);
        comprobadorExistenciaYTipo(f3);
        comprobadorExistenciaYTipo(f4);
    }
    private static void comprobadorExistenciaYTipo(File f) {
        //Comprueba si el resource existe
        if(f.exists()){
            //Si existe comprueba si es un fichero
            if(f.isFile()){
                System.out.println(f.getName() + " existe y es un fichero.");
            }
            //Si no es un directorio
            else{
                System.out.println(f.getName() + " existe y es un directorio.");
            }
            //Si no no existe
        }else{
            System.out.println(f.getName() + " no existe.");
        }
    }
}
