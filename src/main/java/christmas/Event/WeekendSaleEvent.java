package christmas.Event;

import christmas.domain.Calculator;

public class WeekendSaleEvent {
    private static final int FRIDAY = 1;
    private static final int SATURDAY = 2;
    static final String EVENT_NAME = "주말 할인";

    static boolean checkWeekendEvent(Calculator calculator, int date) {
        int result = calculator.calculateWeekdayOrWeekend(date);
        if (result == FRIDAY || result == SATURDAY) {
            return true;
        }
        return false;
    }

    static int weekendEventDiscount(Calculator calculator, int mainCount) {
        return calculator.weekdayAndWeekendDiscount(mainCount);
    }
}
