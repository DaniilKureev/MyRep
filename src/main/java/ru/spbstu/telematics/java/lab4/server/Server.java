package ru.spbstu.telematics.java.lab4.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    static final int PORT = 1234;
    private ArrayList<ClientParams> clients = new ArrayList<ClientParams>();

    public Server() {

        Socket clientSocket = null;
        ServerSocket serverSocket = null;
        
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");
            while (true) {
                clientSocket = serverSocket.accept();
                ClientParams client = new ClientParams(clientSocket, this);
                clients.add(client);
                new Thread(client).start();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                clientSocket.close();
                System.out.println("Сервер остановлен");
                serverSocket.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
		
    public void sendMessageToAllClients(String msg) {
        for (ClientParams o : clients) {
            o.sendMsg(msg);
        }

    }

    public void removeClient(ClientParams client) {
        clients.remove(client);
    }
}
