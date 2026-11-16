public class Arista {
    Vertice destino;
    int latencia;
    Arista sig;        // siguiente arista del mismo vértice

    public Arista(Vertice destino, int latencia) {
        this.destino = destino;
        this.latencia = latencia;
    }
}