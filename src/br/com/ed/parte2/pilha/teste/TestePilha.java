package br.com.ed.parte2.pilha.teste;

import br.com.ed.parte2.pilha.Pilha;

public class TestePilha {

	public static void main(String[] args) {

		Pilha<Integer> pilha = new Pilha<Integer>();

		System.out.println("Está vazia? " + (pilha.estaVazia() ? "Sim" : "Não"));
		System.out.println("Elementos pilha: " + pilha);
		System.out.println("Tamanho: " + pilha.tamanho());

		System.out.println("-- Novo teste --");
		for (int i = 0; i < 5; i++) {
			pilha.empilha(i);
		}

		System.out.println("Está vazia? " + (pilha.estaVazia() ? "Sim" : "Não"));
		System.out.println("Elementos pilha: " + pilha);
		System.out.println("Tamanho: " + pilha.tamanho());
	}
}
