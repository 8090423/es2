/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Titi_
 */
public class MulticastThreadReceive extends Thread {

    private static final String PATH = "chatshare";

    @Override
    public void run() {
        try {
            File directory = new File(PATH);
            if (directory.exists()) {
                System.out.println("exists");
            } else {
                System.out.println("creating");
                directory.mkdir();
            }
            
            byte[] buf = new byte[256];
            
            int i = 0;
            
            try (MulticastSocket socket = new MulticastSocket(4446)) {
                InetAddress address = InetAddress.getByName("224.1.2.3");
                socket.joinGroup(address);
                while (true) {
                    
                    DatagramPacket packet;
                    
                    packet = new DatagramPacket(buf, buf.length);
                    socket.receive(packet);
                    
                    String received = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("FileList: " + received);
                    if (i > 10) {
                        break;
                    }
                }
                socket.leaveGroup(address);
            }
        } catch (IOException ex) {
            Logger.getLogger(MulticastThreadReceive.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
