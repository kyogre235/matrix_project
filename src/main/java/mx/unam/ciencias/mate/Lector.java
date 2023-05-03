package mx.unam.ciencias.mate;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Lector {
  
    public Lista<Integer> lector(String archivo){
        Linea linea = new Linea("");
        Lista<Integer> lista = new Lista<>();
        String l = "";
        try (BufferedReader lectorplano = new BufferedReader(new FileReader(archivo))) {   
            String lineaActual;  

            while ((lineaActual = lectorplano.readLine()) != null){
                if(!lineaActual.contains("#")){
                    l = l + lineaActual + " ";
                }   
            }
            lectorplano.close();
            linea = new Linea(l); 
            
            lista = Linea.creadorEsc(linea.getLineaPlana());
            

            return lista;
        } catch (IOException e) {  
            System.err.println("este archivo no existe, revisa que no este bien escrito");
            System.exit(0);
        }
        return lista;
    }

    public int filas(String archivo){
        Linea linea = new Linea("");
        Lista<Integer> lista = new Lista<>();
        String l = "";
        try (BufferedReader lectorplano = new BufferedReader(new FileReader(archivo))) {   
            String lineaActual;  

            while ((lineaActual = lectorplano.readLine()) != null){
                if(lineaActual.contains("#")){
                    l = l + lineaActual + " ";
                }   
            }
            lectorplano.close();
            linea = new Linea(l); 
            
            lista = Linea.creadorEsc(linea.getLineaPlana());
            

            return lista.eliminaPrimero();
        } catch (IOException e) {  
            System.err.println("este archivo no existe, revisa que no este bien escrito");
            System.exit(0);
        }
        Integer regreso = lista.eliminaPrimero();
        int regreso2 = regreso.intValue(); 
        return regreso2; 
    }

    public int columnas(String archivo){
        Linea linea = new Linea("");
        Lista<Integer> lista = new Lista<>();
        String l = "";
        try (BufferedReader lectorplano = new BufferedReader(new FileReader(archivo))) {   
            String lineaActual;  

            while ((lineaActual = lectorplano.readLine()) != null){
                if(lineaActual.contains("&")){
                    l = l + lineaActual + " ";
                }   
            }
            lectorplano.close();
            linea = new Linea(l); 
            
            lista = Linea.creadorEsc(linea.getLineaPlana());
            

            return lista.eliminaPrimero();
        } catch (IOException e) {  
            System.err.println("este archivo no existe, revisa que no este bien escrito");
            System.exit(0);
        }
        
        Integer regreso = lista.eliminaPrimero();
        int regreso2 = regreso.intValue(); 
        return regreso2;
    }

}
