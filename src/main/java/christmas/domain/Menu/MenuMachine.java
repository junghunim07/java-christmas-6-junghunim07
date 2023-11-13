package christmas.domain.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuMachine {
    public static List<Menu> MenuBoard;

    public MenuMachine() {
        MenuBoard = new ArrayList<>();
        for (MenuName menu : MenuName.values()) {
            addMenu(menu.getMenuName(), menu.getPrice(), menu.getCategory());
        }
    }

    private static void addMenu(String name, int price, Category category) {
        MenuBoard.add(new Menu(name, price, category));
    }
}
