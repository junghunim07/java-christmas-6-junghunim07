package christmas.domain.Event;

public class WeekendEvent {
    private static final int FRIDAY = 1;
    private static final int SATURDAY = 2;
    private static final int WEEK = 7;
    private static final int BENEFIT_AMOUNT = 2023;

    private String eventName;
    private int discount;

    WeekendEvent(String eventName, int discount) {
        this.eventName = eventName;
        this.discount = discount;
    }

    public int getWeekendDiscount(int date, int count) {
        if (weekendValidation(date)) {
            discount = BENEFIT_AMOUNT * count;
        }
        return discount;
    }

    private boolean weekendValidation(int date) {
        if (date >= EventName.WEEKEND_EVENT.getEventStartDate()
                && date <= EventName.WEEKEND_EVENT.getEventFinishDate()) {
            if ((date % WEEK) == FRIDAY || (date % WEEK) == SATURDAY) {
                return true;
            }
            return false;
        }
        return false;
    }
}
