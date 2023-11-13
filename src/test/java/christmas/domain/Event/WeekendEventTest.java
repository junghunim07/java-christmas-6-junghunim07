package christmas.domain.Event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekendEventTest {
    WeekendEvent weekendEvent;

    @BeforeEach
    void setUp() {
        weekendEvent = new WeekendEvent("주말 할인", 0);
    }

    @DisplayName("주말 할인 금액 계산 테스트")
    @Test
    void getWeekendDiscount() {
        int expectedResult = 4046;
        assertThat(weekendEvent.getWeekendDiscount(1, 2, 20000)).isEqualTo(expectedResult);
    }

    @DisplayName("총액이 만원을 넘지 않을 경우 테스트")
    @Test
    void lowTotalPriceAmountAboutWeekendEventTest() {
        assertThat(weekendEvent.getWeekendDiscount(1, 2, 5000)).isEqualTo(0);
    }
}