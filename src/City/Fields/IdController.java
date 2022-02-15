package City.Fields;

public final class IdController {

    private static IdController instance;
    private int id = 1;

    private IdController() {

    }

    public static IdController getInstance() {
        if (instance == null) {
            instance = new IdController();
        }
        return instance;
    }

    public int getNewId() {
        return id++;
    }

}
