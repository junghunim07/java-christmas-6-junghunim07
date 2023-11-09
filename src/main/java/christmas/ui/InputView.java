package christmas.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int getVisitDate() {
        try {
            int date = Integer.parseInt(Console.readLine());
            return date;
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
