package christmas;

import christmas.domain.Badge;
import christmas.domain.Calculator;
import christmas.domain.MenuMachine;
import christmas.ui.InputView;
import christmas.ui.OutputView;
import java.util.HashMap;
import java.util.List;

public class Controller {
    public static int date;
    public static int totalPrice;
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
        totalPrice = calculator.getTotalPrice();
        output.notifyOrderMenu(MenuMachine.menuBoard);
    }

    public void getBadge() {
        output.notifyBadge(Badge.getBadgeName(totalPrice));
    }

    private void hasEvent(HashMap<String,Integer> eventTable) {
        if (eventTable.size() > 0) {
            output.notifyBenefitDetail(eventTable);
        }
        if (eventTable.size() == 0) {
            output.notifyNotBenefit("없음");
        }
    }

    public void inputValueValidation(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
