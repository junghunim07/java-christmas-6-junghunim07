package christmas.domain.Order;

import christmas.domain.Menu.MenuName;
import christmas.ui.OutputView;
import java.util.ArrayList;
import java.util.List;

public class OrderMachine {
    private static final int MAXIMUM_ORDER_COUNT = 20;
    private List<Order> OrderBoard;
    private int TotalPaymentAmount = 0;

    public OrderMachine() {
        OrderBoard = new ArrayList<>();
    }

    public void addOrderMenu(String name, int count) {
        menuValidation(name);
        OrderBoard.add(new Order(name, count));
    }

    private void menuValidation(String name) {
        for (MenuName menuName : MenuName.values()) {
            if (!menuName.getMenuName().equals(name)) {
                throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
            }
        }
    }

    public void totalCountValidation(int totalCount) {
        if (totalCount > MAXIMUM_ORDER_COUNT) {
            throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
        }
    }

    public void calculateTotalPayment() {
        for (Order order : OrderBoard) {
            TotalPaymentAmount += Order.getPayment(order);
        }
    }

    public int getTotalPaymentAmount() {
        return TotalPaymentAmount;
    }

    public List<Order> getOrderBoard() {
        return OrderBoard;
    }
}
