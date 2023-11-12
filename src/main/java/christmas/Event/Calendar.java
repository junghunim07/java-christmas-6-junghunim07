package christmas.Event;

enum Calendar {
    MONDAY(4), TUESDAY(5), WEDNESDAY(6),
    THURSDAY(0), FRIDAY(1), SATURDAY(2),
    SUNDAY(3);

    private final int date;

    Calendar(int date) {
        this.date = (date % 7);
    }

    public int getDate() {
        return date;
    }
}