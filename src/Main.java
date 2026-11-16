public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();
        parte1(g);
        parte2a(g);
        parte2b(g);
        parte3(g);
    }

    // ===== E2 =====
    static void parte1(Grafo g) {
        System.out.println("=== PARTE 1: CONSTRUIR ===");
        String[] equipos = { "Router", "Switch", "PC1", "PC2", "Impresora", "Servidor" };
        for (String e : equipos)
            g.insertarVertice(e);

        g.insertarArista("Router", "Switch", 1);
        g.insertarArista("Router", "Servidor", 4);
        g.insertarArista("Switch", "PC1", 2);
        g.insertarArista("Switch", "PC2", 2);
        g.insertarArista("PC2", "Impresora", 3);
        g.insertarArista("Servidor", "PC2", 5);

        g.mostrar();
        System.out.println("insertarVertice(Router) repetido: " + g.insertarVertice("Router"));
        System.out.println("insertarArista(PC1, Proyector, 3): " + g.insertarArista("PC1", "Proyector", 3));
    }

    // ===== E3 =====
    static void parte2a(Grafo g) {
        System.out.println("\n=== PARTE 2: CONSULTAR ===");
        g.bfs("Router");
        System.out.println("grado(Router) = " + g.grado("Router"));
        System.out.println("grado(Switch) = " + g.grado("Switch"));
        System.out.println("grado(Impresora) = " + g.grado("Impresora"));
        System.out.println("grado(Camara) = " + g.grado("Camara") + "  (no existe)");
    }

    // ===== E4 =====
    static void parte2b(Grafo g) {
        // TODO E4
    }

    // ===== E5 =====
    static void parte3(Grafo g) {
        System.out.println("\n=== PARTE 3: DECIDIR ===");
        System.out.println("eliminarVertice(Switch): " + g.eliminarVertice("Switch"));
        g.mostrar();
        System.out.println("esConexo(Router): " + g.esConexo("Router"));
        g.noAlcanzables("Router");

        System.out.println("\n-- Reconectando con 2 enlaces nuevos --");
        System.out.println(g.insertarArista("Router", "PC1", 2));
        System.out.println(g.insertarArista("Router", "PC2", 2));
        g.mostrar();
        System.out.println("esConexo(Router): " + g.esConexo("Router"));
        g.noAlcanzables("Router");
    }
}