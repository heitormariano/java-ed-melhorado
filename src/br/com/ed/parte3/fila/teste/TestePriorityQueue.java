package br.com.ed.parte3.fila.teste;

import java.util.PriorityQueue;
import java.util.Queue;

public class TestePriorityQueue {

	public static void main(String[] args) {
		Queue<Paciente> filaComPrioridade = new PriorityQueue<>();

		filaComPrioridade.add(new Paciente("Paciente D", 4));
		filaComPrioridade.add(new Paciente("Paciente C", 3));
		filaComPrioridade.add(new Paciente("Paciente B", 2));
		filaComPrioridade.add(new Paciente("Paciente A", 1));

		System.out.println("Elementos da Fila com Prioridade:");
		System.out.println(filaComPrioridade);
	}
}
