package br.com.ed.vetor.labs;

import br.com.ed.vetor.Lista;

public class Exer01 {

	public static void main(String[] args) {

		Lista<Integer> numeros = new Lista<>(3);
		numeros.adiciona(2);
		numeros.adiciona(4);
		numeros.adiciona(6);

		System.out.println("Cont�m 4? " + (numeros.contem(4) ? "SIM" : "N�O"));
		System.out.println("Cont�m 5? " + (numeros.contem(5) ? "SIM" : "N�O"));
		System.out.println("Cont�m 6? " + (numeros.contem(6) ? "SIM" : "N�O"));
	}
}
