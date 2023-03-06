package br.com.ed.parte2.pilha.labs;

import java.util.Scanner;
import java.util.Stack;

public class Exer05 {

	private static Stack<Character> pilhaCaracteres;
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		boolean fimPrograma = false;

		do {
			imprimirMenu();
			fimPrograma = lerOpcao();
		} while (!fimPrograma);
	}

	private static void imprimirMenu() {

		System.out.println("Exercicio 05 - Verificar palindromo");
		System.out.println("Escolha uma das opcoes a seguir");
		System.out.println("1 - Informar palavra/frase (e verificar se e palindromo)");
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
			verificarPalindromo();
			break;
		default:
			System.out.println("Entrada invalida. Informe uma das opcoes disponiveis\n");
			break;
		}

		return flagEncerramento;
	}

	private static void verificarPalindromo() {
		String palavra = lerInformacaoStr("Informe uma palavra");
		palavra = palavra.replaceAll("\\s+", "").toLowerCase();

		gerarPilhaCaracteres(palavra);
		boolean retorno = isPilhaPalindromo();
		if (retorno) {
			System.out.println("Palindromo encontrado");
		} else {
			System.out.println("Palindromo NAO encontroado");
		}

	}

	private static void gerarPilhaCaracteres(String palavra) {
		pilhaCaracteres = new Stack<Character>();
		for (int i = 0; i <= palavra.length() - 1; i++) {
			pilhaCaracteres.push(palavra.charAt(i));
		}
	}

	private static boolean isPilhaPalindromo() {
		int tamanho = pilhaCaracteres.size();
		int comeco = 0;
		int fim = tamanho - 1;
		while (fim > comeco) {
			Character caracterComeco = pilhaCaracteres.get(comeco++);
			Character caracterFim = pilhaCaracteres.get(fim--);
			if (caracterComeco.compareTo(caracterFim) != 0) {
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
