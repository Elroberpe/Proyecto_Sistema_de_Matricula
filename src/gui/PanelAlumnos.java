package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import arreglos.GestorAlumnos;
import clases.Alumno;

public class PanelAlumnos extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtCodigo;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtDni;
    private JTextField txtEdad;
    private JTextField txtCelular;

    private JTextField txtEstado;

    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnEliminar;

    private JTable table;
    private DefaultTableModel modelo;

    private GestorAlumnos gestor;

    public PanelAlumnos(GestorAlumnos gestor) {

        this.gestor = gestor;

        setLayout(new BorderLayout());
        setBackground(new Color(245, 247, 250));

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(16, 0));
        panelPrincipal.setBackground(new Color(245, 247, 250));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        add(panelPrincipal, BorderLayout.CENTER);

        // ==============================
        // FORMULARIO
        // ==============================

        JPanel panelFormulario = new JPanel();
        panelFormulario.setPreferredSize(new Dimension(310, 650));
        panelFormulario.setBackground(Color.WHITE);
        panelFormulario.setLayout(null);
        panelFormulario.setBorder(BorderFactory.createLineBorder(new Color(210, 215, 220)));

        panelPrincipal.add(panelFormulario, BorderLayout.WEST);

        JLabel titulo = new JLabel("Detalle del Alumno");
        titulo.setBounds(16, 12, 250, 25);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 13));
        panelFormulario.add(titulo);

        JSeparator separador = new JSeparator();
        separador.setBounds(0, 45, 310, 2);
        panelFormulario.add(separador);

        // CODIGO
        JLabel lblCodigo = new JLabel("CODIGO");
        lblCodigo.setBounds(16, 62, 120, 20);
        panelFormulario.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(16, 85, 278, 32);
        panelFormulario.add(txtCodigo);

        // NOMBRES
        JLabel lblNombres = new JLabel("NOMBRES");
        lblNombres.setBounds(16, 130, 120, 20);
        panelFormulario.add(lblNombres);

        txtNombres = new JTextField();
        txtNombres.setBounds(16, 153, 278, 32);
        panelFormulario.add(txtNombres);

        // APELLIDOS
        JLabel lblApellidos = new JLabel("APELLIDOS");
        lblApellidos.setBounds(16, 198, 120, 20);
        panelFormulario.add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(16, 221, 278, 32);
        panelFormulario.add(txtApellidos);

        // DNI
        JLabel lblDni = new JLabel("DNI");
        lblDni.setBounds(16, 266, 120, 20);
        panelFormulario.add(lblDni);

        txtDni = new JTextField();
        txtDni.setBounds(16, 289, 278, 32);
        panelFormulario.add(txtDni);

        // EDAD
        JLabel lblEdad = new JLabel("EDAD");
        lblEdad.setBounds(16, 334, 120, 20);
        panelFormulario.add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(16, 357, 278, 32);
        panelFormulario.add(txtEdad);

        // CELULAR
        JLabel lblCelular = new JLabel("CELULAR");
        lblCelular.setBounds(16, 402, 120, 20);
        panelFormulario.add(lblCelular);

        txtCelular = new JTextField();
        txtCelular.setBounds(16, 425, 278, 32);
        panelFormulario.add(txtCelular);
        
        JLabel lblEstado = new JLabel("ESTADO");
        lblEstado.setBounds(16, 470, 120, 20);
        panelFormulario.add(lblEstado);
        
        // ESTADO
        txtEstado = new JTextField("Registrado");
        txtEstado.setBounds(16, 493, 278, 32);
        txtEstado.setEditable(false);
        txtEstado.setBackground(new Color(240, 240, 240));
        panelFormulario.add(txtEstado);

        // BOTONES
        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(16, 550, 85, 35);
        btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnGuardar.setBackground(new Color(46, 125, 50));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        panelFormulario.add(btnGuardar);

        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(112, 550, 85, 35);
        btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnLimpiar.setBackground(new Color(255, 193, 7));
        btnLimpiar.setForeground(Color.BLACK);
        btnLimpiar.setFocusPainted(false);
        panelFormulario.add(btnLimpiar);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(208, 550, 86, 35);
        btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnEliminar.setBackground(new Color(211, 47, 47));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);
        panelFormulario.add(btnEliminar);

        // ==============================
        // TABLA
        // ==============================

        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBackground(Color.WHITE);
        panelTabla.setBorder(BorderFactory.createLineBorder(new Color(210, 215, 220)));

        panelPrincipal.add(panelTabla, BorderLayout.CENTER);

        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(new EmptyBorder(0, 0, 0, 0));

        panelTabla.add(scroll, BorderLayout.CENTER);

        table = new JTable();

        modelo = new DefaultTableModel(
            new Object[][]{},
            new String[]{ "Código", "Nombres", "Apellidos", "DNI", "Celular","Edad", "Estado" }
        ) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        table.setModel(modelo);
        scroll.setViewportView(table);
        
        table.setRowHeight(36);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setForeground(Color.BLACK);
        table.setGridColor(new Color(230, 230, 230));
        table.setSelectionBackground(new Color(227, 242, 253));
        table.setSelectionForeground(Color.BLACK);
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);

        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(38, 50, 56));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setPreferredSize(new Dimension(0, 36));
        table.getTableHeader().setReorderingAllowed(false);

        // Ancho de columnas
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);

        // ==============================
        // EVENTOS
        // ==============================

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarAlumno();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
                mostrarSiguienteCodigo();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarAlumno();
            }
        });

        cargarTabla();
        mostrarSiguienteCodigo();
        
        table.getSelectionModel().addListSelectionListener(e ->{
        	if(!e.getValueIsAdjusting()) {
        		mostrarDatos();
        	}
        });

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent e) {
                cargarTabla();
                mostrarSiguienteCodigo();
            }
        });
        
    }

    // =====================================
    // GUARDAR
    // =====================================

    private void guardarAlumno() {

        try {

            int codAlumno = Integer.parseInt(txtCodigo.getText().trim());
            String nombre = txtNombres.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            String dni = txtDni.getText().trim();
            int edad = Integer.parseInt(txtEdad.getText().trim());
            int celular = Integer.parseInt(txtCelular.getText().trim());

            // ================= VALIDACIONES =================
            if (nombre.isEmpty() || apellidos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nombre y apellido son obligatorios");
                return;
            }

            if (!dni.matches("\\d{8}")) {
                JOptionPane.showMessageDialog(this, "DNI debe tener 8 dígitos");
                return;
            }

            if (!String.valueOf(celular).matches("\\d{9}")) {
                JOptionPane.showMessageDialog(this, "Celular debe tener 9 dígitos");
                return;
            }

            // ================= BUSCAR EXISTENTE =================
            Alumno alumnoExistente = gestor.buscarAlumno(codAlumno);

            if (alumnoExistente != null) {

                // SI ES EL MISMO DNI Y MISMO ALUMNO → SOLO UPDATE
                if (alumnoExistente.getDni().equals(dni)) {

                    Alumno actualizado = new Alumno( codAlumno, nombre,apellidos, dni, edad,celular,alumnoExistente.getEstadoNumerico()
                    );

                    gestor.modificarAlumno(actualizado);
                    JOptionPane.showMessageDialog(this, "Alumno actualizado correctamente");

                } else {
                    // SI EL DNI YA EXISTE EN OTRO ALUMNO
                    if (gestor.existeDni(dni, codAlumno)) {
                        JOptionPane.showMessageDialog(this, "Ya existe otro alumno con ese DNI");
                        return;
                    }

                    Alumno actualizado = new Alumno(codAlumno,nombre,apellidos,dni,edad,celular,alumnoExistente.getEstadoNumerico()
                    );

                    gestor.modificarAlumno(actualizado);
                    JOptionPane.showMessageDialog(this, "Alumno actualizado");
                }

            } else {

                // ================= INSERT =================
                if (gestor.existeDni(dni, 0)) {
                    JOptionPane.showMessageDialog(this, "Ya existe un alumno con ese DNI");
                    return;
                }

                Alumno nuevo = new Alumno( gestor.obtenerSiguienteCodigo(), nombre,apellidos,dni,edad,celular, 0
                );
                gestor.agregarAlumno(nuevo);
                JOptionPane.showMessageDialog(this, "Alumno registrado");
            }

            cargarTabla();
            limpiarCampos();
            txtCodigo.setText(String.valueOf(gestor.obtenerSiguienteCodigo()));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Edad y celular deben ser numéricos");
        }
    }
    // =====================================
    // CARGAR TABLA
    // =====================================

    private void cargarTabla() {

        modelo.setRowCount(0);

        for (Alumno a : gestor.listarAlumnos()) {
            modelo.addRow(new Object[]{
                a.getCodAlumno(),
                a.getNombres(),
                a.getApellidos(),
                a.getDni(),
                a.getCelular(),
                a.getEdad(),
                a.getEstado()
            });
        }
    }

    private void mostrarDatos() {

        int fila = table.getSelectedRow();
        if (fila == -1) {
            return;
        }

        txtCodigo.setText(table.getValueAt(fila, 0).toString());
        txtNombres.setText(table.getValueAt(fila, 1).toString());
        txtApellidos.setText(table.getValueAt(fila, 2).toString());
        txtDni.setText(table.getValueAt(fila, 3).toString());
        txtCelular.setText(table.getValueAt(fila, 4).toString());
        txtEdad.setText(table.getValueAt(fila, 5).toString());

        String estado = table.getValueAt(fila, 6).toString();

        txtEstado.setText(estado);

        txtCodigo.setEditable(false);
        txtDni.setEditable(false);
    }
    
    // =====================================
    // LIMPIAR
    // =====================================

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDni.setText("");
        txtEdad.setText("");
        txtCelular.setText("");
        txtEstado.setText("Registrado");
        table.clearSelection();
        txtDni.setEditable(true);
    }

    // =====================================
    // ELIMINAR
    // =====================================

    private void eliminarAlumno() {

        int cod = Integer.parseInt(txtCodigo.getText().trim());
        boolean eliminado = gestor.eliminarAlumno(cod);

        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Alumno eliminado correctamente");
            cargarTabla();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "No se puede eliminar. El alumno no está en estado REGISTRADO.");
        }
    }
    
	private void mostrarSiguienteCodigo() {
	    txtCodigo.setText(String.valueOf(gestor.obtenerSiguienteCodigo()));
	    txtCodigo.setEditable(false);
	}
	
}