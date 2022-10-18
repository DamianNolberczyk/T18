import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ej9 {
	// Variables
	static String bd = "t14_ej11";
	static String login = "root";
	static String password = "Damian@2003";
	static String url = "jdbc:mysql://localhost:3306/" + bd;
	
	

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection(url, login, password);
			String sURL = url;
			conn = DriverManager.getConnection(sURL,login,password);
			if (conn != null) {
				System.out.println("-Abierta base de datos " + url + " - Ok");

			}
			Statement st = conn.createStatement();// Permite comandos SQL
			// Insertar datos a la tabla
			int codigos[] = { 5, 6, 7, 8, 9 };
			String nombre[] = { "Facultad5", "Facultad6", "Facultad7", "Facultad8", "Facultad9" };
			
			for (int i = 0; i < nombre.length; i++) {
			st.executeUpdate(
			"INSERT INTO facultad (" +
			"codigo, " + "nombre)" +
			"VALUES ("+
			"'" + codigos[i] + "','" +
			nombre[i] + "' )");			}
			System.out.println("-Anadir registros a la tabla - Ok");
			
		} catch (SQLException ex) {
			System.out.println(ex);
		}

	}
} 
