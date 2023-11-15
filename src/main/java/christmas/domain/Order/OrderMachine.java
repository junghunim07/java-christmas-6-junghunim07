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

    public void addOrderMenuToOrderBoard(String name, int count) {
        orderMenuInMenuBoardValidation(name);
        Order newOrder = new Order(name, count);
        orderMenuDuplicateValidation(newOrder);
        calculateTotalPayment(newOrder);
        OrderBoard.add(newOrder);
    }

    private void orderMenuInMenuBoardValidation(String name) {
        boolean orderMenuInMenuBoard = false;
        for (Menu menu : MenuMachine.MenuBoard) {
            if (menu.getName().equals(name)) {
                orderMenuInMenuBoard = true;
            }
        }
        if (!orderMenuInMenuBoard) {
            throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
        }
    }

    private void orderMenuDuplicateValidation(Order newOrder) {
        for (Order order : OrderBoard) {
            if (order.checkDuplicationOrder(newOrder)) {
                throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
            }
        }
    }

    public int countDessertMenuInOrderBoard() {
        for (Order order : OrderBoard) {
            OrderMenuCount += order.getDessertCount();
        }
        return OrderMenuCount;
    }

    public int countMainMenuInOrderBoard() {
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

    private void calculateTotalPayment(Order order) {
        TotalPaymentAmount += Order.getPayment(order);
    }

    public int getTotalPaymentAmount() {
        return TotalPaymentAmount;
    }

    public List<Order> getOrderBoard() {
        return OrderBoard;
    }
}
