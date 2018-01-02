package vista;

import controlador.Partida;
import modelo.Tablero;

public class Principal {

	public static void main(String[] args) {

		Tablero tablero= Tablero.tableroSingleton(10);	//Creamos el tablero
		Partida partida = new Partida();				//Creamos la partida
		Menu menu = new Menu();							//Creamos el menú
		
		menu.crearJugadores();
		partida.ponerFlotaEnTablero(tablero, partida.getFlotaGuerra());
		tablero.verTablero();
		partida.atacar(tablero, 0, 0);
		partida.atacar(tablero, 1, 0);
		partida.atacar(tablero, 0, 1);
		partida.atacar(tablero, 0, 2);
		partida.atacar(tablero, 0, 3);
		partida.atacar(tablero, 2, 0);
		partida.atacar(tablero, 5, 0);
		partida.atacar(tablero, 4, 1);
		partida.atacar(tablero, 4, 2);
		partida.atacar(tablero, 4, 3);
		tablero.verTablero();
		//System.out.println(tablero.getPosicionEnTablero(0, 0).buscarIndexPosicionAtacada(0,0));

		

	} 
}
