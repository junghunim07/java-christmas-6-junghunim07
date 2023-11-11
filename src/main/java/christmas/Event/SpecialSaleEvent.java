package christmas.Event;

import christmas.domain.Calculator;

public class SpecialSaleEvent {
    private static final int SUNDAY = 3;
    private static final int CHRISTMAS = 25;
    static final String EVENT_NAME = "특별 할인";

    static boolean checkSpecialEvent(Calculator calculator, int date) {
        int result = calculator.calculateSpecialDay(date);
        if (result == SUNDAY || date == CHRISTMAS) {
            return true;
        }
        return false;
    }

    static int specialEventDiscount(Calculator calculator) {
        return calculator.specialDayDiscount();
    }
}
