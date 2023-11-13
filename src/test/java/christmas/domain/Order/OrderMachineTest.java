package christmas.domain.Order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OrderMachineTest {
    OrderMachine orderMachine;

    @BeforeEach
    void setUp() {
        orderMachine = new OrderMachine();
    }

    @DisplayName("메뉴판에 없는 메뉴를 주문했을 때 예외 테스트")
    @Test
    void addOrderMenu() {
        assertThatThrownBy(() -> orderMachine.addOrderMenu("딸기케이크", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 메뉴를 주문했을 때 예외 테스트")
    @Test
    void duplicateMenu() {
        orderMachine.addOrderMenu("초코케이크", 1);
        orderMachine.addOrderMenu("아이스크림", 1);
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