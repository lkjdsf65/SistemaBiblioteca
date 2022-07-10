package Conexion;
import java.sql.*;


public class Conexion_BD {
	Connection con; //variable especial para la conexion
	private String DRIVER = "com.mysql.cj.jdbc.Driver";
	private String BD_URL= "jdbc:mysql://localhost:3306/biblioteca";
	private String USER = "root";
	private String PASS = "FP567s";
	
	public Connection conectar() {
		try {
			Class.forName(DRIVER); //solamente vamos a decirle que utilice un driver(linea6)
			con = DriverManager.getConnection(BD_URL,USER,PASS); //ayuda a hacer el vinculo
			System.out.println("Conexion exitosa");
		}catch(Exception error) { //exepciones son tipos de errores
			System.out.println("Problemas al intentar conectar a la bd" );
		}
		return con;
	}
}