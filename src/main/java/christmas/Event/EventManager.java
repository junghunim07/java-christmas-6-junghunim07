package christmas.Event;

import christmas.Controller;
import christmas.domain.Calculator;
import christmas.domain.MenuChecker;
import christmas.domain.MenuMachine;
import java.util.HashMap;

public class EventManager {
    public static HashMap<String, Integer> eventTable;
    Calculator calculator;
    MenuChecker menuChecker;
    MenuMachine menuMachine;

    public EventManager() {
        eventTable = new HashMap<>();
        calculator = new Calculator();
        menuChecker = new MenuChecker();
        menuMachine = new MenuMachine();
    }

    public void getMakeEventTable() {
        checkChristmasEvent();
        checkWeekdayEvent();
        checkWeekendEvent();
        checkSpecialEvent();
        checkGiftEvent();
    }

    private void checkChristmasEvent() {
        if (ChristmasDDayEvent.checkChristmasEventPeriod(Controller.date)) {
            eventTable.put(ChristmasDDayEvent.EVENT_NAME, ChristmasDDayEvent.christmasEventDiscount(calculator, Controller.date));
        }
    }

    private void checkWeekdayEvent() {
        int discount = 0;
        if (WeekdaySaleEvent.checkWeekdayEvent(calculator, Controller.date)) {
            for (String key : menuMachine.menuBoard.keySet()) {
                discount += WeekdaySaleEvent.weekdayEventDiscount(calculator, menuChecker.getDessertCount(key));
            }
            eventTable.put(WeekdaySaleEvent.EVENT_NAME, discount);
        }
        if (discount == 0) {
            eventTable.remove(WeekdaySaleEvent.EVENT_NAME);
        }
    }

    private void checkWeekendEvent() {
        int discount = 0;
        if (WeekendSaleEvent.checkWeekendEvent(calculator, Controller.date)) {
            for (String key : menuMachine.menuBoard.keySet()) {
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
