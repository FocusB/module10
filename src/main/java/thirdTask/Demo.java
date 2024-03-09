package thirdTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        File file = new File("words.txt");
        List<String> words = new ArrayList<>();
        int count = 0;
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        try(FileInputStream fIs = new FileInputStream(file);
        Scanner fileScanner = new Scanner(fIs)){
            while(fileScanner.hasNext()){
                String word = fileScanner.next();
                words.add(word);
            }
        }catch(FileNotFoundException ex){
            throw new RuntimeException(ex);
        }
        for(int i = 0; i<words.size();i++){
            String firstLine = words.get(i);
            for(int j=i; j<words.size();j++){
                if(firstLine.equals(words.get(j))){
                    count++;
                }
            }

            if(!treeMap.containsKey(firstLine)){
            treeMap.put(firstLine, count);
            }
            count=0;
        }
        SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<>(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        sortedSet.addAll(treeMap.entrySet());
        for (Map.Entry<String, Integer> entry : sortedSet) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
