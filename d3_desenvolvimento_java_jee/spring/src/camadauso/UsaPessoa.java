package camadauso;

import beans.BeanPessoa;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsaPessoa {
       
    public static void main(String args[]) {
        
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/ApplicationContext.xml");
        
        BeanPessoa beanpessoa = (BeanPessoa) appContext.getBean("beanpessoa");
        System.out.println(beanpessoa.getNome());
           
    }
   
}
