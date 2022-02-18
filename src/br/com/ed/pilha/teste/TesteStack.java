package br.com.ed.pilha.teste;

import java.util.Stack;

public class TesteStack {

	public static void main(String[] args) {
		Stack<String> fakeNames = new Stack<String>();

		// criando elementos

		for (int i = 0; i < 5; i++) {
			String name = "Person_";
			name += i;
			fakeNames.push(name);
		}

		// imprimindo elementos
		for (int i = 0; i < fakeNames.size(); i++) {
			System.out.println(fakeNames.get(i));
		}

		System.out.println("Pilha Vazia? " + (fakeNames.isEmpty() ? "SIM" : "NÃO"));

		// usando métodos peek e pop
		System.out.println("Uso peek: " + fakeNames.peek());
		System.out.println("Lista após peek: " + fakeNames);

		System.out.println("Uso pop: " + fakeNames.pop());
		System.out.println("Lista após pop: " + fakeNames);
	}
}
