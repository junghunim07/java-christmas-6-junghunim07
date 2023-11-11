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

    public boolean checkSpecialEventPeriod(int date) {
        int result = calculator.calculateSpecialDay(date);
        if (result == 3 || date == 25) {
            return true;
        }
        return false;
    }

    public int christmasEvent(int date) {
        return calculator.christmasDiscount(date);
    }

    public int weekdayEvent() {
        int discount = 0;
        for (String key : MenuMachine.menuBoard.keySet()) {
            discount = calculator.weekdayAndWeekendDiscount(menuChecker.getDessertCount(key));
        }
        return discount;
    }

    public int weekendEvent() {
        int discount = 0;
        for (String key : MenuMachine.menuBoard.keySet()) {
            discount = calculator.weekdayAndWeekendDiscount(menuChecker.getMainCount(key));
        }
        return discount;
    }

    public int specialEvent() {
        return calculator.specialDayDiscount();
    }

    public int giveGiftEvent() {
        int totalPrice = 0;
        int discount = 0;
        for (String key : MenuMachine.menuBoard.keySet()) {
            totalPrice += calculator.calculateTotalOrderAmount(key);
        }
        if (totalPrice >= 120_000) {
            discount = ChristmasMenu.valueOf("CHAMPAGNE").getPrice();
        }
        return discount;
    }
}
