package mx.unam.ciencias.mate;



public class MatrizGPT {


    public static int[][] matrizEscalonada(int[][] matriz) {
        int numFilas = matriz.length;
        int numColumnas = matriz[0].length;
    
        int filaActual = 0;
    
        for (int columna = 0; columna < numColumnas; columna++) {
            int filaNoNula = -1;
    
            for (int fila = filaActual; fila < numFilas; fila++) {
                if (matriz[fila][columna] != 0) {
                    filaNoNula = fila;
                    break;
                }
            }
    
            if (filaNoNula == -1) {
                continue;
            }
    
            if (filaNoNula != filaActual) {
                int[] temp = matriz[filaNoNula];
                matriz[filaNoNula] = matriz[filaActual];
                matriz[filaActual] = temp;
            }
    
            int elementoPrincipal = matriz[filaActual][columna];
            for (int c = columna; c < numColumnas; c++) {
                matriz[filaActual][c] /= elementoPrincipal;
            }
    
            for (int f = filaActual + 1; f < numFilas; f++) {
                int factor = matriz[f][columna];
                for (int c = columna; c < numColumnas; c++) {
                    matriz[f][c] -= factor * matriz[filaActual][c];
                }
            }
    
            filaActual++;
        }
    
        return matriz;
    }
    
}
