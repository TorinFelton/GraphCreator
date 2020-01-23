import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Graph graph1 = new Graph(20, 20);
        Random rand = new Random();

        // System.out.println(graph1.getGraphString());

        int[] startPos = {12, 2};

        Person newPerson = new Person("Dave", startPos, graph1);

        /* # ------------- # Wall building # --------------#

        newPerson.posGraph.constructWall(1, 4, 5, 2);
        newPerson.posGraph.constructWall(1, 4, 7, 1);
        newPerson.posGraph.constructWall(1, 10, 10, 2);
        newPerson.posGraph.constructWall(6, 4, 4, 1);
        newPerson.posGraph.constructWall(6, 8, 6, 2);
        newPerson.posGraph.constructWall(11, 8, 4, 1);

        newPerson.posGraph.constructRectangle(11, 11, 6, 6);
        */

        // newPerson.posGraph.displayGraph();

        newPerson.move(1);

        // newPerson.posGraph.displayGraph();

//        int count = 0;
//        int stepCount = 0;
        boolean valid = true;

        while(valid) { // Runs until the pointer gets stuck in a square of walls

            newPerson.facingDirection = rand.nextInt(4);
            while (newPerson.doNotTry == newPerson.facingDirection) {
                newPerson.facingDirection = rand.nextInt(4);
            }

            if ( !newPerson.move(1) ) {
                valid = false;
            }

            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            newPerson.posGraph.displayGraph();





            /* For if you want a continuous set of movements
            stepCount++;

            if (stepCount == 4) {
                count++;
                stepCount = 0;
            }

            if (count == 5) {
                count = 0;
            }

             */

        }

        //newPerson.move(2);

       // newPerson.posGraph.displayGraph();
        /*

        graph1.addPoint(0, 0);
        // System.out.println(graph1.getGraphString());

        graph1.removePoint(0, 0);
        // System.out.println(graph1.getGraphString());

        graph1.addPoint(0, 0);
        // graph1.displayGraph();

        graph1.addPoint(1, 0);

        graph1.addPoint(3, 0);

        int y = 0;

        for (int x = 0; x < 10; x++) {
            y = x^2 + 2;
            graph1.addPoint(x, y);
        }
        graph1.displayGraph();


         */


    }


}

