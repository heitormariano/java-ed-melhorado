package br.com.ed.parte2.pilha.labs;

import java.util.Scanner;

import br.com.ed.parte2.pilha.Pilha;

public class Exer02 {

	public static void main(String[] args) {
		Pilha<Integer> pilhaPares = new Pilha<Integer>();
		Pilha<Integer> pilhaImpares = new Pilha<Integer>();
		Scanner scan = new Scanner(System.in);

		System.out.println("Exercicio 02 - Pilhas Pares e Impares");
		for (int i = 0; i < 10; i++) {
			System.out.println("Informe um número:");
			int numero = scan.nextInt();

			if (numero == 0) {
				Integer retornoPar = pilhaPares.desempilha();
				Integer retornoImpar = pilhaImpares.desempilha();

				verificarElemDesempilhado(retornoPar, "Par");
				verificarElemDesempilhado(retornoImpar, "Impar");

			} else if (numero % 2 == 0) {
				pilhaPares.empilha(numero);
			} else {
				pilhaImpares.empilha(numero);
			}
		}

		System.out.println("Fim da leitura dos valores");
		imprimirElementosPilha(pilhaPares, "Par");
		imprimirElementosPilha(pilhaImpares, "Impar");

	}

	private static void verificarElemDesempilhado(Integer elemento, String tipoPilha) {
		if (elemento == null) {
			System.out.println("Pilha " + tipoPilha + " está vazia. Insira novos elementos");
		} else {
			System.out.println("Pilha " + tipoPilha + " - Elemento retirado:" + elemento);
		}
	}

	private static void imprimirElementosPilha(Pilha<Integer> pilha, String tipoPilha) {
		if (pilha.estaVazia()) {
			System.out.println("Pilha " + tipoPilha + " está vazia");
		} else {
			System.out.println("## Pilha " + tipoPilha + " ##");
			while (!pilha.estaVazia()) {
				System.out.println("Desempilhando elemento : " + pilha.desempilha());
			}
		}
	}
}
