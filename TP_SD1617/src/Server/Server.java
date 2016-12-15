/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Titi_
 */
public class Server {

    private static final int PORT = 5555;

    private ServerSocket socket;
    private static List<UserSocket> connectedUsers = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    public static void addUserSocket(UserSocket us) {

        connectedUsers.add(us);
        System.out.println("New Client ->> " + us.getSocket().getPort());
    }

    public static void removeUserSocket(UserSocket us) {

        connectedUsers.remove(us);
        System.out.println("Client disconnected ->> " + us.getSocket().getPort());
    }

    public List<UserSocket> getUserSocket() {
        return connectedUsers;
    }

    public static boolean signUp(User user) {
        if (users.contains(user)) {
            return false;
        }
        users.add(user);
        System.out.println("User " + user.getUsername() + " just signed up");
        return true;
    }

    public static boolean login(UserSocket us, User user) {

        for (User u : users) {
            if (u.equals(user)) {
                System.out.println("User " + user.getUsername() + " has logged in!");
                us.setUser(user);
                return true;
            }
        }

        return false;
    }

    public ServerSocket getSocket() {
        return this.socket;
    }

    public void setSocket(ServerSocket socket) {
        this.socket = socket;
    }

    public static void sendMessage(UserSocket userSocket, String msg) {

        String[] newMsg = msg.split(" ");

        String destination = newMsg[1];

        

        for (UserSocket us : connectedUsers) {

            if (us.getUser() != null && !us.equals(userSocket) && us.getUser().getUsername().equals(destination)) {
                try {
                    PrintWriter out = new PrintWriter(us.getSocket().getOutputStream(), true);

                    out.println(msg);

                    System.out.println("Message sent to: " + us.getSocket().getPort() + " ->> " + msg);
                } catch (IOException ex) {

                }
            }
        }

    }

    public static void sendOnline(UserSocket userSocket) {
        String list = "";
        for (UserSocket us : connectedUsers) {
            if (!us.isAnon()) {
                list += us.getUser().getUsername() + " ";
            }
        }

        if (!userSocket.isAnon()) {
            try {
                PrintWriter out = new PrintWriter(userSocket.getSocket().getOutputStream(), true);
                out.println(list);
            } catch (IOException ex) {
            }
        }

    }

    public static void main(String[] args) throws IOException {

        System.out.println("Running chat server");

        ServerSocket serverSocket = null;
        boolean running = true;

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.err.println("Could not start server on port: " + PORT + ".");
            System.exit(1);
        }

        while (running) {
            UserSocket connection = new UserSocket(serverSocket.accept());

            new ServerThread(connection).start();

            addUserSocket(connection);
        }
        serverSocket.close();

    }

}
