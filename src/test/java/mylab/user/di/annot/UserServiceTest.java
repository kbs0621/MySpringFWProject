package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testDI() {
		// UserService not null인지 확인
		assertNotNull(userService);
		
		
		// .getUserRepository not null인지 확인
		assertNotNull(userService.getUserRepository());
		
		// .getUserRepository.getDbType() MySQL 인지 비교하기
		assertEquals("MySQL", userService.getUserRepository().getDbType());
        
        // .getSecurityService not null인지 확인
        assertNotNull(userService.getSecurityService());
        
        // .registerUser True 검증
        boolean result = userService.registerUser("hong", "홍길동", "1234");
        assertTrue(result);
	}
	
	

}
