package graph1;

import java.util.*;

public class Breadth {//Ширина
    public static Set<Vertex> breadthFirstSearch(Vertex root,  Map<Vertex, List<Vertex>> adjMap) {

        Set<Vertex> visited = new LinkedHashSet<>();

        Queue<Vertex> queue = new LinkedList<>(); // Очередь

        queue.add(root);
        visited.add(root); // отметка элемент посищен

        while (!queue.isEmpty()) { //перебор очереди
            Vertex vert = queue.poll();//извлекаем нижний

            for (Vertex v : adjMap.get(vert)) {//перебор соседий
                if (!visited.contains(v)) { // если не посищен
                    visited.add(v); // в посищенные
                    queue.add(v);// в очередь
                }
            }
        }
        return visited;
    }
}
