package christmas.domain.Menu;

public enum Appetizer {
    양송이수프(6000), 타파스(5500), 시저샐러드(8000);

    private final int price;

    Appetizer(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
