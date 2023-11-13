package christmas.domain.Event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekendEventTest {

    @DisplayName("주말 할인 금액 계산 테스트")
    @Test
    void getWeekendDiscount() {
        WeekendEvent weekendEvent = new WeekendEvent("주말 할인", 0);
        int expectedResult = 4046;
        assertThat(weekendEvent.getWeekendDiscount(1, 2)).isEqualTo(expectedResult);
    }
}