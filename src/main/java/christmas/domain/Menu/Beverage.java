package christmas.domain.Menu;

public enum Beverage {
    ZERO_COLA(3000) {
        public String getName() {
            return "제로콜라";
        }
    },
    RED_WINE(60000) {
        public String getName() {
            return "레드와인";
        }
    },
    CHAMPAGNE(25000) {
        public String getName() {
            return "샴페인";
        }
    };

    private final int price;

    Beverage(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static boolean hasSameMenu(String name) {
        for (Beverage beverage : Beverage.values()) {
            if (beverage.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public abstract String getName();
}
