package code;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackUp {
    public static void backUpDirectory() throws IOException {
        SimpleDateFormat formateo= new SimpleDateFormat("yyyyMMdd'_'HH-mm-ss");
        Date fecha =new Date(System.currentTimeMillis());
        String fechaBuena = formateo.format(fecha);
        Path p1 = Path.of("src/resources/dirBackup");
        Path p2 = Path.of("src/resources/dtnBackup");
        //TODO MIRAR PORQUE NO VA EL BORRAR LA CARPETA
        Path pBI = Files.createDirectory(Path.of("src/resources/BuInc" + fechaBuena));
        menu(p1,p2, pBI);
    }

    private static void menu(Path p1, Path p2, Path pBI) throws IOException {
        System.out.println("1.BackUp Completo");
        System.out.println("2.BackUp Incremental");
        System.out.println("3.Salir");
        int menu = libs.Leer.introduceEntero("Introduce número del menu");
        switch(menu){
            case 1 -> backUpCompeto(p1,p2);
            case 2 -> backUpIncremental(p1, p2, pBI);
            case 0 -> System.out.println();
            default -> System.out.println("Número introducido no está en el menu");
        }
    }

    private static void backUpIncremental(Path p1, Path p2, Path pBI) throws IOException {
        if(Files.exists(p1)){
            //Comprbamos que es un directorio
            if(Files.isDirectory(p1)){
                //Si el segundo directorio no existe lo creamos para hacer el backUp
                if(!Files.exists(p2)){
                    Files.createDirectory(p2);
                }
                if(Files.isWritable(p2)){
                    //Recorre el contenido del path1
                    try(DirectoryStream<Path> contenido = Files.newDirectoryStream(p1)){
                        //Para cada contenido que encuentre
                        for(Path p : contenido){
                            //Crea una ruta para el segundo directorio con su nombre
                            String ruta = p2+"/"+p.getFileName();
                            String rutaBI = pBI+"/"+p.getFileName();
                            //Comprueba si la ruta ya existe por lo tanto el archivos ya ha sido introducido anteriormente
                            if(Files.exists(Path.of(ruta))){
                                //Si existe comprueba que sea la última versión
                                if(Files.getLastModifiedTime(p).equals(Files.getLastModifiedTime(Path.of(ruta)))){
                                    System.out.println(p.getFileName() + " ya existe en el destino en su última versión");
                                }else{
                                    Files.copy(p,Path.of(rutaBI),StandardCopyOption.REPLACE_EXISTING);
                                    System.out.println(p.getFileName() + " ha sido modificado a su última versión");
                                }
                            }else{
                                Files.copy(p,Path.of(rutaBI),StandardCopyOption.REPLACE_EXISTING);
                                System.out.println(p.getFileName() + " ha sido copiado correctamente");
                            }
                        }
                    }catch(IOException ex){
                        System.out.println("No se ha podido leer el directorio");
                    }catch(SecurityException ex){
                        System.out.println("No tiene permisos para leer este directorio");
                    }
                    if(Files.size(pBI)==0){
                        Files.delete(pBI);
                    }
                    System.out.println("Back Up completado");
                }else{
                    System.out.println("No se puede escribir en la carpeta de destino");
                }
            }else{
                System.out.println("Esta ruta no es un directorio");
            }
        }else{
            System.out.println("Esta ruta no contiene un directorio existente");
        }
    }

    private static void backUpCompeto(Path p1, Path p2) throws IOException {
        if(Files.exists(p1)){
            //Comprbamos que es un directorio
            if(Files.isDirectory(p1)){
                //Si el segundo directorio no existe lo creamos para hacer el backUp
                if(!Files.exists(p2)){
                    Files.createDirectory(p2);
                }
                if(Files.isWritable(p2)){
                    //Recorre el contenido del path1
                    try(DirectoryStream<Path> contenido = Files.newDirectoryStream(p1)){
                        //Para cada contenido que encuentre
                        for(Path p : contenido){
                            //Crea una ruta para el segundo directorio con su nombre
                            String ruta = p2+"/"+p.getFileName();
                            //Comprueba si la ruta ya existe por lo tanto el archivos ya ha sido introducido anteriormente
                            if(Files.exists(Path.of(ruta))){
                                //Si existe comprueba que sea la última versión
                                if(Files.getLastModifiedTime(p).equals(Files.getLastModifiedTime(Path.of(ruta)))){
                                    System.out.println(p.getFileName() + " ya existe en el destino en su última versión");
                                }else{
                                    Files.copy(p,Path.of(ruta),StandardCopyOption.REPLACE_EXISTING);
                                    System.out.println(p.getFileName() + " ha sido modificado a su última versión");
                                }
                            }else{
                                Files.copy(p,Path.of(ruta),StandardCopyOption.REPLACE_EXISTING);
                                System.out.println(p.getFileName() + " ha sido copiado correctamente");
                            }
                        }
                    }catch(IOException ex){
                        System.out.println("No se ha podido leer el directorio");
                    }catch(SecurityException ex){
                        System.out.println("No tiene permisos para leer este directorio");
                    }
                    System.out.println("Back Up completado");
                }else{
                    System.out.println("No se puede escribir en la carpeta de destino");
                }
            }else{
                System.out.println("Esta ruta no es un directorio");
            }
        }else{
            System.out.println("Esta ruta no contiene un directorio existente");
        }
    }

}
