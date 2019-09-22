import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileWorldAnalyzerTest {
    private FilePartReader reader = new FilePartReader();
    private FileWorldAnalyzer anal;

    @Test
    void getWordsOrderedAlphabetically() throws FileNotFoundException {
        //setup reader and analyzer
        String testPath = "/home/baraciak420/Desktop/PROJEKTY TUTAJ TUTAJ/filepartreader-testing-with-junit-Baraciak/src/test/test_read.txt";
        reader.setup(testPath, 4,7); //words d c b a
        anal = new FileWorldAnalyzer(reader);

        List<String> textArr = new ArrayList<>();
        textArr.add("a");
        textArr.add("b");
        textArr.add("c");
        textArr.add("d");

        assertEquals(textArr, anal.getWordsOrderedAlphabetically());
    }

    @Test
    void getWordsContainingSubstring() {
    }

    @Test
    void getStringsWhichPalindromes() {
    }
}