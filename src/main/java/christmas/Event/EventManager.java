package christmas.Event;

import christmas.Controller;
import christmas.domain.Calculator;
import java.util.HashMap;

public class EventManager {
    public static HashMap<String, Integer> eventTable;
    Calculator calculator;

    public EventManager() {
        eventTable = new HashMap<>();
        calculator = new Calculator();
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
        if (WeekdaySaleEvent.checkWeekdayEvent(calculator, Controller.date)) {
            eventTable.put(WeekdaySaleEvent.EVENT_NAME, WeekdaySaleEvent.weekdayEventDiscount(calculator, Controller.date));
        }
        if (WeekdaySaleEvent.weekdayEventDiscount(calculator, Controller.date) == 0) {
            eventTable.remove(WeekdaySaleEvent.EVENT_NAME);
        }
    }

    private void checkWeekendEvent() {
        if (WeekendSaleEvent.checkWeekendEvent(calculator, Controller.date)) {
            eventTable.put(WeekendSaleEvent.EVENT_NAME, WeekendSaleEvent.weekendEventDiscount(calculator, Controller.date));
        }
        if (WeekendSaleEvent.weekendEventDiscount(calculator, Controller.date) == 0) {
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
