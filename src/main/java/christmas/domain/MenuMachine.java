package christmas.domain;

import java.util.HashMap;
import java.util.List;

public class MenuMachine {
    public HashMap<String, Integer> menuBoard = new HashMap<>();

    public void transform(List<String> menus) {
        for (int i = 0; i < menus.size(); i += 2) {
            menuBoard.put(menuValidation(menus.get(i)), menuCountValidation(menus.get(i + 1)));
        }
    }

    private String menuValidation(String menu) {
        if (menuBoard.containsKey(menu)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        for (ChristmasMenu christmasMenu : ChristmasMenu.values()) {
            if (christmasMenu.getName().equals(menu)) {
                return menu;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    private int menuCountValidation(String number) {
        try {
            int count = Integer.parseInt(number);
            return count;
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
