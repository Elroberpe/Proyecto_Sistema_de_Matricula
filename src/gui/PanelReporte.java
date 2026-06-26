package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import arreglos.GestorAlumnos;
import arreglos.GestorCursos;
import arreglos.GestorMatricula;
import arreglos.GestorReporte;
import clases.Alumno;

public class PanelReporte extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextArea areaTexto;
	private GestorReporte gestorReporte;

	public PanelReporte() {

		setLayout(new BorderLayout(15, 15));
		setBackground(new Color(245, 247, 250));
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// ================ GESTORES ==================

		GestorAlumnos gestorAlumnos = new GestorAlumnos();
		GestorCursos gestorCursos = new GestorCursos();
		GestorMatricula gestorMatricula = new GestorMatricula();
		gestorReporte = new GestorReporte(gestorAlumnos, gestorCursos, gestorMatricula);

		// ================ PANEL CENTRAL ==================

		JPanel panelCentro = new JPanel(new BorderLayout());
		panelCentro.setBackground(Color.WHITE);
		panelCentro
				.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)),
						BorderFactory.createEmptyBorder(15, 15, 15, 15)));

		JLabel lblReporte = new JLabel("Resultado del Reporte");
		lblReporte.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblReporte.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

		areaTexto = new JTextArea();
		areaTexto.setEditable(false);
		areaTexto.setFont(new Font("Consolas", Font.PLAIN, 14));
		areaTexto.setMargin(new Insets(10, 10, 10, 10));
		areaTexto.setLineWrap(true);
		areaTexto.setWrapStyleWord(true);
		areaTexto.setBackground(Color.WHITE);

		JScrollPane scroll = new JScrollPane(areaTexto);
		scroll.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));

		panelCentro.add(lblReporte, BorderLayout.NORTH);
		panelCentro.add(scroll, BorderLayout.CENTER);

		add(panelCentro, BorderLayout.CENTER);

		// ================ BOTONES ==================

		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panelBotones.setBackground(new Color(245, 247, 250));

		JButton btnPendientes = new JButton("Pendientes");
		btnPendientes.setPreferredSize(new Dimension(180, 45));
		btnPendientes.setBackground(new Color(52, 152, 219));
		btnPendientes.setForeground(Color.WHITE);
		btnPendientes.setFocusPainted(false);
		btnPendientes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnPendientes.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPendientes.setBorder(BorderFactory.createEmptyBorder());

		JButton btnVigentes = new JButton("Vigentes");
		btnVigentes.setPreferredSize(new Dimension(180, 45));
		btnVigentes.setBackground(new Color(46, 204, 113));
		btnVigentes.setForeground(Color.WHITE);
		btnVigentes.setFocusPainted(false);
		btnVigentes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnVigentes.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVigentes.setBorder(BorderFactory.createEmptyBorder());

		JButton btnPorCurso = new JButton("Por Curso");
		btnPorCurso.setPreferredSize(new Dimension(180, 45));
		btnPorCurso.setBackground(new Color(155, 89, 182));
		btnPorCurso.setForeground(Color.WHITE);
		btnPorCurso.setFocusPainted(false);
		btnPorCurso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnPorCurso.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPorCurso.setBorder(BorderFactory.createEmptyBorder());

		panelBotones.add(btnPendientes);
		panelBotones.add(btnVigentes);
		panelBotones.add(btnPorCurso);

		add(panelBotones, BorderLayout.SOUTH);

		// Eventos
		btnPendientes.addActionListener(e -> mostrarPendientes());
		btnVigentes.addActionListener(e -> mostrarVigentes());
		btnPorCurso.addActionListener(e -> mostrarPorCurso());
	}

	// ==============================
	// Mostrar alumnos pendientes
	// ==============================
	private void mostrarPendientes() {
		areaTexto.setText("=== Alumnos con matrícula pendiente ===\n");
		ArrayList<Alumno> lista = gestorReporte.alumnosPendientes();
		for (Alumno a : lista) {
			areaTexto.append(a.toString() + "\n");
		}
	}

	// ==============================
	// Mostrar alumnos vigentes
	// ==============================
	private void mostrarVigentes() {
		areaTexto.setText("=== Alumnos con matrícula vigente ===\n");
		ArrayList<Alumno> lista = gestorReporte.alumnosVigentes();
		for (Alumno a : lista) {
			areaTexto.append(a.toString() + "\n");
		}
	}

	// ==============================
	// Mostrar alumnos por curso
	// ==============================
	private void mostrarPorCurso() {
		areaTexto.setText("=== Alumnos matriculados por curso ===\n");
		ArrayList<String> reporte = gestorReporte.alumnosPorCurso();
		for (String linea : reporte) {
			areaTexto.append(linea + "\n");
		}
	}

}
