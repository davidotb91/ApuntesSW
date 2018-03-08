/**
 * 
 */
package ec.apuntes.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * Clase para administrar la conexi�n a la bdd
 * @author davwolf
 */
public class ConexionBdd {
	
	//Determino una �nica conexi�n
	private static Connection con;
	
	/**
	 * M�todo para conectarse a una base de datos
	 * @param usuario usuario de la bdd
	 * @param clave clave de la bdd
	 * @param cadenaConexion cadena de conexi�n de la bdd
	 * @param driver clase dentro del jar que representa el Driver
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection obtenerConexion(String usuario, String clave, String cadenaConexion,
			String driver) throws ClassNotFoundException, SQLException{
		
		/*
		 * (1) Cargo el driver;es decir, cargar la clase java que representa Driver. La cual permitir� establecer
		 * la conexi�n con la bdd. Esta clase se encuentra en el .jar que se descargo.
		 */
//		Class.forName("org.postgresql.Driver");
		Class.forName(driver);
		
		/*
		 * (2) Establecer la conexion
		 */
		con = DriverManager.getConnection(cadenaConexion, usuario, clave);
		
		return con;
	}
	
	
}
