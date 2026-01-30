package br.com.jose.sistemaestagiario;

import java.util.Scanner;

import br.com.jose.sistemaestagiario.db.EstagiarioDAO;
import br.com.jose.sistemaestagiario.domain.Estagiario;

public class SistemaEstagiario {

	private static EstagiarioDAO dao = new EstagiarioDAO();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		boolean rodarDeNovo = true;
		while (rodarDeNovo) {
			System.out.println("1 - Adicionar");
			System.out.println("2 - Listar");
			System.out.println("3 - Apagar");
			System.out.println("4 - Editar");
			System.out.println("0 - Sair");
			System.out.print("Selecione uma opção: ");

			int numOpcao = scanner.nextInt();

			scanner.nextLine();

			if (numOpcao == 1) {

				adicionar(scanner);

			} else if (numOpcao == 2) {

				listar();

			} else if (numOpcao == 3) {

				listar();
				apagar(scanner);

			} else if (numOpcao == 4) {

				listar();
				editar(scanner);

			} else if (numOpcao == 0) {

				rodarDeNovo = false;

			}

		}
	}

	private static void editar(Scanner scanner) {

		System.out.println("Digite o cpf do usuario que deseja editar: ");
		String cpfEdt = scanner.nextLine();

		System.out.println("Digite seu nome: ");
		String nome = scanner.nextLine();
		
		System.out.println("Digite seu telefone: ");
		int tel = scanner.nextInt();
		
		System.out.println("Digite sua idade: ");
		int idade = scanner.nextInt();
		scanner.nextLine();
		
		Estagiario e = new Estagiario();
		
		e.setCpf(cpfEdt);
		e.setNome(nome);
		e.setTel(tel);
		e.setIdade(idade);
		
		dao.editar(e);

	}

	private static void apagar(Scanner scanner) {

		System.out.println("Digite o cpf do estagiario que deseja apagar:");
		String cpfApagar = scanner.nextLine();
		
		dao.apagar(cpfApagar);

	}

	private static void listar() {
		
		var lista = dao.listar();

		if (lista.isEmpty())
			System.out.println("Lista esta vazia!!");

		for (Estagiario e : lista) {

			System.out.println("_______________________");
			System.out.println();
			System.out.println("CPF: " + e.getCpf());
			System.out.println("Nome: " + e.getNome());
			System.out.println("Telefone: " + e.getTel());
			System.out.println("Idade: " + e.getIdade());
			System.out.println();
			System.out.println("________________________");

		}
	}

	private static void adicionar(Scanner scanner) {

		System.out.print("Digite seu CPF: ");
		String cpfScan = scanner.nextLine();

		System.out.print("Digite seu nome: ");
		String nomeScan = scanner.nextLine();

		System.out.print("Digite seu telefone: ");
		int telScan = scanner.nextInt();

		System.out.println("Digite sua idade: ");
		int idadeScan = scanner.nextInt();

		scanner.nextLine();

		Estagiario estagiario = new Estagiario();
		estagiario.setCpf(cpfScan);
		estagiario.setNome(nomeScan);
		estagiario.setTel(telScan);
		estagiario.setIdade(idadeScan);

		dao.salvar(estagiario);

	}

}
