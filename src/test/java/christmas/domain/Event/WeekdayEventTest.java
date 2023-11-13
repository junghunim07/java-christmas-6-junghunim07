package christmas.domain.Event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WeekdayEventTest {

    @DisplayName("평일 할인 금액 계산 테스트")
    @Test
    void getWeekdayDiscount() {
        WeekdayEvent weekdayEvent = new WeekdayEvent("평일 할인", 0);
        int expectedResult = 6069;
        assertThat(weekdayEvent.getWeekdayDiscount(7, 3)).isEqualTo(expectedResult);
    }
}