package christmas.domain.Event;

public class ChristmasEvent {
    private static final int FIRST_BENEFIT_AMOUNT = 1000;
    private static final int AMOUNT_OF_INCREASE = 100;
    private static final String christmasName = EventName.CHRISTMAS_EVENT.getEventName();
    private int discount;

    ChristmasEvent(int discount) {
        this.discount = discount;
    }

    public String getEventName() {
        return christmasName;
    }

    public int getChristmasEventDiscount(int date) {
        if (christmasValidation(date)) {
            discount = calculateChristmasTotalDiscount(date);
        }
        return discount;
    }

    private boolean christmasValidation(int date) {
        if (date >= Calendar.DECEMBER_FIRST.getDate()
                && date <= Calendar.DECEMBER_LAST.getDate()) {
            return true;
        }
        return false;
    }

    private int calculateChristmasTotalDiscount(int date) {
        return FIRST_BENEFIT_AMOUNT + AMOUNT_OF_INCREASE * (--date);
    }
}
