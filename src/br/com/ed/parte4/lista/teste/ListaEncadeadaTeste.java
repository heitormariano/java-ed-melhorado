package br.com.ed.parte4.lista.teste;

import br.com.ed.parte4.lista.ListaEncadeada;

public class ListaEncadeadaTeste {

	public static void main(String[] args) {
		ListaEncadeada<Integer> listaNumeros = new ListaEncadeada<>();
		listaNumeros.adicionar(1);
		listaNumeros.adicionar(2);

		System.out.println("Tamanho = " + listaNumeros.getTamanho());
		System.out.println(listaNumeros);

		listaNumeros.adicionar(3);
		listaNumeros.adicionar(4);
		listaNumeros.adicionar(5);

		System.out.println("Tamanho = " + listaNumeros.getTamanho());
		System.out.println(listaNumeros);

		System.out.println("Imprimindo apenas os valores da lista:");
		System.out.println(listaNumeros.imprimirValoresLoopWhile());
		System.out.println(listaNumeros.imprimirValoresLoopFor());

		System.out.println("Lista após limpeza:");
		listaNumeros.limpar();

		System.out.println("Tamanho = " + listaNumeros.getTamanho());
		System.out.println(listaNumeros.imprimirValoresLoopWhile());
	}
}
