import java.util.LinkedList;
import java.util.List;

public class KPM {

    public static List<Integer> findWordInText(String text, String word) {
        List<Integer> result = new LinkedList<>();
        Integer[] pi = KPM.createPiFor(word);
        int textCharIndex = 0;
        int wordCharIndex = 0;
        int wordLength = word.length();
        int textLength = text.length();
        while (textCharIndex < textLength) {

            if (text.charAt(textCharIndex) == word.charAt(wordCharIndex)) {
                textCharIndex++;
                wordCharIndex++;

                if (wordCharIndex == wordLength - 1) {
                    result.add(textCharIndex - wordLength + 1);
                    wordCharIndex = 0;
                    break;
                }

            } else if (wordCharIndex == 0) {
                textCharIndex++;
            } else {
                wordCharIndex = pi[wordCharIndex - 1];
            }

        }

        return result;

    }

    private static Integer[] createPiFor(String word) {
        Integer[] pi = new Integer[word.length()];
        pi[0] = 0;
        int i = 1;
        int j = 0;
        while (i < word.length()) {
            if (word.charAt(i) == word.charAt(j)) {
                pi[i] = j + 1;
                j++;
            } else if (j == 0) {
                pi[i] = 0;
                i++;
            } else {
                j = pi[j - 1];
            }
        }

        return pi;
    }

}
