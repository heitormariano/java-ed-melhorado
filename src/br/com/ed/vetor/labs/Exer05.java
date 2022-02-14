package br.com.ed.vetor.labs;

import br.com.ed.vetor.Lista;

public class Exer05 {

	public static void main(String[] args) {
		Lista<String> nomes = new Lista<String>(4);

		nomes.adiciona("Peter");
		nomes.adiciona("Joshua");
		nomes.adiciona("Sabrina");
		nomes.adiciona("Margarida");

		System.out.println("Lista:" + nomes);
		System.out.println("Tamanho lista:" + nomes.tamanho());

		nomes.limpar();
		System.out.println("Após uso do método limpar");
		System.out.println("Lista:" + nomes);
		System.out.println("Tamanho lista:" + nomes.tamanho());

		System.out.println();
		System.out.println("Adicionando novos elementos");
		nomes.adiciona("Amanda");
		nomes.adiciona("Bianca");
		nomes.adiciona("Carlos");

		System.out.println("Lista:" + nomes);
		System.out.println("Tamanho lista:" + nomes.tamanho());

		nomes.limpar();
		System.out.println("Novo uso do método limpar...");
		System.out.println("Lista:" + nomes);
		System.out.println("Tamanho lista:" + nomes.tamanho());

	}
}
