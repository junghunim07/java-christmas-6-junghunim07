package christmas.domain.Order;

import christmas.domain.Menu.MenuMachine;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OrderMachineTest {
    OrderMachine orderMachine;
    MenuMachine menuMachine;

    @BeforeEach
    void setUp() {
        orderMachine = new OrderMachine();
        menuMachine = new MenuMachine();
    }

    @DisplayName("메뉴판에 없는 메뉴를 주문했을 때 예외 테스트")
    @Test
    void addOrderMenu() {
        assertThatThrownBy(() -> orderMachine.addOrderMenu("딸기케이크", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 메뉴를 주문 했을 때 예외 테스트")
    @Test
    void duplicateMenu() {
        List<Order> orderMenu = List.of(new Order("초코케이크", 1),
                new Order("해산물파스타", 1));
        for (Order order : orderMenu) {
            orderMachine.addOrderMenu(order.getOrderMenuName(), order.getOrderCount());
        }
        assertThatThrownBy(() -> orderMachine.addOrderMenu("초코케이크", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최대 주문 20개를 넘었을 때 예외 테스트")
    @Test
    void totalCount() {
        assertThatThrownBy(() -> orderMachine.totalCountValidation(21))
                .isInstanceOf(IllegalArgumentException.class);
    }
}