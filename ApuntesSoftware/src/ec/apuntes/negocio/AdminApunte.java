package ec.apuntes.negocio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ec.apuntes.modelo.Apunte;
import ec.apuntes.modelo.Autor;
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
						+ apunte.getDescripcion()+ "', '"+apunte.getIdAutor().getIdAutor() + "');"
								+ "Update public.autor set ranking = ranking + 1 where id_autor= '"+apunte.getIdAutor().getIdAutor()+"';";
				
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
				mensaje = "Apunte guardado correctamente";
	
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
	public String actualizar(Apunte apunte) throws Exception {
		String mensaje = null;
		Connection con = null;
		Statement stUpd = null;

		try {
			// (1) Establecer la conexión
			con = ConexionBdd.obtenerConexion("postgres","sa", "jdbc:postgresql://localhost:5433/ApuntesBDD",
					"org.postgresql.Driver");

			// (2)Definir el SQL a operar
			String sqlUpd = "UPDATE public.apunte" + " SET tipo_apunte='" + apunte.getTipoApunte()
					+ "', fecha_modi='" + apunte.getFechaModi()+ "', descripcion='" + apunte.getDescripcion()+ "', id_autor='" + apunte.getIdAutor().getIdAutor()+ "'" 
					+ " WHERE id_apunte="
					+ apunte.getIdApunte();

			System.out.println(sqlUpd);
			/*
			 * (3)Determinar el objeto JDBC a utilizar para el SQL a)Statement
			 * se utiliza para DDL o DML, parametrización estática; es decir, el
			 * programador configuro los mismos. b)PreparedStament se utiliza
			 * para DDL o DML, parametrización dinámica; es decir, la librerìa
			 * administra los mismos. Los parámetros se colocan con el signo ?
			 * c)CallableStament se utiliza solamente para llamar Procedimientos
			 * Almacenados
			 */
			stUpd = con.createStatement();

			/*
			 * (4)Ejecutar el sql se puede devolver 3 valores: a)DML excepto el
			 * select se utiliza executeUpdate() - int b)DDL se utiliza
			 * execute() - boolean c)Select se utiliza executeQuery() -
			 * ResultSet(Grilla)
			 */
			int numIns = stUpd.executeUpdate(sqlUpd);

			// (5) Manipular el resultado
			mensaje = "Apunte actualizado correctamente";

		} catch (Exception e) {
			throw new Exception("Error al guardar:" + e.getMessage());
		} finally {
			// (6) Cerrar la conexión
			try {
				if (!stUpd.isClosed()) {
					stUpd.close();
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
	public String eliminar(Apunte apunte) throws Exception {
		String mensaje = null;

		try (Connection con = ConexionBdd.obtenerConexion("postgres","sa", "jdbc:postgresql://localhost:5433/ApuntesBDD",
				"org.postgresql.Driver");) {

			String sqlEli = "DELETE FROM public.apunte WHERE id_apunte=" + apunte.getIdApunte();
			System.out.println(sqlEli);

			try (Statement stEli = con.createStatement()) {
				int numIns = stEli.executeUpdate(sqlEli);
				mensaje = "Apunte eliminado correctamente";
			}
		} catch (Exception e) {
			throw new Exception("Error al guardar:" + e.getMessage());
		} finally {
		}

		return mensaje;
	}	
	public List<Apunte> consultarTodos() throws Exception {
		List<Apunte> listaApuntes = new ArrayList<>();
		try (Connection con = ConexionBdd.obtenerConexion("postgres","sa", "jdbc:postgresql://localhost:5433/ApuntesBDD",
				"org.postgresql.Driver");) {

			String sqlCon = "SELECT * FROM public.apunte";
			System.out.println(sqlCon);

			try (Statement stEli = con.createStatement()) {
				
				try(ResultSet tablaInf = stEli.executeQuery(sqlCon)){
//					ResultSetMetaData md = tablaInf.getMetaData();
//					md.getColumnCount()
					//Cuando se devuelve varios registros
					while(tablaInf.next()){
						/*
						 * Dentro de la iteración el Resulset se
						 * vuelve un puntero a la fila
						 */
						Apunte apte = new Apunte();
							//Recuperar por nombre de columna
						apte.setIdApunte(tablaInf.getInt("id_apunte"));
						apte.setTipoApunte(tablaInf.getString("descripcion"));
						apte.setFechaCreacion(tablaInf.getDate("fecha_creacion"));
						apte.setFechaModi(tablaInf.getDate("fecha_modi"));
						
						
						//Recuperar por posición columna tabla
						
						
						listaApuntes.add(apte);
					}
				}
				
			}
		} catch (Exception e) {
			throw new Exception("Error al consultar apuntes:" + e.getMessage());
		} finally {
		}
		return listaApuntes;
	}
	
	//Consultar todos de acuerda al escritor especifico 
	public List<Apunte> consultarPorAutor(Autor autor) throws Exception {
		List<Apunte> listaApuntes = new ArrayList<>();
		try (Connection con = ConexionBdd.obtenerConexion("postgres","sa", "jdbc:postgresql://localhost:5433/ApuntesBDD",
				"org.postgresql.Driver");) {

			String sqlCon = "SELECT * FROM public.apunte Where id_autor="+autor.getIdAutor()+";";
			System.out.println(sqlCon);

			try (Statement stEli = con.createStatement()) {
				
				try(ResultSet tablaInf = stEli.executeQuery(sqlCon)){
//					ResultSetMetaData md = tablaInf.getMetaData();
//					md.getColumnCount()
					//Cuando se devuelve varios registros
					while(tablaInf.next()){
						/*
						 * Dentro de la iteración el Resulset se
						 * vuelve un puntero a la fila
						 */
						Apunte apte = new Apunte();
							//Recuperar por nombre de columna
						apte.setIdApunte(tablaInf.getInt("id_apunte"));
						apte.setTipoApunte(tablaInf.getString("descripcion"));
						apte.setFechaCreacion(tablaInf.getDate("fecha_creacion"));
						apte.setFechaModi(tablaInf.getDate("fecha_modi"));
						
						
						//Recuperar por posición columna tabla
						
						
						listaApuntes.add(apte);
					}
				}
				
			}
		} catch (Exception e) {
			throw new Exception("Error al consultar apuntes:" + e.getMessage());
		} finally {
		}
		return listaApuntes;
	}

}

