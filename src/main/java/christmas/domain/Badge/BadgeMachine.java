package christmas.domain.Badge;

public class BadgeMachine {
    public String showBadgeName(int userBenefit) {
        String badgeName = "";
        for (Badge badge : Badge.values()) {
            if (userBenefit > badge.getBenefit()) {
                badgeName = badge.getBadgeName();
            }
        }
        return badgeName;
    }
}
