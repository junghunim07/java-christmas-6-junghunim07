package christmas;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.startChristmasPlanner();
            controller.getOrderMenu();
            controller.getEventDetail();
            controller.getBadge();
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
