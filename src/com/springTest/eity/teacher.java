package com.springTest.eity;

import javax.management.RuntimeErrorException;

public class teacher {

	 public void say(String name){
		 System.out.println("�Ͽ���!");
	 }
	 
	 public void thros(String name){
		 throw new RuntimeException(name+ " Υ������");
	 }
}
