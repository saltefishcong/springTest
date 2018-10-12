package com.springTest.Aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class teacherBofore implements MethodBeforeAdvice {
    
	@Override
	public void before(Method method, Object[] args, Object target)throws Throwable{
		String hello=(String)args[0];
		if(hello.equals("156")){
			return ;
		}
		System.out.println("学生: 老师好");
	}
}
