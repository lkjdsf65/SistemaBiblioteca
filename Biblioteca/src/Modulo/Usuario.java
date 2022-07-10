package Modulo;

public class Usuario {
	 private int idUsuario;
     private String login;
     private String contrase�a;
     private String nombre;
     private String apellido;
     private int condicion;
     
	public Usuario(int idUsuario, String login, String contrase�a, String nombre, String apellido,int condicion) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.contrase�a = contrase�a;
		this.nombre = nombre;
		this.apellido = apellido;
		this.condicion = condicion;
	}
	public Usuario(String login, String contrase�a, String nombre, String apellido, int condicion) {
		super();
		this.login = login;
		this.contrase�a = contrase�a;
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
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
	