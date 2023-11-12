package christmas.ui;

import java.util.HashMap;

public class OutputView {
    static final String NEW_LINE = "\n";

    private static final String MINUS = "-";
    private static final String WON = "원";
    private static final String INTRO_EXPLANATION = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String NOTIFY_VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String NOTIFY_GET_MENU_COUNT = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String NOTIFY_ORDER_MENU = "<주문 메뉴>" + NEW_LINE;
    private static final String NOTIFY_TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>" + NEW_LINE;
    private static final String NOTIFY_GIFT_MENU = "<증정 메뉴>" + NEW_LINE;
    private static final String NOTIFY_BENEFIT_DETAIL = "<혜택 내역>" + NEW_LINE;
    private static final String NOTIFY_TOTAL_BENEFIT_AMOUNT = "<총혜택 금액>" + NEW_LINE;
    private static final String NOTIFY_PAYMENT_AMOUNT_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>" + NEW_LINE;
    private static final String NOTIFY_DECEMBER_BADGE = "<12월 이벤트 배지>" + NEW_LINE;

    public static final String SPACE = " ";
    public static final String COUNT = "개";
    public static final String NOTHING = "없음";
    public static final String ERROR = "[ERROR]";
    public static final String NOTIFY_INVALID_DATE_ERROR = ERROR + SPACE + "유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public static final String NOTIFY_INVALID_ORDER_ERROR = ERROR + SPACE +"유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public void notifyExplanation() {
        System.out.println(INTRO_EXPLANATION);
    }

    public void notifyVisitDate() {
        System.out.println(NOTIFY_VISIT_DATE);
    }

    public void notifyGetMenu() {
        System.out.println(NOTIFY_GET_MENU_COUNT);
    }

    public void notifyOrderMenu(HashMap<String, Integer> orderMenu) {
        System.out.print(NOTIFY_ORDER_MENU);
        orderMenu.forEach((key, value) -> System.out.println(key + SPACE + value + COUNT));
        System.out.print(NEW_LINE);
    }

    public void notifyPayment(int totalPrice) {
        System.out.println(NOTIFY_TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT + totalPrice + NEW_LINE);
    }
    
    public void notifyGiftMenu(String gift) {
        System.out.println(NOTIFY_GIFT_MENU + gift + NEW_LINE);
    }

    public void notifyBenefitDetail(HashMap<String, Integer> event) {
        System.out.print(NOTIFY_BENEFIT_DETAIL);
        event.forEach((key, value) -> System.out.println(key + " : " + MINUS + value + WON));
        System.out.print(NEW_LINE);
    }

    public void notifyNotBenefit(String event) {
        System.out.println("<혜택 내역>");
        System.out.println(event);
    }
    
    public void notifyAllAmountOfBenefit(int totalDiscount) {
        System.out.println(NOTIFY_TOTAL_BENEFIT_AMOUNT + MINUS + totalDiscount + WON + NEW_LINE);
    }

    public void notifyAmountOfPayment(int payment) {
        System.out.println(NOTIFY_PAYMENT_AMOUNT_AFTER_DISCOUNT + payment + WON + NEW_LINE);
    }

    public void notifyBadge(String badgeName) {
        System.out.println(NOTIFY_DECEMBER_BADGE + badgeName);
    }
}
