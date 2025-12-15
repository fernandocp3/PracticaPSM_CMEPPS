package ahorcado;

import java.util.Scanner;

public class JuegoAhorcado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		int victoriasJ1 = 0;
		int victoriasJ2 = 0;
		int rondasJugadas = 0;

		System.out.println("=== AHORCADO: MEJOR DE 5 ===");

		while (rondasJugadas < 5 && victoriasJ1 < 3 && victoriasJ2 < 3) {
			rondasJugadas++;
			int idAnfitrion = (rondasJugadas % 2 != 0) ? 1 : 2;
			int idAdivinador = (idAnfitrion == 1) ? 2 : 1;

			System.out.println("\n--- RONDA " + rondasJugadas + " ---");
			System.out.println("JUGADOR " + idAnfitrion + ", escribe la palabra secreta:");
			String palabra = scanner.nextLine();


			for (int i = 0; i < 30; i++)
				System.out.println();

			Partida partida = new Partida(palabra);
			boolean gano = partida.jugarTurno(scanner);

			if (gano) {
				System.out.println("¡JUGADOR " + idAdivinador + " GANA LA RONDA!");
				if (idAdivinador == 1)
					victoriasJ1++;
				else
					victoriasJ2++;
			} else {
				System.out.println("¡JUGADOR " + idAdivinador + " PIERDE!");
				if (idAnfitrion == 1)
					victoriasJ1++;
				else
					victoriasJ2++;
			}

			System.out.println("MARCADOR: J1 [" + victoriasJ1 + "] - J2 [" + victoriasJ2 + "]");
		}
		System.out.println("FIN DEL JUEGO");

	}

}
