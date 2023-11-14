package christmas.domain.Order;

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
}
