package br.com.controle;

import java.util.Arrays;
import java.util.Scanner;

public class Professor extends Pessoa {
    private String disciplina;
    private String turno;
    static Scanner  scanner;
    
    public static void novoProfessor(){ 
        scanner = new Scanner(System.in);   
        System.out.println("___[CADASTRAR PROFESSOR]___");
        
        Professor novoProfessor = new Professor();
        
        System.out.println("\nDigite o nome completo:");
        
        try {
            String nomeCompleto = scanner.nextLine();
            novoProfessor.setNome(nomeCompleto);
            novoProfessor.setSobrenome(nomeCompleto);
        } catch(StringIndexOutOfBoundsException ae){
            System.err.println("Você digitou apenas um nome.");
        }
        
        System.out.println("\nDigite o email:");
        novoProfessor.email = scanner.nextLine();
        
        System.out.println("\nDigite a disciplina:");
        novoProfessor.disciplina = scanner.nextLine();
        
        System.out.println("\nDigite o turno:");
        novoProfessor.turno = scanner.nextLine();
        
        addProfessor(novoProfessor);  
    };
    
    public static void addProfessor(Professor professor) {
        Cadastros.cadastrarPessoa(Cadastros.getPosicao(), professor);
        System.out.println("\nNovo PROFESSOR cadastrado com sucesso!\nCódigo: " + Cadastros.getPosicao() + "\n");
        Cadastros.setPosicao();
    };
    
    @Override
    public void consultarSituacao(){  
        System.out.println("\n___[INFORMAÇÕES DOCENTE]___\n");
        StringBuilder nomeCompleto = new StringBuilder();
        nomeCompleto.append(this.nome);
        nomeCompleto.append(this.sobrenome);
        System.out.println(nomeCompleto); 
        System.out.println(this.email);
        System.out.println(this.disciplina);
        System.out.println(this.turno);    
        System.out.println(".............................\n");
    };

}
