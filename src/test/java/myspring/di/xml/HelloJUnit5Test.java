package myspring.di.xml;


//static import : 계속 class 이름을 줄 수 없으므로 
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class HelloJUnit5Test {
	
	ApplicationContext context;
	
	//BeforeEach text 실행하기전에 먼저 실행됨
	//testcase 실행 할때 마다 container를 생성해야하므로 
	
	@BeforeEach
	void createContainer() {
		// 1. Container 객체 생성
		context = new GenericXmlApplicationContext("classpath:spring-beans.xml");
		
	}
	
	@Test
	void helloBean() {
		
		// 2. Container가 생성한 Hello 스프링빈을 요청하기
		Hello helloById = (Hello)context.getBean("hello");
		Hello helloByType = context.getBean("hello",Hello.class);
		
		
		//주소를 비교해서 Singleton 확인해보기
		//System.out.println(helloById == helloByType);
		
		//Assertions.assertSame() 사용해서 비교
		//assertSame(helloById, helloByType);
		
		
		//<property name="name" value="스프링" /> 설정을 테스트
		//값을 비교하기
		assertEquals("Hello 스프링", helloByType.sayHello());
		
		//<property name="printer" ref="strPrinter"/> 설정 테스트
		helloByType.print();
		
		//stringPrinter 스프링빈을 요청하기
		Printer printer = context.getBean("strPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());
		
	}

}
