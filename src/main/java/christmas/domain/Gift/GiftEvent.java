package christmas.domain.Gift;

import christmas.domain.Event.EventName;
import christmas.domain.Menu.Beverage;

public class GiftEvent {
    private static final String EVENT_NAME = EventName.GIFT_EVENT.getEventName();
    private static final int GIFT_EVENT_LIMIT_LINE = 120_000;
    private int discount = 0;

    public int getDiscount(int totalPrice) {
        if (totalPrice >= GIFT_EVENT_LIMIT_LINE) {
            discount = Beverage.샴페인.getPrice();
        }
        return discount;
    }
}
