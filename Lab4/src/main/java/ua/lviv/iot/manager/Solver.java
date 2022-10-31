package ua.lviv.iot.manager;

import java.util.LinkedList;

public class Solver {

    private static LinkedList<String> track = new LinkedList<>();

    public static void solve(LinkedList<String> dictionary) {
        int result = 0;
        Integer cash;
        for (String word : dictionary) {
            cash = check(dictionary, word, 0, new LinkedList<>());
            if (result < cash) {
                result = cash;
            }
        }

        int counter = 0;
        for (String word : track) {
            counter++;
            System.out.println(counter + ": " + word);
        }

        ResultWriter.writeToFile(result);

    }


    private static Integer check(LinkedList<String> dictionary, String word, Integer depth, LinkedList<String> localTrack) {
        int result = depth;
        if (dictionary.contains(word)) {
            localTrack.add(word);
            if (localTrack.size() > track.size()) {
                track = localTrack;
            }
            depth++;
            result = depth;
            Integer cash;
            for (int i = 0; i < word.length(); i++) {
                cash = check(dictionary, newVariant(word, i), depth, new LinkedList<>(localTrack));
                if (result < cash) {
                    result = cash;
                }
            }
        }
        return result;

    }

    public static String newVariant(String word, Integer index) {
        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i != index) {
                newWord.append(word.charAt(i));
            }
        }
        return newWord.toString();
    }


}
