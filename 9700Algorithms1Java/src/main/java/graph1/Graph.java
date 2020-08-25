package graph1;

import java.util.*;

public class Graph { //граф не направленный

    private final Map<Vertex, List<Vertex>> adjMap; // вершины и ребра

    public Graph() {
        this.adjMap = new HashMap<>();
    }

    public Map<Vertex, List<Vertex>> getAdjMap() {
        return adjMap;
    }

    public void addVertex(String label) {
        //проверка по ключю если нет то создание
        adjMap.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);

        //удаляем связи
        adjMap.values().forEach(list -> list.remove(v));
        //удаляем вершину
        adjMap.remove(v);
    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        //находи по ключю и добовляем в лист ребро связь
        adjMap.get(v1).add(v2);

        adjMap.get(v2).add(v1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        List<Vertex> ev1 = adjMap.get(v1);
        List<Vertex> ev2 = adjMap.get(v2);

        //удаляет сязь ребро
        if (ev1 != null) {
            ev1.remove(v2);
        }
        if (ev2 != null) {
            ev2.remove(v1);
        }
    }

    public void create(Graph graph) {
        //вершины
        graph.addVertex("1Bob");
        graph.addVertex("2Alice");
        graph.addVertex("3Mark");
        graph.addVertex("4Rob");
        graph.addVertex("5Maria");

        //связи или ребра
        graph.addEdge("1Bob", "2Alice");
        graph.addEdge("1Bob", "4Rob");

        graph.addEdge("2Alice", "3Mark");
        graph.addEdge("2Alice", "5Maria");

        graph.addEdge("4Rob", "3Mark");
        graph.addEdge("4Rob", "5Maria");
    }

}
