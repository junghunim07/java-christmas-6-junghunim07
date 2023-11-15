package christmas.domain.Badge;

public enum Badge {
    NOTHING(0) {
        public String getName() {
            return "없음";
        }
    },
    STAR(5000) {
        public String getName() {
            return "별";
        }
    },
    TREE(10000) {
        public String getName() {
            return "트리";
        }
    },
    SANTA(20000) {
        public String getName() {
            return "산타";
        }
    };

    private final int benefit;

    Badge(int benefit) {
        this.benefit = benefit;
    }

    public int getBenefit() {
        return benefit;
    }

    public static String informBadgeName(int userBenefit) {
        String badgeName = "";
        for (Badge badge : Badge.values()) {
            if (userBenefit >= badge.getBenefit()) {
                badgeName = badge.getName();
            }
        }
        return badgeName;
    }

    public abstract String getName();
}
