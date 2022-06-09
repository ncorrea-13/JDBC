package tienda;

import java.util.Scanner;

public class Tienda {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Bienvenid@ a nuestro sistema");

        System.out.println("Qué consulta desea realizar?");
        System.out.println("1. listar los productos");
        System.out.println("2. listar los productos con sus precios");
        System.out.println("3. listar los productos con precio entre 120 y 202");
        System.out.println("4. listar los portátiles");
        System.out.println("5. listar el producto más barato");
        System.out.println("6. listar el producto más caro");
        System.out.println("7. ingresar un nuevo producto");
        System.out.println("8. ingresar un nuevo fabricante");
        System.out.println("9. editar un producto");
        System.out.println("10. Salir del sistema");

        switch (leer.nextInt()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                System.out.println("Adiós");
                break;
            default:
                System.out.println("Usted debe ingresar una opción válida");
                break;
        }
    }

}
