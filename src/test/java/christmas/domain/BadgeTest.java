package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BadgeTest {

    @DisplayName("배지 이름 테스트")
    @ParameterizedTest(name = "{displayName} ({0}원)")
    @CsvSource({"0, 없음", "5000, 별", "15000, 트리", "50000, 산타"})
    void getBadge(int userBenefit, String badgeName) {
        assertThat(Badge.getBadgeName(userBenefit)).isEqualTo(badgeName);
    }
}