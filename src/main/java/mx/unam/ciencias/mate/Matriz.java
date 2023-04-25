package mx.unam.ciencias.mate;

public class Matriz{

    public static void main(String[] args) {
        Mtz matriz = new Mtz(6,7);
        Lector lector = new Lector();
        Lista<Integer> lista = new Lista<>();
        lista = lector.lector(args[0]);
        
        matriz.llenarmatriz(lista);
        
        
        Escalonado.escalonar(matriz);
    }
}