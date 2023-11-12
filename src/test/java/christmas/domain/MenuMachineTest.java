package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuMachineTest {
    MenuMachine menuMachine;
    @BeforeEach
    void setUp() {
        menuMachine = new MenuMachine();
    }

    @DisplayName("메뉴판 예외 테스트")
    @Test
    void menuBoardException() {
        assertThatThrownBy(() -> menuMachine.transform(
                List.of("해산물파스타", "2","초코케이크", "1", "레드와인", "a")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 중복 입력 예외 테스트")
    @Test
    void menuDuplicateException() {
        assertThatThrownBy(() -> menuMachine.transform(List.of("해산물파스타", "2","초코케이크", "1", "해산물파스타", "1")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴에 없는 메뉴를 입력했을 때 예외 테스트")
    @Test
    void menuNotHasException() {
        assertThatThrownBy(() -> menuMachine.transform(List.of("해산물파스타", "2","초코케이크", "1", "딸기케이크", "1")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 메뉴를 입력햇을 때 테스트")
    @Test
    void correctMenuTest() {
        menuMachine.transform(List.of("해산물파스타", "1"));
        HashMap<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("해산물파스타", 1);
        assertThat(menuMachine.getMenuBoard()).isEqualTo(expectedResult);
    }
}