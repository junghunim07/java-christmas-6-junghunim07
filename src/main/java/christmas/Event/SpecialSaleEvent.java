package christmas.Event;

import christmas.domain.Calculator;

public class SpecialSaleEvent {
    private final int SUNDAY = 3;
    private final int CHRISTMAS = 25;
    Calculator calculator = new Calculator();

    public void specialEvent(int date) {
        int discount = 0;
        if (checkSpecialEvent(date)) {
            discount = specialEventDiscount();
        }
    }

    private boolean checkSpecialEvent(int date) {
        int result = calculator.calculateSpecialDay(date);
        if (result == SUNDAY || date == CHRISTMAS) {
            return true;
        }
        return false;
    }

    private int specialEventDiscount() {
        return calculator.specialDayDiscount();
    }
}
