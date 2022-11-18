import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int numberOfTest = 10_000;

//        Main.createAverageText("src/main/resources/average.txt");

        test(numberOfTest, "average");

        test(numberOfTest, "best");

        test(numberOfTest, "worst");

    }

    private static void test(int numberOfTest, String caseOfTest) {
        long elapsedTime = 0;
        String text = TextReader.getTextFromFile("src/main/resources/" + caseOfTest + ".txt");
        String word = TextReader.getTextFromFile("src/main/resources/Word.txt");
        for (int i = 0; i < numberOfTest; i++) {
            elapsedTime += makeTest(elapsedTime, word, text);
        }

        FileWriter.writeToFile(new StringBuilder().append(elapsedTime / numberOfTest),
                "src/main/resources/results/" + caseOfTest + "Result.txt");
    }

    private static long makeTest(long sum, String word, String text) {
        long start;
        long end;
        start = System.nanoTime();
        KPM.findWordInText(text, word);
        end = System.nanoTime();
        sum += (end - start);
        return sum / 1_000;
    }

    public static void createAverageText(String path) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();

        for (int i = 1; i < 510_000; i++) {
            if (i % 51 == 0) {
                text.append("\n");
                text.append((char) (random.nextInt(26) + 97));
            } else {
                text.append((char) (random.nextInt(26) + 97));
            }

        }
        text.append("\nabcdefghijk");
        FileWriter.writeToFile(text, path);
    }

}
