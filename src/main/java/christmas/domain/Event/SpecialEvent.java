package christmas.domain.Event;

import christmas.Controller;

public class SpecialEvent {
    private static final int SPECIAL_EVENT_BENEFIT = 1000;
    private static final String eventName = "특별 할인";
    private int discount;

    SpecialEvent(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return eventName;
    }

    public int getSpecialEventDiscount(int date) {
        if (specialEventValidation(date)) {
            discount = SPECIAL_EVENT_BENEFIT;
        }
        return discount;
    }

    private boolean specialEventValidation(int date) {
        if (Calendar.checkStarDay(date)) {
            return true;
        }
        return false;
    }
}
