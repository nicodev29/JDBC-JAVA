package EJ1;
import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main2 {
    public static void main(String[] args) {

        final String url = "jdbc:mysql://localhost:3307/perros?useSSL=false";
        final String user = "root";
        final String pass = "root";

        try {

            Connection conexion = (Connection) DriverManager.getConnection(url, user, pass);
            Statement sentencia = (Statement) conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM mascota limit 10");
            System.out.println();

            while (resultado.next()) {
                System.out.println("Nombre apodo: " + resultado.getString("apodo"));
                System.out.println("Se ejecuto correctamente");
            }

            conexion.close();
            sentencia.close();
            resultado.close();
            System.out.println("Se ejecuto correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
