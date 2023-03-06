package br.com.ed.parte3.fila.labs;

public enum PrioridadeAtendimento {

	VERMELHO(0, "Alta"), AMARELO(1, "Medio"), VERDE(2, "Baixa");

	private int cod;
	private String descricao;

	private PrioridadeAtendimento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static PrioridadeAtendimento obterPrioridadeByCod(int cod) {
		for (PrioridadeAtendimento prioridade : PrioridadeAtendimento.values()) {
			if (prioridade.getCod() == cod) {
				return prioridade;
			}
		}
		return null;
	}

}
