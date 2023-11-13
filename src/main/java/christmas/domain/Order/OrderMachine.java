package christmas.domain.Order;

import christmas.domain.Menu.MenuName;
import christmas.ui.OutputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        Set<String> menuNames = Arrays.stream(MenuName.values())
                .map(MenuName::getMenuName).collect(Collectors.toSet());
        if (!menuNames.contains(name)) {
            throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
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
