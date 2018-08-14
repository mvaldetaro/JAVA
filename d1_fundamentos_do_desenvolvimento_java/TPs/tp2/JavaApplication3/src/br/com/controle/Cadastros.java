package br.com.controle;

import java.util.Scanner;

public class Cadastros {
    private static final Pessoa[] pessoas = new Pessoa[100];
    private static int posicao = 0;
    private static Scanner  scanner;

    
    public static Pessoa getPessoas(int i){
        return Cadastros.pessoas[i];
    };
    
    public static void cadastrarPessoa(int pos, Pessoa pessoa){
        Cadastros.pessoas[pos] = pessoa;
    };
    
    public static int getPosicao(){
        return posicao;
    };
    
    public static void setPosicao(){
        Cadastros.posicao++;
    };
    
    public static void consultar(){
        scanner = new Scanner(System.in);   
        System.out.println("___[CONSULTAR]___"); 
        System.out.println("\nDigite o número do código:");
        int codigo = Integer.parseInt(scanner.nextLine());    
        Cadastros.pessoas[codigo].consultarSituacao();
    }
}
