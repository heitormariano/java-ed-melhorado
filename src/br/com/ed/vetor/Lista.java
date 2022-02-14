package br.com.ed.vetor;

import java.lang.reflect.Array;

public class Lista<T> {

	private T[] elementos;
	private int tamanho;

	@SuppressWarnings("unchecked")
	public Lista(int capacidade) {
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}

	@SuppressWarnings("unchecked")
	public Lista(int capacidade, Class<T> tipoClasse) {
		this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
		this.tamanho = 0;
	}

	public boolean adiciona(T elemento) {
		aumentaCapacidade();
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}

		return false;
	}

	public boolean adiciona(int posicao, T elemento) {
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

	public T busca(int posicao) {
		if (!isPosicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição Inválida");
		}

		return elementos[posicao];
	}

	public int busca(T elemento) {
		for (int i = 0; i < tamanho; i++) {
			if (elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}

	// incremento: retornando elemento removido
	public T remove(int posicao) {
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

	public int tamanho() {
		return this.tamanho;
	}

	private boolean isPosicaoValida(int posicao) {
		if (!(posicao >= 0 && posicao < elementos.length)) {
			return false;
		}

		return true;
	}

	// exercicio 01 - método contém
	public boolean contem(T elemento) {
		return busca(elemento) > -1;
	}

	// exercício 02 - recuperar último índice
	public int ultimoIndice(T elemento) {
		for (int i = tamanho - 1; i >= 0; i--) {
			if (elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}

	// exercício 03 - remoção passando o elemento desejado
	public boolean remove(T elemento) {
		boolean resultado = false;
		int posicaoElem = busca(elemento);
		if (posicaoElem > -1) {
			remove(posicaoElem);
			resultado = true;
		} else {
			System.out.println("Elemento " + elemento + " não existe no vetor.");
		}

		return resultado;
	}

	// exercício 04 - método obtem
	public T obtem(int posicao) {
		return busca(posicao);
	}

	// exercício 05 - método limpar
	@SuppressWarnings("unchecked")
	public void limpar() {
		// capacidade inicial definida em 1
		this.elementos = (T[]) new Object[1];
		this.tamanho = 0;
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
