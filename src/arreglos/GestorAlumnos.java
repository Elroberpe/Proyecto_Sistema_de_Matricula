package arreglos;

import clases.Alumno;
import java.io.*;
import java.util.ArrayList;


public class GestorAlumnos {

	private int contadorCorrelativo = 202010001;
	private final String archivo = "alumnos.txt";
	private ArrayList<Alumno> listaAlumnos;
	
	public GestorAlumnos() {
	    listaAlumnos = new ArrayList<>();
	    cargarDatos();
	}
	
	public int obtenerSiguienteCodigo() {
	    return contadorCorrelativo;
	}
	
    public boolean agregarAlumno(Alumno alumno) {

        if (buscarAlumno(alumno.getCodAlumno()) != null) {
            return false;
        }

        listaAlumnos.add(alumno);
        guardarTodos();
        contadorCorrelativo++;
        return true;
    }


    public ArrayList<Alumno> listarAlumnos() {
    	return listaAlumnos;
    }


    public Alumno buscarAlumno(int codAlumno){
        for(Alumno a : listaAlumnos){
            if(a.getCodAlumno() == codAlumno){
                return a;
            }
        }
        return null;
    }
    
    public boolean existeDni(String dni, int codigoActual) {

        for (Alumno a : listaAlumnos) {
            if (a.getDni().equals(dni) && a.getCodAlumno() != codigoActual) {
                return true;
            }
        }

        return false;
    }

    public boolean eliminarAlumno(int codAlumno) {

        for (int i = 0; i < listaAlumnos.size(); i++) {

            Alumno a = listaAlumnos.get(i);

            // SOLO SE PUEDE ELIMINAR SI ESTÁ REGISTRADO (0)
            if (a.getCodAlumno() == codAlumno) {
                if (!a.getEstado().equals("Registrado")) {
                    return false; 
                }
                listaAlumnos.remove(i);
                guardarTodos();
                return true;
            }
        }

        return false;
    }

    public boolean modificarAlumno(Alumno alumnoNuevo){
    	for(int i = 0; i < listaAlumnos.size(); i++){
            if(listaAlumnos.get(i).getCodAlumno() == alumnoNuevo.getCodAlumno()){
                listaAlumnos.set(i, alumnoNuevo);
                guardarTodos();
                return true;
            }
        }

        return false;
    }
    
    public boolean actualizarEstado(int codAlumno, int nuevoEstado) {

    	for (Alumno a : listaAlumnos) {
            if (a.getCodAlumno() == codAlumno) {
                a.setEstado(nuevoEstado);
                guardarTodos();
                return true;
            }
        }
    	
        return false;
    }

    private void cargarDatos() {

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        	int mayorCodigo = 202010000;
            String linea;
            while ((linea = br.readLine()) != null) {
                String datos[] = linea.split(",");
                Alumno alumno = new Alumno(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        datos[2],
                        datos[3],
                        Integer.parseInt(datos[4]),
                        Integer.parseInt(datos[5]),
                        Integer.parseInt(datos[6])
                );
                listaAlumnos.add(alumno);
                if (alumno.getCodAlumno() > mayorCodigo) {
                    mayorCodigo = alumno.getCodAlumno();
                }
            }
            
            contadorCorrelativo = mayorCodigo + 1;

        } catch (IOException e) {
            System.out.println("Error al leer alumnos: " + e.getMessage());
        }
    }
    
    private void guardarTodos(){
    	try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Alumno a : listaAlumnos) {
                bw.write(a.toLineaArchivo());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error actualizando archivo");
        }
    }
}