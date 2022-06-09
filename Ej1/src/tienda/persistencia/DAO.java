package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    private final String User = "root";
    private final String Password = "root";
    private final String Database = "tienda";
    private final String Driver = "com.mysql.jdbc.Driver";

    protected void conectarBase() throws ClassNotFoundException, SQLException {

        try {
            Class.forName(Driver);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + Database + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, User, Password);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    protected void desconectarBase() throws SQLException {

        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    protected void insetarModificarEliminar(String baseDeDatos) throws ClassNotFoundException, SQLException {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(baseDeDatos);

        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            desconectarBase();
        }
    }

    protected void consultarBase(String baseDeDatos) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(baseDeDatos);
        } catch (Exception ex) {
            throw ex;
        }
    }

}
