package br.com.ed.parte1.vetor;

public class VetorObjects {

	private Object[] elementos;
	private int tamanho;

	public VetorObjects(int capacidade) {
		this.elementos = new Object[capacidade];
		this.tamanho = 0;
	}

	public boolean adiciona(Object elemento) {
		aumentaCapacidade();
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}

		return false;
	}

	public boolean adiciona(int posicao, Object elemento) {
		if (!isPosicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição Inválida");
		}

		aumentaCapacidade();
		for (int i = tamanho - 1; i >= posicao; i--) {
			elementos[i + 1] = elementos[i];
		}
		elementos[posicao] = elemento;
		tamanho++;

		return true;
	}

	public Object busca(int posicao) {
		if (!isPosicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição Inválida");
		}

		return elementos[posicao];
	}

	public int busca(Object elemento) {
		for (int i = 0; i < tamanho; i++) {
			if (elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}

	public void remove(int posicao) {
		if (!isPosicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição Inválida");
		}

		for (int i = posicao; i < tamanho - 1; i++) {
			elementos[i] = elementos[i + 1];
		}

		tamanho--;

	}

	public void remove(Object elemento) {
		int posicaoElem = busca(elemento);
		if (posicaoElem > -1) {
			remove(posicaoElem);
		} else {
			System.out.println("Elemento " + elemento + " não existe no vetor.");
		}
	}

	private void aumentaCapacidade() {
		if (tamanho == elementos.length) {
			Object[] elementosNovos = new Object[elementos.length * 2];
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
		if (!(posicao >= 0 && posicao < tamanho)) {
			return false;
		}

		return true;
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
