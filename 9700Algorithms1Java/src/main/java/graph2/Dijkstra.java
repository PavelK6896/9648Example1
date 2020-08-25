package graph2;

import java.util.*;
import java.util.stream.Collectors;

public class Dijkstra {

    public static Map<Vertex, Integer> dijkstra(String startLabel,  Map<Vertex, List<Edge>> adjMap) {
        Vertex startVertex = new Vertex(startLabel);

        Map<Vertex, Integer> result = adjMap.keySet().stream() // новая мапа с весом всех ребер вершины
                .collect(Collectors.toMap(
                        vert -> vert,
//                        если сама вершина то 0
                        vert -> vert.equals(startVertex) ? 0 : Integer.MAX_VALUE));
        //приоретентная очередь
        //прописываеться компаратор
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(result::get));
        queue.add(startVertex);
        Set<Vertex> settled = new HashSet<>();
        while (!queue.isEmpty()) {//перебераем всю очередь
            Vertex currVert = queue.poll(); //извлекаем с конца //по  компоратору с минимальным весом

            int currDist = result.get(currVert);//получаем вес

            if (settled.contains(currVert)) {//если уже посищали
                continue;
            }
            settled.add(currVert);//говарим что посетили
            for (Edge edge : adjMap.get(currVert)) {// посищаем соседий с минимальным значение
                Vertex neighborVert = edge.getVertex();
                int neighborDist = result.get(neighborVert);
                if (settled.contains(edge.getVertex())) {
                    continue;
                }
                //ослабленеи проверка
                if (neighborDist == Integer.MAX_VALUE || neighborDist > currDist + edge.getWeight()) {
                    result.put(neighborVert, currDist + edge.getWeight());//обновляем значение в мапе
                    queue.add(neighborVert); // снова добовляем в очередь
                }
            }
        }
        return result;
    }

    public static List<Vertex> dijkstraQuick(String startLabel, String endLabel, Map<Vertex, List<Edge>> adjMap) {
        Vertex startVertex = new Vertex(startLabel);

        Map<Vertex, Integer> result = adjMap.keySet().stream() // новая мапа с весом всех ребер вершины
                .collect(Collectors.toMap(
                        vert -> vert,
//                        если сама вершина то 0
                        vert -> vert.equals(startVertex) ? 0 : Integer.MAX_VALUE));

        Map<Vertex, Vertex> prevMap = new HashMap<>();

        //приоретентная очередь
        //прописываеться компаратор
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(result::get));


        queue.add(startVertex);

        Set<Vertex> settled = new HashSet<>();

        while (!queue.isEmpty()) {//перебераем всю очередь
            Vertex currVert = queue.poll(); //извлекаем с конца //по  компоратору с минимальным весом

            int currDist = result.get(currVert);//получаем вес

            if (settled.contains(currVert)) {//если уже посищали
                continue;
            }

            settled.add(currVert);//говарим что посетили

            for (Edge edge : adjMap.get(currVert)) {// посищаем соседий с минимальным значение
                Vertex neighborVert = edge.getVertex();
                int neighborDist = result.get(neighborVert);

                if (settled.contains(edge.getVertex())) {
                    continue;
                }

                //ослабленеи проверка
                if (neighborDist == Integer.MAX_VALUE || neighborDist > currDist + edge.getWeight()) {

                    result.put(neighborVert, currDist + edge.getWeight());//обновляем значение в мапе
                    queue.add(neighborVert); // снова добовляем в очередь
                    prevMap.put(neighborVert, currVert);
                }


            }

        }

        //поиск короткого пути
        Stack<Vertex> stack = new Stack<>();
        stack.push(new Vertex(endLabel));
        Vertex curr = prevMap.get(new Vertex(endLabel));
        while (curr != null) {
            stack.push(curr);
            curr = prevMap.get(curr);
        }

        List<Vertex> path = new ArrayList<>();
        while (!stack.isEmpty()) {
            path.add(stack.pop());
        }


        return path;
    }
}
