package ui;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoasVindas {

    public BoasVindas() {
    }
    
    public static void DataHora() {
        String formatoData = "dd/MM/yyyy";
        String formatoHora = "kk:mm";
        SimpleDateFormat data = new SimpleDateFormat(formatoData);
        SimpleDateFormat hora = new SimpleDateFormat(formatoHora);
        
        Date atual = new Date();
        
        System.out.println(data.format(atual));
        System.out.println("Seja Bem Vindo! São exatamente " + hora.format(atual) + "\n");    
    }
}
