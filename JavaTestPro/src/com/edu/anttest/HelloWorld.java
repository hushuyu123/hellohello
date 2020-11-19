package com.edu.anttest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("test");
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(1, 2);
	}
	@Test
	public void test2() {
		Assert.assertEquals(2, 2);
	}
//	@Test
//	public void test3() {
//		Assert.assertEquals(1, 1);
//	}

}
