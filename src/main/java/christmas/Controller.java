package christmas;

import christmas.domain.Badge.Badge;
import christmas.domain.Event.Calendar;
import christmas.domain.Event.Event;
import christmas.domain.Event.EventMachine;
import christmas.domain.Gift.GiftEvent;
import christmas.domain.Menu.Beverage;
import christmas.domain.Menu.MenuMachine;
import christmas.domain.Order.Order;
import christmas.domain.Order.OrderMachine;
import christmas.ui.InputView;
import christmas.ui.OutputView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controller {
    int date;
    InputView input;
    OutputView output;
    GiftEvent giftEvent;
    OrderMachine orderMachine;
    EventMachine eventMachine;
    public static MenuMachine menuMachine = new MenuMachine();
    private static final int EVENT_APPLICATION_CRITERIA = 10_000;

    Controller() {
        input = new InputView();
        output = new OutputView();
        giftEvent = new GiftEvent();
        orderMachine = new OrderMachine();
        eventMachine = new EventMachine();
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
        orderMachine.totalCountValidation(orderMachine.countTotalOrderMenu());
        callOutputForPrintOrderMenu(orderMachine.getOrderBoard());
        orderMachine.calculateTotalPayment();
        output.notifyPayment(orderMachine.getTotalPaymentAmount());
    }

    public void getEventDetail() {
        checkEventValidation(orderMachine.getTotalPaymentAmount());
        giftEvent.calculateDiscount(orderMachine.getTotalPaymentAmount());
        callOutputAboutGiftEvent();
        callOutputForEventDetail();
        output.notifyAllAmountOfBenefit(eventMachine.getTotalDiscount() + giftEvent.getDiscount());
        output.notifyAmountOfPayment(calculateAmountOfPaymentAfterBenefit());
    }

    public void getBadge() {
        output.notifyBadge(Badge.informBadgeName(eventMachine.getTotalDiscount() + giftEvent.getDiscount()));
    }

    private void makeOrderBoard() {
        HashMap<String, Integer> menus = input.getMenu();
        checkInputMenuOnlyBeverage(menus);
        for (String key : menus.keySet()) {
            orderMachine.addOrderMenu(key, menus.get(key));
        }
    }

    private void checkInputMenuOnlyBeverage(HashMap<String, Integer> inputOrderMenu) {
        List<String> inputOrderName = new ArrayList<>();
        for (String key : inputOrderMenu.keySet()) {
            inputOrderName.add(key);
        }
        List<String> beverageInOrder = new ArrayList<>();
        for (String name : inputOrderName) {
            if (name.equals(Beverage.RED_WINE.getName()) || name.equals(Beverage.ZERO_COLA.getName()) || name.equals(Beverage.CHAMPAGNE.getName())) {
                beverageInOrder.add(name);
            }
        }
        if (beverageInOrder.size() == inputOrderMenu.size()) {
            throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
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
            if (Calendar.checkWeekdayOrWeekend(date)) {
                eventMachine.getEventStatus(date, orderMachine.getOrderMainMenuCount());
            }
            if (!Calendar.checkWeekdayOrWeekend(date)) {
                eventMachine.getEventStatus(date, orderMachine.getOrderDessertMenuCount());
            }
        }
    }

    private void callOutputAboutGiftEvent() {
        if (giftEvent.getDiscount() == 0) {
            output.notifyGiftMenu(OutputView.NOTHING);
        }
        if (giftEvent.getDiscount() > 0) {
            output.notifyGiftMenu(Beverage.CHAMPAGNE.getName() + OutputView.SPACE + "1" + OutputView.COUNT);
        }
    }

    private void callOutputForEventDetail() {
        if (eventMachine.getTotalDiscount() == 0) {
            output.printBenefitDetailTitle();
            output.notifyNotBenefit(OutputView.NOTHING);
        }
        if (eventMachine.getTotalDiscount() != 0) {
            output.printBenefitDetailTitle();
            for (Event event : eventMachine.getEventTable()) {
                output.notifyBenefitDetail(event.getEventName(), event.getDiscount());
            }
            output.notifyBenefitDetail(giftEvent.getEventName(), giftEvent.getDiscount());
        }
    }

    public void inputValueValidation(int date) {
        if (date < Calendar.DECEMBER_FIRST.getDate()
                || date > Calendar.DECEMBER_LAST.getDate()) {
            throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_DATE_ERROR);
        }
    }

    private int calculateAmountOfPaymentAfterBenefit() {
        return orderMachine.getTotalPaymentAmount() - eventMachine.getTotalDiscount();
    }
}
