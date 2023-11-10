package christmas;

import christmas.ui.InputView;
import christmas.ui.OutputView;
import java.util.HashMap;
import java.util.List;

public class Controller {
    HashMap<String, Integer> menuBoard = new HashMap<>();
    InputView input = new InputView();
    OutputView output = new OutputView();

    public void christmasPlannerStart() {
        output.notifyExplanation();
        output.notifyVisitDate();
        int date = input.getVisitDate();
        inputValueValidation(date);
    }

    public void getMenuStart() {
        output.notifyGetMenu();
        List<String> menus = input.getMenu();
        transform(menus);
        output.notifyOrderMenu(menuBoard);
    }

    public void inputValueValidation(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public void transform(List<String> menus) {
        for (int i = 0; i < menus.size(); i += 2) {
            menuBoard.put(menuDuplicateValidation(menus.get(i)), menuCountValidation(menus.get(i + 1)));
        }
    }

    public String menuDuplicateValidation(String menu) {
        if (menuBoard.containsKey(menu)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        return menu;
    }

    public int menuCountValidation(String number) {
        try {
            int count = Integer.parseInt(number);
            return count;
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
