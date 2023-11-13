package christmas.domain.Event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WeekdayEventTest {
    WeekdayEvent weekdayEvent;

    @BeforeEach
    void setUp() {
        weekdayEvent = new WeekdayEvent("평일 할인", 0);
    }

    @DisplayName("평일 할인 금액 계산 테스트")
    @Test
    void getWeekdayDiscount() {
        int expectedResult = 6069;
        assertThat(weekdayEvent.getWeekdayDiscount(7, 3, 20000)).isEqualTo(expectedResult);
    }

    @DisplayName("총액이 만원을 넘지 않을 경우 테스트")
    @Test
    void lowTotalPriceAmountAboutWeekdayEvent() {
        assertThat(weekdayEvent.getWeekdayDiscount(7, 3, 5000)).isEqualTo(0);
    }
}