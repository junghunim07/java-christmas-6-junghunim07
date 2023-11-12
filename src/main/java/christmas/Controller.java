package christmas;

import christmas.Event.EventManager;
import christmas.domain.Badge;
import christmas.domain.Calculator;
import christmas.domain.ChristmasMenu;
import christmas.domain.MenuMachine;
import christmas.ui.InputView;
import christmas.ui.OutputView;
import java.util.List;

public class Controller {
    public static int date;
    public static int totalPrice;
    public static int totalDiscount;
    int giftPrice;
    InputView input = new InputView();
    OutputView output = new OutputView();
    Calculator calculator = new Calculator();
    EventManager eventManager = new EventManager();
    MenuMachine menuMachine = new MenuMachine();

    public void christmasPlannerStart() {
        output.notifyExplanation();
        output.notifyVisitDate();
        date = input.getVisitDate();
        inputValueValidation(date);
    }

    public void getMenuStart() {
        output.notifyGetMenu();
        List<String> menus = input.getMenu();
        menuMachine.transform(menus);
        output.notifyOrderMenu(menuMachine.getMenuBoard());
        totalPrice = calculator.getTotalPrice(menuMachine.getMenuBoard());
        output.notifyPayment(totalPrice);
    }

    public void getEventDetail() {
        checkGift();
        eventManager.getMakeEventTable(menuMachine.getMenuBoard());
        totalDiscount = calculator.getTotalDiscount(EventManager.eventTable);
        printEventDetail();
        output.notifyAllAmountOfBenefit(totalDiscount);
        output.notifyAmountOfPayment(calculator.calculateAmountOfPayment(giftPrice));
    }

    public void getBadge() {
        output.notifyBadge(Badge.getBadgeName(totalDiscount));
    }

    private void printEventDetail() {
        if (EventManager.eventTable.isEmpty()) {
            output.notifyNotBenefit(OutputView.NOTHING);
        }
        if (!EventManager.eventTable.isEmpty()) {
            output.notifyBenefitDetail(EventManager.eventTable);
        }
    }

    private void checkGift() {
        if (totalPrice < EventManager.LIMIT_LINE) {
            giftPrice = 0;
            output.notifyGiftMenu(OutputView.NOTHING);
        }
        if (totalPrice >= EventManager.LIMIT_LINE) {
            giftPrice = ChristmasMenu.CHAMPAGNE.getPrice();
            output.notifyGiftMenu(ChristmasMenu.CHAMPAGNE.getName() + OutputView.SPACE +"1" + OutputView.COUNT);
        }
    }

    public void inputValueValidation(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_DATE_ERROR);
        }
    }
}
