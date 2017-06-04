package ru.spbstu.telematics.java.lab4.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientParams implements Runnable {
	
	//Сервер
private Server server;
	// исходящее сообщение
private PrintWriter outMessage;
	// входящее собщение
private Scanner inMessage;
private static final String HOST = "localhost";
private static final int PORT = 1234;
	// сокет клиента
private Socket clientSocket = null;
private static int clients_count = 0;

public ClientParams(Socket socket, Server server) {
    try {
        clients_count++;
        this.server = server;
        this.clientSocket = socket;
        this.outMessage = new PrintWriter(socket.getOutputStream());
        this.inMessage = new Scanner(socket.getInputStream());
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

@Override
public void run() {
    try {
        while (true) {
			// сервер отправляет сообщение
            server.sendMessageToAllClients("Новый участник вошёл в чат!");
            server.sendMessageToAllClients("Клиентов в чате = " + clients_count);
            break;
        }

        while (true) {
            // Если от клиента пришло сообщение
            if (inMessage.hasNext()) {
                String clientMessage = inMessage.nextLine();
									
                if (clientMessage.equalsIgnoreCase("##session##end##")) {
                    break;
                }
                System.out.println(clientMessage);
                server.sendMessageToAllClients(clientMessage);
            }
            Thread.sleep(100);
        }
    }
    catch (InterruptedException ex) {
        ex.printStackTrace();
    }
    finally {
        this.close();
    }
}

public void sendMsg(String msg) {
    try {
        outMessage.println(msg);
        outMessage.flush();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
	//  выход из чата
public void close() {
    server.removeClient(this);
    clients_count--;
    server.sendMessageToAllClients("Клиентов в чате = " + clients_count);
}
}