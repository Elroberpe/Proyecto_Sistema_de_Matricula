
package arreglos;

import clases.Alumno;
import clases.Curso; // <-- IMPORTANTE
import clases.Matricula;

import java.util.ArrayList;

public class GestorReporte {

	private GestorMatricula gestorMatricula;
	private GestorAlumnos gestorAlumnos;
	private GestorCursos gestorCursos;

	// Constructor
	public GestorReporte(GestorAlumnos gestorAlumnos, GestorCursos gestorCursos, GestorMatricula gestorMatricula) {
		this.gestorAlumnos = gestorAlumnos;
		this.gestorCursos = gestorCursos;
		this.gestorMatricula = gestorMatricula;
	}

	public ArrayList<Alumno> alumnosPendientes() {
		ArrayList<Alumno> pendientes = new ArrayList<>();
		for (Alumno a : gestorAlumnos.listarAlumnos()) {
			if (a.getEstadoNumerico() == 0) // Registrado
				pendientes.add(a);
		}
		return pendientes;
	}

	public ArrayList<Alumno> alumnosVigentes() {
		ArrayList<Alumno> vigentes = new ArrayList<>();
		for (Alumno a : gestorAlumnos.listarAlumnos()) {
			if (a.getEstadoNumerico() == 1) // Matriculado
				vigentes.add(a);
		}
		return vigentes;
	}

	public ArrayList<String> alumnosPorCurso() {
		ArrayList<String> reporte = new ArrayList<>();
		for (Curso c : gestorCursos.listarCursos()) {
			StringBuilder sb = new StringBuilder();
			sb.append("Curso: ").append(c.getAsignatura()).append("\n");

			boolean tieneAlumnos = false;
			for (Matricula m : gestorMatricula.obtenerMatriculas()) {
				if (m.getCodCurso() == c.getCodCurso()) {
					Alumno a = gestorAlumnos.buscarAlumno(m.getCodAlumno()); // ajusta al nombre real del método
					if (a != null) {
						sb.append("  - ").append(a.getNombres()).append(" ").append(a.getApellidos()).append("\n");
						tieneAlumnos = true;
					}
				}
			}
			if (!tieneAlumnos) {
				sb.append("  (sin alumnos matriculados)\n");
			}
			reporte.add(sb.toString());
		}
		return reporte;
	}

}
