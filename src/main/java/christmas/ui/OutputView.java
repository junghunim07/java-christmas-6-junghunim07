package christmas.ui;

import java.util.HashMap;

public class OutputView {
    public void notifyExplanation() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void notifyVisitDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public void notifyGetMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public void notifyOrderMenu(HashMap<String, Integer> orderMenu) {
        System.out.println("<주문 메뉴>");
        orderMenu.forEach((key, value) -> System.out.println(key + " " + value + "개"));
    }

    public void notifyPayment(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(totalPrice);
    }
    
    public void notifyGiftMenu(String gift) {
        System.out.println("<증정 메뉴>");
        System.out.println(gift);
    }

    public void notifyBenefit() {
        System.out.println("<혜택 내역>");
    }

    public void notifyBenefitDetail(HashMap<String, Integer> event) {
        event.forEach((key, value) -> System.out.println(key + " : " + "-" + value + "원"));
    }

    public void notifyNotBenefit(String event) {
        System.out.println(event);
    }
    
    public void notifyAllAmountOfBenefit(int totalDiscount) {
        System.out.println("<총혜택 금액>");
        System.out.println("-" + totalDiscount + "원");
    }

    public void notifyAmountOfPayment(int payment) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(payment + "원");
    }

    public void notifyBadge(String badgeName) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badgeName);
    }
}
