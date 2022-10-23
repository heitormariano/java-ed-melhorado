package br.com.ed.pilha.labs;

import java.util.Stack;

public class Exer08Instrutor {
	// rever solucao da instrutora
	public static void main(String[] args) {

		// considerar torre de hanoi com esta estrutura
		Stack<Integer> original = new Stack<>();
		Stack<Integer> dest = new Stack<>();
		Stack<Integer> aux = new Stack<>();

		// empilhando os valores (discos)
		// obs.: a quantidade de elementos (discos) pode ser maior
		original.push(3);
		original.push(2);
		original.push(1);

		torreDeHanoi(original.size(), original, dest, aux);

	}

	// metodo adota recursao
	public static void torreDeHanoi(int numDiscos, Stack<Integer> original, Stack<Integer> dest, Stack<Integer> aux) {
		if (numDiscos > 0) {
			torreDeHanoi(numDiscos - 1, original, aux, dest);
			dest.push(original.pop());
			System.out.println("------");
			System.out.println("Original: " + original);
			System.out.println("Destino: " + dest);
			System.out.println("Aux: " + aux);
			torreDeHanoi(numDiscos - 1, aux, dest, original);
		}
	}

}
