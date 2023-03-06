package br.com.ed.parte3.fila.labs;

import java.util.Random;

import br.com.ed.parte3.fila.Fila;

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
				// retirando os elementos ("criancas") que antecedem a crianca que sera
				// eleminada, assim como as reincluindo no final da fila
				fila.enfileirar(fila.desenfileirar());
			}

			// excluindo o elemento ("crianca") que esta no ponto de retirada determinado anteriormente
			System.out.println("Eliminado = " + fila.desenfileirar());
		}

		// o ultimo elemento ("crianca") a permanecer sera o ganhador
		System.out.println("Ganhador: " + fila.desenfileirar());
	}

}
