package christmas;

import christmas.domain.MenuMachine;
import christmas.ui.InputView;
import christmas.ui.OutputView;
import java.util.List;

public class Controller {
    InputView input = new InputView();
    OutputView output = new OutputView();
    MenuMachine menuMachine = new MenuMachine();

    public void christmasPlannerStart() {
        output.notifyExplanation();
        output.notifyVisitDate();
        int date = input.getVisitDate();
        inputValueValidation(date);
    }

    public void getMenuStart() {
        output.notifyGetMenu();
        List<String> menus = input.getMenu();
        menuMachine.transform(menus);
        output.notifyOrderMenu(menuMachine.menuBoard);
    }

    public void inputValueValidation(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
