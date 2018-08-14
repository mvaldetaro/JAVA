package servidor;

import java.rmi.registry.Registry;

public class DataHoraServer {
    
    public static void main(String args[]) {
        try {
          Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
          r.rebind("DataHoraServer", new DataHoraImpl());
          System.out.println("Servidor conectado.\n");
        } catch(Exception e){
            System.out.println("Ocorreu um problema na inicialização do servidor.\n"+e.toString());
        }
    }
}
