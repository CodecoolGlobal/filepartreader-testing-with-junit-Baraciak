import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;


    public void setup (String filePath, int fromLine, int toLine){
        if(toLine < fromLine || fromLine < 1)
            throw new IllegalArgumentException("toLine cannot be smaller than fromLine");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    /*opens the file on filePath , and gives back it's content as a String
      it doesn't catch the exception being raised,
      the file isn't present on filePath, we can expect an IOException
     */
    public String read () {
        //opens the file on filePath , and gives back it's content as a String
        //it doesn't catch the exception being raised,
        // if the file isn't present on filePath, we can expect an IOException
        StringBuilder text = new StringBuilder();
        try{
            Scanner scanner = new Scanner(new File(filePath));
            scanner.useDelimiter(" ");
            while(scanner.hasNextLine()){
                text.append(scanner.nextLine()).append("\n");
            }
            return text.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public String readLines (){
        StringBuilder lines = new StringBuilder();

        String text = read();
        String[] textArr = text.split("\n");
        for (int i = fromLine - 1; i < toLine; i++) {
            lines.append(textArr[i]).append("\n");
        }

        return lines.toString();
    }
    //reads the file with read ()
    //it gives back every line from it's content between fromLine and toLine (both of them are included), and returns these lines as a String. Take care because if fromLine is 1, it means the very first row in the file.
    // Also, if fromLine is 1 and toLine is 1 also, we will read only the very first line.
}
//public void setup ()
    //it's parameters are:
    //filePath as a String
    //fromLine as an Integer
    //toLine as an Integer
    //it throws an IllegalArgumentException :
    //if toLine is smaller than fromLine
    //if fromLine is smaller than 1
//public String read ()
    //opens the file on filePath , and gives back it's content as a String
    //it doesn't catch the exception being raised,
    // if the file isn't present on filePath, we can expect an IOException
//public String readLines ():
    //reads the file with read ()
    //it gives back every line from it's content between fromLine and toLine (both of them are included), and returns these lines as a String. Take care because if fromLine is 1, it means the very first row in the file.
    // Also, if fromLine is 1 and toLine is 1 also, we will read only the very first line.