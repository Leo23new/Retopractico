public class Grafo {
    Vertice cabeza;
    int n;

    // ===== E1 =====
    public Vertice buscar(String id) {
        for (Vertice v = cabeza; v != null; v = v.sig) {
            if (v.id.equals(id)) return v;
        }
        return null;
    }

    // ===== E2 =====
    public boolean insertarVertice(String id) {
        return false; // TODO E2
    }

    // ===== E2 =====
    public boolean insertarArista(String origen, String destino, int latencia) {
        return false; // TODO E2
    }

    // ===== E2 =====
    public void mostrar() {
        // TODO E2
    }

    // ===== E3 =====
    private int recorrer(String id, boolean imprimir) {
        return 0; // TODO E3
    }

    // ===== E3 =====
    public void bfs(String id) {
        // TODO E3
    }

    // ===== E3 =====
    public int grado(String id) {
        return -1; // TODO E3
    }

    // ===== E4 =====
    public boolean modificarLatencia(String origen, String destino, int nueva) {
        return false; // TODO E4
    }

    // ===== E4 =====
    public boolean eliminarArista(String origen, String destino) {
        return false; // TODO E4
    }

    // ===== E4 =====
    public boolean eliminarVertice(String id) {
        return false; // TODO E4
    }

    // ===== E4 =====
    public boolean esConexo(String id) {
        return false; // TODO E4
    }

    // ===== E5 =====
    public void noAlcanzables(String id) {
        // TODO E5
    }
}