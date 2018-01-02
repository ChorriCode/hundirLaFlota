package modelo;

public class Tablero {
	
	private static Tablero miTablero;
	private Barco [][] tablero;

	private Tablero(int size) {
		
		tablero = new Barco[size][size];
		vaciarTablero();
	}
	
	public static Tablero tableroSingleton(int size) {
		if (miTablero == null) {
			miTablero = new Tablero(size);
		} else {
			System.out.println("No se peude crear el tablero");
		}
		return miTablero;
	}
	
	
	private void vaciarTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = null;
			}		
		}
	}
	// Muestra el tablero en consola null = "x", los barcos con su tama�o
	public void verTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				try { //usamos un try / catch ya que las posiciones del tablero que son agua, son barcos = null
					Barco barcoActual = tablero[i][j]; //barco de la casilla que estamos analizando
					int sizeBarco = barcoActual.getSize(); //tamaño de ese barco
					String inicialBarco = barcoActual.getShipType().substring(0,1); //inicial del tipo de barco que es Submarino = "S"
					int casillaPosicionBarco = barcoActual.buscarIndexPosicionAtacada(i, j); //según el tamaño del barco que cual de sus partes está ocupando la casilla actual del tablero
					int stateCasillaBarco = barcoActual.getStateForPositions()[casillaPosicionBarco]; // que estado (nada, tocado o hundido) tiene la parte del barco que ocupa la casilla actual del tablero
					System.out.print(sizeBarco + inicialBarco + stateCasillaBarco + " "); // muestra en consola las posiciones del tablero. x = null = agua ----  1S1 = tamaño del barco + incial del tipo de barco + (1 = tocado)
				} catch (NullPointerException e) {
					System.out.print("x" + "   ");
				}
			}	
			System.out.println(); 
		}		
	}

	public Barco getPosicionEnTablero(int x, int y){
		return tablero[x][y];
	}
	
	public Barco[][] getTablero() {
		return tablero;
	}

	public void setTablero(int x, int y, Barco miBarco) {
		tablero[x][y] = miBarco;
	}

	
}
