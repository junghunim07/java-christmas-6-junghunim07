package christmas.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int getVisitDate() {
        try {
            int date = Integer.parseInt(Console.readLine());
            return date;
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public List<String> getMenu() {
        List<String> input = new ArrayList<>();
        try {
            String[] menus = Console.readLine().split("-|,");
            for (int i = 0 ; i < menus.length; i++) {
                input.add(menus[i]);
            }
            return input;
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
