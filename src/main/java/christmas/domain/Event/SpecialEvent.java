package christmas.domain.Event;

public class SpecialEvent {
    private static final int STAR_DAY = 3;
    private static final int CHRISTMAS_DAY = 25;
    private static final int WEEK = 7;
    private static final int SPECIAL_EVENT_BENEFIT = 1000;
    private String eventName;
    private int discount;

    SpecialEvent(String eventName, int discount) {
        this.eventName = eventName;
        this.discount = discount;
    }

    public int getSpecialEventDiscount(int date) {
        if (specialEventValidation(date)) {
            discount = SPECIAL_EVENT_BENEFIT;
        }
        return discount;
    }

    private boolean specialEventValidation(int date) {
        if (date >= EventName.SPECIAL_EVENT.getEventStartDate()
                && date <= EventName.SPECIAL_EVENT.getEventFinishDate()) {
            if ((date % WEEK) == STAR_DAY || date == CHRISTMAS_DAY) {
                return true;
            }
        }
        return false;
    }
}
