package christmas.Event;

import christmas.domain.Calculator;

public class SpecialSaleEvent {
    static final String EVENT_NAME = "특별 할인";

    static boolean checkSpecialEvent(Calculator calculator, int date) {
        int result = calculator.calculateSpecialDay(date);
        if (result == Calendar.SUNDAY.getDate() || date == EventManager.CHRISTMAS) {
            return true;
        }
        return false;
    }

    static int specialEventDiscount(Calculator calculator) {
        return calculator.specialDayDiscount();
    }
}
