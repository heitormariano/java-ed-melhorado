package br.com.ed.parte3.fila.labs;

import br.com.ed.parte3.fila.FilaComPrioridade;

public class PSAtendimento implements Runnable {

	private FilaComPrioridade<Pessoa> fila;

	public PSAtendimento(FilaComPrioridade<Pessoa> fila) {
		super();
		this.fila = fila;
	}

	@Override
	public void run() {

		while (!this.fila.estaVazia()) {
			try {
				Pessoa paciente = fila.desenfileirar();
				System.out.println("-------------------Atendimento-------------------");
				System.out.println(paciente.getNome() + " atendido(a)");
				System.out.println("Prioridade: " + paciente.getPrioridade().getDescricao());
				System.out.println("-------------------------------------------------");
				System.out.println();

				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Atendimento dos pacientes concluido.");
	}

}
