package christmas.domain.Menu;

public enum Dessert {
    CHOCO_CAKE(15000) {
        public String getName() {
            return "초코케이크";
        }
    },
    ICE_CREAM(5000) {
        public String getName() {
            return "아이스크림";
        }
    };

    private final int price;

    Dessert(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public abstract String getName();
}

