package christmas.domain.Order;

import christmas.ui.OutputView;
import java.util.ArrayList;
import java.util.List;

public class OrderMachine {
    private static final int MAXIMUM_ORDER_COUNT = 20;
    private final List<Order> OrderBoard;
    private int TotalPaymentAmount = 0;

    public OrderMachine() {
        OrderBoard = new ArrayList<>();
    }

    public void addOrderMenu(String name, int count) {
        menuValidation();
        menuDuplicateValidation(name);
        OrderBoard.add(new Order(name, count));
    }

    private void menuValidation() {
        List<Order> distinctList = OrderBoard.stream().distinct().toList();
        if (OrderBoard.size() != distinctList.size()) {
            throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
        }
    }

    private void menuDuplicateValidation(String name) {
        for (int i = 0; i < OrderBoard.size(); i++) {
            if (OrderBoard.get(i).getOrderMenuName().equals(name)) {
                throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
            }
        }
    }

    private int countTotalOrderMenu() {
        int count = 0;
        for (Order order : OrderBoard) {
            count += order.getOrderCount();
        }
        return count;
    }

    public void totalCountValidation() {
        if (countTotalOrderMenu() > MAXIMUM_ORDER_COUNT) {
            throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
        }
    }

    public int calculateTotalPayment() {
        for (Order order : OrderBoard) {
            TotalPaymentAmount += Order.getPayment(order);
        }
        return TotalPaymentAmount;
    }

    public int getTotalPaymentAmount() {
        return TotalPaymentAmount;
    }

    public List<Order> getOrderBoard() {
        return OrderBoard;
    }
}
