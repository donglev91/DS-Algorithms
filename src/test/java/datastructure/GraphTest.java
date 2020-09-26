package datastructure;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class GraphTest {
    @Test
    public void addVertex_theSizeOfVerticesShouldIncreaseBy1() {
        Vertex vertex = new Vertex("one");
        Graph graph = new Graph();
        graph.addVertex(vertex);
        assert graph.getVertices().size() == 1;
    }

    @Test
    public void addVertex_thenRemoveVertex_theSizeOfVerticesShouldKeepTheSame() {
        Vertex vertex = new Vertex("one");
        Graph graph = new Graph();
        graph.addVertex(vertex);
        assert graph.getVertices().size() == 1;
        graph.removeVertex(vertex);
    }

    @Test
    public void addEdge_TheAdjVerticesShouldIncrease() {
        Vertex vertex1 = new Vertex("one");
        Vertex vertex2 = new Vertex("two");
        Graph graph = new Graph();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addEdge(vertex1, vertex2);
        assert graph.getAdjVertices(vertex1).size() == 1;
        assert "two".equals(graph.getAdjVertices(vertex1).get(0).getLabel());
        assert graph.getAdjVertices(vertex2).size() == 1;
        assert "one".equals(graph.getAdjVertices(vertex2).get(0).getLabel());
    }

    @Test
    public void addEdgeWithExistVertex_ShouldNullPointerException() {
        Vertex vertex1 = new Vertex("one");
        Vertex vertex2 = new Vertex("two");
        Graph graph = new Graph();
        Assert.assertThrows(NullPointerException.class,
                () -> graph.addEdge(vertex1, vertex2));
    }

    @Test
    public void addEdge_ThenRemove_TheAdjVerticesShouldKeepTheSame() {
        Vertex vertex1 = new Vertex("one");
        Vertex vertex2 = new Vertex("two");
        Graph graph = new Graph();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addEdge(vertex1, vertex2);
        Assert.assertEquals(1, graph.getAdjVertices(vertex1).size());
        Assert.assertEquals("two", graph.getAdjVertices(vertex1).get(0).getLabel());
        graph.removeEdge(vertex1, vertex2);
        Assert.assertEquals(0, graph.getAdjVertices(vertex1).size());
    }

    @Test
    public void depthFirstTraversal_shouldVisitFromRightToLeft_GoDeepestThenMoveToOther() {
        Vertex vertex1 = new Vertex("one");
        Vertex vertex2 = new Vertex("two");
        Vertex vertex3 = new Vertex("three");
        Vertex vertex4 = new Vertex("four");
        Vertex vertex5 = new Vertex("five");
        Graph graph = new Graph();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex2, vertex3);
        graph.addEdge(vertex1, vertex4);
        graph.addEdge(vertex1, vertex5);
        Set<String> visited = graph.depthFirstTraversal(vertex1.getLabel());
        Assert.assertEquals(5, visited.size());
        Assert.assertEquals("[one, five, four, two, three]", visited.toString());
    }

    @Test
    public void breadthFirstTraversal_shouldVisitBreadth() {
        Vertex vertex1 = new Vertex("one");
        Vertex vertex2 = new Vertex("two");
        Vertex vertex3 = new Vertex("three");
        Vertex vertex4 = new Vertex("four");
        Vertex vertex5 = new Vertex("five");
        Graph graph = new Graph();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex2, vertex3);
        graph.addEdge(vertex1, vertex4);
        graph.addEdge(vertex1, vertex5);
        Set<String> visited = graph.breadthFirstTraversal(vertex1.getLabel());
        Assert.assertEquals(5, visited.size());
        Assert.assertEquals("[one, two, four, five, three]", visited.toString());
    }
}
