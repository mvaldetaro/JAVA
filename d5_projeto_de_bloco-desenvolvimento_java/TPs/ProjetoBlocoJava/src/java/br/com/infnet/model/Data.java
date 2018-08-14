package br.com.infnet.model;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


public class Data {
  
    public static String dataFormatada(Date data) { 
        Locale br = new Locale("pt", "BR");
        DateFormat formato = DateFormat.getDateInstance(DateFormat.FULL, br);
        String dthr = formato.format(data); 
        return dthr;
    }  
}
