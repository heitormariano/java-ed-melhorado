package br.com.ed.parte3.fila.labs;

import br.com.ed.parte3.fila.Fila;

public class Exer02 {

	public static void main(String[] args) {
		Fila<String> filaRegular = new Fila<String>();
		Fila<String> filaPrioridade = new Fila<String>();
		final int MAX_ATEND_PRIORIDADE = 3;

		filaRegular.enfileirar("Regular 01");
		filaRegular.enfileirar("Regular 02");
		filaRegular.enfileirar("Regular 03");

		filaPrioridade.enfileirar("Prioridade 01");
		filaPrioridade.enfileirar("Prioridade 02");
		filaPrioridade.enfileirar("Prioridade 03");

		filaRegular.enfileirar("Regular 04");
		filaRegular.enfileirar("Regular 05");

		filaPrioridade.enfileirar("Prioridade 04");
		filaPrioridade.enfileirar("Prioridade 05");

		filaRegular.enfileirar("Regular 06");
		filaRegular.enfileirar("Regular 07");
		filaRegular.enfileirar("Regular 08");

		while (!filaRegular.estaVazia() || !filaPrioridade.estaVazia()) {
			int count = 0;

			// atendimento prioritario (maximo de 3 pessoas)
			while (!filaPrioridade.estaVazia() && count < MAX_ATEND_PRIORIDADE) {
				atenderPessoa(filaPrioridade);
				count++;
			}

			// atendimento regula (1 pessoa por vez)
			if (!filaRegular.estaVazia()) {
				atenderPessoa(filaRegular);
			}

			// verificar se a fila de prioridade esta vazia
			// Se estiver, todos os atendimentos regulares sao realizados
			if (filaPrioridade.estaVazia()) {
				while (!filaRegular.estaVazia()) {
					atenderPessoa(filaRegular);
				}
			}
		}

	}

	private static void atenderPessoa(Fila<String> filaAtendimento) {
		String pessoaAtendida = filaAtendimento.desenfileirar();
		System.out.println("Atendimento realizado para: " + pessoaAtendida);
	}
}
