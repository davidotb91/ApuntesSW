import java.util.Date;

import ec.apuntes.modelo.Apunte;
import ec.apuntes.modelo.Autor;
import ec.apuntes.negocio.AdminApunte;

public class TesterAdminApunte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Autor pepe = new Autor();
		pepe.setIdAutor(2);
		Apunte apunte = new Apunte();
		AdminApunte ad = new AdminApunte();
		apunte.setDescripcion("hola2");
		apunte.setFechaCreacion(new Date());
		apunte.setFechaModi(new Date());
		apunte.setTipoApunte("4");
		apunte.setIdAutor(pepe);
		
		
		try {
			ad.guardar(apunte);
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
