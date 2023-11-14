package christmas.domain.Event;

import christmas.domain.Menu.Beverage;
import christmas.domain.Menu.Dessert;
import christmas.domain.Menu.Main;
import christmas.domain.Order.Order;
import christmas.domain.Order.OrderMachine;
import java.util.ArrayList;
import java.util.List;

public class EventMachine {
    static final int EVENT_APPLICATION_CRITERIA = 10_000;
    private final List<Event> eventTable;
    private ChristmasEvent christmasEvent;
    private WeekdayEvent weekdayEvent;
    private WeekendEvent weekendEvent;
    private SpecialEvent specialEvent;
    private GiftEvent giftEvent;
    private int totalDiscount;

    public EventMachine() {
        eventTable = new ArrayList<>();
        christmasEvent = new ChristmasEvent(EventName.CHRISTMAS_EVENT.getEventName(), 0);
        weekdayEvent = new WeekdayEvent(EventName.WEEKDAY_EVENT.getEventName(), 0);
        weekendEvent = new WeekendEvent(EventName.WEEKEND_EVENT.getEventName(), 0);
        specialEvent = new SpecialEvent(EventName.SPECIAL_EVENT.getEventName(), 0);
        giftEvent = new GiftEvent(EventName.GIFT_EVENT.getEventName(), 0);
    }

    public void getEventStatus(OrderMachine orderMachine, int date, int totalPrice) {
        eventTable.add(new Event(EventName.CHRISTMAS_EVENT.getEventName(), christmasEvent.getChristmasEvent(date, totalPrice)));
        eventTable.add(new Event(EventName.WEEKDAY_EVENT.getEventName()
                , weekdayEvent.getWeekdayDiscount(date, getDessertCount(orderMachine.getOrderBoard()), totalPrice)));
        eventTable.add(new Event(EventName.WEEKEND_EVENT.getEventName()
                , weekendEvent.getWeekendDiscount(date, getMainCount(orderMachine.getOrderBoard()), totalPrice)));
        eventTable.add(new Event(EventName.SPECIAL_EVENT.getEventName(), specialEvent.getSpecialEventDiscount(date, totalPrice)));
        eventTable.add(new Event(EventName.GIFT_EVENT.getEventName()
                , giftEvent.getGiftEventDiscount(orderMachine.getTotalPaymentAmount(), Beverage.샴페인.getPrice())));
        removeNotApplicableEvent();
        calculateTotalDiscount();
    }

    private int getDessertCount(List<Order> orderBoard) {
        int count = 0;
        for (Dessert dessert : Dessert.values()) {
            count += getOrderMenuCount(orderBoard, dessert.name());
        }
        return count;
    }

    private int getMainCount(List<Order> orderBoard) {
        int count = 0;
        for (Main main : Main.values()) {
            count += getOrderMenuCount(orderBoard, main.name());
        }
        return count;
    }

    private int getOrderMenuCount(List<Order> orderBoard, String menu) {
        int count = 0;
        for (Order order : orderBoard) {
            if (menu.equals(order.getOrderMenuName())) {
                count += order.getOrderCount();
            }
        }
        return count;
    }

    private void removeNotApplicableEvent() {
        List<Event> toRemove = new ArrayList<>();
        for (Event event : eventTable) {
            if (event.getDiscount() == 0) {
                toRemove.add(event);
            }
        }
        eventTable.removeAll(toRemove);
    }

    private void calculateTotalDiscount() {
        for (Event event : eventTable) {
            totalDiscount += event.getDiscount();
        }
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public List<Event> getEventTable() {
        return eventTable;
    }
}
