package christmas;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.christmasPlannerStart();
            controller.getMenuStart();
            controller.getEventDetail();
            controller.getBadge();
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
