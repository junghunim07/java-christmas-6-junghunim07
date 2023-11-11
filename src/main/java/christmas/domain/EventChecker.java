package christmas.domain;

import java.util.HashMap;

public class EventChecker {
    public static HashMap<String, Integer> eventTable = new HashMap<>();
    Calculator calculator = new Calculator();
    MenuChecker menuChecker = new MenuChecker();

    public void makeEventTable(int date) {
        checkGiftEvent(date);
    }

    private void checkGiftEvent(int totalPrice) {
        if (totalPrice >= 120_000) {
            eventTable.put("증정 이벤트", giveGiftEventDiscount());
        }
    }

    private int giveGiftEventDiscount() {
        return ChristmasMenu.valueOf("CHAMPAGNE").getPrice();
    }
}
