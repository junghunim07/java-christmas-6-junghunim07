package christmas;

import christmas.ui.InputView;
import christmas.ui.OutputView;

public class Controller {
    InputView input = new InputView();
    OutputView output = new OutputView();

    public void christmasPlannerStart() {
        output.notifyExplanation();
        output.notifyVisitDate();
        int date = input.getVisitDate();
        inputValueValidation(date);
    }

    public void inputValueValidation(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
