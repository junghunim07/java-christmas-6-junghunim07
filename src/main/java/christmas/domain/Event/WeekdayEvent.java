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

    public int getWeekdayDiscount(int date, int dessertCount, int totalPrice) {
        if (weekdayValidation(date, totalPrice)) {
            discount = BENEFIT_AMOUNT * dessertCount;
        }
        return discount;
    }

    private boolean weekdayValidation(int date, int totalPrice) {
        if (totalPrice >= EventMachine.EVENT_APPLICATION_CRITERIA) {
            if (!((date % WEEK) == FRIDAY || (date % WEEK) == SATURDAY)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
