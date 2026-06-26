
package arreglos;

import clases.Alumno;
import clases.Curso;   // <-- IMPORTANTE
import java.util.ArrayList;

public class GestorReporte {

    private GestorAlumnos gestorAlumnos;
    private GestorCursos gestorCursos;

    // Constructor
    public GestorReporte(GestorAlumnos gestorAlumnos, GestorCursos gestorCursos) {
        this.gestorAlumnos = gestorAlumnos;
        this.gestorCursos = gestorCursos;
    }

    public ArrayList<Alumno> alumnosPendientes() {
        ArrayList<Alumno> pendientes = new ArrayList<>();
        for (Alumno a : gestorAlumnos.listarAlumnos()) {
            if (a.getEstadoNumerico() == 1) pendientes.add(a);
        }
        return pendientes;
    }

    public ArrayList<Alumno> alumnosVigentes() {
        ArrayList<Alumno> vigentes = new ArrayList<>();
        for (Alumno a : gestorAlumnos.listarAlumnos()) {
            if (a.getEstadoNumerico() == 2) vigentes.add(a);
        }
        return vigentes;
    }

    public ArrayList<String> alumnosPorCurso() {
        ArrayList<String> reporte = new ArrayList<>();
        for (Curso c : gestorCursos.listarCursos()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Curso: ").append(c.getAsignatura()).append("\n");
            // Aquí solo mostramos el curso, sin alumnos
            reporte.add(sb.toString());
        }
        return reporte;
    }


}



