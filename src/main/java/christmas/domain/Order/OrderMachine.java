package christmas.domain.Order;

import christmas.domain.Menu.Menu;
import christmas.domain.Menu.MenuMachine;
import christmas.ui.OutputView;
import java.util.ArrayList;
import java.util.List;

public class OrderMachine {
    private static final int MAXIMUM_ORDER_COUNT = 20;
    private final List<Order> OrderBoard;
    private int TotalPaymentAmount = 0;

    private int OrderMenuCount = 0;

    public OrderMachine() {
        OrderBoard = new ArrayList<>();
    }

    public void addOrderMenu(String name, int count) {
        orderMenuInMenuBoardValidation(name);
        orderMenuDuplicateValidation();
        OrderBoard.add(new Order(name, count));
    }

    private void orderMenuInMenuBoardValidation(String name) {
        for (Menu menu : MenuMachine.MenuBoard) {
            if (!menu.getName().equals(name)) {
                throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
            }
        }
    }

    private void orderMenuDuplicateValidation() {
        List<Order> distinctList = OrderBoard.stream().distinct().toList();
        if (OrderBoard.size() != distinctList.size()) {
            throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
        }
    }

    public int getOrderDessertMenuCount() {
        for (Order order : OrderBoard) {
            OrderMenuCount += order.getDessertCount();
        }
        return OrderMenuCount;
    }

    public int getOrderMainMenuCount() {
        for (Order order : OrderBoard) {
            OrderMenuCount += order.getMainCount();
        }
        return OrderMenuCount;
    }

    public int countTotalOrderMenu() {
        int count = 0;
        for (Order order : OrderBoard) {
            count += order.getOrderCount();
        }
        return count;
    }

    public void totalCountValidation(int totalCount) {
        if (totalCount > MAXIMUM_ORDER_COUNT) {
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
