import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.Scanner;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;


    public void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine || fromLine < 1)
            throw new IllegalArgumentException("toLine cannot be smaller than fromLine");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }


    public String read() throws FileNotFoundException {
        //opens the file on filePath , and gives back it's content as a String
        //it doesn't catch the exception being raised,
        // if the file isn't present on filePath, we can expect an IOException
        ////problem witch catching IOException catch says that try block does not throw IOException
        StringBuilder text = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(filePath)); //here throws FileNotFoundException
            scanner.useDelimiter(" ");
            while (scanner.hasNextLine()) {
                text.append(scanner.nextLine()).append("\n");//should throw IOException here when file isn't present
            }
            scanner.close();
            return text.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException("File read Failed");
        }
    }


    public String readLines() throws FileNotFoundException {
        StringBuilder lines = new StringBuilder();

        String text = read();
        String[] textArr = text.split("\n");

        //chooses when to end iterating
        //                                          true           :  false
        int validToLine = toLine > textArr.length ? textArr.length : toLine;

        for (int i = fromLine - 1; i < validToLine; i++) {
            lines.append(textArr[i]);
            //does not append \n to last line
            if (i != validToLine - 1) lines.append("\n");
        }
        return lines.toString();
    }
}