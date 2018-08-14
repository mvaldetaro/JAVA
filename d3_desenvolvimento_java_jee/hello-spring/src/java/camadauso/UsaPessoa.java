package camadauso;

import beans.BeanPessoa;

public class UsaPessoa {
       
    public static void main(String args[]) {
        BeanPessoa beanpessoa = new BeanPessoa();
        beanpessoa.setNome("Magno");
        System.out.println(beanpessoa.getNome());              
    }
   
}
