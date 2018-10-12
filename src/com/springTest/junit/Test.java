package com.springTest.junit;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springTest.Aop.teacherAfter;
import com.springTest.Aop.teacherAround;
import com.springTest.Aop.teacherBofore;
import com.springTest.Aop.teacherIntroduction;
import com.springTest.Aop.teacherThrows;
import com.springTest.eity.User;
import com.springTest.eity.student;
import com.springTest.eity.teacher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:com/springTest/junit/Test-context.xml"})
public class Test  extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private User user;
	
	private static ApplicationContext ctx;
	
	@BeforeClass
	public static void Init(){
		 ctx=new ClassPathXmlApplicationContext("classpath*:spring.xml");
	}
	
	@Ignore
	@org.junit.Test
	public void test(){
		System.out.println(user.getName()+"  "+user.getPassword());
	}
	
	@Ignore
	@org.junit.Test
	public void aop(){
		teacher th=new teacher();
		BeforeAdvice bofore=new teacherBofore();
		AfterAdvice after=new teacherAfter();
		MethodInterceptor around=new teacherAround();
		ProxyFactory pf=new ProxyFactory();
		pf.setTarget(th);
		pf.addAdvice(bofore);
		pf.addAdvice(after);
        pf.addAdvice(around);		
		teacher th2=(teacher)pf.getProxy();
		th2.say("黄老师好!");
	}
    
	@Ignore
	@org.junit.Test
	public void aop2(){
		teacher th=(teacher)ctx.getBean("th");
		th.say("黄老师好!");
	}
	
	@Ignore
	@org.junit.Test
	public void thros(){
		teacher th=(teacher)ctx.getBean("thros");
		th.thros("小明");
	}
	
	@Ignore
	@org.junit.Test
	public void thros2(){
		teacher th=new teacher();
		ProxyFactory pf=new ProxyFactory();
		ThrowsAdvice thors=new teacherThrows();
		pf.setTarget(th);
		pf.addAdvice(thors);
		teacher th2=(teacher)pf.getProxy();
		th2.thros("小红");
	}
	
	@Ignore
	@org.junit.Test
	public void inter(){
		teacher th=(teacher)ctx.getBean("intro");
		th.say("157");
	}
	
	@org.junit.Test
	public void inter2(){
		teacher th=new teacher();
		ProxyFactory pf=new ProxyFactory();
		DelegatingIntroductionInterceptor intor=new teacherIntroduction();
		BeforeAdvice bofore=new teacherBofore();
		pf.setInterfaces(student.class);
		pf.setOptimize(true);
		pf.setTarget(th);
		pf.addAdvice(intor);
		pf.addAdvice(bofore);
		teacher th2=(teacher)pf.getProxy();
		th2.say("157");
	}
}
