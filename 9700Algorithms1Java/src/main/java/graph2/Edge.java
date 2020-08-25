package graph2;

public class Edge { //Край ребро

    private Vertex vertex;
    private int weight;

    public Edge(Vertex vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public int getWeight() {
        return weight;
    }
}
