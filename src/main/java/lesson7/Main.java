package lesson7;

public class Main {

  public static void main(String[] args) {
//        testGraph();
//        testDfs();
    testBfs();
  }

  private static void testBfs() {
    Graph graph = new Graph(10);

    String msk = "Москва";
    String tmb = "Тамбов";
    String tul = "Тула";
    String rzn = "Рязань";
    String klg = "Калуга";
    String lpk = "Липецк";
    String orl = "Орел";
    String srv = "Саратов";
    String krk = "Курск";
    String vrzh = "Воронеж";

    graph.addVertex(msk);
    graph.addVertex(tul);
    graph.addVertex(rzn);
    graph.addVertex(klg);
    graph.addVertex(lpk);
    graph.addVertex(tmb);
    graph.addVertex(orl);
    graph.addVertex(srv);
    graph.addVertex(krk);
    graph.addVertex(vrzh);

    graph.addEdges(msk, tul, rzn, klg);
    graph.addEdges(tul, lpk);
    graph.addEdges(rzn, tmb);
    graph.addEdges(klg, orl);
    graph.addEdges(lpk, vrzh);
    graph.addEdges(tmb, srv);
    graph.addEdges(orl, krk);
    graph.addEdges(srv, vrzh);
    graph.addEdges(krk, vrzh);

    graph.bfs(msk, vrzh);
  }

  private static void testDfs() {
    Graph graph = new Graph(7);
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addVertex("D");
    graph.addVertex("E");
    graph.addVertex("F");
    graph.addVertex("G");

    graph.addEdges("A", "B", "C", "D");
    graph.addEdges("B", "E");
    graph.addEdges("D", "F");
    graph.addEdges("F", "G");

    graph.dfs("A");
    //A B E C D F G
  }

  private static void testGraph() {
    Graph graph = new Graph(4);
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addVertex("D");

    graph.addEdges("A", "B", "C");
    graph.addEdges("B", "A", "C", "D");
    graph.addEdges("C", "A", "B", "D");
    graph.addEdges("D", "B", "C");

    System.out.println("Size of graph is " + graph.getSize());
    graph.display();
  }
}
