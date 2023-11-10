package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculatorTest {

    @DisplayName("크리스마스 할인 가격 테스트")
    @ParameterizedTest(name = "{displayName} ({0}원)")
    @CsvSource({"13, 2200", "5, 1400", "26, 0"})
    void christmasDiscount(int date, int expectedDiscount) {
        Calculator calculator = new Calculator();
        int result = calculator.christmasDiscount(date);
        assertThat(result).isEqualTo(expectedDiscount);
    }
}