package christmas;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @DisplayName("음료수만 주문햇을 경우 예외 테스트")
    @Test
    void inputOnlyBeverageMenu() {
        String input = "레드와인-1,제로콜라-2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> controller.getMenuStart()).isInstanceOf(IllegalArgumentException.class);
    }
}