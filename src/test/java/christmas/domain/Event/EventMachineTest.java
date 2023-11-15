package christmas.domain.Event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EventMachineTest {
    EventMachine eventMachine;
    int result;
    int expectedResult;

    @BeforeEach
    void setUp() {
        eventMachine = new EventMachine();
        result = 0;
        expectedResult = 0;
    }

    @DisplayName("크리스마스 이벤트 할인 금액 테스트")
    @Test
    void christmasDiscount() {
        eventMachine.getEventStatus(3, 3);
        expectedResult = 1200;
        for (Event event : eventMachine.getEventTable()) {
            if (event.getEventName().equals(DateEvent.CHRISTMAS_EVENT.getEventName())) {
                result = event.getDiscount();
            }
        }
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("평일 할인 금액 테스트")
    @Test
    void weekdayDiscount() {
        eventMachine.getEventStatus(3, 3);
        expectedResult = 6069;
        for (Event event : eventMachine.getEventTable()) {
            if (event.getEventName().equals(WeekEvent.WEEKDAY_EVENT.getEventName())) {
                result = event.getDiscount();
            }
        }
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("주말에 평일 할인 금액 테스트")
    @Test
    void weekdayDiscountInWeekendDay() {
        eventMachine.getEventStatus(1, 3);
        expectedResult = 0;
        for (Event event : eventMachine.getEventTable()) {
            if (event.getEventName().equals(WeekEvent.WEEKDAY_EVENT.getEventName())) {
                result = event.getDiscount();
            }
        }
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("주말 할인 금액 테스트")
    @Test
    void weekendDiscount() {
        eventMachine.getEventStatus(1, 2);
        expectedResult = 4046;
        for (Event event : eventMachine.getEventTable()) {
            if (event.getEventName().equals(WeekEvent.WEEKEND_EVENT.getEventName())) {
                result = event.getDiscount();
            }
        }
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("평일에 주말 할인 금액 테스트")
    @Test
    void weekendDiscountInWeekday() {
        eventMachine.getEventStatus(3, 2);
        expectedResult = 0;
        for (Event event : eventMachine.getEventTable()) {
            if (event.getEventName().equals(WeekEvent.WEEKEND_EVENT.getEventName())) {
                result = event.getDiscount();
            }
        }
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("별이 있는 날에 특별 할인 금액 테스트")
    @Test
    void specialDiscount() {
        eventMachine.getEventStatus(3, 4);
        expectedResult = 1000;
        for (Event event : eventMachine.getEventTable()) {
            if (event.getEventName().equals(DateEvent.SPECIAL_EVENT.getEventName())) {
                result = event.getDiscount();
            }
        }
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("별이 아닌 날에 특별 할인 금액 테스트")
    @Test
    void specialDiscountInNotStarDay() {
        eventMachine.getEventStatus(5, 4);
        expectedResult = 0;
        for (Event event : eventMachine.getEventTable()) {
            if (event.getEventName().equals(DateEvent.SPECIAL_EVENT.getEventName())) {
                result = event.getDiscount();
            }
        }
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("총 할인 금액 테스트")
    @Test
    void getTotalDiscount() {
        eventMachine.getEventStatus(3, 3);
        int expectedResult = 8269;
        assertThat(eventMachine.getTotalDiscount()).isEqualTo(expectedResult);
    }
}