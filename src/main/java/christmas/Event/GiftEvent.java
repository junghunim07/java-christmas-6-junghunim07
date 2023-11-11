package christmas.Event;

import christmas.domain.ChristmasMenu;

public class GiftEvent {
    static final int LIMIT_LINE = 120_000;
    static final String EVENT_NAME = "증정 이벤트";

    static boolean checkGiftEvent(int totalPrice) {
        if (totalPrice >= LIMIT_LINE) {
            return true;
        }
        return false;
    }

    static int giveGiftEventDiscount() {
        return ChristmasMenu.valueOf("CHAMPAGNE").getPrice();
    }
}
