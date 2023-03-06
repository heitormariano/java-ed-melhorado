package br.com.ed.parte3.fila.teste;

import br.com.ed.parte3.fila.Fila;

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
