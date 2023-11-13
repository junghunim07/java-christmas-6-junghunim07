package christmas.domain.Event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ChristmasEventTest {
    ChristmasEvent christmasEvent;

    @BeforeEach
    void setUp() {
        christmasEvent = new ChristmasEvent("크리스마스 디데이 할인", 0);
    }

    @DisplayName("크리스마스 할인 가격 테스트")
    @ParameterizedTest(name = "{displayName} ({0}일)")
    @CsvSource({"13, 2200", "20, 2900"})
    void getChristmasEvent(int date, int expectedDiscount) {
        assertThat(christmasEvent.getChristmasEvent(date, 20000)).isEqualTo(expectedDiscount);
    }

    @DisplayName("크리스마스 이벤트 날이 아닐 경우 테스트")
    @Test
    void getChristmasNotEvent() {
        assertThat(christmasEvent.getChristmasEvent(27, 20000)).isEqualTo(0);
    }

    @DisplayName("총액이 만원을 넘지 않을 경우 테스트")
    @Test
    void lowTotalPriceAmountAboutChristmasEventTest() {
        assertThat(christmasEvent.getChristmasEvent(24, 5000)).isEqualTo(0);
    }
}