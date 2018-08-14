package br.com.controle;

import java.util.Date;

public class Pessoa {
    protected String nome;
    protected String sobrenome;
    protected String email;
    
    public void setNome(String nomeCompleto){
        String[] n = nomeCompleto.split(" ");
        this.nome = n[0];
    };
    
    public String getNome(){
        return this.nome;
    };
    
    public void setSobrenome(String nomeCompleto){
        int i =  nomeCompleto.indexOf(' ');
        this.sobrenome = nomeCompleto.substring(i);
    };
    
    public String getSobrenome(){
        return this.sobrenome;
    };
    
    public void setEmail(String email){
        this.email = email;
    };
    
    public String getEmail(){
        return this.email;
    };
    
    public void consultarSituacao(){
        System.out.println("Consultar Pessoa.");
    };
    
}
