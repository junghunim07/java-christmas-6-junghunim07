package christmas.Event;

import christmas.domain.Calculator;
import christmas.domain.ChristmasMenu;

public class GiftEvent {
    static final int LIMIT_LINE = 120_000;
    Calculator calculator = new Calculator();

    public void giveGiftEvent(int totalPrice) {
        int discount = 0;
        if (checkGiftEvent(totalPrice)) {
            discount = giveGiftEventDiscount();
        }
    }

    private boolean checkGiftEvent(int totalPrice) {
        if (totalPrice >= LIMIT_LINE) {
            return true;
        }
        return false;
    }

    private int giveGiftEventDiscount() {
        return ChristmasMenu.valueOf("CHAMPAGNE").getPrice();
    }
}
