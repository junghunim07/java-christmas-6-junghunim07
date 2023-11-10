package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EventCheckerTest {
    EventChecker eventChecker;

    @BeforeEach
    void setUp() {
        eventChecker = new EventChecker();
    }

    @DisplayName("주말인지 테스트")
    @Test
    void checkWeekend() {
        int date = 8;
        assertThat(eventChecker.checkWeekdayOrWeekend(date)).isTrue();
    }

    @DisplayName("주말이 아닌지 테스트")
    @Test
    void checkWeekday() {
        int date = 13;
        assertThat(eventChecker.checkWeekdayOrWeekend(date)).isFalse();
    }
}