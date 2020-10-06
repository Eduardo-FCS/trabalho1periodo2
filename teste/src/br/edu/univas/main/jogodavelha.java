//Trabalho realizado por Brendon Augusto e Eduardo Faria

package br.edu.univas.main;

import java.util.Scanner;

public class jogodavelha {
	

	public static void main(String[] args) {
		String player[] = new String[2];
		Scanner scanner = new Scanner(System.in);
		nomes(player);
		int resultado = jogo(player);
		if (resultado == 1) {
			System.out.println("\n" + "Jogador " + player[0] + " ganhou essa rodada !" + "\n");
			System.out.println("=============================================");
		} else if (resultado == 2) {
			System.out.println("\n" + "Jogador " + player[1] + " ganhou essa rodada !" + "\n");
			System.out.println("=============================================");
		} else {
			System.out.println("\n" + "Deu velha !" + "\n");
			System.out.println("=============================================");
		}
		scanner.close();
	}

	public static int jogo(String[] player) {

		Scanner scanner = new Scanner(System.in);
		int resultado = -1, c = 0, cont = 0, historico[][] = new int[3][3];
		String jogadas = "",
				tabuleiro[][] = { { "1A", "1B", "1C" }, { "2A", "2B", "2C" }, { "3A", "3B", "3C" } };

		for (int d = 0; d < 9; d++) {

			System.out.println("\n" + "-> Digite a jogada abaixo (número e letra), " + player[c] + ":");
			jogadas = scanner.nextLine();
			cont++;
			c++;

			if (c == 2) {
				c = 0;
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (tabuleiro[i][j].equals(jogadas)) {
						if (d == 0 || d % 2 == 0) {
							historico[i][j] = 1;
						} else if (d == 1 || d % 2 == 1) {
							historico[i][j] = 2;
						}
					}
				}
			}
			tabulero(historico);
			for (int y = 0; y < 3; y++) {
				if (historico[0][y] == historico[1][y] && historico[2][y] == historico[0][y]) {
					if (historico[0][y] != 0) {
						return historico[0][y]; // ganhou pela coluna
					}
				}
			}
			for (int k = 0; k < 3; k++) {
				if (historico[k][0] == historico[k][1] && historico[k][0] == historico[k][2]) {
					if (historico[k][0] != 0) {
						return historico[k][0]; // ganhou pela linha
					}
				}
			}
			if (historico[0][0] == historico[1][1] && historico[0][0] == historico[2][2]) {
				if (historico[0][0] != 0) {
					return historico[0][0]; // diagonal principal
				}
			}
			if (historico[0][2] == historico[1][1] && historico[2][0] == historico[1][1]) {
				if (historico[0][2] != 0) {
					return historico[2][0]; // diagonal secundário
				}
			}
		}

		return 0;

	}

	public static void tabulero(int historico[][]) {
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (historico[i][j] == 0) {
					System.out.print(" - ");
				} else if (historico[i][j] == 1) {
					System.out.print(" X ");
				} else if (historico[i][j] == 2) {
					System.out.print(" O ");
				}
			}
			System.out.println();
		}

	}
	public static void nomes(String[] player) {
		String player1 = "", player2 = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("================================================" + "\n");
		System.out.println("             JOGO DA VELHA 2.0            ");
		System.out.println("\n" + "\n" + "      Sejam bem-vindos!");
		System.out.println("\n" + "================================================");
		System.out.println("\n" + "• Digite abaixo o nome do primeiro jogador:");
		player1 = scanner.nextLine();
		player[0] = player1;

		System.out.println("\n" + "• Digite abaixo o nome do segundo jogador:");
		player2 = scanner.nextLine();
		player[1] = player2;
		System.out.println("\n" + "================================================");
	}

}
