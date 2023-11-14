package christmas.domain.Menu;

public enum Appetizer {
    MUSHROOM_SOUP(6000) {
        public String getName() {
            return "양송이수프";
        }
    },
    TAPAS(5500) {
        public String getName() {
            return "타파스";
        }
    },
    CAESAR_SALAD(8000) {
        public String getName() {
            return "시저샐러드";
        }
    };

    private final int price;

    Appetizer(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public abstract String getName();
}
