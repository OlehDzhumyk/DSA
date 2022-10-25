package manager;

import model.Graph;
import model.Vertex;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CareerReader {

    public Graph setUpGraph(String path) {
        Graph graph = new Graph();

        for (Integer experience : getVertices(getTextFromFile(path))) {
            graph.vertices.add(new Vertex(experience));
        }

        return graph;

    }

    private List<Integer> getVertices(String text) {
        Pattern pattern = Pattern.compile("\\d+\\s?");
        Matcher matcher = pattern.matcher(text);

        List<Integer> vertices = new LinkedList<>();
        matcher.find();
        matcher.group();

        String valueWithSpace;
        while (matcher.find()) {
            valueWithSpace = matcher.group();
            valueWithSpace = valueWithSpace.replaceAll("\\s+","");
            vertices.add(Integer.parseInt(valueWithSpace));

        }

        return vertices;
    }

    public static String getTextFromFile(String path) {
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
