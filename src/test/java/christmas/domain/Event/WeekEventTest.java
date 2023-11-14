package christmas.domain.Event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WeekEventTest {
    WeekEvent weekEvent;

    @BeforeEach
    void setUp() {
        weekEvent = new WeekEvent(0);
    }

    @DisplayName("평일 할인 금액 계산 테스트")
    @Test
    void getWeekdayDiscount() {
        int expectedResult = 6069;
        assertThat(weekEvent.getWeekEventDiscount(7, 3)).isEqualTo(expectedResult);
    }



    @DisplayName("주말 할인 금액 계산 테스트")
    @Test
    void getWeekendDiscount() {
        int expectedResult = 4046;
        assertThat(weekEvent.getWeekEventDiscount(1, 2)).isEqualTo(expectedResult);
    }
}