package Conexion;

import java.sql.*;

public class ConexionDB {

    public static Connection conectar() {
        Connection conexion = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conexion = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "jaider", "123");
            System.out.println("Conexión establecida.");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conexion;
    }
}
