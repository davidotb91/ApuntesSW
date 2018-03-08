/**
 * 
 */
package ec.apuntes.modelo;

import java.util.Date;

/**
 * @author jonathan.tayupanta
 *
 */
public class Autor {
	private int idAutor;
	private Date fechaNacimiento;
	private String nombreAutor;
	private String apellidoAutor;
	private int ranking;
	private String PaisOrigen;
	private Apunte[] listaApuntes;
	public Autor() {
		}
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public String getApellidoAutor() {
		return apellidoAutor;
	}
	public void setApellidoAutor(String apellidoAutor) {
		this.apellidoAutor = apellidoAutor;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public String getPaisOrigen() {
		return PaisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		PaisOrigen = paisOrigen;
	}
	public Apunte[] getListaApuntes() {
		return listaApuntes;
	}
	public void setListaApuntes(Apunte[] listaApuntes) {
		this.listaApuntes = listaApuntes;
	}

}
