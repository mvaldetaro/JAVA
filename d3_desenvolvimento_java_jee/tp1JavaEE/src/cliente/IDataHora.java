package cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.util.Date;

public interface IDataHora extends Remote {
    public Date dataHora() throws RemoteException;
}
