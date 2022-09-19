import java.util.*;
public class StopWords {
    //use hashset to implement set interface
    private final HashSet<String> stopW;
    //create instance of 'StopWords'
    private static StopWords i;
    private StopWords() {
        this.stopW = new HashSet<String>();
    }
    public static StopWords areStopWords() {
        if (i == null) {
            i = new StopWords();
        }
        return i;
    }
    /*
    using assertions: An assertion allows testing the correctness of any
    assumptions that have been made in the program.
    source: https://www.geeksforgeeks.org/assertions-in-java/
     */
    //add stopwords, assuming str is not empty
    public void wStopWords(String str) {
        assert(str != null);
        this.stopW.add(str);
    }
    //check if word is stopped
    public boolean wordStopped(String str) {
        assert(str != null);
        return this.stopW.contains(str);
    }
}