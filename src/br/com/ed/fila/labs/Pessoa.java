package br.com.ed.fila.labs;

public class Pessoa implements Comparable<Pessoa> {

	private String nome;
	private PrioridadeAtendimento prioridade;

	public Pessoa(String nome, PrioridadeAtendimento prioridade) {
		super();
		this.nome = nome;
		this.prioridade = prioridade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PrioridadeAtendimento getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeAtendimento prioridade) {
		this.prioridade = prioridade;
	}

	@Override
	public int compareTo(Pessoa o) {
		if (this.prioridade.getCod() < o.prioridade.getCod()) {
			return -1;
		} else if (this.prioridade.getCod() > o.prioridade.getCod()) {
			return 1;
		}
		return 0;
	}

}
