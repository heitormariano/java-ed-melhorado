package br.com.ed.vetor.labs;

import java.util.Scanner;

import br.com.ed.vetor.Lista;
import br.com.ed.vetor.teste.Contato;

public class Exer06 {

	private static Scanner scan;
	private static Lista<Contato> lista;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		lista = new Lista<Contato>(20);
		apresentarMenu();
	}

	private static void apresentarMenu() {
		int opcao = -1;

		while (opcao != 0) {
			opcao = obterOpcaoUsuario();

			switch (opcao) {
			case 0:
				imprimirMensagem("Fim Programa");
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
				imprimirMensagem("Op��o inv�lida. Digite novamente\n\n");
				break;
			}
		}
	}

	public static int obterOpcaoUsuario() {

		String entrada;
		int opcaoUsuario = -1;

		imprimirMensagem("Exerc�cio 06");
		imprimirMensagem("Escolha uma das op��es:");
		imprimirMensagem("1 - Adicionar contato no final");
		imprimirMensagem("2 - Adicionar contato em uma posi��o");
		imprimirMensagem("3 - Adicionar contatos (30) automaticamente");
		imprimirMensagem("4 - Buscar contato (usando �ndice)");
		imprimirMensagem("5 - Buscar contato (usando nome)");
		imprimirMensagem("6 - Buscar �ltimo �ndice de Contato");
		imprimirMensagem("7 - Remover contato (usando �ndice)");
		imprimirMensagem("8 - Remover contato (informando nome)");
		imprimirMensagem("9 - Consultar tamanho lista");
		imprimirMensagem("10 - Imprimir contatos da Lista");
		imprimirMensagem("11 - Limpar lista");
		imprimirMensagem("0 - Encerrar o Programa");

		try {
			entrada = scan.nextLine();
			opcaoUsuario = Integer.parseInt(entrada);

		} catch (Exception e) {
			imprimirMensagem("Letras informadas pelo usu�rio");
		}

		// obs.:
		// Quando ocorre exce��o, o valor de opcaoUsuario � definido como -1
		// No switch de apresentarMenu terminamos "entrando" na op��o default
		return opcaoUsuario;
	}

	public static void adicionarContatoNoFinal() {
		Contato contato = new Contato();

		imprimirMensagem("Inclus�o de novo contato");

		String nome = lerInformacaoStr("Informe nome:");
		String telefone = lerInformacaoStr("Informe telefone:");
		String email = lerInformacaoStr("Informe E-mail:");

		contato.setNome(nome);
		contato.setTelefone(telefone);
		contato.setEmail(email);

		lista.adiciona(contato);
	}

	public static void adicionarContato() {
		Contato contato = new Contato();

		imprimirMensagem("Inclus�o de novo contato");
		String nome = lerInformacaoStr("Informe nome:");
		String telefone = lerInformacaoStr("Informe telefone:");
		String email = lerInformacaoStr("Informe E-mail:");

		contato.setNome(nome);
		contato.setTelefone(telefone);
		contato.setEmail(email);

		int posicao = lerInformacaoInt("Informe a posi��o (�ndice) para o contato:");

		lista.adiciona(posicao, contato);
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

			lista.adiciona(contato);
		}

		if (lista.tamanho() == 30) {
			imprimirMensagem("Contatos criados para a lista\n");
		} else {
			imprimirMensagem("Ocorreu um problema na gera��o dos contatos\n");
		}
	}

	public static void buscarContatoPorPosicao() {
		Contato contato;

		try {
			imprimirMensagem("Busca de contato");
			int indice = lerInformacaoInt("Informe o �ndice do contato:");

			contato = lista.busca(indice);
			if (contato != null) {
				imprimirMensagem("Contato encontrado:\n" + contato.toString() + "\n");
			} else {
				imprimirMensagem("N�o existe contato com o �ndice informado");
			}
		} catch (IllegalArgumentException e) {
			imprimirMensagem("Posi��o informada inv�lida!\n");
		}
	}

	public static void buscarContatoPorNome() {
		imprimirMensagem("Busca de contato por nome");
		boolean contatoEncontrado = false;

		String nome = lerInformacaoStr("Informe o nome:");

		for (int i = 0; i < lista.tamanho(); i++) {
			if (lista.obtem(i).getNome().equalsIgnoreCase(nome)) {
				{
					Contato contato = lista.obtem(i);
					contatoEncontrado = true;
					imprimirMensagem("Dados do contato encontrado:");
					imprimirMensagem(contato.toString());
				}
			}
		}

		if (!contatoEncontrado) {
			imprimirMensagem("N�o foi encontrato contato com o nome informado");
		}
	}

	public static void buscarUltimoIndiceContato() {

		imprimirMensagem("Busca de contato");
		int indice = lerInformacaoInt("Informe o �ndice do contato:");

		Contato contato = null;
		try {
			contato = lista.busca(indice);

			int ultimoIndice = lista.ultimoIndice(contato);

			if (ultimoIndice > -1) {
				imprimirMensagem("�ltimo �ndice do contato: " + ultimoIndice);
			} else {
				imprimirMensagem("N�o existe contato para o �ndice informado.");
				imprimirMensagem("Por favor, revise a lista");
			}
		} catch (IllegalArgumentException e) {
			imprimirMensagem("Posi��o inv�lida informada. Tente novamente");
		}

	}

	public static void removerContatoPorPosicao() {

		if (lista.tamanho() > 0) {
			imprimirMensagem("Remo��o de contato:");
			int indice = lerInformacaoInt("Informe o �ndice do contato:");

			Contato contatoExcluido = lista.remove(indice);

			imprimirMensagem("Contato removido com sucesso");
			imprimirMensagem("Dados do contato exclu�do:\n" + contatoExcluido);
		} else {
			imprimirMensagem("Lista vazia. Insira um ou mais contatos antes");
		}
	}

	public static void removerContatoPorNome() {
		if (lista.tamanho() > 0) {
			boolean contatoRemovido = false;
			imprimirMensagem("Remo��o de contato por nome");

			String nome = lerInformacaoStr("Informe o nome do contato:");

			for (int i = 0; i < lista.tamanho(); i++) {
				if (lista.obtem(i).getNome().equalsIgnoreCase(nome)) {
					{
						Contato contato = lista.remove(i);
						contatoRemovido = true;
						imprimirMensagem("Dados do contato removido:");
						imprimirMensagem(contato.toString());
					}
				}
			}

			if (!contatoRemovido) {
				imprimirMensagem("N�o foi encontrato contato com o nome informado");
			}

		} else {
			imprimirMensagem("Lista Vazia. Insira um ou mais contatos");
		}

	}

	public static void limparLista() {
		lista.limpar();
		imprimirMensagem("Resultado da limpeza:\n" + lista);
	}

	public static void imprimirLista() {
		imprimirMensagem("Elementos da Lista:\n" + lista);
	}

	public static void obterTamanhoLista() {
		int tamanhoLista = lista.tamanho();
		imprimirMensagem("Tamanho (qtd itens guardados): " + tamanhoLista);
	}

	public static void imprimirMensagem(String msg) {
		System.out.println(msg);
	}

	protected static String lerInformacaoStr(String msg) {
		imprimirMensagem(msg);
		String entrada = scan.nextLine();

		return entrada;
	}

	protected static int lerInformacaoInt(String msg) {
		boolean entradaValida = false;
		int num = -1;

		while (!entradaValida) {

			try {
				imprimirMensagem(msg);
				String entrada = scan.nextLine();

				num = Integer.parseInt(entrada);

				entradaValida = true;

			} catch (Exception e) {
				imprimirMensagem("Entrada inv�lida, digite novamente");
			}
		}

		return num;
	}

}
