package datastructure;

import java.util.*;
import java.util.ArrayList;

public class Graph {
    private final Map<Vertex, List<Vertex>> adjVertices = new HashMap<>();

    public void addVertex(Vertex vertex) {
        if (!adjVertices.containsKey(vertex))
            adjVertices.put(vertex, new ArrayList<>());
    }

    public void removeVertex(Vertex vertex) {
        adjVertices.remove(vertex);
    }

    public List<Vertex> getAdjVertices(Vertex vertex) {
        if(!adjVertices.containsKey(vertex))
            return null;
        return adjVertices.get(vertex);
    }

    public Set<Vertex> getVertices() {
        return adjVertices.keySet();
    }

    public void addEdge(Vertex vertex1, Vertex vertex2) {
        adjVertices.get(vertex1).add(vertex2);
        adjVertices.get(vertex2).add(vertex1);
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        List<Vertex> vertices1 = adjVertices.get(vertex1);
        List<Vertex> vertices2 = adjVertices.get(vertex2);
        if (vertices1 != null)
            vertices1.remove(vertex2);
        if (vertices2 != null)
            vertices2.remove(vertex1);
    }

    /**
     * TODO: How to travel from left to right?
     * */
    public Set<String> depthFirstTraversal(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> vertexStack = new Stack<>();

        vertexStack.push(root);
        while (!vertexStack.isEmpty()) {
            String vertex = vertexStack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : this.getAdjVertices(new Vertex(vertex))) {
                    if (!visited.contains(v.getLabel()))
                        vertexStack.push(v.getLabel());
                }
            }
        }

        return visited;
    }

    public Set<String> breadthFirstTraversal(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> vertexQueue = new ArrayDeque<>();
        vertexQueue.add(root);

        while (!vertexQueue.isEmpty()) {
            String vertex = vertexQueue.poll();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : this.getAdjVertices(new Vertex(vertex))) {
                    vertexQueue.add(v.getLabel());
                }
            }
        }

        return visited;
    }


}
