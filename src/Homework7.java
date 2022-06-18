import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Homework7 {

    public static void main(String[] args) {
        Graph graph = new Graph();
        for (int i = 0;  i < 10; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 7);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(7, 8);
        graph.addEdge(7, 6);
        graph.addEdge(8, 9);
        // 1 - 2 - 3 - 4 - 6
        //1 - 7 - 6
        graph.search(graph.vertexList[1], graph.vertexList[6]);

    }

    public static class Graph {

        private final int MAX_VERTS = 32;
        private Vertex[] vertexList;
        private int[][] adjMat;
        private int size;

        public Graph(){
            vertexList = new Vertex[MAX_VERTS];
            adjMat = new int[MAX_VERTS][MAX_VERTS];
            size = 0;
            for (int i = 0; i < MAX_VERTS; i++) {
                for (int j = 0; j < MAX_VERTS; j++) {
                    adjMat[i][j] = 0;
                }
            }
        }

        public void addVertex(int number){
            vertexList[size++] = new Vertex(number);
        }
        public void addEdge(int start, int end){
            adjMat[start][end] = 1;
            adjMat[end][start] = 1;
        }
        public void displayVertex(int vertex){
            System.out.println(vertexList[vertex]);
        }

        public boolean search(Vertex start, Vertex target) {
            Queue<Vertex> queue = new LinkedList<Vertex>();
            Map<Integer, Integer> path = new HashMap<Integer, Integer>();
            queue.add(start);
            start.visited = true;
            //Поехали искать
            while(!queue.isEmpty()) {
                Vertex vertex = queue.poll();
                int neighborNumber;
                while((neighborNumber=getAdjUnvisitedVertex(vertex.number)) != -1){
                    vertexList[neighborNumber].visited = true; // Пометка
                    queue.add(vertexList[neighborNumber]);
                    path.put(neighborNumber, vertex.number);
                    if (neighborNumber == target.number) {
                        System.out.println("Found!");

                        //Вывод пути
                        Integer locationNumber = path.get(target.number);
                        System.out.println(target.number);
                        while (!locationNumber.equals(start.number)) {
                            System.out.println(locationNumber);
                            locationNumber = path.get(locationNumber);
                        }
                        System.out.println(start.number);
                        return true;
                    }
                }
            }
            System.out.println("Not Found!");

            return false;
        }

        private int getAdjUnvisitedVertex(int number){
            for (int i = 0; i < size; i++) {
                if(adjMat[number][i] == 1 && !vertexList[i].visited){
                    return i;
                }
            }
            return -1;
        }

        static class Vertex {
            public int number;
            public boolean visited;

            public Vertex(int number) {
                this.number = number;
                this.visited = false;
            }

            @Override
            public String toString() {
                return "Vertex N { " + number + "}";
            }
        }
    }
}