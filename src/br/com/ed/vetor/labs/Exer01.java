package br.com.ed.vetor.labs;

import br.com.ed.vetor.Lista;

public class Exer01 {

	public static void main(String[] args) {

		Lista<Integer> numeros = new Lista<>(3);
		numeros.adiciona(2);
		numeros.adiciona(4);
		numeros.adiciona(6);

		System.out.println("Contém 4? " + (numeros.contem(4) ? "SIM" : "NÃO"));
		System.out.println("Contém 5? " + (numeros.contem(5) ? "SIM" : "NÃO"));
		System.out.println("Contém 6? " + (numeros.contem(6) ? "SIM" : "NÃO"));
	}
}
