package christmas.domain.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuMachine {
    public static List<Menu> MenuBoard;

    public MenuMachine() {
        MenuBoard = new ArrayList<>();
        addAppetizerMenu();
        addMainMenu();
        addDessertMenu();
        addBeverageMenu();
    }

    private static void addAppetizerMenu() {
        for (Appetizer appetizer : Appetizer.values()) {
            MenuBoard.add(new Menu(appetizer.name(), appetizer.getPrice()));
        }
    }

    private static void addMainMenu() {
        for (Main main : Main.values()) {
            MenuBoard.add(new Menu(main.name(), main.getPrice()));
        }
    }

    private static void addDessertMenu() {
        for (Dessert dessert : Dessert.values()) {
            MenuBoard.add(new Menu(dessert.name(), dessert.getPrice()));
        }
    }

    private static void addBeverageMenu() {
        for (Beverage beverage : Beverage.values()) {
            MenuBoard.add(new Menu(beverage.name(), beverage.getPrice()));
        }
    }
}
