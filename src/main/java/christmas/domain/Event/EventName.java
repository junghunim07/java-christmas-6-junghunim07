package christmas.domain.Event;

public enum EventName {
    CHRISTMAS_EVENT("크리스마스 디데이 할인"),
    WEEKDAY_EVENT("평일 할인"),
    WEEKEND_EVENT("주말 할인"),
    SPECIAL_EVENT("특별 할인"),
    GIFT_EVENT("증정 이벤트");

    private final String eventName;

    EventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }
}
