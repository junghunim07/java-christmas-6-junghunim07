package christmas.domain.Event;

public enum Calendar {
    FRIDAY(1), SATURDAY(2), SUNDAY(3),
    ONW_WEEK(7), CHRISTMAS(25),
    DECEMBER_FIRST(1), DECEMBER_LAST(31);

    private final int date;

    Calendar(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    public static boolean getDayOfWeek(int date) {
        if (date % ONW_WEEK.date == FRIDAY.date || date % ONW_WEEK.date == SATURDAY.date) {
            return true;
        }
        return false;
    }

    public static boolean getStarDay(int date) {
        if (date % ONW_WEEK.date == SUNDAY.date || date % ONW_WEEK.date == CHRISTMAS.date) {
            return true;
        }
        return false;
    }
}
