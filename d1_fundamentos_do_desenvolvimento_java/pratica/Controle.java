import java.util.Scanner;

public class Controle {
	
	int posicao;
	String opcao;
	String input;
	String[] nome = new String[2];
	double[] av1 = new double[100];
	double[] av2 = new double[100];
	private Scanner scanner;
	
	// Menu Inicial
	void menu(){	
		do {
			scanner = new Scanner(System.in);
			System.out.println(
					 	"Selecione uma da opções do menu abaixo, digitando um valor de 1 a 4:\n"
						+ "\n"
						+ "[1] Registrar as notas de um novo aluno.\n"
						+ "[2] Consultar boletim de um aluno.\n"
						+ "[3] Consultar notas da turma.\n"
						+ "[4] Sair.\n"
			);
			
			input = scanner.nextLine();
			opcao = input;
			
			switch(opcao){
				case "1":
					//System.out.println("[Registrar as notas de um novo aluno.]\n");
					registrar();
				break;
				case "2":
					consultarAluno();
				break;
				case "3":
					consultarTurma();
				break;
				case "4":
					System.out.println("Saiu do sistema.");
				break;
				default:
					System.out.println("Opção Inválida.");
			}
		} while(opcao != null);
	}
	
	// Registrar novo aluno
	void registrar(){
		System.out.println("[Registrar as notas de um novo aluno.]");
		if (posicao <= 99) {		
			System.out.println("\nDigite o nome do aluno:");
			String novoNome = scanner.nextLine();
			nome[posicao] = novoNome;
			
			System.out.println("\nDigite a nota da AV1:");
			String inputAv1 = scanner.nextLine();
			av1[posicao] = Integer.parseInt(inputAv1);
			
			System.out.println("\nDigite a nota da AV2:");
			String inputAv2 = scanner.nextLine();
			av2[posicao] = Integer.parseInt(inputAv2);
			
			System.out.println("\n------------------------------------------------------");
			System.out.println("O CÓDIGO DO ALUNO: " + posicao);
			System.out.println("------------------------------------------------------\n");
			
			posicao++;
		} else {	
			System.out.println(">>Todas as posições do vetor estão ocupadas, não é possível inserir novos alunos.");
		}
	}
	
	void consultarAluno(){
		System.out.println("[Consultar notas do Aluno.]\n");
		System.out.println("[Por favor digite o código do aluno.]\n");
		
		String input = scanner.nextLine();
		int codigo = Integer.parseInt(input);
		
		System.out.println("\n------------------------------------------------------");
		System.out.println("Nome:" + nome[codigo]);
		System.out.println("AV1: " + av1[codigo] + " | " + "AV2: " + av2[codigo]);
		System.out.println("________________________");
		
		int media = (int) (av1[codigo] + av2[codigo])/2;
		System.out.println("Média: " + media + "\n");
		
		if (media < 4)
			System.out.println("Situação: REPROVADO.");
		else if (media >= 4 && media < 7)
			System.out.println("Situação: PROVA FINAL");
		else
			System.out.println("Situação: APROVADO");
		
		System.out.println("------------------------------------------------------\n");
		
	}
	
	void consultarTurma(){
		System.out.println("[Consultar notas da turma.]\n");
		for(int i = 0; i < nome.length; i++){
			System.out.println("------------------------------------------------------");
			System.out.println("Nome:" + nome[i]);
			System.out.println("AV1: " + av1[i] + " | " + "AV2: " + av2[i]);
			System.out.println("________________________");
			
			int media = (int) (av1[i] + av2[i])/2;
			System.out.println("Média: " + media + "\n");
			
			if (media < 4)
				System.out.println("Situação: REPROVADO.");
			else if (media >= 4 && media < 7)
				System.out.println("Situação: PROVA FINAL");
			else
				System.out.println("Situação: APROVADO");		
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Bem Vindo");
		Controle aluno = new Controle();
		aluno.menu();
	}	
	
}
