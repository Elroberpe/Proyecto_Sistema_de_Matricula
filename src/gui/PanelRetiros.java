package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import arreglos.GestorMatricula;
import arreglos.GestorRetiro;
import clases.Alumno;
import clases.Matricula;
import clases.Retiro;

public class PanelRetiros extends JPanel {

	private static final long serialVersionUID = 1L;
	
	
	private JTextField txtNumeroRetiro;
	private JTextField txtNumeroMatricula;

	
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JButton btnEliminar;
	
	private JTable table;
    private DefaultTableModel modelo;
	
    private GestorRetiro gestorRetiro;
    private GestorMatricula gestorMatricula;
    private GestorAlumnos gestorAlumno;

	public PanelRetiros(GestorAlumnos ga, GestorMatricula gm, GestorRetiro gr) {
	    this.gestorAlumno = ga;
	    this.gestorMatricula = gm;
	    this.gestorRetiro = gr;
		
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

        JLabel lblDetalleRetiro = new JLabel("Detalle de Retiro");
        lblDetalleRetiro.setBounds(16, 12, 250, 25);
        lblDetalleRetiro.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblDetalleRetiro.setForeground(new Color(55, 65, 81));
        panelFormulario.add(lblDetalleRetiro);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 45, 310, 2);
        panelFormulario.add(separator);
        
        // ==================== NUMERO DE RETIRO ====================
        JLabel lblNumMatricula = new JLabel("NUMERO DE RETIRO");
        lblNumMatricula.setBounds(16, 62, 120, 20);
        lblNumMatricula.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblNumMatricula);

        txtNumeroRetiro = new JTextField();
        txtNumeroRetiro.setBounds(16, 85, 278, 32);
        txtNumeroRetiro.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtNumeroRetiro.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtNumeroRetiro);

        // ==================== NUMERO DE MATRICULA ====================
        JLabel lblMatricula = new JLabel("NUM DE MATRICULA");
        lblMatricula.setBounds(16, 130, 120, 20);
        lblMatricula.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelFormulario.add(lblMatricula);

        txtNumeroMatricula = new JTextField();
        txtNumeroMatricula.setBounds(16, 153, 278, 32);
        txtNumeroMatricula.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtNumeroMatricula.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 210)));
        panelFormulario.add(txtNumeroMatricula);

        
        
        // ==================== BOTÓN GUARDAR ====================
        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(16, 357, 85, 35);
        btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnGuardar.setBackground(new Color(46, 125, 50));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        panelFormulario.add(btnGuardar);
        
        btnGuardar.addActionListener(e -> guardarRetiro());

        // ==================== BOTÓN LIMPIAR ====================
        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(112, 357, 85, 35);
        btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnLimpiar.setBackground(new Color(255, 193, 7));
        btnLimpiar.setForeground(Color.BLACK);
        btnLimpiar.setFocusPainted(false);
        panelFormulario.add(btnLimpiar);
        
        btnLimpiar.addActionListener(e->{
        	limpiarCampos();
        	mostrarSiguienteCodigo();
        });

        // ==================== BOTÓN ELIMINAR ====================
        btnEliminar = new JButton("CANCELAR");
        btnEliminar.setBounds(208, 357, 86, 35);
        btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnEliminar.setBackground(new Color(211, 47, 47));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);
        panelFormulario.add(btnEliminar);
        
        btnEliminar.addActionListener(e -> cancelarRetiro());
        
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
                	    "Numero de Retiro",
                	    "Numero de Matricula",
                	    "Fecha",
                	    "Hora",
    
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
        
        listarRetiros();
        mostrarSiguienteCodigo();
        
        table.getSelectionModel().addListSelectionListener(e ->{
        	if(!e.getValueIsAdjusting()) {
        		mostrarDatos();
        	}
        });
	}
	
	private void mostrarSiguienteCodigo() {
	    txtNumeroRetiro.setText(String.valueOf(gestorRetiro.obtenerSiguienteCodigo()));
	    txtNumeroRetiro.setEditable(false);
	}
	
	private void listarRetiros() {
		
	    modelo.setRowCount(0);
	    ArrayList<Retiro> lista = gestorRetiro.obtenerRetiros();

	    for (Retiro r : lista) {
	        Object[] fila = new Object[4];
	        
	        fila[0] = r.getNumRetiro();
	        fila[1] = r.getNumMatricula(); 
	        fila[2] = r.getFecha();
	        fila[3] = r.getHora();

	        modelo.addRow(fila);
	    }
	}
	
	private void mostrarDatos() {
		
		int fila = table.getSelectedRow();
		if(fila == -1) {
			return;
		}
		
		txtNumeroRetiro.setText(table.getValueAt(fila, 0).toString());
		txtNumeroMatricula.setText(table.getValueAt(fila, 1).toString());		
		txtNumeroMatricula.setEditable(false);
		
	}
	
	private void guardarRetiro() {
	    
		try {
	        int numRetiro = Integer.parseInt(txtNumeroRetiro.getText()); 
	        int numMatricula = Integer.parseInt(txtNumeroMatricula.getText().trim());	          
	        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	        String hora = new SimpleDateFormat("HH:mm:ss").format(new Date());
	        
	        Matricula matriculaEncontrada = gestorMatricula.buscarPorNumero(numMatricula);
	        
	        if(matriculaEncontrada == null) {
	        	 JOptionPane.showMessageDialog(null, "No existe el codigo de la Matricula");
		        return;
	        }
	        
	        if(gestorRetiro.yaTieneRetiro(numMatricula)) {
	        	 JOptionPane.showMessageDialog(null, "Ya hay un retiro con esa matricula");
			        return;
	        }
	        
	        
	        int codAlumno = matriculaEncontrada.getCodAlumno();

	        if (gestorAlumno.buscarAlumno(codAlumno).getEstado().equals("Retirado") ) {
	            JOptionPane.showMessageDialog(null,
	                    "El alumno ya se encuentra retirado.");
	            return;
	        }
	        
	        gestorAlumno.actualizarEstado(codAlumno,2);
	        
	        Retiro nuevoRetiro = new Retiro(numRetiro, numMatricula, fecha, hora);

	        gestorRetiro.adicionar(nuevoRetiro);
	        JOptionPane.showMessageDialog(null, "¡Retiro registrado exitosamente!");
	        listarRetiros();
	        limpiarCampos();
	        mostrarSiguienteCodigo();

	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "Error: Ingrese un número de matrícula válido.");
	    }
	}
	
	private void limpiarCampos() {
	    txtNumeroMatricula.setText("");
	    table.clearSelection();
	    txtNumeroMatricula.setEditable(true);
	    txtNumeroMatricula.requestFocus();
	}
	
	private void cancelarRetiro() {
		 
		int numRetiro = Integer.parseInt(txtNumeroRetiro.getText());
		Retiro retiro = gestorRetiro.obtenerRetiro(numRetiro);
		
		if(retiro == null) {
			JOptionPane.showMessageDialog(null, "No existe ese retiro");
			return;
		}
	
		Matricula matricula = gestorMatricula.buscarPorNumero(retiro.getNumMatricula());
		if(matricula == null) {
			JOptionPane.showMessageDialog(null, "No la matricula");
			return;
		}
		
		
		int codAlumno = matricula.getCodAlumno();
		Alumno alumno = gestorAlumno.buscarAlumno(codAlumno);
		
		if (!alumno.getEstado().equals("Retirado")) {
	        JOptionPane.showMessageDialog(null, "Solo se puede eliminar un retiro cuando el alumno está retirado.");
	        return;
	    }
		
		int respuesta = JOptionPane.showConfirmDialog(this,"¿Desea eliminar el retiro?","Confirmación",JOptionPane.YES_NO_OPTION);

	    if (respuesta == JOptionPane.YES_OPTION) {
	        gestorRetiro.eliminarRetiro(numRetiro);
	        gestorAlumno.actualizarEstado(codAlumno, 1);
	        JOptionPane.showMessageDialog(null, "Retiro eliminado correctamente.");

	        listarRetiros();
	        limpiarCampos();
	        mostrarSiguienteCodigo();
	    }
	}
	
	
	
}