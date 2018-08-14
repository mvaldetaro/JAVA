package Calci;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalciInterface extends Remote{
    public int add(int x, int y) throws RemoteException;
    
}
