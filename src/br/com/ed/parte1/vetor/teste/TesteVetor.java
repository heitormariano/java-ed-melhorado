package br.com.ed.parte1.vetor.teste;

import br.com.ed.parte1.vetor.Vetor;

public class TesteVetor {

	public static void main(String[] args) {
		Vetor vetor = new Vetor(5);

		vetor.adiciona("caderno");
		vetor.adiciona("borracha");
		vetor.adiciona("caneta");
		vetor.adiciona("lapis");
		vetor.adiciona("estojo");

		// tentativa de inclusão de sexto elemento
//		boolean retorno = vetor.adiciona("corretivo");
//		System.out.println("Adicionou? " + (retorno ? "Sim" : "Não"));

		System.out.println(vetor.toString());

		System.out.println("Tamanho vetor: " + vetor.tamanho());

		// busca
		System.out.println("Elemento retornado: " + vetor.busca(3));

		// busca (retornando índice)
		System.out.println("Elemento caneta existe?");
		System.out.println(vetor.busca("caneta") >= 0 ? "Sim" : "Não");

		System.out.println("Elemento bolo existe?");
		System.out.println(vetor.busca("bolo") >= 0 ? "Sim" : "Não");

		vetor.adiciona(1, "tesoura");
		// o toString() pode ser omitido
		System.out.println(vetor);

		vetor.adiciona("mochila");
		vetor.adiciona("livros");

		// removendo valor
		System.out.println("Antes da remoção");
		System.out.println(vetor);

		vetor.remove(2);
		System.out.println("Depois da remoção");
		System.out.println(vetor);

		// removendo valor (passando o elemento)
		vetor.remove("livros");
		vetor.remove("Pelota");
		System.out.println("Imprimindo: " + vetor);

	}
}
