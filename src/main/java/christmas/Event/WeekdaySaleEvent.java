package christmas.Event;

import christmas.domain.Calculator;
import christmas.domain.MenuChecker;
import christmas.domain.MenuMachine;

public class WeekdaySaleEvent {
    private final int FRIDAY = 1;
    private final int SATURDAY = 2;
    Calculator calculator = new Calculator();
    MenuChecker menuChecker = new MenuChecker();

    public void weekdayEvent(int date) {
        int discount = 0;
        if (checkWeekdayEvent(date)) {
            discount = weekdayEventDiscount();
        }
    }

    private boolean checkWeekdayEvent(int date) {
        int result = calculator.calculateWeekdayOrWeekend(date);
        if (!(result == FRIDAY || result == SATURDAY)) {
            return true;
        }
        return false;
    }

    private int weekdayEventDiscount() {
        int discount = 0;
        for (String key : MenuMachine.menuBoard.keySet()) {
            discount = calculator.weekdayAndWeekendDiscount(menuChecker.getDessertCount(key));
        }
        return discount;
    }
}
