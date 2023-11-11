package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuCheckerTest {
    MenuChecker menuChecker;

    @BeforeEach
    void setUp() {
        menuChecker = new MenuChecker();
    }

    @DisplayName("디저트 개수 테스트")
    @Test
    void getDessertCount() {
        MenuMachine.transform(List.of("해산물파스타", "1", "초코케이크", "2", "아이스크림", "2"));
        int result = 0;
        for (String key: MenuMachine.menuBoard.keySet()) {
            result += menuChecker.getDessertCount(key);
        }
        int expectedResult = 4;
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("메인 개수 테스트")
    @Test
    void getMainCount() {
        MenuMachine.transform(List.of("해산물파스타", "1", "티본스테이크", "1", "바비큐립", "1"));
        int result = 0;
        for (String key: MenuMachine.menuBoard.keySet()) {
            result += menuChecker.getMainCount(key);
        }
        int expectedResult = 3;
        assertThat(result).isEqualTo(expectedResult);
    }
}