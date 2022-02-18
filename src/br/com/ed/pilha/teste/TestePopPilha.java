package br.com.ed.pilha.teste;

import br.com.ed.pilha.Pilha;

public class TestePopPilha {

	public static void main(String[] args) {
		Pilha<Integer> pilha = new Pilha<Integer>();

		for (int i = 0; i < 10; i++) {
			pilha.empilha(i);
		}

		System.out.println(pilha.desempilha());
		System.out.println(pilha.desempilha());
		System.out.println(pilha.desempilha());

		System.out.println("Tamanho Pilha: " + pilha.tamanho());
		System.out.println("Elementos: " + pilha);

	}
}
