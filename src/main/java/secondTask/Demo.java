package secondTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    private static final String NAME_REGEX = "^(?!name$|age$)\\D*$";
    private static final String AGE_REGEX ="^(?:[1-9]|[1-9][0-9])$";

    public static void main(String[] args) throws IOException {
        Gson gsonMapper = new GsonBuilder().setPrettyPrinting().create();
        List<User> users = new ArrayList<>();
        String name = "";
        int age = 0;
        File file = new File("file2.txt");
        try(FileInputStream fIs = new FileInputStream(file);
        Scanner fileScanner = new Scanner(fIs)){
            while(fileScanner.hasNext()){
                 String line = fileScanner.nextLine();
                String[] splitLine = line.split(" ");
                for (String s : splitLine) {
                    if (s.matches(NAME_REGEX)) {
                        name = s;
                    }

                    if (s.matches(AGE_REGEX)) {
                        age = Integer.parseInt(s);
                    }
                }
                if(!name.isEmpty()&&age!=0) {
                    users.add(new User(name, age));
                }
            }
        }catch (FileNotFoundException ex){
            throw new RuntimeException(ex);
        }
        String customerJson = gsonMapper.toJson(users);
        System.out.println(customerJson);
    }
}
