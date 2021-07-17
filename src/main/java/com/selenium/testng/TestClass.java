package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestClass {
  @BeforeTest
  public void beforeTest() {
  }
  
  @Test
  public void f() {
	  
	  System.out.println("Hello Github !!!!");
  }
 

  @AfterTest
  public void afterTest() {
  }

}
