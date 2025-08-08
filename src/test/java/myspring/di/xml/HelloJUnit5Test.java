package myspring.di.xml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloJUnit5Test {
	
	
	@Test
	void helloBean() {
		// 1. Container 객체 생성
		ApplicationContext context = new GenericXmlApplicationContext("classpath:spring-beans.xml");
		
		// 2. Container가 생성한 Hello 스프링빈을 요청하기
		Hello helloById = (Hello)context.getBean("hello");
		Hello helloByType = context.getBean("hello",Hello.class);
		
		//주소를 비교해서 Singleton 확인해보기
		System.out.println(helloById == helloByType);
		
		//Assertions.assertSame() 사용해서 비교
		Assertions.assertSame(helloById, helloByType);
		
		
	}

}
