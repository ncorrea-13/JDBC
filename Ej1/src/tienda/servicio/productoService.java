package tienda.servicio;

import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class productoService {

    private ProductoDAO dao;

    public productoService() {
        this.dao = new ProductoDAO();
    }

    public void crearProducto(String nombre, Double precio, Integer codigoFabricante) throws Exception {

        try{
            if (nombre == null || nombre.trim().isEmpty()){
                throw new Exception ("Debe indicar el nombre");
            }
            
            if (precio == null){
                throw new Exception ("Debe indicar el precio");
            }
            
            if (codigoFabricante == null){
                throw new Exception ("Debe indicar el fabricante");
            }
            
            if (dao.buscarProductoPorNombre(nombre) != null){
                throw new Exception ("Ya existe el producto");
            }
            
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            dao.guardarProductos(producto);
            
        }catch (Exception ex){
            throw ex;
        }
        
    }
    
}
