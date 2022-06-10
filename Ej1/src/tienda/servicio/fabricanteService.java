package tienda.servicio;

import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class fabricanteService {

    private FabricanteDAO dao;

    public fabricanteService() {
        dao = new FabricanteDAO();
    }

    public void crearFabricante(String nombre) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            if (buscarFabricantePorNombre(nombre) != null) {
                throw new Exception("Ya existe el fabricante");
            }

            Fabricante fabricante = new Fabricante();

            fabricante.setNombre(nombre);
            dao.guardarFabricante(fabricante);

        } catch (Exception ex) {
            throw ex;
        }

    }

    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {

        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del fabricante");
            }
            Fabricante fabricante = dao.buscarFabricantePorNombre(nombre);
            return fabricante;

        } catch (Exception ex) {
            throw ex;
        }
    }
}
