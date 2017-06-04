package ru.spbstu.telematics.java.lab5;

public class Turnstile implements Runnable {

	Controller controller;
	
	public Turnstile(Controller controller)
	{
		this.controller = controller;
	}
	@Override
	public void run() {
		while(true)
		{		
		}
	}	
	
	public synchronized void AddClient(Client client)
	{
		controller.AddClient(client);
	}
	
}
