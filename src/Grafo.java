public class Grafo {
    Vertice cabeza;
    int n;

    // ===== E1 =====
    public Vertice buscar(String id) {
        for (Vertice v = cabeza; v != null; v = v.sig) {
            if (v.id.equals(id))
                return v;
        }
        return null;
    }

    public boolean insertarVertice(String id) {
        if (id == null || buscar(id) != null)
            return false;
        Vertice nuevo = new Vertice(id);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Vertice aux = cabeza;
            while (aux.sig != null)
                aux = aux.sig;
            aux.sig = nuevo;
        }
        n++;
        return true;
    }

    // ===== E2 =====
    public boolean insertarArista(String origen, String destino, int latencia) {
        Vertice vo = buscar(origen);
        Vertice vd = buscar(destino);
        if (vo == null || vd == null || latencia <= 0)
            return false;
        Arista ult = null;
        for (Arista a = vo.ady; a != null; a = a.sig) {
            if (a.destino == vd)
                return false; // ya existe
            ult = a;
        }
        Arista nueva = new Arista(vd, latencia);
        if (ult == null)
            vo.ady = nueva;
        else
            ult.sig = nueva;
        return true;
    }

    // ===== E2 =====
    public void mostrar() {
        for (Vertice v = cabeza; v != null; v = v.sig) {
            System.out.print(v.id + " -> ");
            if (v.ady == null)
                System.out.print("(sin enlaces)");
            for (Arista a = v.ady; a != null; a = a.sig) {
                System.out.print(a.destino.id + "(" + a.latencia + "ms)");
                if (a.sig != null)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }

    // ===== E3 =====
    private int recorrer(String id, boolean imprimir) {
        for (Vertice v = cabeza; v != null; v = v.sig) v.visitado = false;
        Vertice inicio = buscar(id);
        if (inicio == null) return 0;

        Vertice[] cola = new Vertice[n];
        int frente = 0, fin = 0, cont = 0;
        cola[fin++] = inicio;
        inicio.visitado = true;

        while (frente < fin) {
            Vertice actual = cola[frente++];
            cont++;
            if (imprimir) System.out.print(actual.id + (frente < n ? " " : ""));
            for (Arista a = actual.ady; a != null; a = a.sig) {
                if (!a.destino.visitado) {
                    a.destino.visitado = true;
                    cola[fin++] = a.destino;
                }
            }
        }
        if (imprimir) System.out.println();
        return cont;
    }


    // ===== E3 =====
    public void bfs(String id) {
        if (buscar(id) == null) {
            System.out.println("bfs: el equipo '" + id + "' no existe");
            return;
        }
        System.out.print("BFS desde " + id + ": ");
        recorrer(id, true);
    }

    // ===== E3 =====
    public int grado(String id) {
        Vertice v = buscar(id);
        if (v == null) return -1;
        int cont = 0;
        for (Arista a = v.ady; a != null; a = a.sig) cont++;
        return cont;
    }

    // ===== E4 =====
    public boolean modificarLatencia(String origen, String destino, int nueva) {
        Vertice vo = buscar(origen);
        if (vo == null || nueva <= 0) return false;
        for (Arista a = vo.ady; a != null; a = a.sig) {
            if (a.destino.id.equals(destino)) {
                a.latencia = nueva;
                return true;
            }
        }
        return false;
    }

    // ===== E4 =====
    public boolean eliminarArista(String origen, String destino) {
        Vertice vo = buscar(origen);
        if (vo == null) return false;
        Arista ant = null;
        for (Arista a = vo.ady; a != null; ant = a, a = a.sig) {
            if (a.destino.id.equals(destino)) {
                if (ant == null) vo.ady = a.sig;
                else ant.sig = a.sig;
                return true;
            }
        }
        return false;
    }

    // ===== E4 =====
    public boolean eliminarVertice(String id) {
        Vertice objetivo = buscar(id);
        if (objetivo == null) return false;
        // 1) quitar todas las aristas que LLEGAN al vértice
        for (Vertice v = cabeza; v != null; v = v.sig) {
            if (v != objetivo) eliminarArista(v.id, id);
        }
        // 2) quitar el vértice de la lista (sus aristas salientes se van con él)
        if (cabeza == objetivo) {
            cabeza = cabeza.sig;
        } else {
            Vertice ant = cabeza;
            while (ant.sig != objetivo) ant = ant.sig;
            ant.sig = objetivo.sig;
        }
        n--;
        return true;
    }

    // ===== E4 =====
    // true si desde 'id' se puede llegar a TODOS los equipos
    public boolean esConexo(String id) {
        if (buscar(id) == null) return false;
        return recorrer(id, false) == n;
    }

    // ===== E5 =====
    public void noAlcanzables(String id) {
        recorrer(id, false);
        System.out.print("No alcanzables desde " + id + ": ");
        boolean alguno = false;
        for (Vertice v = cabeza; v != null; v = v.sig) {
            if (!v.visitado) {
                System.out.print(v.id + " ");
                alguno = true;
            }
        }
        System.out.println(alguno ? "" : "(ninguno)");
    }

}