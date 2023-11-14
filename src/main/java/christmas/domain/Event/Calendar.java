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
}
