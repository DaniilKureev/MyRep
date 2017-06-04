package ru.spbstu.telematics.java.lab5;

public class Client implements Runnable {

	private Turnstile turnstile;
	int number;
	boolean isRunning = true;

	public Client(Turnstile turnstile, int number )
	{
		this.turnstile = turnstile;
		this.number = number;
		System.out.println("Клиент "+number+" создан!");
	}
	
	@Override
	public void run() {
		turnstile.AddClient(this);
		while(isRunning)
		{
			;
		}
	}
	
	
	public void GetOutFromWagon()
	{
		isRunning = false;
	    System.out.println("Клиент "+number+" покатался и пошел домой!");
	}
}
