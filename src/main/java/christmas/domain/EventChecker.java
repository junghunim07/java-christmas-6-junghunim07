package christmas.domain;

import java.util.HashMap;

public class EventChecker {
    public static HashMap<String, Integer> eventTable = new HashMap<>();
    Calculator calculator = new Calculator();
    MenuChecker menuChecker = new MenuChecker();

    public void makeEventTable(int date) {
        checkSpecialEvent(date);
        checkGiftEvent(date);
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

    private int specialEventDiscount() {
        return calculator.specialDayDiscount();
    }

    private int giveGiftEventDiscount() {
        return ChristmasMenu.valueOf("CHAMPAGNE").getPrice();
    }
}
