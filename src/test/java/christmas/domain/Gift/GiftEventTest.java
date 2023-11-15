package christmas.domain.Gift;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GiftEventTest {
    GiftEvent giftEvent;

    @BeforeEach
    void setUp() {
        giftEvent = new GiftEvent();
    }

    @DisplayName("기준 금액 넘었을 때 증정 이벤트 할인 금액 테스트")
    @ParameterizedTest(name = "{displayName} ({0}원)")
    @ValueSource(ints = {150_000, 120_000})
    void calculateDiscountOverLimitLine(int totalPrice) {
        giftEvent.calculateDiscount(totalPrice);
        assertThat(giftEvent.getDiscount()).isEqualTo(25_000);
    }

    @DisplayName("기준 금액 넘지 않았을 때 증정 이벤트 할인 금액 테스트")
    @ParameterizedTest(name = "{displayName} ({0}원)")
    @ValueSource(ints = {50000, 0})
    void calculateDiscountNotOverLimitLine(int totalPrice) {
        giftEvent.calculateDiscount(totalPrice);
        assertThat(giftEvent.getDiscount()).isEqualTo(0);
    }
}