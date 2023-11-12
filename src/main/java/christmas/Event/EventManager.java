package christmas.Event;

import christmas.Controller;
import christmas.domain.Calculator;
import christmas.domain.MenuChecker;
import christmas.domain.MenuMachine;
import java.util.HashMap;

public class EventManager {

    public static HashMap<String, Integer> eventTable;
    public static final int CHRISTMAS = 25;
    public static final int DECEMBER_START = 1;
    public static final int LIMIT_LINE = 120_000;
    Calculator calculator;
    MenuChecker menuChecker;
    MenuMachine menuMachine;

    public EventManager() {
        eventTable = new HashMap<>();
        calculator = new Calculator();
        menuChecker = new MenuChecker();
        menuMachine = new MenuMachine();
    }

    public void getMakeEventTable(HashMap<String, Integer> menuBoard) {
        checkChristmasEvent();
        checkWeekdayEvent(menuBoard);
        checkWeekendEvent(menuBoard);
        checkSpecialEvent();
        checkGiftEvent();
    }

    private void checkChristmasEvent() {
        if (ChristmasDDayEvent.checkChristmasEventPeriod(Controller.date)) {
            eventTable.put(ChristmasDDayEvent.EVENT_NAME, ChristmasDDayEvent.christmasEventDiscount(calculator, Controller.date));
        }
    }

    private void checkWeekdayEvent(HashMap<String, Integer> menuBoard) {
        int discount = 0;
        if (WeekdaySaleEvent.checkWeekdayEvent(calculator, Controller.date)) {
            for (String key : menuBoard.keySet()) {
                discount += WeekdaySaleEvent.weekdayEventDiscount(calculator, menuChecker.getDessertCount(key));
            }
            eventTable.put(WeekdaySaleEvent.EVENT_NAME, discount);
        }
        if (discount == 0) {
            eventTable.remove(WeekdaySaleEvent.EVENT_NAME);
        }
    }

    private void checkWeekendEvent(HashMap<String, Integer> menuBoard) {
        int discount = 0;
        if (WeekendSaleEvent.checkWeekendEvent(calculator, Controller.date)) {
            for (String key : menuBoard.keySet()) {
                discount += WeekendSaleEvent.weekendEventDiscount(calculator, menuChecker.getMainCount(key));
            }
            eventTable.put(WeekendSaleEvent.EVENT_NAME, discount);
        }
        if (discount == 0) {
            eventTable.remove(WeekendSaleEvent.EVENT_NAME);
        }
    }

    private void checkSpecialEvent() {
        if (SpecialSaleEvent.checkSpecialEvent(calculator, Controller.date)) {
            eventTable.put(SpecialSaleEvent.EVENT_NAME, SpecialSaleEvent.specialEventDiscount(calculator));
        }
    }

    private void checkGiftEvent() {
        if (GiftEvent.checkGiftEvent(Controller.totalPrice)) {
            eventTable.put(GiftEvent.EVENT_NAME, GiftEvent.giveGiftEventDiscount());
        }
    }
}
