package christmas.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class InputView {
    public int getVisitDate() {
        try {
            int date = Integer.parseInt(Console.readLine());
            return date;
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_DATE_ERROR);
        }
    }

    public HashMap<String, Integer> getMenu() {
        HashMap<String, Integer> menu = new HashMap<>();
        try {
            String[] input = Console.readLine().split(",");
            for (String splitInput : input) {
                String[] orderMenu = splitInput.split("-");
                menu.put(orderMenu[0], Integer.parseInt(orderMenu[1]));
            }
            return menu;
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(OutputView.NOTIFY_INVALID_ORDER_ERROR);
        }
    }
}
