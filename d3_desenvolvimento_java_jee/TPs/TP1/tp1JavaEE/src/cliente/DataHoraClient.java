package cliente;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.util.Locale;

public class DataHoraClient {
    
    private IDataHora msi;

    public DataHoraClient() {
        System.out.println("Iniciando o Cliente...");
        try{
            msi = (IDataHora) Naming.lookup("rmi://127.0.0.1/DataHoraServer");
        } catch(Exception e) {
            System.out.println("Falhou ao tentar iniciar o Cliente.\n"+e);
            System.exit(0);
        }    
    }

    public String dataFormatada() throws RemoteException { 
        Locale br = new Locale("pt", "BR");
        DateFormat formato = DateFormat.getDateInstance(DateFormat.FULL, br);
        String dthr = formato.format(msi.dataHora()); 
        return dthr;
    }

    public static void main (String[] args) {    
        DataHoraClient dhc = new DataHoraClient();
        try {
            System.out.println(dhc.dataFormatada());
        } catch(Exception e) {
            System.out.println("Exceção durante chamadas remotas:" +e);
        }
    }    
}

