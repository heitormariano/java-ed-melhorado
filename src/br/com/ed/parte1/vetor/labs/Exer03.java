package br.com.ed.parte1.vetor.labs;

import br.com.ed.parte1.vetor.Lista;

public class Exer03 {

	public static void main(String[] args) {
		Lista<String> nomes = new Lista<String>(4);

		nomes.adiciona("Peter");
		nomes.adiciona("Joshua");
		nomes.adiciona("Sabrina");
		nomes.adiciona("Margarida");

		System.out.println(nomes);
		System.out.println();

		System.out.println("Tentativa remo��o: Joshua");
		System.out.println("Resultado: " + (nomes.remove("Joshua") ? "Elemento removido" : "Elemento n�o removido"));
		System.out.println("Imprimindo lista:");
		System.out.println(nomes);

		System.out.println();

		System.out.println("Tentativa remo��o: Margarida");
		System.out.println("Resultado: " + (nomes.remove("Margarida") ? "Elemento removido" : "Elemento n�o removido"));
		System.out.println("Imprimindo lista:");
		System.out.println(nomes);

	}
}
