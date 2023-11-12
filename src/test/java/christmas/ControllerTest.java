package christmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ControllerTest {
    Controller controller;
    @BeforeEach
    void setUp() {
        controller = new Controller();
    }

    @DisplayName("1 ~ 31사이의 숫자가 아닐 경우 예외 테스트")
    @ParameterizedTest(name = "{displayName} ({0}원)")
    @ValueSource(ints =  {0, 32})
    void inputValueException(int date) {
        assertThatThrownBy(() -> controller.inputValueValidation(date)).isInstanceOf(IllegalArgumentException.class);
    }
}