package christmas.domain.Event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ChristmasEventTest {

    @DisplayName("크리스마스 할인 가격 테스트")
    @ParameterizedTest(name = "{displayName} ({0}일)")
    @CsvSource({"13, 2200", "20, 2900"})
    void getChristmasEvent(int date, int expectedDiscount) {
        ChristmasEvent christmasEvent = new ChristmasEvent("크리스마스 디데이 할인", 0);
        assertThat(christmasEvent.getChristmasEvent(date)).isEqualTo(expectedDiscount);
    }
}