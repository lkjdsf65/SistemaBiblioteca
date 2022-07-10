package Modulo;

public class Libro {
	 private int idLibro;
	 private String titulo;
	 private String autor;
	 private String rutaImagen;
	 private String linkDescarga;
	public Libro(String titulo, String autor, String rutaImagen, String linkDescarga) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.rutaImagen = rutaImagen;
		this.linkDescarga = linkDescarga;
	}
	public Libro(int idLibro, String titulo, String autor, String rutaImagen, String linkDescarga) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.rutaImagen = rutaImagen;
		this.linkDescarga = linkDescarga;
	}
	public Libro() {
	}	
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getRutaImagen() {
		return rutaImagen;
	}
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	public String getLinkDescarga() {
		return linkDescarga;
	}
	public void setLinkDescarga(String linkDescarga) {
		this.linkDescarga = linkDescarga;
	}
}
	