package ua.lviv.iot.manager;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DictionaryReader {
    public  static LinkedList<String> getDictionaryFrom(String path){
        LinkedList<String> dictionary = new LinkedList<>();
        Pattern pattern = Pattern.compile("(\\w+)");
        Matcher matcher = pattern.matcher(getTextFromFile(path));
        matcher.find();
        matcher.group();
        while (matcher.find()) {
            dictionary.add(matcher.group());
        }

        return dictionary;
    }

    private static String getTextFromFile(String path) {
        File file = new File(path);
        String text = null;
        try (Scanner scanner = new Scanner(file)) {
            StringBuilder result = new StringBuilder();
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine()).append("\n");
            }
            text = result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

}
