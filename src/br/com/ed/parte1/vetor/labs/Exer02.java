package br.com.ed.parte1.vetor.labs;

import br.com.ed.parte1.vetor.Lista;

public class Exer02 {

	public static void main(String[] args) {

		Lista<Integer> numeros = new Lista<Integer>(5);
		numeros.adiciona(2);
		numeros.adiciona(6);
		numeros.adiciona(3);
		numeros.adiciona(2);
		numeros.adiciona(6);

		System.out.println("Último índice: " + numeros.ultimoIndice(6));
		System.out.println("Último índice: " + numeros.ultimoIndice(2));
	}
}
