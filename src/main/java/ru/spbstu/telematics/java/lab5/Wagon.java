package ru.spbstu.telematics.java.lab5;

import java.util.ArrayList;

public class Wagon implements Runnable {

	ArrayList<Client> clientList; 
	
	public Wagon(ArrayList<Client> clientList)
	{
		this.clientList = clientList;
	}
	
	@Override
	public void run() {
		System.out.println("Тележка отправилась!");
		try {
			Thread.sleep(3000); // Катаемся
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Тележка вернулась!");
		for(Client c: clientList)
		{
			c.GetOutFromWagon();
		}
	}

}
