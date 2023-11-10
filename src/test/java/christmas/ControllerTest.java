package christmas;

import java.util.List;
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

    @DisplayName("메뉴판 예외 테스트")
    @Test
    void menuBoardException() {
        assertThatThrownBy(() -> controller.transform(List.of("해산물파스타", "2","초코케이크", "1", "레드와인", "a")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 중복 입력 예외 테스트")
    @Test
    void menuDuplicateException() {
        assertThatThrownBy(() -> controller.transform(List.of("해산물파스타", "2","초코케이크", "1", "해산물파스타", "1")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴에 없는 메뉴를 입력했을 때 예외 테스트")
    @Test
    void menuNotHasException() {
        assertThatThrownBy(() -> controller.hasMenu("딸기케이크")).isInstanceOf(IllegalArgumentException.class);
    }
}