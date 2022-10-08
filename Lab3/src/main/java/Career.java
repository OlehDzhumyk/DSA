import manager.CareerReader;
import manager.CareerSolver;
import model.Graph;

public class Career {
    public static void main(String[] args) {

        CareerReader reader = new CareerReader();
        Graph graph = reader.setUpGraph("src/main/resources/career3.in");

        CareerSolver solver = new CareerSolver();
        System.out.println(solver.solve(graph));

    }

}
