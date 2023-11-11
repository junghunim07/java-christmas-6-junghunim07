package christmas.Event;

import christmas.domain.Calculator;
import christmas.domain.MenuChecker;
import christmas.domain.MenuMachine;

public class WeekendSaleEvent {
    private final int FRIDAY = 1;
    private final int SATURDAY = 2;
    Calculator calculator = new Calculator();
    MenuChecker menuChecker = new MenuChecker();

    public void weekendEvent(int date) {
        int discount = 0;
        if (checkWeekendEvent(date)) {
            discount = weekendEventDiscount();
        }
    }

    private boolean checkWeekendEvent(int date) {
        int result = calculator.calculateWeekdayOrWeekend(date);
        if (result == 1 || result == 2) {
            return true;
        }
        return false;
    }

    private int weekendEventDiscount() {
        int discount = 0;
        for (String key : MenuMachine.menuBoard.keySet()) {
            discount = calculator.weekdayAndWeekendDiscount(menuChecker.getMainCount(key));
        }
        return discount;
    }
}
