package br.com.ed.parte1.vetor;

import br.com.ed.base.EstruturaEstatica;

public class ListaVer2<T> extends EstruturaEstatica<T> {

	public ListaVer2(int capacidade) {
		super(capacidade);
	}

	public ListaVer2() {
		super();
	}

	public boolean adiciona(T elemento) {
		return super.adiciona(elemento);
	}

	public boolean adiciona(int posicao, T elemento) {
		return super.adiciona(posicao, elemento);
	}

	public T remove(int posicao) {
		return super.remove(posicao);
	}

	public int busca(T elemento) {
		for (int i = 0; i < tamanho; i++) {
			if (elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}

	public T busca(int posicao) {
		if (!isPosicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição Inválida");
		}

		return elementos[posicao];
	}
}
