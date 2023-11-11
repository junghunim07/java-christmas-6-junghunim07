package christmas.domain;

public class EventChecker {
    Calculator calculator = new Calculator();
    MenuChecker menuChecker = new MenuChecker();

    public boolean checkChristmasEventPeriod(int date) {
        if (date >= 1 && date <= 25) {
            return true;
        }
        return false;
    }

    public boolean checkWeekdayOrWeekend(int date) {
        int result = calculator.calculateWeekdayOrWeekend(date);
        if (result == 1 || result == 2) {
            return true;
        }
        return false;
    }

    public void weekdayEvent(int date) {
        int discount = 0;
        if (!checkWeekdayOrWeekend(date)) {
            for (String key : MenuMachine.menuBoard.keySet()) {
                discount = calculator.weekdayAndWeekendDiscount(menuChecker.getDessertCount(key));
            }
        }
    }
}
