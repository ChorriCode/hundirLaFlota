package vista;

import java.util.Iterator;

import controlador.Partida;
import modelo.Jugador;
import modelo.Tablero;

public class Principal {

	public static void main(String[] args) {

		Tablero tablero= new Tablero(10);				//Creamos el tablero
		Partida partida = new Partida();				//Creamos la partida
		Menu menu = new Menu();							//Creamos el menú
		partida.verParticipantes();
		Jugador jugador = partida.getParticipantes()[0];
		partida.ponerFlotaEnTablero(partida.getFlotaGuerra());
		Tablero.verTablero();
		menu.ataquePorTurno(jugador);
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
				partida.atacar(tablero, i, j);
			}
		}*/
		Tablero.verTablero();
		System.out.println(partida.comprobarFlotaHundida(partida.getFlotaGuerra()));
		//System.out.println(tablero.getPosicionEnTablero(0, 0).buscarIndexPosicionAtacada(0,0));

		System.out.println("puntuacion del jugador " + jugador.getNombre() + " es: " + jugador.getPuntuacion());
		
	} 
}
