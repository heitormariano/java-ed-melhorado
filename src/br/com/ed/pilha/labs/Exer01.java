package br.com.ed.pilha.labs;

import java.util.Scanner;

import br.com.ed.pilha.Pilha;

public class Exer01 {

	public static void main(String[] args) {
		Pilha<Integer> numeros = new Pilha<Integer>();
		Scanner scan = new Scanner(System.in);

		System.out.println("Exercicio 01 - Pilha com valores pares e impares");
		int count = 1;
		while (count <= 10) {
			System.out.println("Informe um número para ser lido");
			int numero = scan.nextInt();

			if (numero % 2 == 0) {
				numeros.empilha(numero);
			} else {
				if (!numeros.estaVazia()) {
					numeros.desempilha();
				} else {
					System.out.println("Pilha vazia. Insira um ou mais números pares");
				}
			}
			count++;
		}

		System.out.println("Fim do programa");

		if (numeros.estaVazia()) {
			System.out.println("A pilha está vazia no final do processamento");
		} else {
			System.out.println("Elementos atuais: " + numeros);
			System.out.println("Limpando a pilha...");
			while (!numeros.estaVazia()) {
				System.out.println("Retirando elemento: " + numeros.desempilha());
			}
		}
	}
}
