package christmas.domain;

import christmas.Controller;
import java.util.HashMap;

public class Calculator {
    private static final int INITIAL_DISCOUNT = 1000;
    private static final int CHRISTMAS_EVENT_INCREASE_AMOUNT = 100;
    private static final int WEEK = 7;
    private static final int THIS_YEAR = 2023;
    public int christmasDiscount(int date) {
        return INITIAL_DISCOUNT + CHRISTMAS_EVENT_INCREASE_AMOUNT * (--date);
    }

    public int calculateWeekdayOrWeekend(int date) {
        return date % WEEK;
    }

    public int weekdayAndWeekendDiscount(int count) {
        return THIS_YEAR * count;
    }

    public int calculateSpecialDay(int date) {
        return date % WEEK;
    }

    public int specialDayDiscount() {
        return INITIAL_DISCOUNT;
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
