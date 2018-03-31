public class Main {

    public static SuperAwesomeRobots superAwesomeRobots = new SuperAwesomeRobots();
    public static RoboticsDatabase mockRoboticsDatabase = new RoboticsDatabase() {
        @Override
        public String getRandomTitle() throws Exception {
            return "Super Duper Muscle Bros";
        }
    };
    public static RoboticsDatabase mockErrorRoboticsDatabase = new RoboticsDatabase() {
        @Override
        public String getRandomTitle() throws Exception {
            throw new Exception("Can't connect to database.");
        }
    };

    public static void main(String[] args) {

        System.out.println("Test Start");

        happyPath();
        multipleSpaces();
        nullTitle();
        getSuperAwesomeTitle();
        getDefaultSuperAwesomeTitleOnError();

        System.out.println("Test End");

    }

    public static void happyPath() {

        System.out.println("Expect getTitleStats to return a phrase with the number of words in the title");
        String result = superAwesomeRobots.getTitleStats("Robot's evil apprentice");
        if (result.equals("There are 3 words in this title.")) {
            System.out.println("\tPASSED");
        } else {
            System.out.println("\tFAILED");
        }

    }

    public static void multipleSpaces() {
        
        System.out.println("Expect getTitleStats to return a phrase with the number of words in the title, even when there are mutliple consecutive spaces");
        String result = superAwesomeRobots.getTitleStats("Robot's   evil   apprentice");
        if (result.equals("There are 3 words in this title.")) {
            System.out.println("\tPASSED");
        } else {
            System.out.println("\tFAILED");
        }

    }

    public static void nullTitle() {
        
        System.out.println("Expect a null title to return the same as 0 words");
        String result = superAwesomeRobots.getTitleStats(null);
        if (result.equals("There are 0 words in this title.")) {
            System.out.println("\tPASSED");
        } else {
            System.out.println("\tFAILED");
        }

    }

    public static void getSuperAwesomeTitle() {
        
        superAwesomeRobots.roboticsDatabase = mockRoboticsDatabase;

        System.out.println("Expect to get a super awesome title");
        String result = superAwesomeRobots.getSuperAwesomeTitle();
        if (result.equals("Super Duper Muscle Bros; There are 4 words in this title.")) {
            System.out.println("\tPASSED");
        } else {
            System.out.println("\tFAILED");
        }

    }

    public static void getDefaultSuperAwesomeTitleOnError() {
        
        superAwesomeRobots.roboticsDatabase = mockErrorRoboticsDatabase;

        System.out.println("Expect to get a super awesome default title when a database error happens");
        String result = superAwesomeRobots.getSuperAwesomeTitle();
        if (result.equals("Mega Interplanetary Ninja Assasin; There are 4 words in this title.")) {
            System.out.println("\tPASSED");
        } else {
            System.out.println("\tFAILED");
        }

    }
}