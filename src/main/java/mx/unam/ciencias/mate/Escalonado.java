package mx.unam.ciencias.mate;
public class Escalonado {
    public static void escalonar(Mtz matriz){
        Mtz mtz = matriz;
        mtz = ordenar(mtz);
        
        int i = 0;
        int j = 0;
        int seguridad = 0;
        
        for(j = 0; j < maxCol(matriz); j++){
            i = j;
            
            while(mtz.matriz[i][j] == 0){
                mtz.recorrerRenglon(i);
            }

            int a = mtz.matriz[i][j];
            int z = i;
            i++;

            while(i<mtz.filasNum){
                if(mtz.matriz[i][j]!=0){
                    int b = mtz.matriz[i][j];
                    int mcm = mcm(a,b);
                    int x = mcm/a;
                    int y = mcm/b;
                    
                    mtz.multiplicarRenglon(z, x);
                    a = mtz.matriz[z][j];
                    mtz.multiplicarRenglon(i, y);
                    mtz.restarRenglon(i, z);
                    i++;
                } else{
                    i++;
                }   
            }    
        }

        for(j = maxCol(matriz)-1; j >= 0; j--){
            i = j;
            
            int a = mtz.matriz[i][j];
            int z = i;
            i--;
            
            while(i>=0){
                if(mtz.matriz[i][j]!=0){
                    int b = mtz.matriz[i][j];
                    int mcm = mcm(a,b);
                    int x = mcm/a;
                    int y = mcm/b;
                    
                    mtz.multiplicarRenglon(z, x);
                    a = mtz.matriz[z][j];
                    mtz.multiplicarRenglon(i, y);
                    mtz.restarRenglon(i, z);
                    i--;
                } else{
                    i--;
                }
                
            }
    
        }
        
        mtz.imprimirMatriz();
        verifica(matriz);

    }

    private static Mtz ordenar(Mtz mtz) {
        Mtz aux = new Mtz(mtz.filasNum, mtz.columnasNum);
        int[] renglonVacio = new int[mtz.columnasNum];
        int a = 0;
        for(int i = 0; i<mtz.columnasNum; i++){
            for(int j = 0; j< mtz.filasNum; j++){
                if(mtz.matriz[j][i] != 0){
                    aux.matriz[a]= mtz.matriz[j];
                    a++;
                    mtz.matriz[j] = renglonVacio;
                
                }

            }
        }
        
        return aux;
    }
    

    private static int mcm(int num1, int num2) {
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);
     
        int resultado = (a / mcd(num1, num2)) * b;
         
        return resultado;
     
    }

    private static int mcd(int num1, int num2) {
 
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);
     
        int resultado = 0;
        do {
            resultado = b;
            b = a % b;
            a = resultado;
        } while (b != 0);
     
        return resultado;
         
    }
    private static void verifica(Mtz matriz){
        boolean solocero;
        for(int i=0; i<matriz.filasNum;i++){
            solocero = true;
            for(int j=0; j<matriz.columnasNum;j++){
                if(matriz.matriz[i][j] != 0 ){
                    solocero = false;
                }

            }
            if(solocero && matriz.matriz[i][matriz.columnasNum-1]  != 0){
                System.out.println("la matriz no tiene solucion");
            }
        }
        System.out.println("la matriz tiene solucion");
    }
    
    

    private static int maxCol(Mtz matriz){
       
        if(matriz.filasNum < matriz.columnasNum)
            return matriz.filasNum;
        
        return matriz.columnasNum;
    }
}
