public class Vertice {
    String id;
    Vertice sig;       // siguiente vértice (lista de vértices)
    Arista ady;        // primera arista saliente (lista de aristas)
    boolean visitado;  // marca para recorridos

    public Vertice(String id) {
        this.id = id;
    }
}