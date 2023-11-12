package christmas.Event;

import christmas.Controller;
import christmas.domain.Calculator;
import christmas.domain.MenuChecker;
import christmas.domain.MenuMachine;
import java.util.HashMap;

public class EventManager {

    private HashMap<String, Integer> eventTable;
    public static final int CHRISTMAS = 25;
    public static final int DECEMBER_START = 1;
    public static final int LIMIT_LINE = 120_000;
    Calculator calculator;
    MenuChecker menuChecker;

    public EventManager() {
        eventTable = new HashMap<>();
        calculator = new Calculator();
        menuChecker = new MenuChecker();
    }

    public void getMakeEventTable(MenuMachine menuMachine) {
        checkChristmasEvent();
        checkWeekdayEvent(menuMachine);
        checkWeekendEvent(menuMachine);
        checkSpecialEvent();
        checkGiftEvent();
    }

    private void checkChristmasEvent() {
        if (ChristmasDDayEvent.checkChristmasEventPeriod(Controller.date)) {
            eventTable.put(ChristmasDDayEvent.EVENT_NAME, ChristmasDDayEvent.christmasEventDiscount(calculator, Controller.date));
        }
    }

    private void checkWeekdayEvent(MenuMachine menuMachine) {
        int discount = 0;
        if (WeekdaySaleEvent.checkWeekdayEvent(calculator, Controller.date)) {
            for (String key : menuMachine.getMenuBoard().keySet()) {
                discount += WeekdaySaleEvent.weekdayEventDiscount(calculator, menuChecker.getDessertCount(menuMachine, key));
            }
            eventTable.put(WeekdaySaleEvent.EVENT_NAME, discount);
        }
        if (discount == 0) {
            eventTable.remove(WeekdaySaleEvent.EVENT_NAME);
        }
    }

    private void checkWeekendEvent(MenuMachine menuMachine) {
        int discount = 0;
        if (WeekendSaleEvent.checkWeekendEvent(calculator, Controller.date)) {
            for (String key : menuMachine.getMenuBoard().keySet()) {
                discount += WeekendSaleEvent.weekendEventDiscount(calculator, menuChecker.getMainCount(menuMachine, key));
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

    public HashMap<String,Integer> getEventTable() {
        return eventTable;
    }
}
