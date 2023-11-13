package christmas.domain.Event;

public class ChristmasEvent {
    private static final int FIRST_BENEFIT_AMOUNT = 1000;
    private static final int AMOUNT_OF_INCREASE = 100;
    private String christmasName;
    private int discount;

    ChristmasEvent(String christmasName, int discount) {
        this.christmasName = christmasName;
        this.discount = discount;
    }

    public int getChristmasEvent(int date) {
        if (christmasValidation(date)) {
            discount = getChristmasTotalDiscount(date);
        }
        return discount;
    }

    private boolean christmasValidation(int date) {
        if (date >= EventName.CHRISTMAS_EVENT.getEventStartDate() &&
            date <= EventName.CHRISTMAS_EVENT.getEventFinishDate()) {
            return true;
        }
        return false;
    }

    private int getChristmasTotalDiscount(int date) {
        return FIRST_BENEFIT_AMOUNT + AMOUNT_OF_INCREASE * (--date);
    }
}
