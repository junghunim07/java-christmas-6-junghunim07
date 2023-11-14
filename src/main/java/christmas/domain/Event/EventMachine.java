package christmas.domain.Event;

import christmas.domain.Order.OrderMachine;
import java.util.ArrayList;
import java.util.List;

public class EventMachine {
    private final List<Event> eventTable;
    private ChristmasEvent christmasEvent;
    private WeekdayEvent weekdayEvent;
    private WeekendEvent weekendEvent;
    private SpecialEvent specialEvent;
    private int totalDiscount;

    public EventMachine() {
        eventTable = new ArrayList<>();
        christmasEvent = new ChristmasEvent(0);
        weekdayEvent = new WeekdayEvent(0);
        weekendEvent = new WeekendEvent(0);
        specialEvent = new SpecialEvent(0);
    }

    public void getEventStatus(OrderMachine orderMachine, int date) {
        eventTable.add(new Event(christmasEvent.getName(), christmasEvent.getChristmasEventDiscount(date)));
        eventTable.add(new Event(specialEvent.getName(), specialEvent.getSpecialEventDiscount(date)));
        decideCallWeekdayEventOrWeekendDayEvent(orderMachine, date);
        removeNotApplicableEventInEventTable();
        calculateTotalDiscount();
    }

    private void removeNotApplicableEventInEventTable() {
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

    private void decideCallWeekdayEventOrWeekendDayEvent(OrderMachine orderMachine, int date) {
        if (Calendar.checkWeekdayOrWeekend(date)) {
            eventTable.add(new Event(weekendEvent.getEventName(), weekendEvent.getDiscount(orderMachine.getOrderMainMenuCount())));
        }
        if (!Calendar.checkWeekdayOrWeekend(date)) {
            eventTable.add(new Event(weekdayEvent.getEventName(), weekdayEvent.getDiscount(orderMachine.getOrderDessertMenuCount())));
        }
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public List<Event> getEventTable() {
        return eventTable;
    }
}
