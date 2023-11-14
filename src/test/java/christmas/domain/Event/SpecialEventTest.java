package christmas.domain.Event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialEventTest {
    SpecialEvent specialEvent;

    @BeforeEach
    void setUp() {
        specialEvent = new SpecialEvent(0);
    }

    @DisplayName("특별 할인 금액 테스트")
    @Test
    void getSpecialEventDiscount() {
        int expectedResult = 1000;
        assertThat(specialEvent.getSpecialEventDiscount(3)).isEqualTo(expectedResult);
    }

    @DisplayName("총액이 만원을 넘지 않을 경우 테스트")
    @Test
    void lowTotalPriceAmountAboutSpecialEventTest() {
        assertThat(specialEvent.getSpecialEventDiscount(3)).isEqualTo(0);
    }
}