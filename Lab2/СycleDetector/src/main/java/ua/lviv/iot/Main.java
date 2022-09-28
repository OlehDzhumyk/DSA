package ua.lviv.iot;
import ua.lviv.iot.GraphManager.CycleDetector;
import ua.lviv.iot.GraphModel.Graph;
import ua.lviv.iot.GraphManager.GraphReader;

public class Main {

    public static void main(String[] args) {

        GraphReader reader = new GraphReader();
        Graph graph1 = reader.setGraphFrom("src/main/resources/input1.txt");
        Graph graph2 = reader.setGraphFrom("src/main/resources/input2.txt");
        Graph graph3 = reader.setGraphFrom("src/main/resources/input3.txt");
        Graph graph4 = reader.setGraphFrom("src/main/resources/input4.txt");
        Graph graph5 = reader.setGraphFrom("src/main/resources/input5.txt");

        CycleDetector cycleDetector = new CycleDetector();

        cycleDetector.printCycle(graph1);


    }

}
