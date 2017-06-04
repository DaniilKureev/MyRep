package ru.spbstu.telematics.java.lab3;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		int lines = 5;
		int columns = 5;
		ArrayList<ArrayList<Double>> matr = new ArrayList<ArrayList<Double>>();
		for (int i=0;i<lines;i++){
			matr.add(new ArrayList <Double>());
			for (int j=0;j<columns;j++)
				matr.get(i).add((double)(i*columns+j));
		}
		System.out.println("Исходная матрица:");
		for (int i=0;i<lines;i++)
		{
			for (int j=0;j<columns;j++)
				System.out.print(matr.get(i).get(j)+"\t");
			System.out.print("\n");
		}
		System.out.println("Матрица, заполненная значениями функции y=x^2 (функция Math.pow(x,2))");
		MyThread[] threads=new MyThread[lines*columns];
		long timeStart = System.currentTimeMillis();
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
		long timeEnd = System.currentTimeMillis();
		for (int i=0;i<lines;i++)
		{
			for (int j=0;j<columns;j++)
				System.out.print(matr.get(i).get(j)+"\t");
			System.out.print("\n");
		}
		System.out.println("Затраченное на вычисления время (ms): "+(timeEnd-timeStart));
	}
}
