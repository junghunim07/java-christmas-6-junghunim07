package christmas.domain.Event;

public enum WeekEvent {
    WEEKDAY_EVENT("평일 할인", 2023) {
        public int getDiscount(int date, int dessertMenuCount) {
            if (!Calendar.checkWeekdayOrWeekend(date)) {
                return WEEKDAY_EVENT.benefit * dessertMenuCount;
            }
            return 0;
        }
    },
    WEEKEND_EVENT("주말 할인", 2023) {
        public int getDiscount(int date, int mainMenuCount) {
            if (Calendar.checkWeekdayOrWeekend(date)) {
                return WEEKDAY_EVENT.benefit * mainMenuCount;
            }
            return 0;
        }
    };

    private final String eventName;
    private final int benefit;

    WeekEvent(String eventName, int benefit) {
        this.eventName = eventName;
        this.benefit = benefit;
    }

    public String getEventName() {
        return eventName;
    }

    public int getBenefit() {
        return benefit;
    }

    public abstract int getDiscount(int date, int menuCount);
}
