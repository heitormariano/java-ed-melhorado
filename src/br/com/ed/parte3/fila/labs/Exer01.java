package br.com.ed.parte3.fila.labs;

import br.com.ed.parte3.fila.Fila;

public class Exer01 {

	public static void main(String[] args) {
		Fila<Documento> filaImpressao = new Fila<Documento>();

		filaImpressao.enfileirar(new Documento("Doc A", 10));
		filaImpressao.enfileirar(new Documento("Doc B", 15));
		filaImpressao.enfileirar(new Documento("Doc C", 36));
		filaImpressao.enfileirar(new Documento("Doc D", 12));
		filaImpressao.enfileirar(new Documento("Doc E", 145));

		while (!filaImpressao.estaVazia()) {
			Documento docImprimir = filaImpressao.desenfileirar();
			System.out.println("Imprimindo " + docImprimir);

			try {
				Thread.sleep(200 * docImprimir.getQtdPaginas());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Os documentos da fila foram impressos");
	}
}
