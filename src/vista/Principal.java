package vista;

import controlador.Partida;
import modelo.Tablero;

public class Principal {

	public static void main(String[] args) {

		Tablero tablero= Tablero.tableroSingleton(10);
		

		Partida partida = new Partida();
		partida.ponerFlotaEnTablero(tablero, partida.getFlotaGuerra());
		tablero.verTablero();
		partida.atacar(tablero, 3, 0);
		partida.atacar(tablero, 1, 0);
		partida.atacar(tablero, 3, 1);
		partida.atacar(tablero, 3, 2);
		partida.atacar(tablero, 3, 3);
		tablero.verTablero();
		//System.out.println(tablero.getPosicionEnTablero(0, 0).buscarIndexPosicionAtacada(0,0));
		System.out.println(
		partida.generarPosicionAleatoria(1) + " " +
		partida.generarPosicionAleatoria(2) + " " +
		partida.generarPosicionAleatoria(3) + ""
		);
		
		

	} 
}
