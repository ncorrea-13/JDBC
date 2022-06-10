package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;

public final class ProductoDAO extends DAO {

    public void guardarProductos(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe introducir un Producto");
            }

            String baseDeDatos = "INSERT INTO Producto (nombre, precio, codigo_fabricante)"
                    + "VALUES ( '" + producto.getNombre() + "' , '" + producto.getPrecio()
                    + "' , '" + producto.getCodigoFabricante() + "' );";

            insetarModificarEliminar(baseDeDatos);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void modificarProductosPorNombre(Producto producto, String nombre) throws Exception {

        try {
            if (producto == null) {
                throw new Exception("Debe introducir un usuario");
            }

            String baseDeDatos = "UPDATE Producto SET"
                    + " nombre = '" + producto.getNombre() + "' , precio = "+ producto.getPrecio() + ", codigo_fabricante = "
                    + producto.getCodigoFabricante() + " WHERE nombre = '" + nombre+ "'";

            insetarModificarEliminar(baseDeDatos);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void eliminarProductosPorNombre(Producto producto) throws Exception {

        try {
            if (producto == null) {
                throw new Exception("Debe introducir un producto");
            }

            String baseDeDatos = "DELETE FROM Producto WHERE nombre = '" + producto.getNombre() + "'";

            insetarModificarEliminar(baseDeDatos);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public Producto buscarProductoPorNombre(String nombre) throws Exception {

        try {

            String baseDeDatos = "SELECT * FROM Producto "
                    + " WHERE nombre = '" + nombre + "'";

            consultarBase(baseDeDatos);

            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }

            desconectarBase();
            return producto;

        } catch (Exception ex) {

            desconectarBase();
            throw ex;

        }

    }
    
    public Producto buscarPortatiles(String nombre) throws Exception {

        try {

            String baseDeDatos = "SELECT * FROM Producto "
                    + " WHERE nombre Like '%" + nombre + "%'";

            consultarBase(baseDeDatos);

            Producto producto = null;
            Collection<Producto> portatiles = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                portatiles.add(producto);
            }
            
            for (Producto u: portatiles){
                System.out.println(u);
            }

            desconectarBase();
            return producto;

        } catch (Exception ex) {

            desconectarBase();
            throw ex;

        }

    }

    public Collection<Producto> listarPoductos() throws Exception {
        try {
            String baseDeDatos = "SELECT * FROM Producto";

            consultarBase(baseDeDatos);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }

            desconectarBase();
            return productos;
        } catch (Exception ex) {
            ex.printStackTrace();
            desconectarBase();
            throw ex;
        }
    }
    
    public Collection<Producto> listarPoductosPorNombre() throws Exception {
        try {
            String baseDeDatos = "SELECT * FROM Producto ORDER BY nombre ASC Limit 1";

            consultarBase(baseDeDatos);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }

            desconectarBase();
            return productos;
        } catch (Exception ex) {
            ex.printStackTrace();
            desconectarBase();
            throw ex;
        }
    }
    
    public Collection<Producto> listarProductoBarato() throws Exception {
        try {
            String baseDeDatos = "SELECT * FROM Producto ORDER BY precio ASC Limit 1";

            consultarBase(baseDeDatos);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }

            desconectarBase();
            return productos;
        } catch (Exception ex) {
            ex.printStackTrace();
            desconectarBase();
            throw ex;
        }
    }
    
    public Collection<Producto> listarProductoCaro() throws Exception {
        try {
            String baseDeDatos = "SELECT * FROM Producto ORDER BY precio DESC Limit 1";

            consultarBase(baseDeDatos);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }

            desconectarBase();
            return productos;
        } catch (Exception ex) {
            ex.printStackTrace();
            desconectarBase();
            throw ex;
        }
    }

}