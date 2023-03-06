package br.com.ed.parte1.vetor;

public class Vetor {

	private String[] elementos;
	private int tamanho;

	public Vetor(int capacidade) {
		this.elementos = new String[capacidade];
		this.tamanho = 0;
	}

	public boolean adiciona(String elemento) {
		aumentaCapacidade();
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}

		return false;
	}

	public boolean adiciona(int posicao, String elemento) {
		if (!isPosicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição Inválida");
		}

		aumentaCapacidade();
//		for (int i = tamanho - 1; i >= posicao; i--) {
//			elementos[i + 1] = elementos[i];
//		}
		for (int i = tamanho; i > posicao; i--) {
			elementos[i] = elementos[i - 1];
		}
		elementos[posicao] = elemento;
		tamanho++;

		return true;
	}

	public String busca(int posicao) {
		if (!isPosicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição Inválida");
		}

		return elementos[posicao];
	}

	public int busca(String elemento) {
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

	public void remove(String elemento) {
		int posicaoElem = busca(elemento);
		if (posicaoElem > -1) {
			remove(posicaoElem);
		} else {
			System.out.println("Elemento " + elemento + " não existe no vetor.");
		}
	}

	private void aumentaCapacidade() {
		if (tamanho == elementos.length) {
			String[] elementosNovos = new String[elementos.length * 2];
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
