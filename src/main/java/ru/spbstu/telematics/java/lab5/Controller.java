package ru.spbstu.telematics.java.lab5;

import java.util.ArrayList;

public class Controller implements Runnable {

	ArrayList<Client> clientList = new ArrayList<Client>();
	final int maxSize = 10;
	
	public synchronized void AddClient(Client client) {
		clientList.add(client);
		System.out.println("Прибыл новый клиент, размер очереди :" + clientList.size());
		if (clientList.size() == maxSize) {
			Thread t = new Thread(new Wagon(clientList));
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clientList = new ArrayList<Client>();
		}
	}
	
	@Override
	public void run() {
		while(true);
	}

}
