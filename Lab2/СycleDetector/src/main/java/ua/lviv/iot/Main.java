package ua.lviv.iot;
import ua.lviv.iot.GraphManager.CycleDetector;
import ua.lviv.iot.GraphManager.GraphWriter;
import ua.lviv.iot.GraphModel.Graph;
import ua.lviv.iot.GraphManager.GraphReader;


public class Main {

    public static void main(String[] args) {

        GraphReader reader = new GraphReader();
        Graph graph = reader.setGraphFrom("src/main/resources/input1.txt");

        CycleDetector cycleDetector = new CycleDetector();


        GraphWriter writer = new GraphWriter();
        writer.writeToFile(graph);

        cycleDetector.printCycle(graph);


    }

}
