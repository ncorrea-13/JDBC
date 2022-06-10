package tienda.servicio;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class productoService {

    private ProductoDAO dao;

    public productoService() {
        this.dao = new ProductoDAO();
    }

    public void crearProducto(String nombre, Double precio, Integer codigoFabricante) throws Exception {

        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            if (precio == null) {
                throw new Exception("Debe indicar el precio");
            }

            if (codigoFabricante == null) {
                throw new Exception("Debe indicar el fabricante");
            }

            if (buscarProductoPorNombre(nombre) != null) {
                throw new Exception("Ya existe el producto");
            }

            Producto producto = new Producto();

            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            dao.guardarProductos(producto);

        } catch (Exception ex) {
            throw ex;
        }

    }

    public Producto modificarProducto(String nombre) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del producto");
            }

            Producto producto = new Producto();

            System.out.println("Dicte los detalles del producto cambiado");

            producto.setNombre(leer.next());
            producto.setPrecio(leer.nextDouble());
            producto.setCodigoFabricante(leer.nextInt());

            dao.modificarProductosPorNombre(producto, nombre);

            return null;

        } catch (Exception ex) {
            throw ex;
        }
    }

    public Producto buscarProductoPorNombre(String nombre) throws Exception {

        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del producto");
            }
            Producto producto = dao.buscarProductoPorNombre(nombre);
            return producto;

        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public Producto buscarPortatiles() throws Exception {

        try {
            
            Producto producto = dao.buscarPortatiles("Portatil");
            return producto;

        } catch (Exception ex) {
            throw ex;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {

        try {

            Collection<Producto> productos = dao.listarPoductos();

            return productos;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void mostrarProductos() throws Exception {

        try {

            Collection<Producto> productos = listarProductos();

            if (productos.isEmpty()) {
                throw new Exception("No se encuentran productos");
            } else {
                for (Producto u : productos) {
                    System.out.println(u);
                }
            }

        } catch (Exception ex) {
            throw ex;
        }

    }

    public Collection<Producto> listarProductosPorNombre() throws Exception {

        try {

            Collection<Producto> productos = dao.listarPoductosPorNombre();

            return productos;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void mostrarProductosPorNombre() throws Exception {

        try {

            Collection<Producto> productos = listarProductosPorNombre();
            if (productos.isEmpty()) {
                throw new Exception("No se encuentran productos");
            } else {
                for (Producto u : productos) {
                    System.out.println(u);
                }
            }

        } catch (Exception ex) {
            throw ex;
        }

    }

    public void mostrarProductoBarato() throws Exception {

        try {

            Collection<Producto> productos = listarProductosBarato();

            if (productos.isEmpty()) {
                throw new Exception("No se encuentran productos");
            } else {
                for (Producto u : productos) {
                    System.out.println(u);
                }
            }

        } catch (Exception ex) {
            throw ex;
        }

    }

    public Collection<Producto> listarProductosBarato() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductoBarato();

            return productos;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void mostrarProductoCaro() throws Exception {

        try {

            Collection<Producto> productos = listarProductosCaro();

            if (productos.isEmpty()) {
                throw new Exception("No se encuentran productos");
            } else {
                for (Producto u : productos) {
                    System.out.println(u);
                }
            }

        } catch (Exception ex) {
            throw ex;
        }

    }

    public Collection<Producto> listarProductosCaro() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductoCaro();

            return productos;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
