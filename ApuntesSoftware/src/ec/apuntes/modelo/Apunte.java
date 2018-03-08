/**
 * 
 */
package ec.apuntes.modelo;

import java.util.Date;

/**
 * @author jonathan.tayupanta
 *
 */
public class Apunte {
	private int idApunte;
	private String tipoApunte;
	private Date fechaCreacion;
	private Date fechaModi;
	private String descripcion;
	private Autor idAutor;
	public Apunte() {
		// TODO Auto-generated constructor stub
	}
	public int getIdApunte() {
		return idApunte;
	}
	public void setIdApunte(int idApunte) {
		this.idApunte = idApunte;
	}
	public String getTipoApunte() {
		return tipoApunte;
	}
	public void setTipoApunte(String tipoApunte) {
		this.tipoApunte = tipoApunte;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaModi() {
		return fechaModi;
	}
	public void setFechaModi(Date fechaModi) {
		this.fechaModi = fechaModi;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Autor getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(Autor idAutor) {
		this.idAutor = idAutor;
	}
	

}
