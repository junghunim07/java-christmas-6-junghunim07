package christmas;

import christmas.Event.EventManager;
import christmas.Event.GiftEvent;
import christmas.domain.Badge;
import christmas.domain.Calculator;
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
        output.notifyOrderMenu(menuMachine.menuBoard);
        totalPrice = calculator.getTotalPrice(menuMachine.menuBoard);
        output.notifyPayment(totalPrice);
    }

    public void getEventDetail() {
        checkGift();
        eventManager.getMakeEventTable();
        totalDiscount = calculator.getTotalDiscount(EventManager.eventTable);
        output.notifyBenefit();
        printEventDetail();
        output.notifyAllAmountOfBenefit(totalDiscount);
        output.notifyAmountOfPayment(calculator.calculateAmountOfPayment(giftPrice));
    }

    public void getBadge() {
        output.notifyBadge(Badge.getBadgeName(totalDiscount));
    }

    private void printEventDetail() {
        if (EventManager.eventTable.isEmpty()) {
            output.notifyNotBenefit("없음");
        }
        if (!EventManager.eventTable.isEmpty()) {
            output.notifyBenefitDetail(EventManager.eventTable);
        }
    }

    private void checkGift() {
        if (totalPrice < 120_000) {
            giftPrice = 0;
            output.notifyGiftMenu("없음");
        }
        if (totalPrice >= 120_000) {
            giftPrice = 25_000;
            output.notifyGiftMenu("샴페인 1개");
        }
    }

    public void inputValueValidation(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
