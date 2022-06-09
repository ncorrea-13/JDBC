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

            String baseDeDatos = "INSERT INTO Producto (codigo, nombre, precio, codigo_fabricante)"
                    + "VALUES ( '" + producto.getCodigo() + "' , '" + producto.getNombre() + "' , '" + producto.getPrecio()
                    + "' , '" + producto.getCodigoFabricante() + "' );";

            insetarModificarEliminar(baseDeDatos);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void modificarProductos(Producto producto) throws Exception {

        try {
            if (producto == null) {
                throw new Exception("Debe introducir un usuario");
            }

            String baseDeDatos = "UPDATE Producto SET"
                    + "nombre = '" + producto.getNombre() + "' WHERE codigo = '" + producto.getCodigo() + "')";

            insetarModificarEliminar(baseDeDatos);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void eliminarProductos(Producto producto) throws Exception {

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
                    + " WHERE nombre = " + nombre + "'";

            consultarBase(baseDeDatos);

            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                producto.setCodigoFabricante(resultado.getInt(3));
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
            String baseDeDatos = "SELECT codigo, nombre FROM Producto";

            consultarBase(baseDeDatos);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getInt(2));
                producto.setCodigoFabricante(resultado.getInt(3));
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