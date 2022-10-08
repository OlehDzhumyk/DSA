package model;

public class Vertex {

    public int experience;
    public Integer indexOfBetterWay;

    public Vertex(int experience) {
        this.experience = experience;
    }

    public Integer leftChildIndex(int currentIndex, int arraySize) {
        return 2 * currentIndex + 1 < arraySize ? 2 * currentIndex + 1 : null;
    }

    public Integer rightChildIndex(int currentIndex, int arraySize) {
        return 2 * currentIndex + 2 < arraySize ? 2 * currentIndex + 2 : null;
    }


}
