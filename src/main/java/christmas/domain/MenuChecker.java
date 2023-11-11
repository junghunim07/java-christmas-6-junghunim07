package christmas.domain;

public class MenuChecker {
    public int getDessertCount(String menu) {
        int count = 0;
        for (ChristmasMenu christmasMenu : ChristmasMenu.values()) {
            if (christmasMenu.getCategory().equals(MenuCategory.DESSERT)) {
                count += getMenuCount(christmasMenu, menu);
            }
        }
        return count;
    }

    public int getMenuCount(ChristmasMenu christmasMenu, String key) {
        if (christmasMenu.getName().equals(key)) {
            return MenuMachine.menuBoard.get(key);
        }
        return 0;
    }
}
