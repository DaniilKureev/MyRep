package ru.spbstu.telematics.java.lab1;
import java.io.*;

public class Reader 
{	
	public static void ReadFromFile()
	{
		try(FileReader reader = new FileReader("src/main/java/ru/spbstu/telematics/java/lab1/example.txt"))
	    {
	        int c;
	        while((c=reader.read())!=-1){
	             
	            System.out.print((char)c);
	        } 
	    }
	    catch(IOException ex){
	         
	        System.out.println(ex.getMessage());
	    }   
	}
}
