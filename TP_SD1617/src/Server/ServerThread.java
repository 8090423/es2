/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Titi_
 */
public class ServerThread extends Thread {
    private UserSocket userSocket;
    

    public ServerThread( UserSocket userSocket) {
        super("ServerThread");
        this.userSocket = userSocket;
        
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(userSocket.getSocket().getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            userSocket.getSocket().getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {

                if (inputLine.startsWith("signup")) {
                    if (inputLine.split(" ").length == 3) {
                        String[] data = inputLine.split(" ");
                        if (Server.signUp(new User(data[1], data[2]))) {
                            out.println("signupOK");
                        } else {
                            out.println("signupUSERFAIL");
                        }
                    } else {
                        out.println("signupFAIL");
                    }
                }

                if (inputLine.startsWith("login")) {
                    if (inputLine.split(" ").length == 3) {
                        String[] data = inputLine.split(" ");
                        if (Server.login(userSocket, new User(data[1], data[2]))) {
                            System.out.println("Login sucesso");
                            out.println("loginOK");
                        } else {
                            out.println("loginUSERPASSFAIL");
                        }
                    } else {
                        out.println("loginFAIL");
                    }
                }
                
                if(inputLine.startsWith("message")){                    
                    Server.sendMessage(userSocket, inputLine);
                }                
                if (inputLine.startsWith("online")) {
                    Server.sendOnline(userSocket);
                }               

            }

            out.close();
            in.close();
            userSocket.getSocket().close();

        } catch (IOException e) {

            System.out.println("LOG OUT");
            Server.removeUserSocket(userSocket);
        }
    }
}
