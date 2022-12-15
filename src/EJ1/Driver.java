package EJ1;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Driver {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/nba?useSSL=false";
        String user = "root";
        String pass = "root";

        try {

            Connection conexion = (Connection) DriverManager.getConnection(url, user, pass);
            Statement sentencia = (Statement) conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM jugador limit 10");
            System.out.println();

            while (resultado.next()) {
                System.out.println("Nombre jugador: " + resultado.getString("nombre") + " -- " +"Procedencia: " + resultado.getString("procedencia"));
            }

            conexion.close();
            sentencia.close();
            resultado.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
