package christmas.domain;

public class Calculator {
    public int christmasDiscount(int date) {
        EventChecker eventChecker = new EventChecker();
        int discount = 0;
        if (eventChecker.checkChristmasEventPeriod(date)) {
            discount = 1000 + 100 * (date - 1);
        }
        return discount;
    }

    public int calculateWeekdayOrWeekend(int date) {
        return date % 7;
    }
}
