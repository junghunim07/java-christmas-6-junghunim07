package christmas.domain.Gift;

import christmas.domain.Menu.Beverage;

public class GiftEvent {
    private static final String EVENT_NAME = "증정 이벤트";
    private static final String giftMenuName = Beverage.CHAMPAGNE.getName();
    private static final int GIFT_EVENT_LIMIT_LINE = 120_000;
    private int discount = 0;

    public int getDiscount() {
        return discount;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public String getGiftMenuName() {
        return giftMenuName;
    }

    public void calculateDiscount(int totalPrice) {
        if (totalPrice >= GIFT_EVENT_LIMIT_LINE) {
            discount = Beverage.CHAMPAGNE.getPrice();
        }
    }
}
