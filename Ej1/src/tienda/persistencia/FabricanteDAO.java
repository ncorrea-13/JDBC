package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;

public class FabricanteDAO extends DAO {

    public void guardarFabricante(Fabricante fabricante) throws Exception {

        try {
            if (fabricante == null) {
                throw new Exception("Debe introducir un Fabricante");
            }

            String baseDeDatos = "INSERT INTO Fabricante (nombre)"
                    + "VALUES ( '" + fabricante.getNombre() + "' );";

            insetarModificarEliminar(baseDeDatos);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void modificarFabricante(Fabricante fabricante) throws Exception {

        try {
            if (fabricante == null) {
                throw new Exception("Debe introducir un Fabricante");
            }

            String baseDeDatos = "UPDATE Fabricante SET"
                    + "nombre = '" + fabricante.getNombre() + "' WHERE codigo = '" + fabricante.getCodigo() + "')";

            insetarModificarEliminar(baseDeDatos);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void eliminarFabricante(Fabricante fabricante) throws Exception {

        try {
            if (fabricante == null) {
                throw new Exception("Debe introducir un Fabricante");
            }

            String baseDeDatos = "DELETE FROM Fabricante WHERE nombre = '" + fabricante.getNombre() + "'";

            insetarModificarEliminar(baseDeDatos);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {

        try {

            String baseDeDatos = "SELECT * FROM Fabricante "
                    + " WHERE nombre = " + nombre + "'";

            consultarBase(baseDeDatos);

            Fabricante fabricante = null;

            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setNombre(resultado.getString(1));
            }

            desconectarBase();
            return fabricante;

        } catch (Exception ex) {

            desconectarBase();
            throw ex;

        }

    }

    public Collection<Fabricante> listarFabricantes() throws Exception {
        try {
            String baseDeDatos = "SELECT codigo, nombre FROM Fabricante";

            consultarBase(baseDeDatos);

            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();

            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setNombre(resultado.getString(1));
                fabricantes.add(fabricante);
            }

            desconectarBase();
            return fabricantes;
        } catch (Exception ex) {
            ex.printStackTrace();
            desconectarBase();
            throw ex;
        }
    }
}
