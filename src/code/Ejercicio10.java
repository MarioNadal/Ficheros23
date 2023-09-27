package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class Ejercicio10 {
    public static void leerContenido(){
        Path p1 = Path.of("src/resources/ejercicio10.txt");
        //Creo un mapa para guardar el carácter ya introducidp y el número de veces que se ha introducido ya
        HashMap<Character, Integer> map= new HashMap<>();
        //Compruebo que a ruta existe
        if(Files.exists(p1)){
            //Compruebo que es un fichero
            if(p1.toString().endsWith(".txt")){
                try{
                    //Divido en lineas el texto del fichero
                    ArrayList<String> lineas = (ArrayList<String>) Files.readAllLines(p1);
                    lineas.forEach(linea->{
                        //Divido cada linea en char para tener cada valor
                        for(int contador = 0; contador<linea.length();contador++){
                            char lineaChar = linea.charAt(contador);
                            //Si el valor ya esta puesto añado 1 al valor
                            if(map.containsKey(lineaChar)){
                                map.replace(lineaChar, map.get(lineaChar)+1);
                            //Si aun no se ha introducido el valor lo añado con el número 1 de la primera vez que se ha introducido
                            }else{
                                map.put(lineaChar, 1);
                            }
                        }
                    });
                }catch(IOException ex){
                    System.out.println("No se ha podido leer el fichero");
                }
            }else{
                System.out.println("El tipo de archivo no es correcto");
            }
        }else{
            System.out.println("El archivo no existe");
        }
        //Imprimo el mapa con todos los datos al acabar
        System.out.println(map);
    }
}
