package christmas.Event;

import christmas.domain.Calculator;

public class WeekendSaleEvent {
    static final String EVENT_NAME = "주말 할인";

    static boolean checkWeekendEvent(Calculator calculator, int date) {
        int day = calculator.calculateWeekdayOrWeekend(date);
        if (day == Calendar.FRIDAY.getDate() || day == Calendar.SATURDAY.getDate()) {
            return true;
        }
        return false;
    }

    static int weekendEventDiscount(Calculator calculator, int mainCount) {
        return calculator.weekdayAndWeekendDiscount(mainCount);
    }
}
