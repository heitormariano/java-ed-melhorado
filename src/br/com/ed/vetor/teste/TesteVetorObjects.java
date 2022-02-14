package br.com.ed.vetor.teste;

import br.com.ed.vetor.VetorObjects;

public class TesteVetorObjects {

	public static void main(String[] args) {
		VetorObjects vetorObjects = new VetorObjects(5);

		vetorObjects.adiciona(10);
		vetorObjects.adiciona(200);
		vetorObjects.adiciona("Teste");
		vetorObjects.adiciona("Show");
		vetorObjects.adiciona(50);

		System.out.println(vetorObjects.toString());

		System.out.println("Tamanho vetor: " + vetorObjects.tamanho());

		// busca
		System.out.println("Elemento retornado: " + vetorObjects.busca(3));

		// busca (retornando índice)
		System.out.println("Elemento 10 existe?");
		System.out.println(vetorObjects.busca((Object) Integer.parseInt("10")) >= 0 ? "Sim" : "Não");

		System.out.println("Elemento 80 existe?");
		System.out.println(vetorObjects.busca((Object) Integer.parseInt("80")) >= 0 ? "Sim" : "Não");

		vetorObjects.adiciona(1, 400);
		// o toString() pode ser omitido
		System.out.println(vetorObjects);

		vetorObjects.adiciona(60);
		vetorObjects.adiciona(70);

		// removendo valor
		System.out.println("Antes da remoção");
		System.out.println(vetorObjects);

		vetorObjects.remove(2);
		System.out.println("Depois da remoção");
		System.out.println(vetorObjects);

		// removendo valor (passando o elemento)
		vetorObjects.remove((Object) Integer.parseInt("60"));
		vetorObjects.remove((Object) Integer.parseInt("70"));
		System.out.println("Imprimindo: " + vetorObjects);

	}
}
