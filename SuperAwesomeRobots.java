public class SuperAwesomeRobots {
    
    public RoboticsDatabase roboticsDatabase;

    public String getSuperAwesomeTitle() {
        String title = null;
        try {
            title = roboticsDatabase.getRandomTitle();
        } catch (Exception ex) {
            title = "Mega Interplanetary Ninja Assasin";
        }
        return title + "; There are " + getWordCount(title) + " words in this title.";
    }

    protected int getWordCount(String title) {
        int wordCount = 0;
        if (title != null) {
            String[] words = title.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].trim().length() > 0) {
                    wordCount++;
                }
            }
        }
        return wordCount;
    }

}