package christmas.domain.Order;

import christmas.domain.Menu.Dessert;
import christmas.domain.Menu.Main;
import christmas.domain.Menu.Menu;
import christmas.domain.Menu.MenuMachine;

public class Order {
    private String orderMenuName;
    private int orderCount;

    Order(String orderMenuName, int orderCount) {
        this.orderMenuName = orderMenuName;
        this.orderCount = orderCount;
    }

    public String getOrderMenuName() {
        return orderMenuName;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public static int getPayment(Order order) {
        int payment = 0;
        for (Menu menu : MenuMachine.MenuBoard) {
            if (menu.getName().equals(order.getOrderMenuName())) {
                payment = menu.getPrice() * order.orderCount;
            }
        }
        return payment;
    }

    public int getDessertCount() {
        int count = 0;
        if (checkDessertMenu(orderMenuName)) {
            count = orderCount;
        }
        return count;
    }

    private boolean checkDessertMenu(String orderMenuName) {
        for (Dessert dessert : Dessert.values()) {
            if (dessert.name().equals(orderMenuName)) {
                return true;
            }
        }
        return false;
    }

    public int getMainCount() {
        int count = 0;
        if (checkMainMenu(orderMenuName)) {
            count = orderCount;
        }
        return count;
    }

    private boolean checkMainMenu(String orderMenuName) {
        for (Main main : Main.values()) {
            if (main.name().equals(orderMenuName)) {
                return true;
            }
        }
        return false;
    }
}
