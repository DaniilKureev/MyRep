package ru.spbstu.telematics.java.lab1;

import org.junit.Assert;
import org.junit.Test;

import ru.spbstu.telematics.java.lab1.RandomUuid;

public class AppTest
{
	@Test
	public void UuidNotNull(){
		Assert.assertNotNull((new RandomUuid()).GetUUID());
	}
	@Test
	public void TwoUuidsAreNotEqual(){
		Assert.assertNotEquals((new RandomUuid()).GetUUID(),(new RandomUuid()).GetUUID());
	}
}