package christmas.domain.Menu;

public enum Main {
    티본스테이크(55000), 바비큐립(54000),
    해산물파스타(35000), 크리스마스파스타(25000);

    private final int price;

    Main(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
