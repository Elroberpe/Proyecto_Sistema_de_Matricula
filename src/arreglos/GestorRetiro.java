package arreglos;

import java.io.*;
import java.util.ArrayList;

import clases.Matricula;
import clases.Retiro;

public class GestorRetiro {


    private int contadorCorrelativo = 200001;

    private ArrayList<Retiro> listaRetiros;
    private final String RUTA_ARCHIVO = "retiros.txt";

    public GestorRetiro() {
        listaRetiros = new ArrayList<>();
        cargarDatos(); 
    }

    public int obtenerSiguienteCodigo() {
        return contadorCorrelativo;
    }

    public void adicionar(Retiro nuevoRetiro) {
        listaRetiros.add(nuevoRetiro);
        guardarDatos();
        contadorCorrelativo++; 
    }

    public ArrayList<Retiro> obtenerRetiros() {
        return listaRetiros;
    }
    
    public Retiro obtenerRetiro(int numeroDeRetiro) {
    	for(Retiro r : listaRetiros) {
    		if (r.getNumRetiro() == numeroDeRetiro) {
    			return r;
    		}		
    	}
    	return null;   	
    }
    
  public boolean eliminarRetiro(int numeroRetiro) {
    	
    	Retiro retiro = obtenerRetiro(numeroRetiro);
    	if(retiro!= null) {
    		listaRetiros.remove(retiro);
    		guardarDatos();
    		return true;
    	}
    	return false;
    	
    }
    
    public boolean yaTieneRetiro(int numMatricula) {

        for (Retiro r : listaRetiros) {
            if (r.getNumMatricula() == numMatricula) {
                return true;
            }
        }

        return false;
    }

    private void cargarDatos() {
        try {
            File archivo = new File(RUTA_ARCHIVO);
            
            if (archivo.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;
                
                int mayorCodigo = 200000;

                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(",");
                    
                    Retiro r = new Retiro(
                            Integer.parseInt(partes[0]),
                            Integer.parseInt(partes[1]),
                            partes[2],
                            partes[3]
                    );
                    
                    listaRetiros.add(r);

                    if (r.getNumRetiro() > mayorCodigo) {
                        mayorCodigo = r.getNumRetiro();
                    }
                }
                
                contadorCorrelativo = mayorCodigo + 1;
                br.close();
            }
        } catch (Exception e) {
            System.out.println("Error al cargar retiros: " + e.getMessage());
        }
    }

    private void guardarDatos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (Retiro r : listaRetiros) {
                writer.println(r.toLineArchivo());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar retiro: " + e.getMessage());
        }
    }
}