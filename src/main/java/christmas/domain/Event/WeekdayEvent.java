package christmas.domain.Event;

public class WeekdayEvent {
    private static final int BENEFIT = 2023;
    private static final String eventName = EventName.WEEKDAY_EVENT.getEventName();
    private int discount;

    WeekdayEvent(int discount) {
        this.discount = discount;
    }

    public int getDiscount(int count) {
        discount = calculateWeekdayDiscount(count);
        return discount;
    }

    public String getEventName() {
        return eventName;
    }

    private int calculateWeekdayDiscount(int count) {
        return BENEFIT * count;
    }
}
