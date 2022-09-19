import java.util.*;
/* this program is used to arrange output in
alphabetical order. assign current object in kWords to array list of string,
then loop through and add current object to an array (create new)
*/
public class AlphabeticalOrder {
    private List<String> kWords;
    public AlphabeticalOrder() {
        this.kWords = new ArrayList<String>();
    }
    public String[] Alphabetised() {
        Collections.sort(this.kWords);
        int L1 = this.kWords.size();
        return this.kWords.toArray(new String[L1]);
    }
    public void fillArray(String[] kWord) {
        for (String i : kWord) {
            this.kWords.add(i);
        }
    }
}