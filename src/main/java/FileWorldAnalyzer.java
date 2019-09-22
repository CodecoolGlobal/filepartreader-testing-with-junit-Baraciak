import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class FileWorldAnalyzer {
    private FilePartReader reader;

    public FileWorldAnalyzer(FilePartReader reader){
        this.reader = reader;
    }


    public List getWordsOrderedAlphabetically () throws FileNotFoundException {
        //    returns the words ordered by alphabetically as an ArrayList

        String text = reader.readLines();
        List<String> textArr = Arrays.asList(text.split("\n"));
        textArr.sort(String::compareToIgnoreCase);
//        Collections.sort(textArr); // --> is case sensitive
        return textArr;
    }


    public List getWordsContainingSubstring (String subString ) throws FileNotFoundException{
        reader.readLines();
//    returns the words which contains the subString
        return null;
    }


    public List getStringsWhichPalindromes () throws FileNotFoundException{
        reader.readLines();
//    returns the words from the String which are palindrome
        return null;
    }

}
