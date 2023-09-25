package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BackUp {
    public static void backUpDirectory() throws IOException {
        Path p1 = Path.of("src/resources/dirBackup");
        Path p2 = Path.of("src/resources/dtnBackup");
        if(Files.exists(p1)){
            if(Files.isDirectory(p1)){
                if(!Files.exists(p2)){
                    //Si el directorio de destino no existe lo crea
                    Files.createDirectory(p2);
                }
                //En consola hace el println como que ha hecho el copy pero no hace nada en el directorio
                Files.copy(p1,p2,StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Back Up completado");
            }else{
                System.out.println("Esta ruta no es un directorio");
            }
        }else{
            System.out.println("Esta ruta no contiene un directorio existente");
        }
    }

}
