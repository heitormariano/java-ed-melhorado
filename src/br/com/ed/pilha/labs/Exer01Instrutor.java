package br.com.ed.pilha.labs;

import java.util.Scanner;

import br.com.ed.pilha.Pilha;

public class Exer01Instrutor {

	public static void main(String[] args) {
		Pilha<Integer> numeros = new Pilha<Integer>();
		Scanner scan = new Scanner(System.in);

		System.out.println("Pilha para numeros Pares e Ímpares");
		for (int i = 0; i < 10; i++) {
			System.out.println("Informe um número para ser lido");
			int numero = scan.nextInt();

			if (numero % 2 == 0) {
				numeros.empilha(numero);
			} else {
				Integer retorno = numeros.desempilha();
				if (retorno == null) {
					System.out.println("Pilha vazia. Insira um ou mais números pares");
				} else {
					System.out.println("Usando método desempilha...");
					System.out.println("Elemento retirado: " + retorno);
				}
			}
		}

		System.out.println("Fim do programa");

		if (numeros.estaVazia()) {
			System.out.println("A pilha está vazia no final do processamento");
		} else {
			System.out.println("Elementos atuais: " + numeros);
			System.out.println("Limpando a pilha...");
			while (!numeros.estaVazia()) {
				System.out.println("Elemento desempilhado: " + numeros.desempilha());
			}
		}
	}
}
