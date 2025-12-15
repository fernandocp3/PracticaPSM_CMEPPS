package ahorcado;

import java.util.Iterator;
import java.util.Scanner;

public class Partida {
	private static final int MAX_FALLOS = 6;
	private String palabraSecreta;
	private char[] progreso;
	private int fallosActuales;
	
	public Partida(String palabra) {
		
		this.palabraSecreta = palabra.toUpperCase();
		this.progreso = new char[palabra.length()];
		this.fallosActuales = 0;
		
		for(int i = 0; i < progreso.length; i++) {
			progreso[i] = '_';
		}
	}
	
	public boolean jugarTurno(Scanner scanner) {
		
		for (int i = 0; i < 50; i++) {
            System.out.println();
        }
		
		while(fallosActuales < MAX_FALLOS && new String(progreso).contains("_")) {
			imprimirEstado();
			System.out.println("Introduce una letra: ");
			String entrada = scanner.nextLine();
			
			for (int i = 0; i < 50; i++) {
	            System.out.println();
	        }
			
			if(entrada.isEmpty()) continue;
			
			if(entrada.length() > 1) {
				System.out.println("Introduce solo una letra, por favor.");
				continue;
			}
			
			char letra = entrada.toUpperCase().charAt(0);
			procesarLetra(letra);
		}
		
		for (int i = 0; i < 50; i++) {
            System.out.println();
        }
		
		imprimirEstado();
		
		return !new String(progreso).contains("_");
	}
	
	private void procesarLetra(char letra) {
		boolean acierto = false;
		
		for(int i=0; i < palabraSecreta.length(); i++) {
			if(palabraSecreta.charAt(i) == letra) {
				progreso[i] = letra;
				acierto = true;
			}
		}
		
		if(!acierto) {
			fallosActuales++;
			System.out.println("¡Letra incorrecta!");
		}
	}
	
	private void imprimirEstado() {
		System.out.println("\nPalabra: " + String.valueOf(progreso));
		System.out.println("Fallos: " + fallosActuales + "/" + MAX_FALLOS);
		
		dibujarAhorcado();
	}
	
	private void dibujarAhorcado() {
        // Base fija del patíbulo
        System.out.println("  _______");
        System.out.println("  |     |");

        // Cabeza (Fallo 1)
        if (fallosActuales >= 1) {
            System.out.println("  |     O");
        } else {
            System.out.println("  |");
        }

        // Cuerpo y brazos (Fallos 2, 3, 4)
        if (fallosActuales == 2) {
            System.out.println("  |     |");
        } else if (fallosActuales == 3) {
            System.out.println("  |    /|");
        } else if (fallosActuales >= 4) {
            System.out.println("  |    /|\\");
        } else {
            System.out.println("  |");
        }

        // Piernas (Fallos 5, 6)
        if (fallosActuales == 5) {
            System.out.println("  |    /");
        } else if (fallosActuales >= 6) {
            System.out.println("  |    / \\");
        } else {
            System.out.println("  |");
        }

        // Base inferior
        System.out.println("  |");
        System.out.println("__|__");
    }
}
