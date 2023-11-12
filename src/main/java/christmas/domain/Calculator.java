package christmas.domain;

import christmas.Controller;
import java.util.HashMap;

public class Calculator {
    MenuMachine menuMachine = new MenuMachine();
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
        int count = menuMachine.menuBoard.get(menu);
        int price = ChristmasMenu.getPriceByName(menu);
        return count * price;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (String key : menuMachine.menuBoard.keySet()) {
            totalPrice += calculateTotalOrderAmount(key);
        }
        return totalPrice;
    }

    public int getTotalDiscount(HashMap<String,Integer> eventTable) {
        int discount = 0;
        for (String key : eventTable.keySet()) {
            if (eventTable.get(key) != 0) {
                discount += eventTable.get(key);
            }
        }
        return discount;
    }

    public int calculateAmountOfPayment(int giftDiscount) {
        return Controller.totalPrice - Controller.totalDiscount + giftDiscount;
    }
}
