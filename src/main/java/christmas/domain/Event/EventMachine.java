package christmas.domain.Event;

import christmas.domain.Menu.Category;
import christmas.domain.Menu.MenuMachine;
import christmas.domain.Menu.MenuName;
import christmas.domain.Order.Order;
import christmas.domain.Order.OrderMachine;
import java.util.ArrayList;
import java.util.List;

public class EventMachine {
    private List<Event> eventTable;
    private OrderMachine orderMachine;
    private ChristmasEvent christmasEvent;
    private WeekdayEvent weekdayEvent;
    private WeekendEvent weekendEvent;

    public EventMachine() {
        eventTable = new ArrayList<>();
        orderMachine = new OrderMachine();
        christmasEvent = new ChristmasEvent(EventName.CHRISTMAS_EVENT.getEventName(), 0);
        weekdayEvent = new WeekdayEvent(EventName.WEEKDAY_EVENT.getEventName(), 0);
        weekendEvent = new WeekendEvent(EventName.WEEKEND_EVENT.getEventName(), 0);
    }

    public void getEventStatus(int date) {
        eventTable.add(new Event(EventName.CHRISTMAS_EVENT.getEventName(), christmasEvent.getChristmasEvent(date)));
        eventTable.add(new Event(EventName.WEEKDAY_EVENT.getEventName()
                , weekdayEvent.getWeekdayDiscount(date, getDessertCount(orderMachine.getOrderBoard()))));
        eventTable.add(new Event(EventName.WEEKEND_EVENT.getEventName()
                , weekendEvent.getWeekendDiscount(date, getMainCount(orderMachine.getOrderBoard()))));
    }

    private int getDessertCount(List<Order> orderBoard) {
        int count = 0;
        for (MenuName menuName : MenuName.values()) {
            if (menuName.getCategory().equals(Category.DESSERT)) {
                count = getOrderMenuCount(orderBoard, menuName);
            }
        }
        return count;
    }

    private int getMainCount(List<Order> orderBoard) {
        int count = 0;
        for (MenuName menuName : MenuName.values()) {
            if (menuName.getCategory().equals(Category.MAIN)) {
                count = getOrderMenuCount(orderBoard, menuName);
            }
        }
        return count;
    }

    private int getOrderMenuCount(List<Order> orderBoard, MenuName menuName) {
        int count = 0;
        for (Order order : orderBoard) {
            if (menuName.getMenuName().equals(order.getOrderMenuName())) {
                count += order.getOrderCount();
            }
        }
        return count;
    }
}
