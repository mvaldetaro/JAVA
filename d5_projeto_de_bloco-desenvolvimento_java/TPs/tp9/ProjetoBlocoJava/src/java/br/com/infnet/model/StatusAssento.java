package br.com.infnet.model;

import br.com.infnet.controller.dao.LogDAO;
import br.com.infnet.controller.dao.SalaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusAssento {  

public List<String> status(List<Sala> sala, List<Registro> logs) {    
    List<String> status = new ArrayList<>();
    
    for (Sala item : sala) {
        String s = "disponivel";
        for(Registro r : logs){
            if(item.getIdassentos() == r.getIdassentos()) {
                s =  "indisponivel"; 
            }
        }
        status.add(s);
    }
    
    return status;
}

/*public static void main(String[] args) throws SQLException, Exception {    
    SalaDAO s = new SalaDAO();
    LogDAO l = new LogDAO();    
    System.out.println(status(s.getSala(1), l.listLogsAssentosSala(1)));   
}*/

}
