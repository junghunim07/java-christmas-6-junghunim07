package christmas.domain.Order;

import christmas.domain.Menu.MenuName;

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
        for (MenuName menuName : MenuName.values()) {
            if (menuName.getMenuName().equals(order.getOrderMenuName())) {
                payment = menuName.getPrice() * order.getOrderCount();
            }
        }
        return payment;
    }
}
