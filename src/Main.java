import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
//    String log_file = "log.txt";
    static int countwordinfile(String word){
        int count = 0;
        try(Scanner scanner = new Scanner(new File("log.txt"))) {
//            scanner.useDelimiter(Pattern.compile("[A-Z]"));
            while (scanner.hasNext()){
                String wordinfile = scanner.next();
                if(wordinfile.equals(word)){
                    count++;
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    public static void main(String[] a) throws FileNotFoundException {
//        Main log_file = new Main();
        System.out.println("TOTAL LOGS");
        File logFile = new File("log.txt");

        Scanner myfilereader = new Scanner(logFile);
        while(myfilereader.hasNextLine()){
            String logs = myfilereader.nextLine();
            System.out.println(logs);
        }
        myfilereader.close();
        System.out.println("SUMMARY LOGS");
        System.out.println("INFO LOGS");
        System.out.println(countwordinfile("INFO"));
        System.out.println("ERROR LOGS");
        System.out.println(countwordinfile("ERROR"));
        System.out.println("WARN LOGS");
        System.out.println(countwordinfile("WARN"));
    }
}