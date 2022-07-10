package Modulo;

public class Usuario {
	 private int idUsuario;
     private String login;
     private String contraseña;
     private String nombre;
     private String apellido;
     private int condicion;
     
	public Usuario(int idUsuario, String login, String contraseña, String nombre, String apellido,int condicion) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellido = apellido;
		this.condicion = condicion;
	}
	public Usuario(String login, String contraseña, String nombre, String apellido, int condicion) {
		super();
		this.login = login;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellido = apellido;
		this.condicion = condicion;
	}
	
	public Usuario() {
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getCondicion() {
		return condicion;
	}
	public void setCondicion(int condicion) {
		this.condicion = condicion;
	}
}
	