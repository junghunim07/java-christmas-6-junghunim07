package christmas.domain.Menu;

public enum Beverage {
    제로콜라(3000), 레드와인(60000), 샴페인(25000);

    private final int price;

    Beverage(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
