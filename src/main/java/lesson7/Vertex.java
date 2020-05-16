package lesson7;

import java.util.Objects;

public class Vertex {

  private final String label;
  private boolean visited;
  private Vertex predecessor;

  public Vertex(String label) {
    this.label = label;
  }

  public Vertex getPredecessor() {
    return predecessor;
  }

  public void setPredecessor(Vertex predecessor) {
    this.predecessor = predecessor;
  }

  public String getLabel() {
    return label;
  }

  @Override
  public String toString() {
    return "Vertex{" +
        "label='" + label + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vertex vertex = (Vertex) o;
    return Objects.equals(label, vertex.label);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label);
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }
}
