package br.com.ed.pilha.labs;

import java.util.Objects;

public class Livro {

	private String nome;
	private String isbn;
	private String anoLancamento;
	private String autor;

	public Livro() {
		super();
	}

	public Livro(String nome, String isbn, String anoLancamento, String autor) {
		super();
		this.nome = nome;
		this.isbn = isbn;
		this.anoLancamento = anoLancamento;
		this.autor = autor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoLancamento, autor, isbn, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(anoLancamento, other.anoLancamento) && Objects.equals(autor, other.autor)
				&& Objects.equals(isbn, other.isbn) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", isbn=" + isbn + ", anoLancamento=" + anoLancamento + ", autor=" + autor + "]";
	}

}
