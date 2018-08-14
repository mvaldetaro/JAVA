package ui;

import bussinesRules.Categoria;

import java.sql.SQLException;
import java.util.Arrays;


public class Interface {
     public static void main(String[] args) throws SQLException, Exception {

        BoasVindas.DataHora();
        Ofertas.armazenaCanaisOfertas();
        Categoria.gravarCategorias();
        
        //Carrega Ofertas
        Ofertas.lerOfertas();
        System.out.println(Arrays.toString(Ofertas.recuperarCanaisOfertados().toArray()));
        
        //Carrega Menu Principal
        Menu.showMenu();
    }
}
