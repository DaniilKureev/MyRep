package ru.spbstu.telematics.java.lab2;

import java.util.ArrayList;
import java.util.Iterator;

public class App {

	public static void main(String[] args) 
	{
		OwnList<String> list = new OwnList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		
		for(int i=0; i<5; i++)
		{
			list.add(Integer.toString(i));
			list2.add(Integer.toString(i));
		}
		
		System.out.println("OwnList has size: " + list.size());
		System.out.println("ArrayList has size: " + list2.size());
		
		Iterator<String> itr = list.iterator();
		Iterator<String> itr2 = list2.iterator();
		boolean isEqual = true;
		while (itr.hasNext())
		{
	        if(!itr.next().equals(itr2.next())) isEqual = false;
		}
		if(isEqual) System.out.println("Lists are the same!");
		
		for(int i=0; i<3; i++)
		{
			list.remove(0);
		}
			
		if(!list.contains("1") && list.contains("3")) System.out.println("\"Contains\" method works!");
		
		for(int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}
}
