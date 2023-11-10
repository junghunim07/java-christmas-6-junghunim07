package christmas.domain;

public class EventChecker {
    public boolean checkChristmasEventPeriod(int date) {
        if (date >= 1 && date <= 25) {
            return true;
        }
        return false;
    }
}
