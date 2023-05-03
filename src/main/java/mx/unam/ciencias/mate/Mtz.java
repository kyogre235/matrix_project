package mx.unam.ciencias.mate;



public class Mtz {
    
    public int[][] matriz;
    public int filasNum;
    public int columnasNum;

    public Mtz(int Filas,int Columnas){

        matriz = new int[Filas][Columnas];
        filasNum = Filas;
        columnasNum = Columnas;
        
    }

    public void llenarmatriz(Lista<Integer> lista){
        for(int i = 0;i < filasNum;i++){
            for(int j = 0; j < columnasNum; j++){
                matriz[i][j] = lista.eliminaPrimero();
            }
        }
        
    }

    public void cambiarRenglones(int renglon1, int renglon2){
        int [] renglonAux = new int[columnasNum];
        renglonAux = matriz[renglon1];
        matriz[renglon1] = matriz[renglon2];
        matriz[renglon2] = renglonAux;
        
    }

    public void multiplicarRenglon(int renglon, int escalar){
        for(int i=0; i<columnasNum; i++){
            matriz[renglon][i] = matriz[renglon][i]*escalar;
        }
        
    }

    public void restarRenglon(int renglon1, int renglon2){
        int [] renglonAux = new int[columnasNum];

        for(int i=0; i<columnasNum; i++){
            renglonAux[i] = matriz[renglon1][i] - matriz[renglon2][i];
        }

        matriz[renglon1] = renglonAux;
        
    }

    public void imprimirMatriz(){
        for(int i=0; i<filasNum;i++){
            for(int j=0; j<columnasNum;j++){
                System.out.print(matriz[i][j]+"            ");
            }
            System.out.print("\n");
        }
    }
    public void recorrerRenglon(int renglon){
        int[] aux = matriz[renglon];

        for(int i=renglon; i<filasNum-1; i++){
            matriz[i] = matriz[i+1];
        }
        matriz[filasNum-1]= aux;
    }

    

}
