package christmas.domain.Event;

public enum DateEvent {
    CHRISTMAS_EVENT("크리스마스 디데이 할인", 1000) {
        public int getDiscount(int date) {
            return CHRISTMAS_EVENT.BENEFIT + 100 * (--date);
        }
    },
    SPECIAL_EVENT("특별 할인", 1000) {
        public int getDiscount(int date) {
            if (Calendar.checkStarDay(date)) {
                return SPECIAL_EVENT.BENEFIT;
            }
            return 0;
        }
    };

    private final String eventName;
    private final int BENEFIT;

    DateEvent (String eventName, int BENEFIT) {
        this.eventName = eventName;
        this.BENEFIT = BENEFIT;
    }

    public String getEventName() {
        return eventName;
    }

    public abstract int getDiscount(int value);
}

