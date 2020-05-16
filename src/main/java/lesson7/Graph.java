package lesson7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

  private final List<Vertex> vertexList;
  private final boolean[][] adjMat;

  public Graph(int maxVertexCount) {
    this.vertexList = new ArrayList<>(maxVertexCount);
    this.adjMat = new boolean[maxVertexCount][maxVertexCount];
  }

  public void addVertex(String label) {
    vertexList.add(new Vertex(label));
  }

  public void addEdges(String start, String second, String... other) {
    addEdge(start, second);
    for (String another : other) {
      addEdge(start, another);
    }
  }

  private void addEdge(String start, String finish) {
    int startIndex = indexOf(start);
    int finishIndex = indexOf(finish);

    if (startIndex == -1 || finishIndex == -1) {
      throw new IllegalArgumentException("Invalid label for edge");
    }

    adjMat[startIndex][finishIndex] = true;
    adjMat[finishIndex][startIndex] = true;
  }

  private int indexOf(String vertexLabel) {
    for (int i = 0; i < vertexList.size(); i++) {
      if (vertexLabel.equals(vertexList.get(i).getLabel())) {
        return i;
      }
    }

    return -1;
  }

  public int getSize() {
    return vertexList.size();
  }

  private void displayVertex(Vertex vertex) {
    System.out.println(vertex);
  }

  public void display() {
    for (int i = 0; i < getSize(); i++) {
      System.out.print(vertexList.get(i));
      for (int j = 0; j < getSize(); j++) {
        if (adjMat[i][j]) {
          System.out.print(" -> " + vertexList.get(j));
        }
      }
      System.out.println();
    }
  }

  /**
   * англ. Depth-first search, DFS
   *
   * @param startLabel
   */
  public void dfs(String startLabel) {
    int startIndex = indexOf(startLabel);
    if (startIndex == -1) {
      throw new IllegalArgumentException("Invalid start label");
    }

    Stack<Vertex> stack = new Stack<>();

    Vertex vertex = vertexList.get(startIndex);
    visitVertex(vertex, stack);

    while (!stack.isEmpty()) {
      vertex = getNearUnvisitedVertex(stack.peek());
      if (vertex != null) {
        visitVertex(vertex, stack);
      } else {
        stack.pop();
      }
    }

    resetVertexState();

  }

  /**
   * англ. breadth-first search, BFS
   *
   * @param startLabel
   */
  public void bfs(String startLabel, String endLabel) {
    int startIndex = indexOf(startLabel);
    if (startIndex == -1) {
      throw new IllegalArgumentException("Invalid start label");
    }

    Queue<Vertex> queue = new LinkedList<>();
    Vertex vertex = vertexList.get(startIndex);
    visitVertex(vertex, queue);
    while (!queue.isEmpty()) {

      vertex = getNearUnvisitedVertex(queue.peek());

      if (vertex != null) {
        if (vertex.getLabel().equals(endLabel)) {
          printWayBack(vertex);
          break;
        }
        visitVertex(vertex, queue);

      } else {
        queue.remove();
      }
    }

    resetVertexState();
  }

  private void printWayBack(Vertex vertex) {
    System.out.println();
    System.out.println("Your Path is");
    Stack<Vertex> vertices = new Stack<>();
    vertices.push(vertex);
    while (vertex.getPredecessor() != null) {
      vertex = vertex.getPredecessor();
      vertices.push(vertex);
    }
    while (!vertices.isEmpty()) {
      System.out.println(vertices.pop());
    }
    vertices.clear();
  }

  private void resetVertexState() {
    for (Vertex vertex : vertexList) {
      vertex.setVisited(false);
      vertex.setPredecessor(null);
    }
  }

  private Vertex getNearUnvisitedVertex(Vertex peek) {
    int peekIndex = vertexList.indexOf(peek);
    for (int i = 0; i < getSize(); i++) {
      if (adjMat[peekIndex][i] && !vertexList.get(i).isVisited()) {
        Vertex vertex = vertexList.get(i);
        vertex.setPredecessor(peek);
        return vertex;
      }
    }

    return null;
  }

  private void visitVertex(Vertex vertex, Stack<Vertex> stack) {
    displayVertex(vertex);
    stack.push(vertex);
    vertex.setVisited(true);
  }

  private void visitVertex(Vertex vertex, Queue<Vertex> queue) {

    queue.add(vertex);
    vertex.setVisited(true);
    displayVertex(vertex);
  }


}
