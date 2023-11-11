package christmas.Event;

import christmas.domain.Calculator;

public class ChristmasDDayEvent {
    static final String EVENT_NAME = "크리스마스 디데이 할인";
    static boolean checkChristmasEventPeriod(int date) {
        if (date >= 1 || date <= 25) {
            return true;
        }
        return false;
    }

    static int christmasEventDiscount(Calculator calculator, int date) {
        return calculator.christmasDiscount(date);
    }
}
