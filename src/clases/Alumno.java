package clases;

public class Alumno {

	private int codAlumno, edad, celular, estado;
	private String nombres, apellidos, dni;

	public Alumno() {
	}

	public Alumno(int codAlumno, String nombres, String apellidos, String dni, int edad, int celular, int estado) {
		this.codAlumno = codAlumno;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.celular = celular;
		this.estado = estado;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getEstado() {
		switch (estado) {
		case 0:
			return "Registrado";
		case 1:
			return "Matriculado";
		case 2:
			return "Retirado";
		default:
			return "Desconocido";
		}
	}

	public int getEstadoNumerico() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String toLineaArchivo() {

		return codAlumno + "," + nombres + "," + apellidos + "," + dni + "," + edad + "," + celular + "," + estado;
	}

	@Override
	public String toString() {
		return "Código: " + codAlumno + " | Nombre: " + nombres + " " + apellidos + " | DNI: " + dni + " | Edad: "
				+ edad + " | Celular: " + celular + " | Estado: " + getEstado();
	}
}