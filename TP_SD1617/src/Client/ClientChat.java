/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientChat {

    private final String hostName = "127.0.0.1";
    private final int portNumber = 5555;
    private Socket echoSocket;
    private PrintWriter out;
    private BufferedReader in;    
    private String username;
    private boolean login = false;

    public ClientChat() {

        try {
            echoSocket = new Socket(hostName, portNumber);

            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

        } catch (IOException ex) {
            System.err.println("Não foi possível establecer ligação ao servidor!");
            System.exit(-1);
        }
        
        
    }

    public Socket getEchoSocket() {
        return echoSocket;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String signUp(String username, String password) throws IOException {
        String result = "signupFAIL";
        if (!"".equals(username) && !"".equals(password)) {
            out.println("signup " + username + " " + password);

            while ((result = in.readLine()) != null) {
                return result;
            }
        }
        return result;
    }

    public String login(String username, String password) throws IOException {
        String result = "loginFAIL";
        if (!"".equals(username) && !"".equals(password)) {
            out.println("login " + username + " " + password);
            this.username = username;
            result = in.readLine();

        }
        return result;
    }

    public String[] getOnline() throws IOException {
        ArrayList<String> list = new ArrayList<>();
        String rawList;
        String[] rlist = {};

        out.println("online");

        rawList = in.readLine();
        if (!rawList.startsWith("message")) {
            rawList = rawList.replace(username, "");
            rlist = rawList.split(" ");

            return rlist;
        } else {
            
        }

        return rlist;

    }

    public void sendMessage(String message) {

        out.println(message);

    }


}
