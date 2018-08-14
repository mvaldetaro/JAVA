package br.com.controle;

import static br.com.controle.Professor.scanner;
import java.util.Scanner;

public class Aluno extends Pessoa {
    private int matricula;
    private String turno;
    private int turma;
    
    public static void novoAluno(){ 
        scanner = new Scanner(System.in);   
        System.out.println("___[CADASTRAR ALUNO]___");
        
        Aluno novoAluno = new Aluno();
        
        System.out.println("\nDigite o nome completo::");
        String nomeCompleto = scanner.nextLine();
        
        novoAluno.setNome(nomeCompleto);
        novoAluno.setSobrenome(nomeCompleto);
        
        System.out.println("\nDigite o email:");
        novoAluno.email = scanner.nextLine();
        
        System.out.println("\nDigite o número de matrícula:");
        novoAluno.matricula = Integer.parseInt(scanner.nextLine());
        
        System.out.println("\nDigite o turno:");
        novoAluno.turno = scanner.nextLine();
        
        System.out.println("\nDigite o número da turma:");
        novoAluno.turma = Integer.parseInt(scanner.nextLine());
        
        addAluno(novoAluno);  
    };
    
    public static void addAluno(Aluno aluno){
        Cadastros.cadastrarPessoa(Cadastros.getPosicao(), aluno);
        System.out.println("\nNovo ALUNO cadastrado com sucesso!\nCódigo: " + Cadastros.getPosicao() + "\n");
        Cadastros.setPosicao();
    };
    
    @Override
    public void consultarSituacao(){  
        System.out.println("\n___[INFORMAÇÕES DISCENTE]___\n"); 
        StringBuilder nomeCompleto = new StringBuilder();
        nomeCompleto.append(this.nome);
        nomeCompleto.append(this.sobrenome);
        System.out.println(nomeCompleto);  
        System.out.println(this.email);
        System.out.println(this.matricula);
        System.out.println(this.turno);    
        System.out.println(this.turma);
        System.out.println(".............................\n");
    };
}
