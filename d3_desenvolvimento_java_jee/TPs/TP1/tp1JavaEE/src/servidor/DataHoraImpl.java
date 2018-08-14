package servidor;

import cliente.IDataHora;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DataHoraImpl extends UnicastRemoteObject implements IDataHora {

    public DataHoraImpl() throws RemoteException {
        System.out.println("Servidor instanciado.");
    }
    
    public Date dataHora() throws RemoteException {
       Calendar c = Calendar.getInstance();  
       return c.getTime();
    }
    
}
