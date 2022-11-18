import java.io.IOException;

public class FileWriter {

    public static void writeToFile(StringBuilder text, String path) {
        try (java.io.FileWriter result = new java.io.FileWriter(path)) {
            result.write(text.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
