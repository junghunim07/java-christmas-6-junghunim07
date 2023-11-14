package christmas.domain.Menu;

public class Menu {
    private String menu;
    private int price;

    Menu(String menu, int price) {
        this.menu = menu;
        this.price = price;
    }

    public String getName() {
        return menu;
    }

    public int getPrice() {
        return price;
    }
}
