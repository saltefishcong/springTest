package com.springTest.Aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class teacherIntroduction extends DelegatingIntroductionInterceptor implements IntroductionInterceptor {
    
	private static boolean flag=false;
	
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		Object[] args=arg0.getArguments();
		if(((String)args[0]).equals("157")){
			flag=true;
		}
		Object object=null;
		if(flag ==true){
			System.out.println("是本班学生");
			object=super.invoke(arg0);
		}else{
			System.out.println("滚");
			object=super.invoke(arg0);
		}
		return object;
	}

}
