package christmas.domain.Badge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BadgeTest {

    @DisplayName("혜택 금액에 따른 배지 테스트")
    @ParameterizedTest(name = "{displayName} ({0}원)")
    @CsvSource({"50000, 산타", "15000, 트리", "6000, 별", "1000, 없음"})
    void showBadgeName(int userBenefit, String expectedResult) {
        assertThat(Badge.informBadgeName(userBenefit)).isEqualTo(expectedResult);
    }
}