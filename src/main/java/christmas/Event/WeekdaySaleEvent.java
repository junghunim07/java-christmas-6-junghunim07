package christmas.Event;

import christmas.domain.Calculator;

public class WeekdaySaleEvent {
    static final String EVENT_NAME = "평일 할인";

    static boolean checkWeekdayEvent(Calculator calculator, int date) {
        int result = calculator.calculateWeekdayOrWeekend(date);
        if (!(result == Calendar.FRIDAY.getDate() || result == Calendar.SATURDAY.getDate())) {
            return true;
        }
        return false;
    }

    static int weekdayEventDiscount(Calculator calculator, int dessertCount) {
        return calculator.weekdayAndWeekendDiscount(dessertCount);
    }
}
