package christmas.domain.Event;

public class WeekdayEvent {
    private static final int FRIDAY = 1;
    private static final int SATURDAY = 2;
    private static final int WEEK = 7;
    private static final int BENEFIT_AMOUNT = 2023;
    private String eventName;
    private int discount;

    WeekdayEvent(String eventName, int discount) {
        this.eventName = eventName;
        this.discount = discount;
    }

    public int getWeekdayDiscount(int date, int dessertCount) {
        if (weekdayValidation(date)) {
            discount = BENEFIT_AMOUNT * dessertCount;
        }
        return discount;
    }

    private boolean weekdayValidation(int date) {
        if (date >= EventName.WEEKDAY_EVENT.getEventStartDate()
                && date <= EventName.WEEKDAY_EVENT.getEventFinishDate()) {
            if (!((date % WEEK) == FRIDAY || (date % WEEK) == SATURDAY)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
