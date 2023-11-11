package christmas.Event;

import christmas.domain.Calculator;

public class WeekdaySaleEvent {
    private static final int FRIDAY = 1;
    private static final int SATURDAY = 2;
    static final String EVENT_NAME = "평일 할인";

    static boolean checkWeekdayEvent(Calculator calculator, int date) {
        int result = calculator.calculateWeekdayOrWeekend(date);
        if (!(result == FRIDAY || result == SATURDAY)) {
            return true;
        }
        return false;
    }

    static int weekdayEventDiscount(Calculator calculator, int dessertCount) {
        return calculator.weekdayAndWeekendDiscount(dessertCount);
    }
}
