package ru.spbstu.telematics.java.lab1;

import java.util.UUID;

public class RandomUuid {

	private UUID uuid;
	
	public RandomUuid()
	{
		uuid =  UUID.randomUUID();
	}
	
	public UUID GetUUID() 
	{
	    return uuid;
	}
}
