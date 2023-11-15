package christmas;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ControllerTest {
    Controller controller;
    @BeforeEach
    void setUp() {
        controller = new Controller();
    }

    @DisplayName("1 ~ 31사이의 숫자가 아닐 경우 예외 테스트")
    @Test
    void inputValueException() {
        String input[] = {"0", "32", "a"};
        for (int i = 0; i < input.length; i++) {
            InputStream in = new ByteArrayInputStream(input[i].getBytes());
            System.setIn(in);
        }
        assertThatThrownBy(() -> controller.startChristmasPlanner()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료수만 주문햇을 경우 예외 테스트")
    @ParameterizedTest(name = "{displayName} ({0}개)")
    @CsvSource({"3, 3", "5, 5"})
    void inputOnlyBeverageMenu(int beverageOnlyInOrder, int orderCount) {
        assertThatThrownBy(() -> controller.callOnlyBeverageException(beverageOnlyInOrder, orderCount)).isInstanceOf(IllegalArgumentException.class);
    }
}