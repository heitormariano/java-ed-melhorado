package br.com.ed.parte4.lista.teste;

import br.com.ed.parte4.lista.ListaEncadeada;

public class ListaEncadeadaTeste {

	public static void main(String[] args) {
		ListaEncadeada<Integer> listaNumeros = new ListaEncadeada<>();
		listaNumeros.adicionar(1);

		System.out.println(listaNumeros);
	}
}
