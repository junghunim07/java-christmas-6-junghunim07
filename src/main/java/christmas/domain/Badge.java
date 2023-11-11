package christmas.domain;

public enum Badge {
    NOTHING(0, "없음"),
    STAR(5_000, "별"),
    TREE(10_000, "트리"),
    SANTA(20_000, "산타");

    private final int benefit;
    private final String name;

    Badge(int benefit, String name) {
        this.benefit = benefit;
        this.name = name;
    }

    public int getBenefit() {
        return benefit;
    }

    public String getName() {
        return name;
    }

    public static String getBadgeName(int userBenefit) {
        String badgeName = "";
        for (Badge badge : Badge.values()) {
            if (userBenefit >= badge.getBenefit()) {
                badgeName = badge.getName();
            }
        }
        return badgeName;
    }
}
