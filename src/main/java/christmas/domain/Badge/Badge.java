package christmas.domain.Badge;

public enum Badge {
    없음 (0),
    별 (5000),
    트리(10000),
    산타(20000);

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
                badgeName = badge.name();
            }
        }
        return badgeName;
    }
}
