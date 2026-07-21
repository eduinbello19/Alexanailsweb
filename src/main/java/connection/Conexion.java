package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Se mejoró la configuración de la conexión a la base de datos haciéndola
    // más robusta y compatible con versiones recientes de MySQL. Se agregaron
    // parámetros para deshabilitar SSL en entornos locales, permitir la
    // recuperación de claves públicas durante la autenticación y establecer
    // la zona horaria del servidor, lo que reduce posibles errores de conexión.
    private static final String URL =
            "jdbc:mysql://localhost:3306/alexa_nails_app"
                    + "?useSSL=false"
                    + "&allowPublicKeyRetrieval=true"
                    + "&serverTimezone=America/Bogota";

    private static final String USUARIO = "root";
    private static final String CLAVE = "root";

    public Connection getConexion() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    URL,
                    USUARIO,
                    CLAVE
            );

            System.out.println("Conexión exitosa con la base de datos");

        } catch (ClassNotFoundException e) {

            System.out.println("No se encontró el driver JDBC de MySQL");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Error al conectar con MySQL: " + e.getMessage());
            e.printStackTrace();
        }

        return con;
    }
}
