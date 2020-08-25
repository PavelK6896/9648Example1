package graph2;

public class Main {

    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph();
        weightedGraph.create(weightedGraph);

        //декстра обход с подщетом веса ребер до вершины от начальной
        System.out.println(Dijkstra.dijkstra("1", weightedGraph.getAdjMap()));

        //просто поиск всех вершин кратчайшего пути по весу
        System.out.println(Dijkstra.dijkstraQuick("1", "5", weightedGraph.getAdjMap()));
    }
}
