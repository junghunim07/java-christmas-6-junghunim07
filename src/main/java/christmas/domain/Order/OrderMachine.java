package christmas.domain.Order;

import christmas.domain.Menu.MenuName;
import christmas.ui.OutputView;
import java.util.ArrayList;
import java.util.List;

public class OrderMachine {
    private static final int MAXIMUM_ORDER_COUNT = 20;
    private List<Order> OrderBoard;

    public OrderMachine() {
        OrderBoard = new ArrayList<>();
    }

    public void addOrderMenu(String name, int count) {
        validation(name);
        OrderBoard.add(new Order(name, count));
    }

    private void validation(String name) {
        for (MenuName menuName : MenuName.values()) {
            if (!menuName.getMenuName().equals(name)) {
                throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
            }
        }
        int totalCount = 0;
        for (Order order : OrderBoard) {
            totalCount += order.getOrderCount();
            if (totalCount > MAXIMUM_ORDER_COUNT) {
                throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
            }
        }
    }

    public List<Order> getOrderBoard() {
        return OrderBoard;
    }
}
