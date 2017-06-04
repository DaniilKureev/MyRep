package ru.spbstu.telematics.java.lab1;


public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("*******File reading*********");
        Reader.ReadFromFile();
        System.out.println("******New UUID generation**********");
        System.out.println((new  RandomUuid()).GetUUID());
    }
}
