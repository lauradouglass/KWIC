//import useful packages
import java.util.*;
import java.lang.*;
public class CircularShift {
    //set delimiter val to 1 whitespace
    public static String D = " "; //assuming words are seperated by spaces
    //try putting _ before private attributes? to fix error
    private final String notUpper;
    private final StopWords stopW;
    public CircularShift(String str) {
        assert(str != null);
        //stop words in lowercase
        this.notUpper = str.toLowerCase();
        this.stopW = StopWords.areStopWords();
    }
    //make index all uppercase
    private String makeCapital(String L) {
        //new array of string and string builder to append the keywords
        String[] currentWord2 = L.split(D);
        StringBuilder buildString = new StringBuilder();
        int L4 = buildString.length();
        for (String i : currentWord2) {
            if (this.stopW.wordStopped(i)) {
                buildString.append(i);
            } else if (i.trim().isEmpty()) {
                continue;
            } else {
                //capitalize non stop words
                buildString.append(i.toUpperCase());
            }
            buildString.append(D);
        }
        if (L4 > 0) {
            //delete last new line seperator
            buildString.deleteCharAt(L4- 1);
        }
        return buildString.toString();
    }
    //move current word to first, then recursively move by 2
    //this ->current object? idk java is weird lol
    public String[] shifting() {
        String[] currentWord = this.notUpper.split(D);
        //length of string array
        int L = currentWord.length;
        String[] shiftTo = new String[L];
        shiftTo[0] = this.notUpper;
        for (int i=1; i<L; i++) {
            //call shifted line from below
            shiftTo[i] = this.ShiftedLine(i, currentWord);
        }
        String[] postShifting = noStopWordsAhead(shiftTo);
        int L1 = postShifting.length;
        for (int i=0; i<L1; i++) {
            postShifting[i] = makeCapital(postShifting[i]);
        }
        //output the filtered shifts that was performed above
        return postShifting;
    }
    //let A = the index of the shifted line
    //let B = the array of words we wish to get shifted line for
    private String ShiftedLine(int A, String[] B) {
        //create a new instance of string builder object to help append the words from the array
        StringBuilder buildString = new StringBuilder();
        //length of array
        int L2 = B.length;
        int L3 = buildString.length();
        for (int i=A; i<L2; i++) {
            buildString.append(B[i]);
            buildString.append(D); //defined above to be space
        }
        for (int i=0; i<A; i++) {
            buildString.append(B[i]);
            buildString.append(D);
        }
        //delete last new line seperator if string builder is populated
        if (L3 > 0) {
            buildString.deleteCharAt(L3-1);
        }
        //convert string object into a string and return that
        return buildString.toString();
    }
    private String[] noStopWordsAhead(String[] shiftB) {
        //create a list of string to store shifts, can't remember how to do that rn, tomorrow
        List<String> LShifts = new ArrayList<String>(Arrays.asList(shiftB));
        //loop through array list using iterator
        //if there is a stop word in front, remove it
        LShifts.removeIf(this::stopWordsAhead);
        //len of list of shift
        int L4 = LShifts.size();
        return LShifts.toArray(new String[L4]);
    }
    //call wordStopped from StopWords.java
    private boolean stopWordsAhead(String str8) {
        return this.stopW.wordStopped(str8.split(D)[0]);
    }
}