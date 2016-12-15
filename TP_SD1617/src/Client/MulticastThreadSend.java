/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Titi_
 */
public class MulticastThreadSend extends Thread {

    private  final String PATH = "chatshare";
    private final String username;
    public MulticastThreadSend(String string) {
        this.username = string;
    }

    
    
    @Override
    public void run() {
        
        File directory = new File(PATH);
        if (directory.exists()) {
            System.out.println("exists");
        } else {
            System.out.println("creating");
            directory.mkdir();
        }

        File[] listOfFiles = directory.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }

        MulticastSocket mSocket = null;
        InetAddress address = null;
        try {
            mSocket = new MulticastSocket(4446);
            address = InetAddress.getByName("224.1.2.3");
            mSocket.joinGroup(address);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        byte[] buf = new byte[256];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        while (true) {
            try {

                String dString = "";

                for (File file : listOfFiles) {
                    dString += file + " ";                    
                }

                buf = dString.getBytes();
                
                // send it
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4446);
                mSocket.send(packet);

            } catch (UnknownHostException ex) {
                Logger.getLogger(MulticastThreadSend.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MulticastThreadSend.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
            // sleep for a while
            try {
                sleep(5000);
            } catch (InterruptedException e) {
            }

        }

        mSocket.close();
    }

}
