package christmas.domain.Menu;

public class Menu {
    private String name;
    private int price;
    private Category menuCategory;

    Menu(String name, int price, Category menuCategory) {
        this.name = name;
        this.price = price;
        this.menuCategory = menuCategory;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Category getMenuCategory() {
        return menuCategory;
    }
}
