package br.com.ed.parte3.fila.teste;

import java.util.LinkedList;
import java.util.Queue;

public class TesteQueueJava {

	public static void main(String[] args) {
		Queue<Integer> numerosQueue = new LinkedList<Integer>();

		numerosQueue.add(10);
		numerosQueue.add(20);
		numerosQueue.add(30);
		numerosQueue.add(40);

		System.out.println("Vazia? " + numerosQueue.isEmpty());
		System.out.println("Elementos Fila: " + numerosQueue);

		System.out.println("Removendo elemento: " + numerosQueue.remove());
		System.out.println("Elementos apos remocao: " + numerosQueue);

		System.out.println("Elemento espiar: " + numerosQueue.peek());
		System.out.println("Tamanho fila:" + numerosQueue.size());

	}
}
