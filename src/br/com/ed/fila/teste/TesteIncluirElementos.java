package br.com.ed.fila.teste;

import br.com.ed.fila.Fila;

public class TesteIncluirElementos {

	public static void main(String[] args) {
		Fila<String> nomes = new Fila<String>();

		nomes.enfileirar("Nome01");
		nomes.enfileirar("Nome02");
		nomes.enfileirar("Nome03");

		System.out.println("Vazia? " + nomes.estaVazia());
		System.out.println("Tamanho? " + nomes.tamanho());
		System.out.println("Elementos:");
		System.out.println(nomes);
	}
}
