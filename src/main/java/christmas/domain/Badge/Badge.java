package christmas.domain.Badge;

enum Badge {
    NOTHING(0, "없음"),
    STAR(5_000, "별"),
    TREE(10_000, "트리"),
    SANTA(20_000, "산타");

    private final int benefit;
    private final String badgeName;

    Badge(int benefit, String badgeName) {
        this.benefit = benefit;
        this.badgeName = badgeName;
    }

    public int getBenefit() {
        return benefit;
    }

    public String getBadgeName() {
        return badgeName;
    }
}
