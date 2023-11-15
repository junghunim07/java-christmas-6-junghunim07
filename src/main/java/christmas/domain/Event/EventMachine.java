package christmas.domain.Event;

import java.util.ArrayList;
import java.util.List;

public class EventMachine {
    private final List<Event> eventTable;
    private int totalDiscount;

    public EventMachine() {
        eventTable = new ArrayList<>();
    }

    public void getEventStatus(int date, int menuCount) {
        for (DateEvent dateEvent : DateEvent.values()) {
            eventTable.add(new Event(dateEvent.getEventName(), dateEvent.getDiscount(date)));
        }
        for (WeekEvent weekEvent : WeekEvent.values()) {
            eventTable.add(new Event(weekEvent.getEventName(), weekEvent.getDiscount(date, menuCount)));
        }
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
