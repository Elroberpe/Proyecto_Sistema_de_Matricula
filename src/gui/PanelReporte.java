package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import arreglos.GestorAlumnos;
import arreglos.GestorCursos;
import arreglos.GestorReporte;
import clases.Alumno;
import java.util.ArrayList;

public class PanelReporte extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextArea areaTexto;
    private GestorReporte gestorReporte;

    public PanelReporte() {
        setLayout(new BorderLayout());
        setBackground(new Color(245,247,250));

        // Instancias de gestores
        GestorAlumnos gestorAlumnos = new GestorAlumnos();
        GestorCursos gestorCursos = new GestorCursos();
        gestorReporte = new GestorReporte(gestorAlumnos, gestorCursos);

        // Título
        JLabel titulo = new JLabel("Módulo de Reportes", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(new Color(33,37,41));
        add(titulo, BorderLayout.NORTH);

        // Área de texto
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Consolas", Font.PLAIN, 14));
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        JButton btnPendientes = new JButton("Alumnos Pendientes");
        JButton btnVigentes = new JButton("Alumnos Vigentes");
        JButton btnPorCurso = new JButton("Matriculados por Curso");

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

