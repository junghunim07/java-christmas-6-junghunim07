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

    public int weekdayAndWeekendDiscount(int count) {
        return 2023 * count;
    }

    public int calculateSpecialDay(int date) {
        return date % 7;
    }

    public int specialDayDiscount() {
        return 1000;
    }

    public int calculateTotalOrderAmount(String menu) {
        int count = MenuMachine.menuBoard.get(menu);
        int price = ChristmasMenu.getPriceByName(menu);
        return count * price;
    }
}
