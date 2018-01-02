package vista;

import java.util.Scanner;

import controlador.Partida;
import modelo.Jugador;
import modelo.Tablero;

public class Menu {
	
	private Scanner scan = new Scanner(System.in);
	
	public Jugador[] crearJugadores() {  //Cuando es contra la máquina elegimos hasta 4 jugadores
		int opcion = 0;
		String nombre;
		System.out.println("HUNDIR LA FLOTA");
		System.out.print("¿Cuantos jugadores participarán? [1 a 4]: ");
		opcion = scan.nextInt();
		while (opcion < 1 || opcion > 4) {
			System.out.println();
			System.out.print("Por favor introduzca un número del 1 al 4: ");
			opcion = scan.nextInt();
		}
		Jugador[] resultado = new Jugador[opcion];
		
		for (int i = 0; i < resultado.length; i++) { //recorremos el array resultado para crear la cantidad de jugadores seleccionada
			System.out.print("Nombre del Jugador " + i + ": ");
			nombre = scan.next(); //nombre del jugador
			resultado[i] = new Jugador(i,nombre); //creamos el jugador con su nombre y directamente lo metemos en el array resultado
		}
		return resultado;
	}
	
	public void ataquePorTurno(Jugador jugador) {	
		System.out.println("Jugador " + jugador.getNombre() + " ataca:");
		System.out.println("Introduce coordenada X: ");
		int x = scan.nextInt();
		System.out.println("Introduce coordenada Y: ");
		int y = scan.nextInt();
		jugador.atacar(x, y);
	}
	
	public void turnoJugadores(Jugador[] jugadores) {
		int turno= 0;		
		while (Partida.comprobarFlotaHundida(Partida.getFlotaGuerra()) != true) { // Mientras la flota no esté hundida hacemos turnos de juego
			System.out.println("TURNO " + turno);
			for (int i = 0; i < jugadores.length; i++) { //vamos rotando a los jugadores para que participen
				System.out.println("----- Turno del jugador " + jugadores[i].getNombre() + " -----");
				do {
					ataquePorTurno(jugadores[i]);
					System.out.println("Acierta?: " + jugadores[i].getAciertaUltimoAtaque());
					if (Partida.comprobarFlotaHundida(Partida.getFlotaGuerra()) == true) {break;}
				} while (jugadores[i].getAciertaUltimoAtaque() == true); //si un jugador acierta vuelve a tirar en el mismo turno.
			}
			turno++;
			Tablero.verTablero();
		}
		System.out.println("*********** Flota Hundida - Fin Partida ***********");
		// la partida termino buscamos un método que muestre las puntuaciones y el ganador
		obtenerPuntuacion();
	}
	
	public void obtenerPuntuacion() {
		Jugador [] participantes = Partida.getParticipantes();
		for (Jugador jugador : participantes) {
			System.out.println(jugador);
		}
	}
}
