package Conexion;

import java.sql.*;

public class PruebaConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Conexion_BD conn = new Conexion_BD();
				Connection usarConexion = null;
				Statement stm = null;
				ResultSet rs = null;

				try {
					usarConexion = conn.conectar();
					stm = usarConexion.createStatement();
					rs = stm.executeQuery("SELECT * FROM libros");
					while (rs.next()) {
						int id = rs.getInt(1);
						String titulo = rs.getString(2);
						String autor = rs.getString(3);
						int paginas = rs.getInt(6);
						String fecha = rs.getString(7);
						int descargas = rs.getInt(8);
						System.out.println(id + " - " + titulo + " - " + autor + " - " + paginas + " - " + fecha + " - " + descargas);
		// dirigirse a la carpeta raiz, click derecho, propiedades
					}
				} catch (Exception e) {

				} finally {
					try {
						if (rs != null) {
							rs.close();
						}
						if (stm != null) {
							stm.close();
						}
						if (usarConexion != null) {
							usarConexion.close();
						}
					} catch (Exception e2) {
					}
				}
			}

		}