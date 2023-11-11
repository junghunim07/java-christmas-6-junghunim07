package christmas;

import christmas.domain.Calculator;
import christmas.domain.MenuMachine;
import christmas.ui.InputView;
import christmas.ui.OutputView;
import java.util.List;

public class Controller {
    int date;
    InputView input = new InputView();
    OutputView output = new OutputView();
    Calculator calculator = new Calculator();

    public void christmasPlannerStart() {
        output.notifyExplanation();
        output.notifyVisitDate();
        date = input.getVisitDate();
        inputValueValidation(date);
    }

    public void getMenuStart() {
        output.notifyGetMenu();
        List<String> menus = input.getMenu();
        MenuMachine.transform(menus);
        output.notifyOrderMenu(MenuMachine.menuBoard);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (String key : MenuMachine.menuBoard.keySet()) {
            totalPrice += calculator.calculateTotalOrderAmount(key);
        }
        return totalPrice;
    }

    public void inputValueValidation(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
