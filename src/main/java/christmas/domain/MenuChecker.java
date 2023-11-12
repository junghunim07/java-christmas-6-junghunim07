package christmas.domain;

public class MenuChecker {
    public int getDessertCount(MenuMachine menuMachine, String menu) {
        int count = 0;
        for (ChristmasMenu christmasMenu : ChristmasMenu.values()) {
            if (christmasMenu.getCategory().equals(MenuCategory.DESSERT)) {
                count += getMenuCount(menuMachine, christmasMenu, menu);
            }
        }
        return count;
    }

    public int getMainCount(MenuMachine menuMachine, String menu) {
        int count = 0;
        for (ChristmasMenu christmasMenu : ChristmasMenu.values()) {
            if (christmasMenu.getCategory().equals(MenuCategory.MAIN)) {
                count += getMenuCount(menuMachine, christmasMenu, menu);
            }
        }
        return count;
    }

    public int getMenuCount(MenuMachine menuMachine, ChristmasMenu christmasMenu, String key) {
        if (christmasMenu.getName().equals(key)) {
            return menuMachine.getMenuBoard().get(key);
        }
        return 0;
    }
}
