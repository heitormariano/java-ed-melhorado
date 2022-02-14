package br.com.ed.vetor.labs;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.ed.vetor.teste.Contato;

public class Exer07 {

	private static Scanner scan;
	private static ArrayList<Contato> lista;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		lista = new ArrayList<Contato>();
		apresentarMenu();
	}

	private static void apresentarMenu() {
		int opcao = -1;

		while (opcao != 0) {
			opcao = obterOpcaoUsuario();

			switch (opcao) {
			case 0:
				printMensagem("Fim Programa");
				break;
			case 1:
				adicionarContatoNoFinal();
				break;
			case 2:
				adicionarContato();
				break;
			case 3:
				gerarContatos();
				break;
			case 4:
				buscarContatoPorPosicao();
				break;
			case 5:
				buscarContatoPorNome();
				break;
			case 6:
				buscarUltimoIndiceContato();
				break;
			case 7:
				removerContatoPorPosicao();
				break;
			case 8:
				removerContatoPorNome();
				break;
			case 9:
				obterTamanhoLista();
				break;
			case 10:
				imprimirLista();
				break;
			case 11:
				limparLista();
				break;
			default:
				printMensagem("Opção inválida. Digite novamente\n\n");
				break;
			}
		}
	}

	public static int obterOpcaoUsuario() {

		String entrada;
		int opcaoUsuario = -1;

		printMensagem("Exercício 07 - Uso ArrayList");
		printMensagem("Escolha uma das opções:");
		printMensagem("1 - Adicionar contato no final");
		printMensagem("2 - Adicionar contato em uma posição");
		printMensagem("3 - Adicionar contatos (30) automaticamente");
		printMensagem("4 - Buscar contato (usando índice)");
		printMensagem("5 - Buscar contato (usando nome)");
		printMensagem("6 - Buscar último índice de Contato");
		printMensagem("7 - Remover contato (usando índice)");
		printMensagem("8 - Remover contato (informando nome)");
		printMensagem("9 - Consultar tamanho lista");
		printMensagem("10 - Imprimir contatos da Lista");
		printMensagem("11 - Limpar lista");
		printMensagem("0 - Encerrar o Programa");

		try {
			entrada = scan.nextLine();
			opcaoUsuario = Integer.parseInt(entrada);

		} catch (Exception e) {
			printMensagem("Letras informadas pelo usuário");
		}

		// obs.:
		// Quando ocorre exceção, o valor de opcaoUsuario
		// é definido como -1
		// No switch de apresentarMenu terminamos "entrando" na opção default
		return opcaoUsuario;
	}

	public static void adicionarContatoNoFinal() {
		Contato contato = new Contato();

		printMensagem("Inclusão de novo contato");

		String nome = lerInformacaoStr("Informe nome:");
		String telefone = lerInformacaoStr("Informe telefone:");
		String email = lerInformacaoStr("Informe E-mail:");

		contato.setNome(nome);
		contato.setTelefone(telefone);
		contato.setEmail(email);

		lista.add(contato);
	}

	public static void adicionarContato() {
		Contato contato = new Contato();

		printMensagem("Inclusão de novo contato");
		String nome = lerInformacaoStr("Informe nome:");
		String telefone = lerInformacaoStr("Informe telefone:");
		String email = lerInformacaoStr("Informe E-mail:");

		contato.setNome(nome);
		contato.setTelefone(telefone);
		contato.setEmail(email);

		int posicao = lerInformacaoInt("Informe a posição (índice) para o contato:");

		lista.add(posicao, contato);
	}

	public static void gerarContatos() {
		Contato contato;

		for (int i = 0; i < 30; i++) {
			contato = new Contato();
			String nome = "Contato";
			String telefone = "98899-45";
			String email = "contato_";

			nome = nome + (Integer.toString(i));
			email = email + Integer.toString(i) + "@teste.com.br";

			if (i < 10) {
				telefone = telefone + Integer.toString(i) + Integer.toString(i);
			} else {
				telefone = telefone + Integer.toString(i);
			}

			contato.setNome(nome);
			contato.setTelefone(telefone);
			contato.setEmail(email);

			lista.add(contato);
		}

		if (lista.size() == 30) {
			printMensagem("Contatos criados para a lista\n");
		} else {
			printMensagem("Ocorreu um problema na geração dos contatos\n");
		}
	}

	public static void buscarContatoPorPosicao() {
		Contato contato;

		try {
			printMensagem("Busca de contato");
			int indice = lerInformacaoInt("Informe o índice do contato:");

			contato = lista.get(indice);
			if (contato != null) {
				printMensagem("Contato encontrado:\n" + contato.toString() + "\n");
			} else {
				printMensagem("Não existe contato com o índice informado");
			}
		} catch (IllegalArgumentException e) {
			printMensagem("Posição informada inválida!\n");
		}
	}

	public static void buscarContatoPorNome() {
		printMensagem("Busca de contato por nome");
		boolean contatoEncontrado = false;

		String nome = lerInformacaoStr("Informe o nome:");

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNome().equalsIgnoreCase(nome)) {
				{
					Contato contato = lista.get(i);
					contatoEncontrado = true;
					printMensagem("Dados do contato encontrado:");
					printMensagem(contato.toString());
				}
			}
		}

		if (!contatoEncontrado) {
			printMensagem("Não foi encontrato contato com o nome informado");
		}
	}

	public static void buscarUltimoIndiceContato() {

		printMensagem("Busca de contato");
		int indice = lerInformacaoInt("Informe o índice do contato:");

		Contato contato = null;
		try {
			contato = lista.get(indice);

			int ultimoIndice = lista.lastIndexOf(contato);

			if (ultimoIndice > -1) {
				printMensagem("Último índice do contato: " + ultimoIndice);
			} else {
				printMensagem("Não existe contato para o índice informado.");
				printMensagem("Por favor, revise a lista");
			}
		} catch (IllegalArgumentException e) {
			printMensagem("Posição inválida informada. Tente novamente");
		}

	}

	public static void removerContatoPorPosicao() {

		if (lista.size() > 0) {
			printMensagem("Remoção de contato:");
			int indice = lerInformacaoInt("Informe o índice do contato:");

			Contato contatoExcluido = lista.remove(indice);

			printMensagem("Contato removido com sucesso");
			printMensagem("Dados do contato excluído:\n" + contatoExcluido);
		} else {
			printMensagem("Lista vazia. Insira um ou mais contatos antes");
		}
	}

	public static void removerContatoPorNome() {
		if (lista.size() > 0) {
			boolean contatoRemovido = false;
			printMensagem("Remoção de contato por nome");

			String nome = lerInformacaoStr("Informe o nome do contato:");

			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getNome().equalsIgnoreCase(nome)) {
					{
						Contato contato = lista.remove(i);
						contatoRemovido = true;
						printMensagem("Dados do contato removido:");
						printMensagem(contato.toString());
					}
				}
			}

			if (!contatoRemovido) {
				printMensagem("Não foi encontrato contato com o nome informado");
			}

		} else {
			printMensagem("Lista Vazia. Insira um ou mais contatos");
		}

	}

	public static void limparLista() {
		lista.clear();
		printMensagem("Resultado da limpeza:\n" + lista);
	}

	public static void imprimirLista() {
		printMensagem("Elementos da Lista:\n" + lista);
	}

	public static void obterTamanhoLista() {
		int tamanhoLista = lista.size();
		printMensagem("Tamanho (qtd itens guardados): " + tamanhoLista);
	}

	protected static String lerInformacaoStr(String msg) {
		printMensagem(msg);
		String entrada = scan.nextLine();

		return entrada;
	}

	protected static int lerInformacaoInt(String msg) {
		boolean entradaValida = false;
		int num = -1;

		while (!entradaValida) {

			try {
				printMensagem(msg);
				String entrada = scan.nextLine();

				num = Integer.parseInt(entrada);

				entradaValida = true;

			} catch (Exception e) {
				printMensagem("Entrada inválida, digite novamente");
			}
		}

		return num;
	}

	public static void printMensagem(String msg) {
		System.out.println(msg);
	}

}
