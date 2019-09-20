public class Main {

    public static void main(String[] args) {
        String path = "/home/baraciak420/Desktop/PROJEKTY TUTAJ TUTAJ/filepartreader-testing-with-junit-Baraciak/src/main/resources/HelloWorld.txt";
        FilePartReader reader = new FilePartReader();
        reader.setup(path, 4, 5);

        String lines = reader.readLines();
        System.out.println(lines);
    }
}
