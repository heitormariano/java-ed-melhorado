package br.com.ed.fila.teste;

import br.com.ed.fila.Fila;

public class TesteCriacaoFila {

	public static void main(String[] args) {
		Fila<String> nomes = new Fila<String>();

		System.out.println("Vazia? " + nomes.estaVazia());
		System.out.println("Tamanho? " + nomes.tamanho());
		System.out.println(nomes.desenfileirar());
	}
}
