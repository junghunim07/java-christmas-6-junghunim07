package christmas.domain.Event;

public enum Calendar {
    FRIDAY {
        public int getDate() {
            return 1;
        }
    },
    SATURDAY {
        public int getDate() {
            return 2;
        }
    },
    SUNDAY {
        public int getDate() {
            return 3;
        }
    },
    ONW_WEEK {
        public int getDate() {
            return 7;
        }
    }, CHRISTMAS {
        public int getDate() {
            return 25;
        }
    },
    DECEMBER_FIRST {
        public int getDate() {
            return 1;
        }
    }, DECEMBER_LAST {
        public int getDate() {
            return 31;
        }
    };

    public static boolean checkWeekdayOrWeekend(int date) {
        if ((date % ONW_WEEK.getDate()) == FRIDAY.getDate() || (date % ONW_WEEK.getDate()) == SATURDAY.getDate()) {
            return true;
        }
        return false;
    }

    public static boolean checkStarDay(int date) {
        if ((date % ONW_WEEK.getDate()) == SUNDAY.getDate() || (date % ONW_WEEK.getDate()) == CHRISTMAS.getDate()) {
            return true;
        }
        return false;
    }

    public abstract int getDate();
}
