package ru.spbstu.telematics.java.lab5;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		ArrayList<Turnstile> turnstilesList = new ArrayList<Turnstile>();
		ArrayList<Thread> clientsList = new ArrayList<Thread>();
		
		for(int i=0;i<4;i++)
		{
			turnstilesList.add(new Turnstile(controller));
			new Thread(turnstilesList.get(i)).start();
		}

		for(int i=0;i<20;i++){
			clientsList.add(new Thread(new Client(turnstilesList.get(new Random().nextInt(4)), i)));
			clientsList.get(i).start();
		}
		
		for(int i=0;i<20;i++)
		{
			try {
				clientsList.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
