package christmas.domain;

public class Calculator {
    public int christmasDiscount(int date) {
        return 1000 + 100 * (date - 1);
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

    private int calculateTotalOrderAmount(String menu) {
        int count = MenuMachine.menuBoard.get(menu);
        int price = ChristmasMenu.getPriceByName(menu);
        return count * price;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (String key : MenuMachine.menuBoard.keySet()) {
            totalPrice += calculateTotalOrderAmount(key);
        }
        return totalPrice;
    }

    public int calculateAmountOfPayment(int totalPrice, int totalDiscount) {
        return totalPrice - totalDiscount;
    }
}
