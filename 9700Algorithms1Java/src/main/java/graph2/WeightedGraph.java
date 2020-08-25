package graph2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeightedGraph { //Взвешенный

    private Map<Vertex, List<Edge>> adjMap;

    public WeightedGraph() {
        this.adjMap = new HashMap<>();
    }

    public void addVertex(String label) {
        adjMap.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);

        //удаляем связи
        adjMap.values().forEach(list -> list.remove(v));
        //удаляем вершину
        adjMap.remove(v);
    }

    public void addEdge(String label1, String label2, int weight) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        Edge e1 = new Edge(v1, weight);
        Edge e2 = new Edge(v2, weight);
        adjMap.get(v1).add(e2);
        adjMap.get(v2).add(e1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Edge> ev1 = adjMap.get(v1);
        List<Edge> ev2 = adjMap.get(v2);

        if (ev1 != null) {
            ev1.removeAll(ev1.stream()
                    .filter(edge -> edge.getVertex().equals(v2))
                    .collect(Collectors.toList()));
        }

        if (ev2 != null) {
            ev2.removeAll(ev2.stream()
                    .filter(edge -> edge.getVertex().equals(v1))
                    .collect(Collectors.toList()));
        }
    }


    public void create(WeightedGraph weightedGraph) {

        weightedGraph.addVertex("1");
        weightedGraph.addVertex("2");
        weightedGraph.addVertex("3");
        weightedGraph.addVertex("4");
        weightedGraph.addVertex("5");
        weightedGraph.addVertex("6");
        weightedGraph.addVertex("7");

        weightedGraph.addEdge("1", "2", 7);
        weightedGraph.addEdge("1", "3", 9);
        weightedGraph.addEdge("1", "6", 14);
        weightedGraph.addEdge("2", "3", 10);
        weightedGraph.addEdge("2", "4", 15);
        weightedGraph.addEdge("3", "6", 2);
        weightedGraph.addEdge("3", "4", 11);
        weightedGraph.addEdge("4", "5", 6);
        weightedGraph.addEdge("5", "6", 9);
        weightedGraph.addEdge("6", "7", 5);
    }

    public Map<Vertex, List<Edge>> getAdjMap() {
        return adjMap;
    }

    public void setAdjMap(Map<Vertex, List<Edge>> adjMap) {
        this.adjMap = adjMap;
    }
}
