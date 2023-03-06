package br.com.ed.parte1.vetor.teste;

import br.com.ed.parte1.vetor.VetorObjects;

public class TesteVetorContatos {

	public static void main(String[] args) {

		VetorObjects vetorContatos = new VetorObjects(5);

		Contato c1 = new Contato("Heitor", "9898-9898", "teste01.gmail.com");
		Contato c2 = new Contato("Bill", "1223-5656", "teste02.gmail.com");
		Contato c3 = new Contato("Ted", "7822-8977", "teste03.gmail.com");

		// contato com os mesmos parâmetros de c1
		Contato c4CopiaParams = new Contato("Heitor", "9898-9898", "teste01.gmail.com");

		vetorContatos.adiciona(c1);
		vetorContatos.adiciona(c2);
		vetorContatos.adiciona(c3);

		System.out.println("Tamanho vetor: " + vetorContatos.tamanho());

		int posicao = vetorContatos.busca(c4CopiaParams);
		if (posicao > -1) {
			System.out.println("Elemento existe no vetor");
		} else {
			System.out.println("Elemento não existe no vetor");
		}

		System.out.println("Imprimindo vetor:");
		System.out.println(vetorContatos);
	}
}
