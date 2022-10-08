package manager;

import model.Graph;
import model.Vertex;

public class CareerSolver {


    public int solve(Graph graph) {

        Integer max;
        max = visit(graph, 0);

        Vertex runVertex = graph.vertices.get(0);

        while (runVertex.indexOfBetterWay != null) {
            System.out.println(runVertex.experience);
            runVertex = graph.vertices.get(runVertex.indexOfBetterWay);
        }
        System.out.println();
        return max;
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

