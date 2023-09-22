import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String guiones = "-".repeat(20);
        int menu;
        boolean salir = false;
        do {
                System.out.println(guiones);
                System.out.println("1. Ejercicio1 ficheros");
                System.out.println("2. Ejercicio1 ficheros NIO");
                System.out.println("3. Ejercicio2 ficheros en un directorio");
                System.out.println("4. Ejercicio2 ficheros NIO en un directorio");
                System.out.println("0. Salir");
                System.out.println(guiones);
                //System.out.println("Introduzca número del ejercicio:");
                menu = libs.Leer.introduceEntero();
                /*menu = sc.nextInt();*/
                System.out.println(guiones);

            switch (menu) {
                case 4 -> {
                    code.Ejercicio2NIO.checkDirectory();
                }
                case 3 -> {
                    code.Ejercicio2.checkDirectory();
                }
                case 2 -> {
                    code.Ejercicio1NIO.checkFilesNIO();
                }
                case 1 -> {
                    code.Ejercicio1.checkFiles();
                }
                case 0->{
                    salir = true;
                }
                default -> {
                    System.out.println("Ese número no esta en el menú, introduzca un número del menu.");
                }
            }
        } while (!salir);
    }
}