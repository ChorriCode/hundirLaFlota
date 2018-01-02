package vista;

import java.util.Iterator;

import controlador.Partida;
import modelo.Jugador;
import modelo.Tablero;

public class Principal {

	public static void main(String[] args) {

		Tablero tablero= new Tablero(10);				//Creamos el tablero
		Partida partida = new Partida();				//Creamos la partida (jugadores y flota aleatoria)
		Menu menu = new Menu();							//Creamos el menú
		Partida.verParticipantes();
		//Jugador jugador = Partida.getParticipantes()[0];
		Partida.ponerFlotaEnTablero(Partida.getFlotaGuerra());
		Tablero.verTablero();
		menu.turnoJugadores(Partida.getParticipantes());
		/*jugador.atacar(1, 0);
		jugador.atacar(1, 1);
		jugador.atacar(1, 2);
		jugador.atacar(1, 3);
		jugador.atacar(1, 4);
		jugador.atacar(1, 5);
		jugador.atacar(1, 6);
		jugador.atacar(1, 7);
		jugador.atacar(1, 8);
		jugador.atacar(1, 9);*/
		/*for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				jugador.atacar(i, j);
			}
		}*/
		Tablero.verTablero();
		System.out.println(partida.comprobarFlotaHundida(partida.getFlotaGuerra()));
		//System.out.println(tablero.getPosicionEnTablero(0, 0).buscarIndexPosicionAtacada(0,0));
		menu.obtenerPuntuacion();
	} 
}
