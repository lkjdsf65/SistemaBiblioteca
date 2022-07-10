package Modulo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import Conexion.Conexion_BD;

public class ConsultaLibros {
	Conexion_BD conn = new Conexion_BD();
	Connection usarConexion = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps;

	
	public void mostrarLibros(int condicion) {

		if (condicion > 0 && condicion < 5) {

			try {
				usarConexion = conn.conectar(); // estamos usando la llave
				String consulta = "SELECT * FROM libros";// usamos esta consulta...
				stm = usarConexion.createStatement();
				rs = stm.executeQuery(consulta); // tenemos toda la inf de libros
				while (rs.next()) { // leemos linea por linea

					Libro libro = new Libro();

					libro.setIdLibro(rs.getInt(1));
					libro.setTitulo(rs.getString(2));
					libro.setAutor(rs.getString(3));
					libro.setRutaImagen(rs.getString(4));
					libro.setLinkDescarga(rs.getString(5));

					switch (condicion) {
					case 1:
						System.out.printf("%2d,%35s,%35s,%35s,%35s%n", libro.getIdLibro(), libro.getTitulo(),
								libro.getAutor(), libro.getRutaImagen(), libro.getLinkDescarga());
						break;
					case 2:
						System.out.printf("%2d,%35s,%35s,%35s,%35s%n", libro.getIdLibro(), libro.getTitulo(),
								libro.getAutor(), libro.getRutaImagen(), libro.getLinkDescarga());
						break;
					case 3:
						System.out.printf("%2d,%35s,%35s,%35s%n", libro.getIdLibro(), libro.getTitulo(),
								libro.getAutor(), libro.getRutaImagen());
						break;
					case 4:
						System.out.printf("%2d,%35s,%35s,%35s,%35s%n", libro.getIdLibro(), libro.getTitulo(),
								libro.getAutor(), libro.getRutaImagen(),
								"Verificar su situacion (cuotas/limite de descargas)");
						break;
					default:
						System.out.println("condicion no valida");
						break;
					}

				}
			} catch (Exception e) {
				System.out.println("oops: " + e);
			}

		} else {
			System.out.println("usuario desconocido");
		}

	}

	public int buscarLibro(String tituloLibro) {
		int idLibro = 0;
		try {
			String consulta = "SELECT idLibro from libros where titulo='" + tituloLibro + "'";
			usarConexion = conn.conectar();
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta);
			if (rs.next()) {
				idLibro = rs.getInt(1);
			
			} else {
				System.out.println("no se encontro el libro");
			}

		} catch (Exception e) {
			System.out.println("hola" + e);
		}
		return idLibro;
	}

	public void insertarLibro(int condicion) {
		if (condicion == 1) {
			
			try {
				Scanner scan = new Scanner(System.in);

				System.out.print("Ingrese titulo del libro: ");
				String titulo = scan.next();
				System.out.print("Ingrese autor del libro: ");
				String autor = scan.next();
				System.out.print("Ingrese ruta de la imagen de portada: ");
				String imagen = scan.next();
				System.out.print("Ingrese link de descarga: ");
				String linkDescarga = scan.next();

				String consulta = "insert into libros (titulo,autor,rutaImagen,linkDescarga)values(?,?,?,?)";
				usarConexion = conn.conectar();
				ps = usarConexion.prepareStatement(consulta);
				// idLibro, titulo, autor, rutaImagen, linkDescarga
				ps.setObject(1, titulo);
				ps.setObject(2, autor);
				ps.setObject(3, imagen);
				ps.setObject(4, linkDescarga);
				ps.executeUpdate();
				System.out.println("¡Libro agregado exitosamente!");
			} catch (Exception e) {
				System.out.println("no se puedo agregar el libro");
			}
		} else {
			System.out.println("Usuario no autorizado");
		}

	}

	public Libro buscarLibro(int condicion, String titulo) {
		Libro book = new Libro();
		if (condicion == 1) {
			try {
				usarConexion = conn.conectar(); // estamos usando la llave
				String consulta = "SELECT * FROM libros where titulo='" + titulo + "'";// usamos esta
				stm = usarConexion.createStatement();
				rs = stm.executeQuery(consulta); // tenemos toda la inf de usuarios
				if (rs.next()) {
					Libro libro = new Libro();
					// idLibro, titulo, autor, rutaImagen, linkDescarga

					libro.setTitulo(rs.getString(1));
					libro.setAutor(rs.getString(2));
					libro.setRutaImagen(rs.getString(3));
					libro.setLinkDescarga(rs.getString(4));
					book = libro;
				}

			} catch (Exception e) {
				System.out.println("no encontre ese libro: " + e);
			}
		}
		return book;
	}

	public void actualizarLibro(int condicion) {

		// idLibro, titulo, autor, rutaImagen, linkDescarga
		if (condicion == 1) {

			Scanner scan = new Scanner(System.in);
			System.out.print("Ingrese titulo del libro que quiere actualizar");
			String titulo = scan.next();
			Libro bookOldData = buscarLibro(condicion, titulo);

			System.out.print("Cambiar titulo " + bookOldData.getTitulo() + ": ");
			String tituloNew = scan.next();
			System.out.print("Nuevo autor: ");
			String autorNew = scan.next();
			System.out.print("Cambiar ruta imagen (ruta anterior: " + bookOldData.getRutaImagen() + "):  ");
			String imagenNew = scan.next();
			System.out.print("Cambiar link de descarga: ");
			String descargaNew = scan.next();

			String consulta = "update libros set  titulo=?, autor=?, rutaImagen=?, linkDescarga=? where titulo=?";
			try {
				usarConexion = conn.conectar();
				ps = usarConexion.prepareStatement(consulta);

				ps.setObject(1, tituloNew);
				ps.setObject(2, autorNew);
				ps.setObject(3, imagenNew);
				ps.setObject(4, descargaNew);
				ps.setObject(5, titulo);

				ps.executeUpdate();
				System.out.println("¡Libro actualizado correctamente!");
			} catch (Exception e) {
				System.out.println("oops: " + e);
			}
		} else {
			System.out.println("Usuario no autorizado");
		}

	}

	public void eliminarLibro(int condicion)
	
	{
		if (condicion ==1) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Ingrese id del libro que quiere eliminar");
			int idLibro = scan.nextInt();
			String consulta = "delete from libros where idLibro=?";
		try {
			usarConexion = conn.conectar();
			ps = usarConexion.prepareStatement(consulta);
			ps.setInt(1, idLibro);
			ps.executeUpdate();
			System.out.println("¡Libro eliminado correctamente!");
		} catch (Exception e) {

		}
		}else {
			System.out.println("Usuario no autorizado");
		}
		
	}

}