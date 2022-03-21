package br.com.ed.fila.labs;

import java.util.Random;

import br.com.ed.fila.FilaComPrioridade;

public class PSNovosPacientes implements Runnable {

	private FilaComPrioridade<Pessoa> fila;
	private int contator = 0;
	private Random random = new Random();

	public PSNovosPacientes(FilaComPrioridade<Pessoa> fila) {
		super();
		this.fila = fila;
	}

	@Override
	public void run() {
		for (int i = 0; i < 6; i++) {
			try {
				Thread.sleep(8000);

				++contator;
				String nomePaciente = "Paciente gerado " + contator;
				PrioridadeAtendimento prioridade = obterPrioridadeAleatorio();

				Pessoa paciente = new Pessoa(nomePaciente, prioridade);
				boolean resultado = fila.enfileirar(paciente);

				if (resultado) {
					System.out.println("----------------Entrada Paciente-----------------");
					System.out.println(paciente.getNome() + " enfileirado(a)");
					System.out.println("Prioridade: " + paciente.getPrioridade().getDescricao());
					System.out.println("-------------------------------------------------");
					System.out.println();
				} else {
					System.out.println("Ocorreu um problema na inclusao do paciente");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private PrioridadeAtendimento obterPrioridadeAleatorio() {
		int codPrioridade = random.nextInt(PrioridadeAtendimento.values().length);
		return PrioridadeAtendimento.obterPrioridadeByCod(codPrioridade);
	}

}
