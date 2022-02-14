package br.com.ed.vetor.teste;

import br.com.ed.pilha.Pilha;

public class VerTopoPilha {

	public static void main(String[] args) {
		Pilha<Integer> pilha = new Pilha<Integer>();

		System.out.println("Elemento topo: " + pilha.topo());
		System.out.println("Pilha: " + pilha);

		System.out.println("-- Novo teste --");
		for (int i = 0; i < 5; i++) {
			pilha.empilha(i);
		}

		System.out.println("Elemento topo: " + pilha.topo());
		System.out.println("Pilha: " + pilha);
	}
}
