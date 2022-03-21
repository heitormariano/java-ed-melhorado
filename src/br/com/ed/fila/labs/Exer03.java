package br.com.ed.fila.labs;

import static br.com.ed.fila.labs.PrioridadeAtendimento.AMARELO;
import static br.com.ed.fila.labs.PrioridadeAtendimento.VERDE;
import static br.com.ed.fila.labs.PrioridadeAtendimento.VERMELHO;

import br.com.ed.fila.FilaComPrioridade;

public class Exer03 {

	public static void main(String[] args) {
		FilaComPrioridade<Pessoa> filaInicial = new FilaComPrioridade<>();

		filaInicial.enfileirar(new Pessoa("Carlos", VERMELHO));
		filaInicial.enfileirar(new Pessoa("Joao", AMARELO));
		filaInicial.enfileirar(new Pessoa("Mateus", VERDE));
		filaInicial.enfileirar(new Pessoa("Jose", VERDE));
		filaInicial.enfileirar(new Pessoa("Maria", AMARELO));
		filaInicial.enfileirar(new Pessoa("Marta", VERMELHO));

		PSAtendimento psAtendimento = new PSAtendimento(filaInicial);
		PSNovosPacientes psNovosPacientes = new PSNovosPacientes(filaInicial);

		Thread tAtendimentos = new Thread(psAtendimento);
		Thread tNovosPacientes = new Thread(psNovosPacientes);

		tAtendimentos.start();
		tNovosPacientes.start();
	}
}
