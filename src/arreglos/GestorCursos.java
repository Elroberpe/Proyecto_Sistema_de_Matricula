package arreglos;

import clases.Curso;
import java.io.*;
import java.util.ArrayList;

public class GestorCursos {

    private final String archivo = "cursos.txt";


    // Registrar un curso en el archivo
    public void agregarCurso(Curso curso) {

        try {

            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(curso.toLineaArchivo());
            bw.newLine();

            bw.close();

        } catch (IOException e) {
            System.out.println("Error al guardar curso: " + e.getMessage());
        }
    }



    // Leer todos los cursos del archivo
    public ArrayList<Curso> listarCursos() {

        ArrayList<Curso> cursos = new ArrayList<>();

        try {

            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {

                String datos[] = linea.split(",");


                Curso curso = new Curso(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        Integer.parseInt(datos[2]),
                        Integer.parseInt(datos[3]),
                        Integer.parseInt(datos[4])
                );


                cursos.add(curso);
            }

            br.close();


        } catch (IOException e) {

            System.out.println("Error al leer archivo: " + e.getMessage());

        }


        return cursos;
    }



    // Buscar un curso por código
    public Curso buscarCurso(int codCurso) {


        ArrayList<Curso> cursos = listarCursos();


        for(Curso c : cursos) {

            if(c.getCodCurso() == codCurso) {
                return c;
            }
        }


        return null;
    }



    // Eliminar un curso
    public boolean eliminarCurso(int codCurso) {


        ArrayList<Curso> cursos = listarCursos();


        boolean eliminado = false;


        for(Curso c : cursos) {

            if(c.getCodCurso() == codCurso) {

                cursos.remove(c);
                eliminado = true;
                break;
            }
        }


        if(eliminado){

            guardarTodos(cursos);
        }


        return eliminado;
    }



    // Modificar curso
    public boolean modificarCurso(Curso cursoNuevo) {


        ArrayList<Curso> cursos = listarCursos();


        boolean encontrado = false;


        for(int i = 0; i < cursos.size(); i++){


            if(cursos.get(i).getCodCurso() == cursoNuevo.getCodCurso()){


                cursos.set(i, cursoNuevo);
                encontrado = true;
                break;
            }
        }



        if(encontrado){

            guardarTodos(cursos);
        }


        return encontrado;
    }




    // Método auxiliar para reescribir el archivo
    private void guardarTodos(ArrayList<Curso> cursos){


        try {


            FileWriter fw = new FileWriter(archivo);

            BufferedWriter bw = new BufferedWriter(fw);



            for(Curso c : cursos){

                bw.write(c.toLineaArchivo());
                bw.newLine();

            }


            bw.close();


        } catch(IOException e){

            System.out.println("Error al actualizar archivo");
        }

    }

}