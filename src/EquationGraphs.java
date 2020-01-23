import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class EquationGraphs {
    public static void main(String[] args) {
        outputGraph();
    }

    public static void outputGraph() {
        int sampleAmount = 1;
        int data = 0;
        String fileContents = "";
        String fileName = "C:\\Users\\torin\\Desktop\\General\\Resources\\Personal\\Development\\Java\\AutoGen Art\\art.txt";

        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            FileReader reader = new FileReader(fileName);
            while (data != -1) {
                data = reader.read();
                fileContents += (char) data;
            }
            for(int i = 0; i < sampleAmount; i++) {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Graph currentGraph = drawGraph();

                byte[] bytes = (fileContents + (currentGraph.returnGraph())).getBytes();
                fout.write(bytes);
            }
            System.out.println("Generated Successfully");
            fout.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Graph drawGraph() {
        Graph graph1 = new Graph(100, 100);

        int[] startPos = {0, 0};

        Person newPerson = new Person("Graph Plotter", startPos, graph1);

        // Work out equation

        // y = x^2
        int y = 0;
        int x = 0;
        boolean valid = true;

        while (valid) {
            // y = (int) Math.pow(x, 2); // y = x^2
            y = 100-x;

            if (y > graph1.ySize) {
                valid = false;
            } else if (x == graph1.xSize) {
                valid = false;
            } else {
                System.out.println("Added point: " + x + " " + y);
                newPerson.posGraph.addPoint(x, y); // Plot point
            }

            x++;
        }

        return newPerson.posGraph;
    }
}

