package ru.spbstu.telematics.java.lab2;

import org.junit.Assert;
import org.junit.Test;


public class AppTest 
{ 
    @Test
    public void TestAdd(){
        OwnList<Integer> list = new OwnList<Integer>();
        for(int i = 0; i < 5; i++){
            Assert.assertTrue(list.add(i));
        }
    }

    @Test
    public void TestGet(){
    	OwnList<Integer> list = new OwnList<Integer>();
        for(Integer i = 0; i < 5; i++){
            list.add(i);
            Assert.assertEquals(i, list.get(i));
        }
    }

    @Test
    public void TestSize(){
    	OwnList<Integer> list = new OwnList<Integer>();
        for(Integer i = 0; i < 5; i++){
            list.add(i);
            Assert.assertEquals(i + 1, list.size());
        }
    }

    @Test
    public void TestRemove(){
    	OwnList<Integer> list = new OwnList<Integer>();
        list.add(1);
        Assert.assertNull(list.remove(0));
    }

    @Test
    public void TestContains(){
    	OwnList<Integer> list = new OwnList<Integer>();
        list.add(1);
        Assert.assertTrue(list.contains(1));
        Assert.assertFalse(list.contains(2));
    }
}
