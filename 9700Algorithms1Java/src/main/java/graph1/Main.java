package graph1;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.create(graph);


        //посетить все вершины в графе
        //Глубина
        System.out.println(Depth.depthFirstSearch(new Vertex("1Bob") , graph.getAdjMap()));

        //Ширина
        System.out.println(Breadth.breadthFirstSearch(new Vertex("1Bob"), graph.getAdjMap()));

    }
}
