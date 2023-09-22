package code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio1NIO {
    /*Lo mismo que el Ejercicio 1 pero usamos NIO que
     nos da más información usando Path en vez de File*/
    public static void checkFilesNIO(){
        Path p1 = Path.of("src/resources/fileE1.txt");
        Path p2 = Path.of("src/resources/ej1");
        Path p3 = Path.of("src/resources/fileE2.txt");
        Path p4 = Path.of("src/resources/ej2");
        Files.exists(p1);
        comprobadorExistenciaYTipo(p1);
        comprobadorExistenciaYTipo(p2);
        comprobadorExistenciaYTipo(p3);
        comprobadorExistenciaYTipo(p4);
    }
    private static void comprobadorExistenciaYTipo(Path p) {
        if(Files.exists(p)){
            if(Files.isDirectory(p)){
                System.out.println(p.getFileName() + " existe y es un directorio.");
            }else{
                System.out.println(p.getFileName() + " existe y es un fichero.");
            }
        }else{
            System.out.println(p.getFileName() + " no existe.");
        }
    }
}
