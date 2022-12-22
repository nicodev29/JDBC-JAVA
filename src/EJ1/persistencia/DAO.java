package EJ1.persistencia;
import java.sql.*;
public abstract class DAO {
    private final String URL = "jdbc:mysql://localhost:3307/";
    private final String USER = "root";
    private final String PASS = "root";
    private final String DATABASE = "perros";
    private final String CERTIFICADO= "?useSSL=false";
    private final String URLCOMPLETA = URL + DATABASE + CERTIFICADO;
    protected Connection conexion = null;
    protected Statement sentencia = null;
    protected ResultSet resultado = null;

    protected void conectarse2() throws Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(URLCOMPLETA, USER, PASS);

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    //Metodo conectarse a la base
//   protected void conectarBase() {
//        try {
//            conexion = (Connection) DriverManager.getConnection(url, user, pass);
//            System.out.println("Se conecto correctamente");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    //metodo para ejecutar una consulta a la base
    protected void insertarModificarEliminar (String consulta) throws Exception {
        try {
            conectarse2();
            sentencia = (Statement) conexion.createStatement();
            sentencia.executeUpdate(consulta);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            desconectarBase();
        }
    }
    //metodo para consultar a la base y traer datos de lo que consultamos en el metodo anterior
    protected void consultarBase (String consulta) throws Exception {
        try {
            conectarse2();
            sentencia = (Statement) conexion.createStatement();
            resultado = sentencia.executeQuery(consulta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Metodo desconectarse de la base cerrando conexiones
    protected void desconectarBase() throws Exception {
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
        } catch (Exception ex) {
            throw ex;
        }
    }
}
