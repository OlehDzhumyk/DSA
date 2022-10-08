import manager.CareerReader;
import manager.CareerSolver;
import model.Graph;

public class Career {
    public static void main(String[] args) {

        CareerReader reader = new CareerReader();
        Graph graph = reader.setUpGraph("src/main/resources/career2.in.txt");

        CareerSolver solver = new CareerSolver();
        solver.solve(graph);

    }

}
