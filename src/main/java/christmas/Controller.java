package christmas;

import christmas.domain.Badge.Badge;
import christmas.domain.Event.Calendar;
import christmas.domain.Event.Event;
import christmas.domain.Event.EventMachine;
import christmas.domain.Menu.Beverage;
import christmas.domain.Menu.MenuMachine;
import christmas.domain.Order.Order;
import christmas.domain.Order.OrderMachine;
import christmas.ui.InputView;
import christmas.ui.OutputView;
import java.util.HashMap;
import java.util.List;

public class Controller {
    private static final int EVENT_APPLICATION_CRITERIA = 10_000;
    int date;
    int giftPrice;
    InputView input;
    OutputView output;
    OrderMachine orderMachine;
    EventMachine eventMachine;
    MenuMachine menuMachine;

    Controller() {
        input = new InputView();
        output = new OutputView();
        orderMachine = new OrderMachine();
        eventMachine = new EventMachine();
        menuMachine = new MenuMachine();
    }

    public void christmasPlannerStart() {
        output.notifyExplanation();
        output.notifyVisitDate();
        date = input.getVisitDate();
        inputValueValidation(date);
    }

    public void getMenuStart() {
        output.notifyGetMenu();
        output.notifyPreview(date);
        makeOrderBoard();
        orderMachine.totalCountValidation(countAllOrderMenu(orderMachine.getOrderBoard()));
        callOutputForPrintOrderMenu(orderMachine.getOrderBoard());
        orderMachine.calculateTotalPayment();
        output.notifyPayment(orderMachine.getTotalPaymentAmount());
    }

    public void getEventDetail() {
        checkEventValidation(orderMachine.getTotalPaymentAmount());
        checkGiftEvent(eventMachine.getEventTable());
        printEventDetail();
        output.notifyAllAmountOfBenefit(eventMachine.getTotalDiscount());
        output.notifyAmountOfPayment(calculateAmountOfPayment());
    }

    public void getBadge() {
        output.notifyBadge(Badge.informBadgeName(eventMachine.getTotalDiscount()));
    }

    private void makeOrderBoard() {
        HashMap<String, Integer> menus = input.getMenu();
        for (String key : menus.keySet()) {
            orderMachine.addOrderMenu(key, menus.get(key));
        }
    }

    private void callOutputForPrintOrderMenu(List<Order> orderBoard) {
        output.printOrderMenuTitle();
        for (Order order : orderBoard) {
            output.notifyOrderMenu(order.getOrderMenuName(), order.getOrderCount());
        }
    }

    private void checkEventValidation(int totalPrice) {
        if (totalPrice >= EVENT_APPLICATION_CRITERIA) {
            eventMachine.getEventStatus(date);
        }
    }

    private void checkGiftEvent(List<Event> eventTable) {
        for (Event event : eventTable) {
            if (event.getEventName().equals(EventName.GIFT_EVENT.getEventName())) {
                giftPrice = Beverage.샴페인.getPrice();
                output.notifyGiftMenu(Beverage.샴페인.name() + OutputView.SPACE +"1" + OutputView.COUNT);
            }
        }
        output.notifyGiftMenu(OutputView.NOTHING);
    }

    private void printEventDetail() {
        if (eventMachine.getTotalDiscount() == 0) {
            output.printBenefitDetailTitle();
            output.notifyNotBenefit(OutputView.NOTHING);
        }
        if (eventMachine.getTotalDiscount() != 0) {
            output.printBenefitDetailTitle();
            for (Event event : eventMachine.getEventTable()) {
                output.notifyBenefitDetail(event.getEventName(), event.getDiscount());
            }
        }
    }

    public void inputValueValidation(int date) {
        if (date < Calendar.DECEMBER_FIRST.getDate()
                || date > Calendar.DECEMBER_LAST.getDate()) {
            throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_DATE_ERROR);
        }
    }

    private int countAllOrderMenu(List<Order> orderBoard) {
        int totalCount = 0;
        for (Order order : orderBoard) {
            totalCount += order.getOrderCount();
        }
        return totalCount;
    }

    private int calculateAmountOfPayment() {
        return orderMachine.getTotalPaymentAmount() - eventMachine.getTotalDiscount() + giftPrice;
    }
}
