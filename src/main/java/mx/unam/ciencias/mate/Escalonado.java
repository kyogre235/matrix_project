package mx.unam.ciencias.mate;
public class Escalonado {
    protected static void escalonar(Mtz matriz){
        Mtz mtz = matriz;
        mtz = ordenar(mtz);
        
        int i = 0;
        int j = 0;
        int seguridad = 0;
        while(!verifica(mtz)){
            while(mtz.matriz[i][j]== 0){
                mtz.recorrerRenglon(i);
            }
            while(mtz.matriz[i+1][j] != 0){
                int a = mtz.matriz[i][j];
                int b = mtz.matriz[i+1][j];
                int mcm = mcm(a,b);
                int x = mcm/a;
                int y = mcm/b;
                mtz.multiplicarRenglon(i, x);
                mtz.multiplicarRenglon(i+1, y);
                mtz.restarRenglon(i+1, i);
                mtz.recorrerRenglon(i+1);
            }
            mtz.recorrerRenglon(i+1);
            i++;
            j++;
            
            if(i==mtz.filasNum-1||j==mtz.columnasNum){
                i = 0;
                j = 0;
                //seguridad++;
            }
            
            if(seguridad == 20)
                break;
        }
        
            mtz.imprimirMatriz();

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

    protected static int mcm(int num1, int num2) {
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);
     
        int resultado = (a / mcd(num1, num2)) * b;
         
        return resultado;
     
    }

    protected static int mcd(int num1, int num2) {
 
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
    protected static boolean verifica(Mtz matriz){
        int a = 1;
        boolean escalonado = true;
        for(int j = 0; j < matriz.columnasNum; j++){
            for(int i = a; i < matriz.filasNum;i++){
                if(matriz.matriz[i][j] != 0){
                    escalonado = false;
                    break;
                }  
            }
        a++;
        if(!escalonado)
            break;
        }
        return escalonado;
    }
    
}
