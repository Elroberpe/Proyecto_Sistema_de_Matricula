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

public class PanelCursos extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtCodigo ;
	private JTextField txtAsignatura;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	
	private JComboBox<String> cboCiclo;
	
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JButton btnEliminar;
	
	private JTable table;
    private DefaultTableModel modelo;


	public PanelCursos() {
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

        JLabel lblDetalleCurso = new JLabel("Detalle del Curso");
        lblDetalleCurso.setBounds(16, 12, 250, 25);
        lblDetalleCurso.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblDetalleCurso.setForeground(new Color(55, 65, 81));
        panelFormulario.add(lblDetalleCurso);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 45, 310, 2);
        panelFormulario.add(separator);
        
     // ==================== CÓDIGO ====================
        JLabel lblCodigo = new JLabel("CÓDIGO");
        lblCodigo.setBounds(16, 62, 120, 20);
        lblCodigo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(16, 85, 278, 32);
        txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtCodigo.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtCodigo);

        // ==================== ASIGNATURA ====================
        JLabel lblAsignatura = new JLabel("ASIGNATURA");
        lblAsignatura.setBounds(16, 130, 120, 20);
        lblAsignatura.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblAsignatura);

        txtAsignatura = new JTextField();
        txtAsignatura.setBounds(16, 153, 278, 32);
        txtAsignatura.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtAsignatura.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtAsignatura);

        // ==================== CRÉDITOS ====================
        JLabel lblCreditos = new JLabel("CRÉDITOS");
        lblCreditos.setBounds(16, 198, 120, 20);
        lblCreditos.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblCreditos);

        txtCreditos = new JTextField();
        txtCreditos.setBounds(16, 221, 278, 32);
        txtCreditos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtCreditos.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtCreditos);

        // ==================== HORAS ====================
        JLabel lblHoras = new JLabel("HORAS");
        lblHoras.setBounds(16, 266, 120, 20);
        lblHoras.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblHoras);

        txtHoras = new JTextField();
        txtHoras.setBounds(16, 289, 278, 32);
        txtHoras.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtHoras.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtHoras);

        // ==================== CICLO ====================
        JLabel lblCiclo = new JLabel("CICLO");
        lblCiclo.setBounds(16, 334, 120, 20);
        lblCiclo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblCiclo);

        String[] ciclos = {
            "I Ciclo",
            "II Ciclo",
            "III Ciclo",
            "IV Ciclo",
            "V Ciclo",
            "VI Ciclo",
            "VII Ciclo",
            "VIII Ciclo",
            "IX Ciclo",
            "X Ciclo"
        };

        cboCiclo = new JComboBox<>(ciclos);
        cboCiclo.setBounds(16, 357, 278, 32);
        cboCiclo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        cboCiclo.setBackground(Color.WHITE);
        panelFormulario.add(cboCiclo);

        // ==================== BOTONES ====================

        // Guardar
        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(16, 430, 85, 35);
        btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnGuardar.setBackground(new Color(46, 125, 50));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        panelFormulario.add(btnGuardar);

        // Limpiar
        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(112, 430, 85, 35);
        btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnLimpiar.setBackground(new Color(255, 193, 7));
        btnLimpiar.setForeground(Color.BLACK);
        btnLimpiar.setFocusPainted(false);
        panelFormulario.add(btnLimpiar);

        // Eliminar
        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(208, 430, 86, 35);
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
                	    "Código",
                	    "Asignatura",
                	    "Créditos",
                	    "Horas",
                	    "Ciclo"
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