package christmas.domain.Event;

import java.util.ArrayList;
import java.util.List;

public class EventMachine {
    private final List<Event> eventTable;
    private ChristmasEvent christmasEvent;
    private WeekEvent weekEvent;
    private SpecialEvent specialEvent;
    private int totalDiscount;

    public EventMachine() {
        eventTable = new ArrayList<>();
        christmasEvent = new ChristmasEvent(0);
        weekEvent = new WeekEvent(0);
        specialEvent = new SpecialEvent(0);
    }

    public void getEventStatus(int date, int menuCount) {
        eventTable.add(new Event(christmasEvent.getName(), christmasEvent.getChristmasEventDiscount(date)));
        eventTable.add(new Event(weekEvent.getName(), weekEvent.getWeekEventDiscount(date, menuCount)));
        eventTable.add(new Event(specialEvent.getName(), specialEvent.getSpecialEventDiscount(date)));
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

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public List<Event> getEventTable() {
        return eventTable;
    }
}
