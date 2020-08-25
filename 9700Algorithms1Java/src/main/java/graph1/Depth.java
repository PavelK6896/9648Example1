package graph1;

import java.util.*;

public class Depth {//Глубина обойти все вершины

    public static Set<Vertex> depthFirstSearch(Vertex root, Map<Vertex, List<Vertex>> adjMap) {

        Set<Vertex> visited = new LinkedHashSet<>();

        Stack<Vertex> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            Vertex vert = stack.pop();//извлекаем верхний

            if (!visited.contains(vert)) {
                visited.add(vert);//список посищенных

                adjMap.get(vert).forEach(stack::push);//посетить все остальные
            }
        }

        return visited;
    }
}
