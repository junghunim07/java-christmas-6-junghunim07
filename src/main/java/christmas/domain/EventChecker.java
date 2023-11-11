package christmas.domain;

import java.util.HashMap;

public class EventChecker {
    public static HashMap<String, Integer> eventTable = new HashMap<>();
    Calculator calculator = new Calculator();
    MenuChecker menuChecker = new MenuChecker();

    public void makeEventTable(int date) {
        checkWeekendEvent(date);
        checkSpecialEvent(date);
        checkGiftEvent(date);
    }

    private void checkWeekendEvent(int date) {
        int result = calculator.calculateWeekdayOrWeekend(date);
        if (result == 1 || result == 2) {
            eventTable.put("주말 할인", weekendEventDiscount());
        }
    }

    private void checkSpecialEvent(int date) {
        int result = calculator.calculateSpecialDay(date);
        if (result == 3 || date == 25) {
            eventTable.put("특별 할인", specialEventDiscount());
        }
    }

    private void checkGiftEvent(int totalPrice) {
        if (totalPrice >= 120_000) {
            eventTable.put("증정 이벤트", giveGiftEventDiscount());
        }
    }

    private int weekendEventDiscount() {
        int discount = 0;
        for (String key : MenuMachine.menuBoard.keySet()) {
            discount = calculator.weekdayAndWeekendDiscount(menuChecker.getMainCount(key));
        }
        return discount;
    }

    private int specialEventDiscount() {
        return calculator.specialDayDiscount();
    }

    private int giveGiftEventDiscount() {
        return ChristmasMenu.valueOf("CHAMPAGNE").getPrice();
    }
}
