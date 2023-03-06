package br.com.ed.parte1.vetor.labs;

import br.com.ed.parte1.vetor.Lista;

public class Exer04 {

	public static void main(String[] args) {
		Lista<String> nomes = new Lista<String>(4);

		nomes.adiciona("Peter");
		nomes.adiciona("Joshua");
		nomes.adiciona("Sabrina");
		nomes.adiciona("Margarida");

		System.out.println("Elemento índice 0: " + nomes.obtem(0));
		System.out.println("Elemento índice 2: " + nomes.obtem(2));
		// System.out.println("Elemento índice 2: " + nomes.obtem(4)); // Exception

	}
}
