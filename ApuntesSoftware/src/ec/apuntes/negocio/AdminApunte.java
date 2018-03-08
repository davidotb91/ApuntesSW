package ec.apuntes.negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import ec.apuntes.modelo.Apunte;
import ec.apuntes.modelo.ConexionBdd;

public class AdminApunte {

	
	public String guardar(Apunte apunte) throws Exception {
			String mensaje = null;
			Connection con = null;
			Statement stIns = null;
	
			try {
				// (1) Establecer la conexión
				con = ConexionBdd.obtenerConexion("postgres","sa", "jdbc:postgresql://localhost:5433/ApuntesBDD",
						"org.postgresql.Driver");
	
				// (2)Definir el SQL a operar
				String sqlIns = "INSERT INTO public.apunte(id_apunte,tipo_apunte, fecha_creacion,fecha_modi, descripcion, id_autor)"
						+ " VALUES(nextval('apunte_id_apunte_seq'::regclass), '"
						+ apunte.getTipoApunte()+ "', '" + apunte.getFechaCreacion()+ "', '"+ apunte.getFechaModi()+ "', '"
						+ apunte.getDescripcion()+ "', '"+apunte.getIdAutor().getIdAutor() + "')";
				
				System.out.println(sqlIns);
				
				
				
						
				
				
				/*
				 * (3)Determinar el objeto JDBC a utilizar para el SQL a)Statement
				 * se utiliza para DDL o DML, parametrización estática; es decir, el
				 * programador configuro los mismos. b)PreparedStament se utiliza
				 * para DDL o DML, parametrización dinámica; es decir, la librerìa
				 * administra los mismos. Los parámetros se colocan con el signo ?
				 * c)CallableStament se utiliza solamente para llamar Procedimientos
				 * Almacenados
				 */
				stIns = con.createStatement();
	
				/*
				 * (4)Ejecutar el sql se puede devolver 3 valores: a)DML excepto el
				 * select se utiliza executeUpdate() - int b)DDL se utiliza
				 * execute() - boolean c)Select se utiliza executeQuery() -
				 * ResultSet(Grilla)
				 */
				int numIns = stIns.executeUpdate(sqlIns);
	
				// (5) Manipular el resultado
				mensaje = "Tipo Producto guardado correctamente(" + numIns + ")";
	
			} catch (Exception e) {
				throw new Exception("Error al guardar:" + e.getMessage());
			} finally {
				// (7) Cerrar objetos y la conexión
				try {
					if (!stIns.isClosed()) {
						stIns.close();
					}
					if (!con.isClosed()) {
						con.close();
					}
				} catch (SQLException e) {
					System.err.println("No se pudo cerrar la conexión");
				}
			}
	
			return mensaje;
		}
	
		
}

