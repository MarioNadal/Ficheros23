package code;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BackUp {
    public static void backUpDirectory() throws IOException {
        Path p1 = Path.of("src/resources/dirBackup");
        Path p2 = Path.of("src/resources/dtnBackup");
        //Comprobamos que existe
        if(Files.exists(p1)){
            //Comprbamos que es un directorio
            if(Files.isDirectory(p1)){
                //Si el segundo directorio no existe lo creamos para hacer el backUp
                if(!Files.exists(p2)){
                    Files.createDirectory(p2);
                }
                //Recorre el contenido del path1
                try(DirectoryStream<Path> contenido = Files.newDirectoryStream(p1)){
                    //Para cada contenido que encuentre
                    for(Path p : contenido){
                        //Crea una ruta para el segundo directorio con su nombre
                        String ruta = p2+"/"+p.getFileName();
                        //Se copia cada archivo en la segunda ruta
                        Files.copy(p,Path.of(ruta),StandardCopyOption.REPLACE_EXISTING);
                    }
                }catch(IOException ex){
                    System.out.println("No se ha podido leer el directorio");
                }catch(SecurityException ex){
                    System.out.println("No tiene permisos para leer este directorio");
                }
                System.out.println("Back Up completado");
            }else{
                System.out.println("Esta ruta no es un directorio");
            }
        }else{
            System.out.println("Esta ruta no contiene un directorio existente");
        }
    }

}
