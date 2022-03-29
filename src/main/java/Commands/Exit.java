package Commands;

/**
 * Завершает работу программы.
 */

public class Exit implements Commands{

    @Override
    public void execute() {
        System.exit(0);
    }

    public static String name() {
        return "exit";
    }

    public static Information getInfo() throws Exception {
        return new Information(0,0,false,false, null, null);
    }

}
