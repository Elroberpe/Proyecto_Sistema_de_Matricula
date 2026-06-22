package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PanelAlumnos extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtCodigo ;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtEdad;
	private JTextField txtCelular;
	
	private JComboBox<String> cboEstado;
	
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JButton btnEliminar;
	
	private JTable table;
    private DefaultTableModel modelo;
	  
	public PanelAlumnos() {
		setLayout(new BorderLayout());
		setBackground(new Color(245, 247, 250));
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(16,0));
		panelPrincipal.setBackground(new Color(245, 247, 250));
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(16,16,16,16));
		
		add(panelPrincipal, BorderLayout.CENTER);
		
		//Panel Formulario 
        JPanel panelFormulario = new JPanel();
        panelFormulario.setPreferredSize(new Dimension(310, 650));
        panelFormulario.setBackground(Color.WHITE);
        panelFormulario.setBorder(BorderFactory.createLineBorder(new Color(210, 215, 220)));
        panelFormulario.setLayout(null);
        panelPrincipal.add(panelFormulario, BorderLayout.WEST);

        JLabel lblDetalleAlumno = new JLabel("Detalle del Alumno");
        lblDetalleAlumno.setBounds(16, 12, 250, 25);
        lblDetalleAlumno.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblDetalleAlumno.setForeground(new Color(55, 65, 81));
        panelFormulario.add(lblDetalleAlumno);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 45, 310, 2);
        panelFormulario.add(separator);
        
        JLabel lblCodigo = new JLabel("CODIGO");
        lblCodigo.setBounds(16, 62, 120, 20);
        lblCodigo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setForeground(Color.GRAY);
        txtCodigo.setBounds(16, 85, 278, 32);
        txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtCodigo.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtCodigo);
        
     // ==================== NOMBRES ====================
        JLabel lblNombres = new JLabel("NOMBRES");
        lblNombres.setBounds(16, 130, 120, 20);
        lblNombres.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblNombres);

        txtNombres = new JTextField();
        txtNombres.setForeground(Color.GRAY);
        txtNombres.setBounds(16, 153, 278, 32);
        txtNombres.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtNombres.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtNombres);

        // ==================== APELLIDOS ====================
        JLabel lblApellidos = new JLabel("APELLIDOS");
        lblApellidos.setBounds(16, 198, 120, 20);
        lblApellidos.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setForeground(Color.GRAY);
        txtApellidos.setBounds(16, 221, 278, 32);
        txtApellidos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtApellidos.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtApellidos);

     // ==================== DNI ====================
        JLabel lblDni = new JLabel("DNI");
        lblDni.setBounds(16, 266, 120, 20);
        lblDni.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblDni);

        txtDni = new JTextField();
        txtDni.setBounds(16, 289, 278, 32);
        txtDni.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtDni.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtDni);

        // ==================== EDAD ====================
        JLabel lblEdad = new JLabel("EDAD");
        lblEdad.setBounds(16, 334, 120, 20);
        lblEdad.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(16, 357, 278, 32);
        txtEdad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtEdad.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtEdad);

        // ==================== CELULAR ====================
        JLabel lblCelular = new JLabel("CELULAR");
        lblCelular.setBounds(16, 402, 120, 20);
        lblCelular.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblCelular);

        txtCelular = new JTextField();
        txtCelular.setBounds(16, 425, 278, 32);
        txtCelular.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtCelular.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtCelular);

        // ==================== ESTADO ====================
        JLabel lblEstado = new JLabel("ESTADO");
        lblEstado.setBounds(16, 470, 120, 20);
        lblEstado.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblEstado);

        String[] estados = {
            "Registrado",
            "Matriculado",
            "Retirado"
        };

        cboEstado = new JComboBox<>(estados);
        cboEstado.setBounds(16, 493, 278, 32);
        cboEstado.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        cboEstado.setBackground(Color.WHITE);
        cboEstado.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(cboEstado);
        
     // ==================== BOTÓN GUARDAR ====================
        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(16, 550, 85, 35);
        btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setBackground(new Color(46, 125, 50));
        btnGuardar.setForeground(Color.WHITE);
        panelFormulario.add(btnGuardar);

        // ==================== BOTÓN LIMPIAR ====================
        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(112, 550, 85, 35);
        btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setBackground(new Color(255, 193, 7));
        btnLimpiar.setForeground(Color.BLACK);
        panelFormulario.add(btnLimpiar);

        // ==================== BOTÓN ELIMINAR ====================
        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(208, 550, 86, 35);
        btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBackground(new Color(211, 47, 47));
        btnEliminar.setForeground(Color.WHITE);
        panelFormulario.add(btnEliminar);
		
        
        // =======================
        // PANEL TABLA
        // =======================

        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBackground(Color.WHITE);
        panelTabla.setBorder(BorderFactory.createLineBorder(new Color(210, 215, 220)));
        panelPrincipal.add(panelTabla, BorderLayout.CENTER);
        
        // =======================
        // TABLA
        // =======================
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        panelTabla.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();

        modelo = new DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "Código",
                        "Nombres",
                        "Apellidos",
                        "DNI",
                        "Celular",
                        "Estado"
                }
        ) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setModel(modelo);
        scrollPane.setViewportView(table);

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

        table.getColumnModel().getColumn(0).setPreferredWidth(80);   // Código
        table.getColumnModel().getColumn(1).setPreferredWidth(180);  // Nombres
        table.getColumnModel().getColumn(2).setPreferredWidth(180);  // Apellidos
        table.getColumnModel().getColumn(3).setPreferredWidth(100);  // DNI
        table.getColumnModel().getColumn(4).setPreferredWidth(120);  // Celular
        table.getColumnModel().getColumn(5).setPreferredWidth(100);  // Estado

        
       
	}
}