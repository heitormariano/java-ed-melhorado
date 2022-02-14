package br.com.ed.base;

public class EstruturaEstatica<T> {

	protected T[] elementos;
	protected int tamanho;

	@SuppressWarnings("unchecked")
	public EstruturaEstatica(int capacidade) {
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}

	public EstruturaEstatica() {
		this(10);
	}

	protected boolean adiciona(T elemento) {
		aumentaCapacidade();
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}

		return false;
	}

	protected boolean adiciona(int posicao, T elemento) {
		if (!isPosicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição Inválida");
		}

		aumentaCapacidade();
		for (int i = tamanho; i > posicao; i--) {
			elementos[i] = elementos[i - 1];
		}
		elementos[posicao] = elemento;
		tamanho++;

		return true;
	}

	protected T remove(int posicao) {
		if (!isPosicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição Inválida");
		}

		T elemRemovido = elementos[posicao];
		for (int i = posicao; i < tamanho - 1; i++) {
			elementos[i] = elementos[i + 1];
		}

		tamanho--;
		return elemRemovido;
	}

	@SuppressWarnings("unchecked")
	private void aumentaCapacidade() {
		if (tamanho == elementos.length) {
			T[] elementosNovos = (T[]) new Object[elementos.length * 2];
			for (int i = 0; i < elementos.length; i++) {
				elementosNovos[i] = elementos[i];
			}
			elementos = elementosNovos;
		}
	}

	public boolean isPosicaoValida(int posicao) {
		if (!(posicao >= 0 && posicao < elementos.length)) {
			return false;
		}

		return true;
	}

	public int tamanho() {
		return this.tamanho;
	}

	public boolean estaVazia() {
		return this.tamanho == 0;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for (int i = 0; i < tamanho - 1; i++) {
			sb.append(elementos[i]).append(", ");
		}
		if (this.tamanho > 0) {
			sb.append(elementos[this.tamanho - 1]);
		}
		sb.append("]");

		return sb.toString();
	}
}
