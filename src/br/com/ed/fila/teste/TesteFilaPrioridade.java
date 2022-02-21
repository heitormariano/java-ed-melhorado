package br.com.ed.fila.teste;

import br.com.ed.fila.FilaComPrioridade;

public class TesteFilaPrioridade {

	public static void main(String[] args) {
		FilaComPrioridade<Paciente> fila = new FilaComPrioridade<>();

		fila.enfileirar(new Paciente("Paciente B", 2));
		fila.enfileirar(new Paciente("Paciente A", 1));
		fila.enfileirar(new Paciente("Paciente C", 3));

		System.out.println(fila);

		System.out.println("Removendo elemento da Fila: " + fila.desenfileirar());

		System.out.println(fila);
	}
}
