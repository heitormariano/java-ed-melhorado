package br.com.ed.fila.labs;

import java.util.Random;

import br.com.ed.fila.Fila;

public class Exer04 {

	public static void main(String[] args) {
		Fila<Integer> fila = new Fila<>();

		// os numeros incluidos representam as criancas
		for (int i = 0; i < 10; i++) {
			fila.enfileirar(i);
		}

		Random aleatorio = new Random();

		int num = 0;
		while (num == 0) {
			// o valor de num indica o ponto de retirada de um elemento ("crianca") da fila
			num = aleatorio.nextInt(10);
		}

		// valor de num sendo impresso
		System.out.println("Número = " + num);

		while (fila.tamanho() > 1) {
			for (int i = 0; i < num; i++) {
				// retirando os elementos ("criancas") que estao antes da crianca que sera
				// eleminada, assim como as reinserindo no final da fila
				fila.enfileirar(fila.desenfileirar());
			}

			// eliminando a "crianca" que esta no ponto de retirada determinado anteiormente
			System.out.println("Eliminado = " + fila.desenfileirar());
		}

		// a ultima "crianca" a permanecer sera a ganhadora
		System.out.println("Ganhador: " + fila.desenfileirar());
	}

}
