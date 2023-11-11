package christmas.Event;

import christmas.domain.Calculator;

public class ChristmasDDayEvent {
    Calculator calculator = new Calculator();
    public void christmasEvent(int date) {
        int discount = 0;
        if (checkChristmasEventPeriod(date)) {
            discount = christmasEventDiscount(date);
        }
    }

    private boolean checkChristmasEventPeriod(int date) {
        if (date >= 1 || date <= 25) {
            return true;
        }
        return false;
    }

    private int christmasEventDiscount(int date) {
        return calculator.christmasDiscount(date);
    }
}
