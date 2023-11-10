package christmas.domain;

public class Calculator {
    EventChecker eventChecker = new EventChecker();

    public int christmasDiscount(int date) {
        int discount = 0;
        if (eventChecker.checkChristmasEventPeriod(date)) {
            discount = 1000 + 100 * (date - 1);
        }
        return discount;
    }
}
