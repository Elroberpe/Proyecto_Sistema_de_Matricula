package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import arreglos.GestorAlumnos;
import arreglos.GestorCursos;
import arreglos.GestorMatricula;
import arreglos.GestorRetiro;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import clases.Retiro;

public class PanelConsultaAlumnos extends JPanel {

    private static final long serialVersionUID = 1L;

    // ===================== ALUMNO =====================
    private JTextField txtBuscarAlu;

    private JTextField txtCodAlu;
    private JTextField txtNomAlu;
    private JTextField txtApeAlu;
    private JTextField txtDniAlu;
    private JTextField txtCelAlu;
    private JTextField txtEstAlu;
    
    private JTextField txtBuscarMatricula;
    private JTextField txtBuscarRetiro;

    // ===================== CURSO =====================
    private JTextField txtBuscarCur;

    private JTextField txtCodCur;
    private JTextField txtAsig;
    private JTextField txtCiclo;
    private JTextField txtHoras;
    
    private GestorAlumnos ga = new GestorAlumnos();
    private GestorMatricula gm = new GestorMatricula();
    private GestorCursos gc = new GestorCursos();
    private GestorRetiro gr = new GestorRetiro();

    public PanelConsultaAlumnos() {

        setLayout(null);
        setBackground(new Color(240, 242, 245));

        // ===================== TITULO =====================
        JLabel titulo = new JLabel("MODULO DE CONSULTAS", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titulo.setBounds(0, 15, 1200, 40);
        add(titulo);

        JLabel lblMat = new JLabel("Buscar Matrícula:");
        lblMat.setBounds(30, 65, 130, 25);
        add(lblMat);

        txtBuscarMatricula = new JTextField();
        txtBuscarMatricula.setBounds(160, 65, 200, 28);
        add(txtBuscarMatricula);

        JButton btnBuscarMat = new JButton("Buscar");
        btnBuscarMat.setBounds(370, 65, 100, 28);
        add(btnBuscarMat);


        JLabel lblRet = new JLabel("Buscar Retiro:");
        lblRet.setBounds(500, 65, 120, 25);
        add(lblRet);

        txtBuscarRetiro = new JTextField();
        txtBuscarRetiro.setBounds(620, 65, 200, 28);
        add(txtBuscarRetiro);

        JButton btnBuscarRet = new JButton("Buscar");
        btnBuscarRet.setBounds(830, 65, 100, 28);
        add(btnBuscarRet);
        
        // ==========================================================
        //                     PANEL ALUMNO
        // ==========================================================
        JPanel panelAlumno = new JPanel();
        panelAlumno.setLayout(null);
        panelAlumno.setBounds(30, 130, 520, 420);
        panelAlumno.setBackground(Color.WHITE);
        panelAlumno.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Datos del Alumno",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14)
        ));
        add(panelAlumno);

        JLabel lblBuscarAlu = new JLabel("Buscar:");
        lblBuscarAlu.setBounds(20, 40, 80, 25);
        panelAlumno.add(lblBuscarAlu);

        txtBuscarAlu = new JTextField();
        txtBuscarAlu.setBounds(90, 40, 250, 28);
        panelAlumno.add(txtBuscarAlu);

        JButton btnBuscarAlu = new JButton("Buscar");
        btnBuscarAlu.setBounds(350, 40, 100, 28);
        panelAlumno.add(btnBuscarAlu);

        JLabel lbl1 = new JLabel("Código:");
        lbl1.setBounds(20, 100, 100, 25);
        panelAlumno.add(lbl1);

        txtCodAlu = new JTextField();
        txtCodAlu.setBounds(120, 100, 330, 28);
        txtCodAlu.setEditable(false);
        panelAlumno.add(txtCodAlu);

        JLabel lbl2 = new JLabel("Nombre:");
        lbl2.setBounds(20, 140, 100, 25);
        panelAlumno.add(lbl2);

        txtNomAlu = new JTextField();
        txtNomAlu.setBounds(120, 140, 330, 28);
        txtNomAlu.setEditable(false);
        panelAlumno.add(txtNomAlu);

        JLabel lbl3 = new JLabel("Apellido:");
        lbl3.setBounds(20, 180, 100, 25);
        panelAlumno.add(lbl3);

        txtApeAlu = new JTextField();
        txtApeAlu.setBounds(120, 180, 330, 28);
        txtApeAlu.setEditable(false);
        panelAlumno.add(txtApeAlu);

        JLabel lbl4 = new JLabel("DNI:");
        lbl4.setBounds(20, 220, 100, 25);
        panelAlumno.add(lbl4);

        txtDniAlu = new JTextField();
        txtDniAlu.setBounds(120, 220, 330, 28);
        txtDniAlu.setEditable(false);
        panelAlumno.add(txtDniAlu);

        JLabel lbl5 = new JLabel("Celular:");
        lbl5.setBounds(20, 260, 100, 25);
        panelAlumno.add(lbl5);

        txtCelAlu = new JTextField();
        txtCelAlu.setBounds(120, 260, 330, 28);
        txtCelAlu.setEditable(false);
        panelAlumno.add(txtCelAlu);

        JLabel lbl6 = new JLabel("Estado:");
        lbl6.setBounds(20, 300, 100, 25);
        panelAlumno.add(lbl6);

        txtEstAlu = new JTextField();
        txtEstAlu.setBounds(120, 300, 330, 28);
        txtEstAlu.setEditable(false);
        panelAlumno.add(txtEstAlu);

        // ==========================================================
        //                     PANEL CURSO
        // ==========================================================
        JPanel panelCurso = new JPanel();
        panelCurso.setLayout(null);
        panelCurso.setBounds(600, 130, 520, 420);
        panelCurso.setBackground(Color.WHITE);
        panelCurso.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Datos del Curso",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14)
        ));
        add(panelCurso);

        JLabel lblBuscarCur = new JLabel("Buscar:");
        lblBuscarCur.setBounds(20, 40, 80, 25);
        panelCurso.add(lblBuscarCur);

        txtBuscarCur = new JTextField();
        txtBuscarCur.setBounds(90, 40, 250, 28);
        panelCurso.add(txtBuscarCur);

        JButton btnBuscarCur = new JButton("Buscar");
        btnBuscarCur.setBounds(350, 40, 100, 28);
        panelCurso.add(btnBuscarCur);

        JLabel c1 = new JLabel("Código:");
        c1.setBounds(20, 100, 120, 25);
        panelCurso.add(c1);

        txtCodCur = new JTextField();
        txtCodCur.setBounds(140, 100, 310, 28);
        txtCodCur.setEditable(false);
        panelCurso.add(txtCodCur);

        JLabel c2 = new JLabel("Asignatura:");
        c2.setBounds(20, 140, 120, 25);
        panelCurso.add(c2);

        txtAsig = new JTextField();
        txtAsig.setBounds(140, 140, 310, 28);
        txtAsig.setEditable(false);
        panelCurso.add(txtAsig);

        JLabel c3 = new JLabel("Ciclo:");
        c3.setBounds(20, 180, 120, 25);
        panelCurso.add(c3);

        txtCiclo = new JTextField();
        txtCiclo.setBounds(140, 180, 310, 28);
        txtCiclo.setEditable(false);
        panelCurso.add(txtCiclo);

        JLabel c4 = new JLabel("Horas:");
        c4.setBounds(20, 220, 120, 25);
        panelCurso.add(c4);

        txtHoras = new JTextField();
        txtHoras.setBounds(140, 220, 310, 28);
        txtHoras.setEditable(false);
        panelCurso.add(txtHoras);
        
        btnBuscarAlu.addActionListener(e -> buscarAlumno());
        btnBuscarCur.addActionListener(e -> buscarCurso());
        btnBuscarMat.addActionListener(e -> buscarMatricula());
        btnBuscarRet.addActionListener(e -> buscarRetiro());
        
    }
    
    
    private void buscarAlumno () {
    	
    	try {
            int cod = Integer.parseInt(txtBuscarAlu.getText().trim());
            Alumno a = ga.buscarAlumno(cod);

            if (a == null) {
                JOptionPane.showMessageDialog(this, "Alumno no encontrado");
                limpiarAlumno();
                limpiarCurso();
                return;
            }
            
            mostrarAlumno(a);
          
            if(a.getEstado() == 1) {
            	// 3. BUSCAR MATRÍCULA
                Matricula m = gm.buscarPorAlumno(cod);

                if (m == null) {
                    JOptionPane.showMessageDialog(this, "El alumno no está matriculado");
                    limpiarCurso();
                    return;
                }

                // 4. BUSCAR CURSO
                mostrarCurso(m.getCodCurso());
            } else {
            	limpiarCurso();
            }
           
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un código válido");
        }
    	
    }
    
    private void buscarCurso() {
    	
        try {
            int cod = Integer.parseInt(txtBuscarCur.getText().trim());
            limpiarAlumno();
            mostrarCurso(cod);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un código válido");
        }
    }
    
    
    private void buscarMatricula() {
    	
        try {
            int numMatricula = Integer.parseInt(txtBuscarMatricula.getText().trim());
            Matricula m = gm.buscarPorNumero(numMatricula);
            
            if (m == null) {
                JOptionPane.showMessageDialog(this, "Matrícula no encontrada");
                return;
            }
            
            Alumno a = ga.buscarAlumno(m.getCodAlumno());
            
            if (a == null) {
                JOptionPane.showMessageDialog(this, "Alumno no encontrado");
                return;
            }
            
            mostrarAlumno(a);
            mostrarCurso(m.getCodCurso());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número de matrícula válido");
        }
    }
    
    private void buscarRetiro() {

        try {

            int numRetiro = Integer.parseInt(txtBuscarRetiro.getText().trim());
            Retiro r = gr.obtenerRetiro(numRetiro);

            if (r == null) {
                JOptionPane.showMessageDialog(this, "Retiro no encontrado");
                return;
            }

            Matricula m = gm.buscarPorNumero(r.getNumMatricula());

            if (m == null) {
                JOptionPane.showMessageDialog(this, "La matrícula asociada no existe");
                return;
            }

            Alumno a = ga.buscarAlumno(m.getCodAlumno());

            if (a == null) {
                JOptionPane.showMessageDialog(this, "Alumno no encontrado");
                return;
            }

            mostrarAlumno(a);
            mostrarCurso(m.getCodCurso());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número de retiro válido");
        }
    }
    
    private void mostrarAlumno(Alumno a) {

        txtCodAlu.setText(String.valueOf(a.getCodAlumno()));
        txtNomAlu.setText(a.getNombres());
        txtApeAlu.setText(a.getApellidos());
        txtDniAlu.setText(a.getDni());
        txtCelAlu.setText(String.valueOf(a.getCelular()));
        txtEstAlu.setText(String.valueOf(a.getEstado()));
    }
    
    private void mostrarCurso(int codCurso) {

        Curso c = gc.buscarCurso(codCurso);

        if (c == null) {
            limpiarCurso();
            JOptionPane.showMessageDialog(this, "Curso no encontrado");
            return;
        }

        txtCodCur.setText(String.valueOf(c.getCodCurso()));
        txtAsig.setText(c.getAsignatura());
        txtCiclo.setText(String.valueOf(c.getCiclo()));
        txtHoras.setText(String.valueOf(c.getHoras()));
    }
    
    private void limpiarAlumno() {
        txtCodAlu.setText("");
        txtNomAlu.setText("");
        txtApeAlu.setText("");
        txtDniAlu.setText("");
        txtCelAlu.setText("");
        txtEstAlu.setText("");
    }

    private void limpiarCurso() {
        txtCodCur.setText("");
        txtAsig.setText("");
        txtCiclo.setText("");
        txtHoras.setText("");
    }
    
}