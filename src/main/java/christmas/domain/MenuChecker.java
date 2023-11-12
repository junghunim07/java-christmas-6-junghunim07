package christmas.domain;

public class MenuChecker {
    MenuMachine menuMachine = new MenuMachine();
    public int getDessertCount(String menu) {
        int count = 0;
        for (ChristmasMenu christmasMenu : ChristmasMenu.values()) {
            if (christmasMenu.getCategory().equals(MenuCategory.DESSERT)) {
                count += getMenuCount(christmasMenu, menu);
            }
        }
        return count;
    }

    public int getMainCount(String menu) {
        int count = 0;
        for (ChristmasMenu christmasMenu : ChristmasMenu.values()) {
            if (christmasMenu.getCategory().equals(MenuCategory.MAIN)) {
                count += getMenuCount(christmasMenu, menu);
            }
        }
        return count;
    }

    public int getMenuCount(ChristmasMenu christmasMenu, String key) {
        if (christmasMenu.getName().equals(key)) {
            return menuMachine.getMenuBoard().get(key);
        }
        return 0;
    }
}
