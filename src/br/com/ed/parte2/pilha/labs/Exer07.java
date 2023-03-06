package br.com.ed.parte2.pilha.labs;

import java.util.Scanner;

import br.com.ed.parte2.pilha.Pilha;

public class Exer07 {

	private static Pilha<Integer> pilhaValoresTemp;
	private static Scanner scan;

	public static void main(String[] args) {
		pilhaValoresTemp = new Pilha<Integer>();
		scan = new Scanner(System.in);
		boolean fimPrograma = false;

		do {
			imprimirMenu();
			fimPrograma = lerOpcao();
		} while (!fimPrograma);
	}

	private static void imprimirMenu() {

		System.out.println("Exercicio 07 - Decimal para binario");
		System.out.println("Escolha uma das opcoes a seguir");
		System.out.println("1 - Informar um numero decimal para ser convertido em binario");
		System.out.println("0 - Encerrar o programa");
	}

	private static boolean lerOpcao() {
		boolean flagEncerramento = false;

		int opcao = lerInformacaoInt("");

		switch (opcao) {
		case 0:
			flagEncerramento = true;
			System.out.println("Fim do programa!");
			break;
		case 1:
			processarNumeroDecimal();
			break;
		default:
			System.out.println("Entrada invalida. Informe uma das opcoes disponiveis\n");
			break;
		}

		return flagEncerramento;
	}

	private static void processarNumeroDecimal() {
		int numeroDecimal = lerInformacaoInt("Informe o numero decimal:");

		String binario = obterNumeroBinario(numeroDecimal);
		if (!binario.isEmpty()) {
			System.out.println("Binario de " + numeroDecimal + ": " + binario + "\n");
		} else {
			System.out.println("Binario nao pode ser calculado\n");
		}
	}

	private static String obterNumeroBinario(int numeroDecimal) {
		String valorBinario = "";

		while (numeroDecimal > 0) {
			pilhaValoresTemp.empilha(numeroDecimal % 2);
			numeroDecimal = numeroDecimal / 2;
		}

		while (!pilhaValoresTemp.estaVazia()) {
			valorBinario += pilhaValoresTemp.desempilha();
		}

		return valorBinario;
	}

	protected static String lerInformacaoStr(String msg) {
		System.out.println(msg);
		String entrada = scan.nextLine();

		return entrada;
	}

	protected static int lerInformacaoInt(String msg) {
		boolean entradaValida = false;
		int num = -1;

		while (!entradaValida) {
			try {
				if (!msg.isEmpty()) {
					System.out.println(msg);
				}

				String entrada = scan.nextLine();
				num = Integer.parseInt(entrada);

				entradaValida = true;

			} catch (Exception e) {
				System.out.println("Entrada invalida. Informe uma opcao valida");
			}
		}

		return num;
	}

}
