package mx.unam.ciencias.mate;

public class Matriz{

    public static void main(String[] args) {
        Lector lector = new Lector();
        int i = lector.filas(args[0]);
        int j = lector.columnas(args[0]);
        Lista<Integer> lista = new Lista<>();
        Mtz matriz = new Mtz(i,j);
        lista = lector.lector(args[0]);
        
        matriz.llenarmatriz(lista);
        
        
        Escalonado.escalonar(matriz);
        //matriz.matriz = MatrizGPT.matrizEscalonada(matriz.matriz);
        //matriz.imprimirMatriz();
    }
}