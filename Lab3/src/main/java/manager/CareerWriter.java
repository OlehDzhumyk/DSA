package manager;

import java.io.FileWriter;
import java.io.IOException;

public class CareerWriter {

    public void writeToFile(Integer outPut) {
        try (FileWriter result = new FileWriter("src/main/resources/career.out.txt")) {
                result.write(outPut.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
