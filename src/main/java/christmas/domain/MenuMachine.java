package christmas.domain;

import christmas.ui.OutputView;
import java.util.HashMap;
import java.util.List;

public class MenuMachine {
    private HashMap<String, Integer> menuBoard = new HashMap<>();

    public void transform(List<String> menus) {
        for (int i = 0; i < menus.size(); i += 2) {
            menuBoard.put(menuValidation(menus.get(i)), menuCountValidation(menus.get(i + 1)));
        }
    }

    private String menuValidation(String menu) {
        if (menuBoard.containsKey(menu)) {
            throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
        }
        for (ChristmasMenu christmasMenu : ChristmasMenu.values()) {
            if (christmasMenu.getName().equals(menu)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
    }

    private int menuCountValidation(String number) {
        try {
            int count = Integer.parseInt(number);
            return count;
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
        }
    }

    public HashMap<String, Integer> getMenuBoard() {
        return menuBoard;
    }
}
