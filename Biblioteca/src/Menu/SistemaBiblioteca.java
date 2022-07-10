package Menu;
import java.util.ArrayList;
import java.util.Scanner;

import Modulo.ConsultaHistorial;
import Modulo.ConsultaLibros;
import Modulo.ConsultaUsuario;
import Modulo.Libro;
import Modulo.Usuario;


public class SistemaBiblioteca {  
	
		public static void main(String[] args) {
			
			System.out.println("···················································");
			System.out.println("········ Bienbenido/a a Sistema Biblioteca ········");
			System.out.println("···················································"); 

			Modulo.Usuario usuario = null;
			Scanner scan = new Scanner(System.in);
			System.out.println("Ingresar");
		    System.out.println("(1) para ingresar con cuenta \n(2) para ingresar como invitado\n");
			int ingreso = scan.nextInt();

			if (ingreso == 1) {

				System.out.print("Ingrese login\n");
				String loginIngresado = scan.next();
				System.out.print("Ingrese contraseña\n");
				String claveIngresada = scan.next();
				
				ConsultaUsuario consultaUser = new ConsultaUsuario();
				usuario = consultaUser.validarLogin(loginIngresado, claveIngresada);
				if (usuario != null) {
					ConsultaLibros consultaBook = new ConsultaLibros();
					System.out.println("Bienvenido " + usuario.getNombre() + " " + usuario.getApellido());

					if (usuario.getCondicion() == 1) {
						System.out.println(" \n ===============Cuenta administrador===============");
						System.out.println("¿Desea agregar o modificar datos? \n 1)Si    2)No\n");

						int respuesta = scan.nextInt();
						if (respuesta == 1) {
							System.out.println("\n ===============Menu administrador===============");
							System.out.println("1) Agregar nuevo usuario");
							System.out.println("2) Modificar usuario");
							System.out.println("3) Dar baja usuario");
							System.out.println("4) Eliminar usuario");
							System.out.println("5) Mostrar socios dados de ALTA");
							System.out.println("6) Mostrar socios dados de BAJA");
							System.out.println("7) Agregar Libro nuevo");
							System.out.println("8) Modificar libro");
							System.out.println("9) Eliminar libro");
							System.out.println("0) Salir \n");

							int opcion = scan.nextInt();

							switch (opcion) {
							case 1:
								consultaUser.insertarUsuario(usuario.getCondicion());
								break;
							case 2:
								consultaUser.actualizarUsuario(usuario.getCondicion());
								break;
							case 3:
								System.out.println("no se encuentra disponible por el momento");
								break;
							case 4:
								consultaUser.eliminarUsuario(usuario.getCondicion());
								break;
							case 5:
								consultaUser.mostrarUsuariosSocios(usuario.getCondicion());
								break;
							case 6:
								consultaUser.mostrarUsuariosBaja(usuario.getCondicion());
								break;
							case 7:
								consultaBook.insertarLibro(usuario.getCondicion());
								break;
							case 8:
								consultaBook.actualizarLibro(usuario.getCondicion());
								break;
							case 9:
								consultaBook.eliminarLibro(usuario.getCondicion());
								break;
							default:
								break;
							}//termina el switch

						} //termina la resp

					}//termina condicion 1
					System.out.println("\n =============CATALOGO DE LIBROS===============\n");
					System.out.printf("%2S,%35s,%35s,%35s,%35s%n", "ID", "TITULO", "AUTOR", "RUTA IMAGEN",
							"LINK DE DESCARGA");
					ConsultaLibros libros2 = new ConsultaLibros();
					libros2.mostrarLibros(usuario.getCondicion());
					System.out.print("¿Desea descargar algun libro?\n 1)Si  2)No\n");
					int descarga = scan.nextInt();
					if(descarga==1) {
						Scanner scanear = new Scanner(System.in);
						System.out.print("Ingrese titulo del libro: \n");
						String libroDescarga = scanear.nextLine();
						
						ConsultaHistorial historial = new ConsultaHistorial();
						historial.descargarLibro(libroDescarga, usuario.getIdUsuario());
					}if(descarga==2){
						System.out.println("Gracias por visitarnos");
					}
				}

			}

			if (ingreso == 2) {
				System.out.println("Bienvenido usuario invitado");
				System.out.println("\n =============CATALOGO DE LIBROS===============\n");
				
				System.out.printf("%2S,%35s,%35s,%35s%n", "ID", "TITULO", "DESCRIPCIÓN", "RUTA IMAGEN");
				//TRAYENDO LOS LIBROS DE LA BASE DE DATOS
				ConsultaLibros libros = new ConsultaLibros();
				libros.mostrarLibros(3);
				
			}
		}

	}