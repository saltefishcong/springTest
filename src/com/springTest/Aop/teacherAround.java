package com.springTest.Aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class teacherAround implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		Object[] args=arg0.getArguments();
		System.out.println("how are you !" +args[0]);
		Object object=arg0.proceed();
		System.out.println("об©нак.");
		return object;
	}

}
