//import useful packages
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException, NullPointerException{
        //arraylist to store read input
        //read in user input using buffer read.
        //use while loop to ensure entire file is read
        List<String> userIn = new ArrayList<String>();
        BufferedReader readIn = new BufferedReader(new FileReader("/Users/lauradouglas/IdeaProjects/KWIC/src/input.txt"));
        String str;
        while ((str = readIn.readLine()) != null) {
            userIn.add(str);
        }
        //delete all duplicates
        List<String> deleteDuplicates = new ArrayList<String>();
        for (String i : userIn){
            if(!deleteDuplicates.contains(i)){
                deleteDuplicates.add(i);
            }
        }
        readIn.close();
        //ask user for a 'stop_words' file. words in this text file will be ignored
        Scanner stopWords = new Scanner(System.in);
        System.out.println("Do you have stop words? (y/n): ");
        String ans = stopWords.nextLine();
        String comp = "y";
        if(ans.equals(comp)) {
            try {
                Scanner scanner = new Scanner(new File("/Users/lauradouglas/IdeaProjects/KWIC/src/stopwords.txt"));
                String SC = scanner.nextLine();
                StopWords stop = StopWords.areStopWords();
                while (!SC.isBlank()) {
                    stop.wStopWords(SC);
                    SC = scanner.nextLine();
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        //create an instance of Alphabetical order and Circular shift to pass input
        AlphabeticalOrder AO = new AlphabeticalOrder();
        for (String str1 : deleteDuplicates) {
            CircularShift CS = new CircularShift(str1);
            AO.fillArray(CS.shifting());
        }
        String[] userOut = AO.Alphabetised();
        StringBuilder buildString = new StringBuilder();
        String spaceOut = System.lineSeparator();
        for (String str2 : userOut) {
            buildString.append(str2).append(spaceOut);
        }
        //saving to file or printing to terminal
        Scanner save = new Scanner(System.in);
        System.out.println("Input 'view' + ENTER to view your output in terminal.\n" + "Or input 'file' + ENTER to get a text file of your results");
        String printOption = save.nextLine();
        String view = "view";
        String file = "file";
        if (printOption.equals(view)){
            System.out.print(buildString);
        } else if (printOption.equals(file)) {
            try (BufferedWriter toFile = new BufferedWriter(new FileWriter("kwic.txt"))) {
                toFile.append(buildString);//does buildString.toString() internally;
                toFile.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}