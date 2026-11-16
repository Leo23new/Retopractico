# Reto: La red del laboratorio

Grafo dirigido con multilistas (Vertice, Arista, Grafo). Java, sin HashMap/ArrayList/librerías.

## Ejecutar
javac -d out src/*.java
java -cp out Main

## Parte 3: respuestas
**Estado antes del fallo** (tras la Parte 2): Router→Switch(1), Router→Servidor(2),
Switch→PC1(2), Switch→PC2(2), PC2→Impresora(3).

**¿esConexo("Router") tras eliminar el Switch?** `false`.

**¿Qué equipos quedaron aislados (inalcanzables desde Router)?**
PC1, PC2 e Impresora. Solo se alcanzan Router y Servidor
(el enlace Servidor→PC2 ya se había eliminado en la Parte 2).

**¿Cuántos enlaces nuevos como mínimo?** 2.
Hay que alcanzar dos grupos independientes: {PC1} y {PC2, Impresora}.
Un solo enlace no basta porque PC1 y PC2 no están conectados entre sí,
y PC2 ya alcanza a Impresora, por eso con llegar a PC2 basta.
Enlaces agregados: Router→PC1 (2 ms) y Router→PC2 (2 ms).

**Comprobación:** esConexo("Router") = `true`.

## Código de grado(id)
(pegar aquí el método de E3)

## Capturas
Ver carpeta /capturas