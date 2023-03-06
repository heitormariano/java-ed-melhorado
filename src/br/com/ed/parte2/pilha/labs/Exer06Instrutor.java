package br.com.ed.parte2.pilha.labs;

import java.util.Scanner;

import br.com.ed.parte2.pilha.Pilha;

public class Exer06Instrutor {

	private static Pilha<Character> pilhaExpressao;
	private static Scanner scan;

	final static String ABRE = "([{";
	final static String FECHA = ")]}";

	public static void main(String[] args) {
		pilhaExpressao = new Pilha<Character>();
		scan = new Scanner(System.in);
		boolean fimPrograma = false;

		do {
			imprimirMenu();
			fimPrograma = lerOpcao();
		} while (!fimPrograma);
	}

	private static void imprimirMenu() {

		System.out.println("Exercicio 06 - Verificar Expressao Balanceada");
		System.out.println("Escolha uma das opcoes a seguir");
		System.out.println("1 - Informar expressao (simbolos) (e verificar se esta balanceada)");
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
			verificarSimbolosExpressao();
			break;
		default:
			System.out.println("Entrada invalida. Informe uma das opcoes disponiveis\n");
			break;
		}

		return flagEncerramento;
	}

	private static void verificarSimbolosExpressao() {
		String expressaoEntrada = lerInformacaoStr("Informe a expressao(simbolos)");
		expressaoEntrada = expressaoEntrada.replaceAll("\\s+", "").toLowerCase();

		boolean retorno = isPilhaBalanceada(expressaoEntrada);
		if (retorno) {
			System.out.println("Expressao Balanceada");
		} else {
			System.out.println("Expressao NAO Balanceada");
		}

	}

	private static boolean isPilhaBalanceada(String expressao) {
		int index = 0;
		char simbolo, topo;

		while (index < expressao.length()) {
			simbolo = expressao.charAt(index);

			if (ABRE.indexOf(simbolo) > -1) {
				pilhaExpressao.empilha(simbolo);

			} else if (FECHA.indexOf(simbolo) > -1) {

				if (pilhaExpressao.estaVazia()) {
					return false;
				} else {
					topo = pilhaExpressao.desempilha();

					if (ABRE.indexOf(topo) != FECHA.indexOf(simbolo)) {
						return false;
					}
				}
			}
			
			index++;
		}

		return pilhaExpressao.estaVazia();
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
