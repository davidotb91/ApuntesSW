import java.util.Date;

import ec.apuntes.modelo.Apunte;
import ec.apuntes.modelo.Autor;
import ec.apuntes.negocio.AdminApunte;
import ec.apuntes.negocio.AdminaAutor;

public class TesterAdminApunte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Autor pepe = new Autor();
		//pepe.setIdAutor(2);
		Apunte apunte = new Apunte();
		AdminApunte ad = new AdminApunte();
		AdminaAutor at = new AdminaAutor();
		apunte.setDescripcion("holamodificado");
		apunte.setFechaCreacion(new Date());
		apunte.setFechaModi(new Date());
		apunte.setTipoApunte("4");
		pepe.setIdAutor(3);
		apunte.setIdAutor(pepe);
		apunte.setIdApunte(2);
		pepe.setFechaNacimiento(new Date());
		pepe.setNombreAutor("Allison");
		pepe.setApellidoAutor("linda");
		pepe.setRanking(4);
		pepe.setPaisOrigen("EC");
		
		
		try {
			ad.guardar(apunte);
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
