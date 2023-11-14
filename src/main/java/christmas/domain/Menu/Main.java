package christmas.domain.Menu;

public enum Main {
    T_BONE_STEAK(55000) {
        public String getName() {
            return "티본스테이크";
        }
    }, BBQ_RIB(54000) {
        public String getName() {
            return "바비큐립";
        }
    },
    SEAFOOD_PASTA(35000) {
        public String getName() {
            return "해산물파스타";
        }
    }, CHRISTMAS_PASTA(25000) {
        public String getName() {
            return "크리스마스파스타";
        }
    };

    private final int price;

    Main(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    public abstract String getName();
}
