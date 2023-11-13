package christmas.domain.Event;

public class GiftEvent {
    private static final int LIMIT_LINE = 120_000;
    private String eventName;
    private int discount;

    GiftEvent(String eventName, int discount) {
        this.eventName = eventName;
        this.discount = discount;
    }

    public int getGiftEventDiscount(int totalPrice, int giftPrice) {
        if (giftEventValidation(totalPrice)) {
            discount = giftPrice;
        }
        return discount;
    }

    private boolean giftEventValidation(int totalPrice) {
        if (totalPrice >= EventMachine.EVENT_APPLICATION_CRITERIA) {
            if (totalPrice >= LIMIT_LINE) {
                return true;
            }
            return false;
        }
        return false;
    }
}
