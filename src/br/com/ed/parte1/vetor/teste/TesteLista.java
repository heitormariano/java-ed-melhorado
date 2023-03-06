package br.com.ed.parte1.vetor.teste;

import br.com.ed.parte1.vetor.Lista;

public class TesteLista {

	public static void main(String[] args) {
		Lista<String> nomes = new Lista<String>(3);
		nomes.adiciona("Heitor");
		nomes.adiciona("Fernanda");
		nomes.adiciona("Pedro");

		System.out.println("Nomes: " + nomes);

		Lista<Contato> contatos = new Lista<Contato>(2);
		contatos.adiciona(new Contato("Carlos", "98855-6644", "carlos@teste.com"));
		contatos.adiciona(new Contato("Maria", "92233-7788", "maria@teste.com"));
		
		System.out.println(contatos);
	}
}
