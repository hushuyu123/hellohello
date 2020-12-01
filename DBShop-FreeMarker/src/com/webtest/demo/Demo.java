package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo {
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

}
