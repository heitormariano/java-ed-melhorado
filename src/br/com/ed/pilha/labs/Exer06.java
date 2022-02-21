package br.com.ed.pilha.labs;

import java.util.Scanner;

import br.com.ed.pilha.Pilha;

public class Exer06 {

	/*
	 * esta solucao considera apenas a quantidade de simbolos usados (solucao
	 * incompleta). A solucao não verifica se a abertura e fechamento dos simbolos
	 * esta na ordem correta. Casos como este ([)] sao aceitos (expressao
	 * considerada balanceada).
	 * 
	 */
	private static Pilha<Character> pilhaExpressao;
	private static Scanner scan;

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
		System.out.println("1 - Informar expressao (simbolos) e verificar se esta balanceada)");
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

		String simbolosExtraidos = extrairSimbolosExpressao(expressaoEntrada);
		boolean pilhaGerada = gerarPilhaSimbolosExp(simbolosExtraidos);
		if (pilhaGerada) {
			boolean pilhaBalanceada = isPilhaBalanceada();
			if (pilhaBalanceada) {
				System.out.println("Expressao Balanceada");
			} else {
				System.out.println("Expressao NAO Balanceada");
			}
		} else {
			System.out.println("Ausencia de simbolos. Avaliacao nao pode ser realizada");
		}
	}

	private static String extrairSimbolosExpressao(String expressao) {
		int index = 0;
		String simbolos = "";

		while (index < expressao.length()) {
			char caracter = expressao.charAt(index);

			if (caracter == '{' || caracter == '[' || caracter == '(' || caracter == '}' || caracter == ']'
					|| caracter == ')') {
				simbolos += caracter;
			}

			index++;
		}

		return simbolos;
	}

	private static boolean gerarPilhaSimbolosExp(String simbolos) {
		boolean retorno;
		if (simbolos == null || simbolos.isEmpty()) {
			retorno = false;
		} else {
			for (int i = 0; i <= simbolos.length() - 1; i++) {
				pilhaExpressao.empilha(simbolos.charAt(i));
			}
			retorno = true;
		}

		return retorno;
	}

	private static boolean isPilhaBalanceada() {
		int countChavesAbert = 0, countColchetesAbert = 0, countParentesesAbert = 0;
		int countChavesFech = 0, countColchetesFech = 0, countParentesesFech = 0;

		if (pilhaExpressao.tamanho() % 2 != 0) {
			return false;
		} else {
			for (int i = 0; i < pilhaExpressao.tamanho(); i++) {
				Character simbolo = pilhaExpressao.busca(i);
				switch (simbolo) {
				case '{':
					countChavesAbert++;
					break;
				case '[':
					countColchetesAbert++;
					break;
				case '(':
					countParentesesAbert++;
					break;
				case '}':
					countChavesFech++;
					break;
				case ']':
					countColchetesFech++;
					break;
				case ')':
					countParentesesFech++;
					break;
				}
			}

			if (countChavesAbert != countChavesFech || countColchetesAbert != countColchetesFech
					|| countParentesesAbert != countParentesesFech) {
				return false;
			}
		}

		return true;
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
