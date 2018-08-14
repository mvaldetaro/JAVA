/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calci;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author Magno
 */
public class CalciClient {
    public static void main(String args[]) throws NotBoundException, MalformedURLException, RemoteException{
        Scanner sc = new Scanner(System.in);
        try {
            CalciInterface c = (CalciInterface)Naming.lookup("//localhost/Calci");
        } catch(Exception e) {
            System.out.println("Servidor não conectado " + e);
        }
    }
}
