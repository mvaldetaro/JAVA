package rmi;

import java.rmi.*;
import java.rmi.registry.Registry;

public class ArrancaServidor
{
    public static void main(String argv[])
    {
        try
        {   
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
            r.rebind("ServidorMat_1", new ServidorMat());
            System.out.println("Arrancando servidor...");
            //Naming.rebind("ServidorMat_1", new ServidorMat());
            System.out.println("Servidor conectado.\n");
        }
        catch (Exception e)
        {
            System.out.println("Ocorreu um problema no arranque do servidor.\n"+e.toString());
        }
    }
}
 