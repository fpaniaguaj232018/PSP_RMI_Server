package net.juanxxiii.rmi;

import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CifradorPasswords implements ICifradorPasswords{

    @Override
    public String cifrarPassword(String password) throws RemoteException {
        byte[] digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            digest = md.digest();
            //System.out.println(digest);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return digest.toString();
    }
}
