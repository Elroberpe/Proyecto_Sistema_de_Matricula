package arreglos;

import clases.Alumno;
import java.io.*;
import java.util.ArrayList;


public class GestorAlumnos {

    private String archivo = "alumnos.txt";

    public int generarCodigoAlumno() {
        ArrayList<Alumno> alumnos = listarAlumnos();
        
        if (alumnos.isEmpty()) {
            return 202010001;
        }
        
        int mayorCodigo = alumnos.get(0).getCodAlumno();
        
        for (Alumno a : alumnos) {
            if (a.getCodAlumno() > mayorCodigo) {
                mayorCodigo = a.getCodAlumno();
            }
        }
        return mayorCodigo + 1;
    }
    
    public boolean agregarAlumno(Alumno alumno) {

        if (buscarAlumno(alumno.getCodAlumno()) != null) {
            return false;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write(alumno.toLineaArchivo());
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar alumno: " + e.getMessage());
            return false;
        }
    }


    public ArrayList<Alumno> listarAlumnos() {

        ArrayList<Alumno> alumnos = new ArrayList<>();

        try (BufferedReader br =
                new BufferedReader(new FileReader(archivo))) {

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

                alumnos.add(alumno);
            }

        } catch (IOException e) {
            System.out.println("Error al leer alumnos: " + e.getMessage() );
        }

        return alumnos;
    }


    public Alumno buscarAlumno(int codAlumno){

        ArrayList<Alumno> alumnos = listarAlumnos();
        for(Alumno a : alumnos){
            if(a.getCodAlumno() == codAlumno){
                return a;
            }
        }
        return null;
    }


    public boolean eliminarAlumno(int codAlumno) {

        ArrayList<Alumno> alumnos = listarAlumnos();
        
        for (int i = 0; i < alumnos.size(); i++) {

            if (alumnos.get(i).getCodAlumno() == codAlumno) {
                alumnos.remove(i);
                guardarTodos(alumnos);
                return true;
            }
        }

        return false;
    }

    public boolean modificarAlumno(Alumno alumnoNuevo){
        ArrayList<Alumno> alumnos = listarAlumnos();
        boolean encontrado = false;
        for(int i = 0; i < alumnos.size(); i++){
            if(alumnos.get(i).getCodAlumno() == alumnoNuevo.getCodAlumno()){
                alumnos.set(i, alumnoNuevo);
                encontrado = true;
                break;
            }
        }
        if(encontrado){
            guardarTodos(alumnos);
        }
        return encontrado;

    }
    
    public boolean actualizarEstado(int codAlumno, int nuevoEstado) {

        ArrayList<Alumno> alumnos = listarAlumnos();
        
        for (int i = 0; i < alumnos.size(); i++) {
            Alumno a = alumnos.get(i);
            if (a.getCodAlumno() == codAlumno) {
                a.setEstado(nuevoEstado);
                alumnos.set(i, a);
                guardarTodos(alumnos);
                return true;
            }
        }

        return false;
    }

    private void guardarTodos(ArrayList<Alumno> alumnos){

        try{
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(Alumno a : alumnos){
                bw.write(a.toLineaArchivo()
                );
                bw.newLine();
            }

            bw.close();

        }catch(IOException e){
            System.out.println( "Error actualizando archivo"
            );
        }
    }
}