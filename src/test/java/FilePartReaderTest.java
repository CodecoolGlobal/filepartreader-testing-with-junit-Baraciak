import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    FilePartReader reader = new FilePartReader();

    @Test
    void test_ReaderSetupRangeToRead_ThrowsInvalidArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> reader.setup("/test_path", 2, 1));
    }


    @Test
    void test_ReaderSetupInvalidFromLine_ThrowsInvalidArgumentException(){
        int invalidFromLine = 0;
        assertThrows(IllegalArgumentException.class, () -> reader.setup("/test_path", invalidFromLine, 1));
    }

    @Test //throws IOException doesnt work
    void test_readInvalidPathThrowsFileNotFoundException(){
        reader.setup("/invalid_path", 2, 4);
        assertThrows(FileNotFoundException.class, () -> reader.read());
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3})
    void test_readLines(int i) throws FileNotFoundException {
        String testPath = "/home/baraciak420/Desktop/PROJEKTY TUTAJ TUTAJ/filepartreader-testing-with-junit-Baraciak/src/test/test_read.txt";
        reader.setup(testPath, i, i);
        assertEquals(Integer.toString(i), reader.readLines());
    }

    @Test
    void test_readLinesRangeOutOfBounds() throws FileNotFoundException {
        int indexOutOfBounds = 1000;
        String testPath = "/home/baraciak420/Desktop/PROJEKTY TUTAJ TUTAJ/filepartreader-testing-with-junit-Baraciak/src/test/test_read.txt";
        reader.setup(testPath, 2, indexOutOfBounds);
        assertEquals("2\n3", reader.readLines());
    }
}