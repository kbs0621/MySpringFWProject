package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private OrderService orderService;

    @Test
    void testShoppingCartBean() {
        // Null 여부 검증
        assertNotNull(shoppingCart, "ShoppingCart 빈이 주입되지 않았습니다.");

        // 리스트 크기 검증
        assertEquals(2, shoppingCart.getProducts().size(), "상품 개수가 2개여야 합니다.");

        // 상품 이름 검증
        assertEquals("노트북", shoppingCart.getProducts().get(0).getName());
        assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName());
    }

    @Test
    void testOrderServiceBean() {
        // Null 여부 검증
        assertNotNull(orderService, "OrderService 빈이 주입되지 않았습니다.");

    }
}