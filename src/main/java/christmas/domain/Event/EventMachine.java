package christmas.domain.Event;

import java.util.ArrayList;
import java.util.List;

public class EventMachine {
    private List<Event> eventTable;
    private ChristmasEvent christmasEvent;

    public EventMachine() {
        eventTable = new ArrayList<>();
        christmasEvent = new ChristmasEvent(EventName.CHRISTMAS_EVENT.getEventName(), 0);
    }

    public void getEventStatus(int date) {
        eventTable.add(new Event(EventName.CHRISTMAS_EVENT.getEventName(), christmasEvent.getChristmasEvent(date)));
    }
}
