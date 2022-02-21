package br.com.ed.fila.teste;

import br.com.ed.fila.Fila;

public class TesteRetirarElementos {

	public static void main(String[] args) {
		Fila<Integer> numeros = new Fila<Integer>();

		numeros.enfileirar(1);
		numeros.enfileirar(2);
		numeros.enfileirar(3);
		
		System.out.println("Elementos Fila: " + numeros);
		System.out.println("Elemento removido: " + numeros.desenfileirar());
		System.out.println("Elemento removido: " + numeros.desenfileirar());
		System.out.println("Elemento removido: " + numeros.desenfileirar());
		System.out.println("Tamanho Fila: " + numeros.tamanho());

	}
}
