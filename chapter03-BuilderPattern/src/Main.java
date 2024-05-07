
public class Main {

    public static void main(String[] args) {
        // Membuat RobotDirector
        RobotDirector director = RobotDirector.getInstance();

        // Membuat robot casual
        Robot casualRobot = director.CasualRobot();
        System.out.println("Casual Robot:");
        System.out.println(casualRobot.toString());

        // Membuat robot intelligent
        Robot intelligentRobot = director.IntelligentRobot();
        System.out.println("\nIntelligent Robot:");
        System.out.println(intelligentRobot.toString());

        // Membuat robot rere
        Robot rereRobot = director.RereRobot();
        System.out.println("\nRere Robot:");
        System.out.println(rereRobot.toString());
    }
}

