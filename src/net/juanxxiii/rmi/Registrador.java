package net.juanxxiii.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Registrador {
    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.createRegistry(5555);
            CifradorPasswords cp = new CifradorPasswords();
            registro.bind("benzema", 
                    (ICifradorPasswords)UnicastRemoteObject.exportObject(cp, 0));
            System.out.println("SERVER RUNNING...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
