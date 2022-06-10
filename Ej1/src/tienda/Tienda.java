package tienda;

import java.util.Scanner;
import tienda.servicio.fabricanteService;
import tienda.servicio.productoService;

public class Tienda {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        productoService producto = new productoService();
        fabricanteService fabricante = new fabricanteService();
        
        //
        
        //
        System.out.println("Bienvenid@ a nuestro sistema");

        System.out.println("Qué consulta desea realizar?");
        System.out.println("1. listar los productos");
        System.out.println("2. listar los productos por su precio");
        System.out.println("3. listar los portátiles");
        System.out.println("4. listar el producto más barato");
        System.out.println("5. listar el producto más caro");
        System.out.println("6. ingresar un nuevo producto");
        System.out.println("7. ingresar un nuevo fabricante");
        System.out.println("8. buscar un producto");
        System.out.println("9. editar un producto");
        System.out.println("10. Salir del sistema");

        switch (leer.nextInt()) {
            case 1:

                try {
                    producto.mostrarProductos();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;

            case 2:
                try {
                    producto.mostrarProductosPorNombre();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;
            case 3:
                try {
                    producto.buscarPortatiles();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;
            case 4:
                try {
                    producto.mostrarProductoBarato();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;
            case 5:
                try {
                    producto.mostrarProductoCaro();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;
            case 6:

                try {
                    producto.crearProducto(leer.next(), leer.nextDouble(), leer.nextInt());
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                break;
            case 7:
                try {
                    
                    fabricante.crearFabricante(leer.next());
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;
            case 8:

                try {
                    System.out.println("Debe ingresar el nombre del producto");
                    System.out.println(producto.buscarProductoPorNombre(leer.next()));
                } catch (Exception ex) {
                    System.out.println("Su programa no pudo correr debido al error " + ex);
                }

                break;
            case 9:
                try {
                    System.out.println("Dicte el nombre del producto que desea modificar");
                    producto.modificarProducto(leer.next());
                } catch (Exception ex) {
                    System.out.println(ex);
                }
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
