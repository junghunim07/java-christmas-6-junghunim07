package christmas.domain.Event;

public class Event {
    private String eventName;
    private int discount;

    Event(String eventName, int discount) {
        this.eventName = eventName;
        this.discount = discount;
    }

    public String getEventName() {
        return eventName;
    }

    public int getDiscount() {
        return discount;
    }
}
