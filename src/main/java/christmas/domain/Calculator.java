package christmas.domain;

import christmas.Controller;
import java.util.HashMap;

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

    private int calculateTotalOrderAmount(HashMap<String, Integer> menuBoard, String menu) {
        int count = menuBoard.get(menu);
        int price = ChristmasMenu.getPriceByName(menu);
        return count * price;
    }

    public int getTotalPrice(HashMap<String, Integer> menuBoard) {
        int totalPrice = 0;
        for (String key : menuBoard.keySet()) {
            totalPrice += calculateTotalOrderAmount(menuBoard, key);
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
