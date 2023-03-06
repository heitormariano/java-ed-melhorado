package br.com.ed.parte2.pilha.labs;

import java.util.Scanner;
import java.util.Stack;

public class Exer04 {

	private static Stack<Livro> pilhaLivros;
	private static Scanner scan;

	public static void main(String[] args) {
		pilhaLivros = new Stack<Livro>();
		scan = new Scanner(System.in);
		boolean fimPrograma = false;

		do {
			imprimirMenu();
			fimPrograma = lerOpcao();
		} while (!fimPrograma);
	}

	private static void imprimirMenu() {

		System.out.println("Exercicio 04 - uso Stack");
		System.out.println("Escolha uma das opcoes a seguir");
		System.out.println("1 - Adicionar Livro (empilhar)");
		System.out.println("2 - Remover Livro (desempilhar)");
		System.out.println("3 - Consultar tamanho pilha");
		System.out.println("4 - Espiar elemento do topo");
		System.out.println("5 - Imprimir elementos da Pilha");
		System.out.println("6 - Desempilhar todos os elementos");
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
			adicionarLivro();
			break;
		case 2:
			removerLivro();
			break;
		case 3:
			obterTamanhoPilha();
			break;
		case 4:
			espiarElementoTopo();
			break;
		case 5:
			imprimirElementosPilha();
			break;
		case 6:
			desempilharTodos();
			break;
		default:
			System.out.println("Entrada invalida. Informe uma das opcoes disponiveis\n");
			break;
		}

		return flagEncerramento;
	}

	private static void adicionarLivro() {
		Livro livro = new Livro();

		System.out.println("Inclusao de novo Livro");

		String nome = lerInformacaoStr("Informe nome:");
		String isbn = lerInformacaoStr("Informe isbn:");
		String anoLancamento = lerInformacaoStr("Informe ano lancamento:");
		String autor = lerInformacaoStr("Informe nome do autor:");

		livro.setNome(nome);
		livro.setIsbn(isbn);
		livro.setAnoLancamento(anoLancamento);
		livro.setAutor(autor);

		pilhaLivros.push(livro);

	}

	private static void removerLivro() {
		Livro livroRetornado = pilhaLivros.pop();

		if (livroRetornado == null) {
			System.out.println("Pilha esta vazia. Insira um ou mais elementos\n");
		} else {
			System.out.println("Pilha Livros - Elemento retirado: " + livroRetornado + "\n");
		}
	}

	private static void obterTamanhoPilha() {
		System.out.println("Tamanho Pilha: " + pilhaLivros.size() + "\n");
	}

	private static void espiarElementoTopo() {
		Livro elementoTopo = pilhaLivros.peek();
		if (elementoTopo == null) {
			System.out.println("Pilha vazia (sem elementos)\n");
		} else {
			System.out.println("Elemento do topo: " + elementoTopo + "\n");
		}
	}

	private static void imprimirElementosPilha() {
		if (!pilhaLivros.isEmpty()) {
			System.out.println("Elementos da pilha:" + pilhaLivros + "\n");
		} else {
			System.out.println("Pilha vazia. Adicione um ou mais elementos\n");
		}
	}

	private static void desempilharTodos() {
		if (pilhaLivros.isEmpty()) {
			System.out.println("Pilha vazia (sem elementos)\n");
		} else {
			System.out.println("desempilhando elementos...");
			while (!pilhaLivros.isEmpty()) {
				System.out.println("Elemento retirado: " + pilhaLivros.pop());
			}
			System.out.println();
		}
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
