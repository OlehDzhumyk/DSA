package manager;

import model.Graph;
import model.Vertex;

public class CareerSolver {


    public void solve(Graph graph) {

        CareerWriter writer = new CareerWriter();
        writer.writeToFile(visit(graph, 0));

        Vertex runVertex = graph.vertices.get(0);
        System.out.println(runVertex.experience);

        while (runVertex.indexOfBetterWay != null) {
            runVertex = graph.vertices.get(runVertex.indexOfBetterWay);
            System.out.println(runVertex.experience);
        }

    }

    Integer visit(Graph graph, int currentIndex) {

        Vertex currentVertex = graph.vertices.get(currentIndex);

        Integer rightChild = currentVertex.rightChildIndex(currentIndex, graph.vertices.size());
        Integer leftChild = currentVertex.leftChildIndex(currentIndex, graph.vertices.size());

        Integer leftMax;
        Integer rightMax;


        if (rightChild != null) {
            rightMax = visit(graph, rightChild);
            rightMax = rightMax + currentVertex.experience;

        } else rightMax = currentVertex.experience;


        if (leftChild != null) {
            leftMax = visit(graph, leftChild);
            leftMax = leftMax + currentVertex.experience;

        } else leftMax = currentVertex.experience;


        if (leftMax > rightMax) {
            currentVertex.indexOfBetterWay = leftChild;
            return leftMax;
        } else {
            currentVertex.indexOfBetterWay = rightChild;
            return rightMax;
        }
    }

}

