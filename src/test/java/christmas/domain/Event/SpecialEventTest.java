package christmas.domain.Event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialEventTest {

    @DisplayName("특별 할인 금액 테스트")
    @Test
    void getSpecialEventDiscount() {
        SpecialEvent specialEvent = new SpecialEvent("특별 할인", 0);
        int expectedResult = 1000;
        assertThat(specialEvent.getSpecialEventDiscount(3)).isEqualTo(expectedResult);
    }
}