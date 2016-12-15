/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.Socket;

/**
 *
 * @author Titi_
 */
public class UserSocket {
    
    
    
    
    private Socket socket;
    private User user;

    public UserSocket(Socket socket) {
        this.socket = socket;
        this.user = null;
    }

    public UserSocket(Socket socket, User user) {
        this.socket = socket;
        this.user = user;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public boolean isAnon(){
        return user==null;
    }
}
