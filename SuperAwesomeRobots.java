public class SuperAwesomeRobots {
    
    public RoboticsDatabase roboticsDatabase;

    public String getSuperAwesomeTitle() {
        String title = null;
        try {
            title = roboticsDatabase.getRandomTitle();
        } catch (Exception ex) {
            title = "Mega Interplanetary Ninja Assasin";
        }
        return title + "; " + getTitleStats(title);
    }

    protected String getTitleStats(String title) {
        String[] words = title.split(" ");
        int wordCount = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].trim().length() > 0) {
                wordCount++;
            }
        }
        return "There are " + wordCount + " words in this title.";
    }

}