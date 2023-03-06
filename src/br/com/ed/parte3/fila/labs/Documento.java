package br.com.ed.parte3.fila.labs;

public class Documento {

	private String nome;
	private int qtdPaginas;

	public Documento() {
	}

	public Documento(String nome, int qtdPaginas) {
		super();
		this.nome = nome;
		this.qtdPaginas = qtdPaginas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}

	@Override
	public String toString() {
		return "Documento [nome=" + nome + ", qtdPaginas=" + qtdPaginas + "]";
	}

}
