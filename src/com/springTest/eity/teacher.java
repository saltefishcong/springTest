package com.springTest.eity;

import javax.management.RuntimeErrorException;

public class teacher {

	 public void say(String name){
		 System.out.println("上课了!");
	 }
	 
	 public void thros(String name){
		 throw new RuntimeException(name+ " 违反纪律");
	 }
}
