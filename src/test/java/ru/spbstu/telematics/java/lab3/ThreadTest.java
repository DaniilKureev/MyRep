package ru.spbstu.telematics.java.lab3;


import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class ThreadTest {
	@Test(expected=NullPointerException.class)
	public void matrNullTest() throws InterruptedException{
		ArrayList <ArrayList <Double>> matr= null;
		MyThread thread=new MyThread(matr,0, 0);
		thread.start();
		thread.join();
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void matrColumnIndexOutOfRangeTest() throws InterruptedException{
		int lines = 3;
		int columns = 3;
		ArrayList<ArrayList<Double>> matr = new ArrayList<ArrayList<Double>>();
		for (int i=0;i<lines;i++){
			matr.add(new ArrayList <Double>());
			for (int j=0;j<columns;j++)
				matr.get(i).add((double)(i*columns+j));
		}
		MyThread thread=new MyThread(matr,0, columns);
		thread.start();
		thread.join();
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void matrLineIndexOutOfRangeTest() throws InterruptedException{
		int lines = 3;
		int columns = 3;
		ArrayList<ArrayList<Double>> matr = new ArrayList<ArrayList<Double>>();
		for (int i=0;i<lines;i++){
			matr.add(new ArrayList <Double>());
			for (int j=0;j<columns;j++)
				matr.get(i).add((double)(i*columns+j));
		}
		MyThread thread=new MyThread(matr,lines, 0);
		thread.start();
		thread.join();
	}
	
	@Test
    public void CheckComputationTest(){
		
		int lines = 3;
		int columns = 3;
		
		ArrayList<ArrayList<Double>> matr = new ArrayList<ArrayList<Double>>();
		for (int i=0;i<lines;i++){
			matr.add(new ArrayList <Double>());
			for (int j=0;j<columns;j++)
				matr.get(i).add((double)(i*columns+j));
		}
		
		MyThread[] threads=new MyThread[lines*columns];
		for (int i=0;i<lines;i++){
			for(int j=0;j<columns;j++)
			{
				threads[i*columns+j]=new MyThread(matr,i,j);
				threads[i*columns+j].start();
			}
		}
		try {
			for (int i=0;i<lines*columns;i++)
				threads[i].join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ArrayList<ArrayList<Double>> expectedResult = new ArrayList<ArrayList<Double>>();
		for (int i=0;i<lines;i++){
			expectedResult.add(new ArrayList <Double>());
			for (int j=0;j<columns;j++)
				expectedResult.get(i).add((double)(Math.pow(i*columns+j,2)));
		}
		
		for (int i=0;i<lines;i++){
			for(int j=0;j<columns;j++)
			{
				Assert.assertEquals(matr.get(i).get(j),expectedResult.get(i).get(j));
			}
		}
    }
}