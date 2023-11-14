package christmas.domain.Event;

public class WeekEvent {
    private static final int BENEFIT = 2023;
    private String eventName;
    private int discount;

    WeekEvent(int discount) {
        this.discount = discount;
    }

    public int getWeekEventDiscount(int date, int count) {
        if (checkWeekdayOrWeekend(date)) {
            discount = calculateEventTotalDiscount(count);
        }
        if (!checkWeekdayOrWeekend(date)) {
            discount = calculateEventTotalDiscount(count);
        }
        return discount;
    }

    public String getEventName() {
        return eventName;
    }

    private boolean checkWeekdayOrWeekend(int date) {
        if ((date % Calendar.ONW_WEEK.getDate()) == Calendar.FRIDAY.ordinal()
                || (date % Calendar.ONW_WEEK.getDate()) == Calendar.SUNDAY.ordinal()) {
            eventName = EventName.WEEKEND_EVENT.getEventName();
            return true;
        }
        eventName = EventName.WEEKDAY_EVENT.getEventName();
        return false;
    }

    private int calculateEventTotalDiscount(int count) {
        return BENEFIT * count;
    }
}
