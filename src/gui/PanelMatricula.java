package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PanelMatricula extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtNumeroMatricula ;
	private JTextField txxCodAlumno;
	private JTextField txtCodCurso;
	private JTextField txtFecha;
	private JTextField txtHora;

	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JButton btnEliminar;

	private JTable table;
    private DefaultTableModel modelo;
	
	public PanelMatricula() {
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

        JLabel lblDetalleMatricula = new JLabel("Detalle de la Matricula");
        lblDetalleMatricula.setBounds(16, 12, 250, 25);
        lblDetalleMatricula.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblDetalleMatricula.setForeground(new Color(55, 65, 81));
        panelFormulario.add(lblDetalleMatricula);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 45, 310, 2);
        panelFormulario.add(separator);
        
        // ==================== NUMERO DE MATRICULA ====================
        JLabel lblNumMatricula = new JLabel("NUMERO DE MATRICULA");
        lblNumMatricula.setBounds(16, 62, 120, 20);
        lblNumMatricula.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblNumMatricula);

        txtNumeroMatricula = new JTextField();
        txtNumeroMatricula.setBounds(16, 85, 278, 32);
        txtNumeroMatricula.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtNumeroMatricula.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtNumeroMatricula);

        // ==================== CODIGO DE ALUMNO ====================
        JLabel lblAlumno = new JLabel("CODIGO DEL ALUMNO");
        lblAlumno.setBounds(16, 130, 120, 20);
        lblAlumno.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblAlumno);

        txxCodAlumno = new JTextField();
        txxCodAlumno.setBounds(16, 153, 278, 32);
        txxCodAlumno.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txxCodAlumno.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txxCodAlumno);

        // ==================== CODIGO CURSO ====================
        JLabel lblCurso = new JLabel("CODIGO DEL CURSO");
        lblCurso.setBounds(16, 198, 120, 20);
        lblCurso.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblCurso);

        txtCodCurso = new JTextField();
        txtCodCurso.setBounds(16, 221, 278, 32);
        txtCodCurso.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtCodCurso.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtCodCurso);

     // ==================== FECHA ====================
        JLabel lblFecha = new JLabel("FECHA");
        lblFecha.setBounds(16, 266, 120, 20);
        lblFecha.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(16, 289, 278, 32);
        txtFecha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtFecha.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtFecha);

        // ==================== HORA ====================
        JLabel lblHora = new JLabel("HORA");
        lblHora.setBounds(16, 334, 120, 20);
        lblHora.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblHora);

        txtHora = new JTextField();
        txtHora.setBounds(16, 357, 278, 32);
        txtHora.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtHora.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtHora);

        // ==================== BOTÓN GUARDAR ====================
        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(16, 420, 85, 35);
        btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnGuardar.setBackground(new Color(46, 125, 50));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        panelFormulario.add(btnGuardar);

        // ==================== BOTÓN LIMPIAR ====================
        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(112, 420, 85, 35);
        btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnLimpiar.setBackground(new Color(255, 193, 7));
        btnLimpiar.setForeground(Color.BLACK);
        btnLimpiar.setFocusPainted(false);
        panelFormulario.add(btnLimpiar);

        // ==================== BOTÓN ELIMINAR ====================
        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(208, 420, 86, 35);
        btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnEliminar.setBackground(new Color(211, 47, 47));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);
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
                	    "Numero de Matricula",
                	    "Alumno",
                	    "Matricula",
                	    "Fecha",
                	    "Hora"
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

        table.getColumnModel().getColumn(0).setPreferredWidth(80);   
        table.getColumnModel().getColumn(1).setPreferredWidth(180);  
        table.getColumnModel().getColumn(2).setPreferredWidth(180);  
        table.getColumnModel().getColumn(3).setPreferredWidth(100);  
        table.getColumnModel().getColumn(4).setPreferredWidth(120);  
	}
}