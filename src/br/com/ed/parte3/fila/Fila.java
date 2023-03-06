package br.com.ed.parte3.fila;

import br.com.ed.base.EstruturaEstatica;

public class Fila<T> extends EstruturaEstatica<T> {

	public Fila() {
		super();
	}

	public Fila(int capacidade) {
		super(capacidade);
	}

	public boolean enfileirar(T elemento) {
		return super.adiciona(elemento);
	}

	public T desenfileirar() {
		final int POS = 0;

		if (this.estaVazia()) {
			return null;
		}

		return super.remove(POS);
	}

	public T espiar() {
		if (this.estaVazia()) {
			return null;
		}

		return elementos[0];
	}
}
