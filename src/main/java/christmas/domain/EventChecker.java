package christmas.domain;

import java.util.HashMap;

public class EventChecker {
    static HashMap<String, Integer> eventTable = new HashMap<>();
    Calculator calculator = new Calculator();
    MenuChecker menuChecker = new MenuChecker();

    public boolean checkChristmasEventPeriod(int date) {
        if (date >= 1 && date <= 25) {
            eventTable.put("크리스마스 디데이 할인", christmasEvent(date));
            return true;
        }
        return false;
    }

    public boolean checkWeekdayOrWeekend(int date) {
        int result = calculator.calculateWeekdayOrWeekend(date);
        if (result == 1 || result == 2) {
            eventTable.put("주말 할인", weekendEvent());
            return true;
        }
        eventTable.put("평일 할인", weekdayEvent());
        return false;
    }

    public boolean checkSpecialEventPeriod(int date) {
        int result = calculator.calculateSpecialDay(date);
        if (result == 3 || date == 25) {
            eventTable.put("특별 할인", specialEvent());
            return true;
        }
        return false;
    }

    public boolean checkGiftEvent(int totalPrice) {
        if (totalPrice >= 120_000) {
            eventTable.put("증정 이벤트", giveGiftEvent());
            return true;
        }
        return false;
    }

    public int christmasEvent(int date) {
        return calculator.christmasDiscount(date);
    }

    public int weekdayEvent() {
        int discount = 0;
        for (String key : MenuMachine.menuBoard.keySet()) {
            discount = calculator.weekdayAndWeekendDiscount(menuChecker.getDessertCount(key));
        }
        return discount;
    }

    public int weekendEvent() {
        int discount = 0;
        for (String key : MenuMachine.menuBoard.keySet()) {
            discount = calculator.weekdayAndWeekendDiscount(menuChecker.getMainCount(key));
        }
        return discount;
    }

    public int specialEvent() {
        return calculator.specialDayDiscount();
    }

    public int giveGiftEvent() {
        return ChristmasMenu.valueOf("CHAMPAGNE").getPrice();
    }
}
