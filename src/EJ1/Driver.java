package EJ1;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class Driver {
    public static void main(String[] args) {

        try {

            Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/nba", "root", "root");
            Statement sentencia = (Statement) conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM jugador LIMIT 10");
            System.out.println("Nos conectamos joyaaa");
            System.out.println();

            while (resultado.next()) {
                System.out.println("Jugador: " + resultado.getString("nombre"));
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
