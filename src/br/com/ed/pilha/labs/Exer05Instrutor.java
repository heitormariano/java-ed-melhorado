package br.com.ed.pilha.labs;

import java.util.Scanner;
import java.util.Stack;

public class Exer05Instrutor {

	private static Stack<Character> pilhaCaracteres;
	private static Scanner scan;

	public static void main(String[] args) {
		pilhaCaracteres = new Stack<Character>();
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
		boolean retorno = isPilhaPalindromo(palavra);
		if (retorno) {
			System.out.println("Palindromo encontrado");
		} else {
			System.out.println("Palindromo NAO encontrado");
		}
	}

	private static void gerarPilhaCaracteres(String palavra) {
		for (int i = 0; i <= palavra.length() - 1; i++) {
			pilhaCaracteres.push(palavra.charAt(i));
		}
	}

	private static boolean isPilhaPalindromo(String palavra) {
		String palavraInversa = "";
		while (!pilhaCaracteres.isEmpty()) {
			palavraInversa += pilhaCaracteres.pop();
		}

		if (palavra.equals(palavraInversa)) {
			return true;
		}

		return false;
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
