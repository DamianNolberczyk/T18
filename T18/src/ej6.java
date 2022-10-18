import java.sql.*;
public class ej6 {
	// Variables
	static String bd = "T14_Ej8_Piezas_Proveedores";
	static String login = "root";
	static String password = "damian2003";
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
			int codigos[] = { 6, 7, 8, 9, 10 };
			String nombres[] = { "pieza6", "pieza7", "pieza8", "pieza9", "pieza10" };
			for (int i = 0; i < nombres.length; i++) {
			st.executeUpdate(
			"INSERT INTO piezas (" +
			"Codigo, " + "Nombre) "+
			"VALUES ("+
			"'" + codigos[i] + "','" +
			nombres[i] +"' )");
			}
			System.out.println("-Anadir registros a la tabla - Ok");
			
		} catch (SQLException ex) {
			System.out.println(ex);
		}

	}
}
