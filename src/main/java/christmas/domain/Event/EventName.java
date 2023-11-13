package christmas.domain.Event;

enum EventName {
    CHRISTMAS_EVENT("크리스마스 디데이 할인", 1, 25),
    WEEKDAY_EVENT("평일 할인", 1, 31),
    WEEKEND_EVENT("주말 할인", 1, 31),
    SPECIAL_EVENT("특별 할인", 1, 31),
    GIFT_EVENT("증정 이벤트", 1, 31);

    private final String eventName;
    private final int eventStartDate;
    private final int eventFinishDate;

    EventName(String eventName, int eventStartDate, int eventFinishDate) {
        this.eventName = eventName;
        this.eventStartDate = eventStartDate;
        this.eventFinishDate = eventFinishDate;
    }

    public String getEventName() {
        return eventName;
    }

    public int getEventStartDate() {
        return eventStartDate;
    }

    public int getEventFinishDate() {
        return eventFinishDate;
    }
}
