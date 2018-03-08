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

public class AdminaAutor {
	public String guardar(Autor autor) throws Exception {
		String mensaje = null;
		Connection con = null;
		Statement stIns = null;

		try {
			// (1) Establecer la conexión
			con = ConexionBdd.obtenerConexion("postgres","sa", "jdbc:postgresql://localhost:5433/ApuntesBDD",
					"org.postgresql.Driver");

			// (2)Definir el SQL a operar
			String sqlIns = "INSERT INTO public.autor(id_autor,fecha_nacimiento, nombre_autor,apellido_autor, ranking, pais_origen)"
					+ " VALUES(nextval('autor_id_autor_seq'::regclass), '"
					+ autor.getFechaNacimiento()+ "', '" + autor.getNombreAutor()+ "', '"+ autor.getApellidoAutor()+ "', '"
					+ autor.getRanking()+ "', '"+autor.getPaisOrigen() + "')";
			
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
			mensaje = "Autor guardado correctamente";

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
	public String actualizar(Autor autor) throws Exception {
	String mensaje = null;
	Connection con = null;
	Statement stUpd = null;

	try {
		// (1) Establecer la conexión
		con = ConexionBdd.obtenerConexion("postgres","sa", "jdbc:postgresql://localhost:5433/ApuntesBDD",
				"org.postgresql.Driver");

		// (2)Definir el SQL a operar
		String sqlUpd = "UPDATE public.autor" + " SET fecha_nacimiento='" + autor.getFechaNacimiento()
				+ "', nombre_autor='" + autor.getNombreAutor()+ "', apellido_autor='" + autor.getApellidoAutor()+ "', ranking='" + autor.getRanking()+ "',pais_origen='"+autor.getPaisOrigen()+"'" 
				+ " WHERE id_autor="
				+ autor.getIdAutor();

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
		mensaje = "Autor actualizado correctamente";

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
	public String eliminar(Autor autor) throws Exception {
		String mensaje = null;

		try (Connection con = ConexionBdd.obtenerConexion("postgres","sa", "jdbc:postgresql://localhost:5433/ApuntesBDD",
				"org.postgresql.Driver");) {

			String sqlEli = "DELETE FROM public.autor WHERE id_apunte=" + autor.getIdAutor();
			System.out.println(sqlEli);

			try (Statement stEli = con.createStatement()) {
				int numIns = stEli.executeUpdate(sqlEli);
				mensaje = "Autor eliminado correctamente";
			}
		} catch (Exception e) {
			throw new Exception("Error al guardar:" + e.getMessage());
		} finally {
		}

		return mensaje;
	}	
	public List<Autor> consultarTodos() throws Exception {
		List<Autor> listaAutores = new ArrayList<>();
		try (Connection con = ConexionBdd.obtenerConexion("postgres","sa", "jdbc:postgresql://localhost:5433/ApuntesBDD",
				"org.postgresql.Driver");) {

			String sqlCon = "SELECT * FROM public.autor order by ranking desc;";
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
						Autor atr = new Autor();
							//Recuperar por nombre de columna
						atr.setIdAutor(tablaInf.getInt("id_autor"));
						atr.setFechaNacimiento(tablaInf.getDate("fecha_nacimiento"));
						atr.setNombreAutor(tablaInf.getString("nombre_autor"));
						atr.setApellidoAutor(tablaInf.getString("apellido_autor"));
						atr.setRanking(tablaInf.getInt("ranking"));
						atr.setPaisOrigen(tablaInf.getString("pais_origen"));
						
						
						//Recuperar por posición columna tabla
						
						
						listaAutores.add(atr);
					}
				}
				
			}
		} catch (Exception e) {
			throw new Exception("Error al consultar apuntes:" + e.getMessage());
		} finally {
		}
		return listaAutores;
	}
	
	//Consultar todos de acuerda al escritor especifico 
	public List<Autor> consultarPorApellido(String Apellido) throws Exception {
		List<Autor> listaAutores = new ArrayList<>();
		try (Connection con = ConexionBdd.obtenerConexion("postgres","sa", "jdbc:postgresql://localhost:5433/ApuntesBDD",
				"org.postgresql.Driver");) {

			String sqlCon = "SELECT * FROM public.autor where apellido_autor like '"+Apellido+"' order by ranking desc;";
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
						Autor atr = new Autor();
							//Recuperar por nombre de columna
						atr.setIdAutor(tablaInf.getInt("id_autor"));
						atr.setFechaNacimiento(tablaInf.getDate("fecha_nacimiento"));
						atr.setNombreAutor(tablaInf.getString("nombre_autor"));
						atr.setApellidoAutor(tablaInf.getString("apellido_autor"));
						atr.setRanking(tablaInf.getInt("ranking"));
						atr.setPaisOrigen(tablaInf.getString("pais_origen"));
						
						
						//Recuperar por posición columna tabla
						
						
						listaAutores.add(atr);
					}
				}
				
			}
		} catch (Exception e) {
			throw new Exception("Error al consultar apuntes:" + e.getMessage());
		} finally {
		}
		return listaAutores;
		
	}



}
