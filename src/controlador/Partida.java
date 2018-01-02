package controlador;

import modelo.Barco;
import modelo.Jugador;
import modelo.Tablero;
import vista.Menu;

public class Partida {
	
	private static Barco [] flotaGuerra; // array de los barcos que van a posicionarse en el tablero
	private static Jugador [] participantes;
	private static boolean flotaHundida = false;
	
	public Partida() {			//CONTRUCTOR
		flotaGuerra = generarFlota();
		participantes = new Menu().crearJugadores();		
	}
	// Genera la flota de barcos que va ajugar la partida
	private static Barco [] generarFlota() {
		Barco [] resultado = {new Barco(1), new Barco(2), new Barco(3), new Barco(4)};
		return resultado;
	}
	
	public static void verParticipantes() {
		for (Jugador jugador : participantes) {
			System.out.println(jugador);
		}
	}
	
	public static void ponerFlotaEnTablero(Barco [] flota) {
		/*  Esto coloca los barcos en la x=0 de las diferentes y
		for (int i = 0; i < flota.length; i++) {
			for (int j = 0; j < flota[i].getSize(); j++) {
				flota[i].setPositions(j,""+i+"-"+j);
				tablero.setTablero(i, j, flota[i]);
				System.out.println(flota[i].getPositions()[j]);
			}
		}
		*/
		for (int i = 0; i < flota.length; i++) {
			Barco barcoActual = flota[i];  // metemos en una variable el barco actual del array flota con el que vamos a trabajar
			int sizeBarco = barcoActual.getSize(); // almacenamos el tamaño que tiene el barco actual en una variable
			int posicion = generarPosicionAleatoria(sizeBarco); // llamámos al métod que está en esta misma clase para que nos genere una posición aleatoria dentro de la cordenada x del tablero.
			for (int j = 0; j < sizeBarco; j++) { //una vez tenemos la posicion, colocamos el barco actual de la flota en el tablero.
				barcoActual.setPositions(j, "" + i + "-" + (posicion + j)); //establecemos la posición del barco en su propio array de posiciones con un String del tipo "x-y"
				Tablero.setTablero(i, (posicion + j), barcoActual);
				System.out.println(barcoActual.getPositions()[j]);
			}
		}
		
	}
	
	public static int generarPosicionAleatoria(int sizeBarco){
		int posicionAleatoria;
		posicionAleatoria = (int) (Math.random() * (11 - sizeBarco)); //generamos una posicion aleatoria, solo la coordenada y dentro de la fila x que estemos en ese momento.
																	  //la posicion tiene que ser inferior al tamaño del barco para que no se salga del tablero
		return posicionAleatoria;
	}
	/*
	public void atacar(Tablero tablero, int x, int y) {
		Barco posicionAtacada = null; // Las posiciones en el tablero contienen barcos o null;
		posicionAtacada = tablero.getPosicionEnTablero(x, y);  // posición atacada, ahora comprobar si hay barco o no (null)
		if (posicionAtacada != null) { //comprobamos si la posición es distinta de agua es que hay barco
			int index = posicionAtacada.buscarIndexPosicionAtacada(x, y); //buscar en el array de posiciones del barco atacado que estado tiene dicha posición		
			if (index != -1) { //comprobamos que la posición del array no sea -1, eso significa que fue encontrada
				posicionAtacada.cambiarStateBarco(index);
				posicionAtacada.comprarBarcoHundido();
			}
		}
		
	}
	*/
	public static void sumarPuntuacionJugador(Jugador jugador, int puntos) {
		jugador.setPuntuacion(puntos); // añadimos la puntuación a un jugador concreto (siendo tocado = 2 puntos y hundido = 1 punto)
	}
	
	public static boolean comprobarFlotaHundida(Barco [] flota) {
		int contador = 0;
		for (Barco barco : flota) { // recorremos la flota y por cada barco hundido sumamos uno al contador
			if (barco.getHundido() == true) {
				contador++;
			}
		}
		if (contador == flota.length) { // si el contador es igual al numero de barcos de la flota es que todos están hundidos
			flotaHundida = true;
			return flotaHundida;				
		} else { // si faltan barcos por hundir retorno el valor por defecto de flotaHundida que es false;		
			return flotaHundida;
		}
		
	}

	public static Barco[] getFlotaGuerra() {
		return flotaGuerra;
	}

	public static void setFlotaGuerra(Barco[] flota) {
		flotaGuerra = flota;
	}
	public static Jugador[] getParticipantes() {
		return participantes;
	}
	
	

}
