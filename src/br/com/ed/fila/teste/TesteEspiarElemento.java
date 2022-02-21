package br.com.ed.fila.teste;

import br.com.ed.fila.Fila;

public class TesteEspiarElemento {

	public static void main(String[] args) {
		Fila<Integer> numeros = new Fila<Integer>();

		numeros.enfileirar(1);
		numeros.enfileirar(2);
		numeros.enfileirar(3);

		System.out.println("Elementos Fila: " + numeros);
		System.out.println("Elemento espiar (do inicio): " + numeros.espiar());

	}
}
