package christmas.domain.Menu;

public enum Dessert {
    초코케이크(15000), 아이스크림(5000);

    private final int price;

    Dessert(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

