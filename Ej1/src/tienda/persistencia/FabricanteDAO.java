package tienda.persistencia;

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

    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {
        try {
            String baseDeDatos = "SELECT * FROM Fabricante "
                    + " WHERE nombre = '" + nombre + "'";

            consultarBase(baseDeDatos);

            Fabricante fabricante = null;

            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }

            desconectarBase();
            return fabricante;

        } catch (Exception ex) {

            desconectarBase();
            throw ex;

        }

    }
}
