package arreglos;

import java.io.*;
import java.util.ArrayList;
import clases.Matricula;

public class GestorMatricula {
	

	private int contadorCorrelativo = 100001;
	
    private ArrayList<Matricula> listaMatriculas;
    private final String RUTA_ARCHIVO = "matriculas.txt";

    public GestorMatricula() {
        listaMatriculas = new ArrayList<>();
        cargarDatos();
    }
    
    public int obtenerSiguienteCodigo() {
        return contadorCorrelativo;
    }
    
   
    public Matricula buscarPorNumero(int numMatriculaBuscado) {
        
        for (Matricula m : listaMatriculas) {
            if (m.getNumMatricula() == numMatriculaBuscado) {
                return m; 
            }
        }
        return null; 
    }
    
    
    
    public void adicionar(Matricula nuevaMatricula) {
        listaMatriculas.add(nuevaMatricula);
        guardarDatos();
        contadorCorrelativo++;
    }
    
    public ArrayList<Matricula> obtenerMatriculas() {
        return listaMatriculas;
    }
    
    public boolean cambiarCursoMatriculado(int numMatriculaBuscado, int nuevoCodCurso) {
        for (Matricula m : listaMatriculas) {
            if (m.getNumMatricula() == numMatriculaBuscado) {               
                m.setCodCurso(nuevoCodCurso);
                guardarDatos(); 
                return true; 
            }
        }
        return false; 
    }
    
    public boolean eliminarMatricula(int numMatriculaBuscado) {
    	
    	Matricula matricula = buscarPorNumero(numMatriculaBuscado);
    	if(matricula!= null) {
    		listaMatriculas.remove(matricula);
    		guardarDatos();
    		return true;
    	}
    	return false;
    	
    }
    

    public Matricula buscarPorAlumno(int codAlumnoBuscado) {
        for (Matricula m : listaMatriculas) {
            if (m.getCodAlumno() == codAlumnoBuscado) {
                return m; 
            }
        }
        return null; 
    }
    
    public boolean yaEstaMatriculado(int codAlumnoBuscado) {

        for (Matricula m : listaMatriculas) {
        	if (m.getCodAlumno() == codAlumnoBuscado) {
                return true; 
            }
        }
        
        return false; 
    }
    
    private void cargarDatos() {

        try {
            File archivo = new File(RUTA_ARCHIVO);
  
            if (archivo.exists()) {

                BufferedReader br = new BufferedReader( new FileReader(archivo));
                String linea;
                int mayorCodigo = 100000;

                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(",");
                    Matricula m = new Matricula(
                            Integer.parseInt(partes[0]),
                            Integer.parseInt(partes[1]),
                            Integer.parseInt(partes[2]),
                            partes[3],
                            partes[4]
                    );

                    listaMatriculas.add(m);

                    if (m.getNumMatricula() > mayorCodigo) {
                        mayorCodigo = m.getNumMatricula();
                    }
                }

                contadorCorrelativo = mayorCodigo + 1;
                br.close();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void guardarDatos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (Matricula m : listaMatriculas) {
                writer.println(m.toLineaArchivo()); 
            }
        } catch (IOException e) {
            System.out.println("Error al guardar matrícula: " + e.getMessage());
        }
    }
    
    
}