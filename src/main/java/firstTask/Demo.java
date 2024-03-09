package firstTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static final String PHONE_REGEX_1 ="^[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-]{1}[0-9]{4,6}$";
    public static void main(String[] args) throws IOException{
        File file = new File("file.txt");
        try(FileInputStream fIs = new FileInputStream(file);
        Scanner fileScanner = new Scanner(fIs)){
            while(fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                if(line.matches(PHONE_REGEX_1)){
                    System.out.println(line);
                }
            }
        }catch(FileNotFoundException ex){
            throw new RuntimeException(ex);
        }
    }
}
