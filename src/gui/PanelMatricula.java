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
import arreglos.GestorCursos;
import arreglos.GestorMatricula;
import clases.Alumno;
import clases.Matricula;

public class PanelMatricula extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private GestorMatricula gestorMatricula = new GestorMatricula();
	private GestorAlumnos gestorAlumnos = new GestorAlumnos() ;
	private GestorCursos gestorCurso = new GestorCursos();
	
	private JTextField txtNumeroMatricula ;
	private JTextField txxCodAlumno;
	private JTextField txtCodCurso;


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
        btnEliminar = new JButton("CANCELAR");
        btnEliminar.setBounds(208, 420, 86, 35);
        btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnEliminar.setBackground(new Color(211, 47, 47));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);
        panelFormulario.add(btnEliminar);
        
        btnGuardar.addActionListener( e -> guardarMatricula());
        btnLimpiar.addActionListener( e -> {
            limpiarCampos();
            mostrarSiguienteCodigo();
        });
        btnEliminar.addActionListener(e -> cancelarMatricula());
        
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
                	    "Codigo Alumno",
                	    "Codigo Curso",
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
        
        mostrarSiguienteCodigo();
        listarMatriculas();
        
        table.getSelectionModel().addListSelectionListener(e ->{
        	if(!e.getValueIsAdjusting()) {
        		mostrarDatos();
        	}
        });
	}
	
	
	public void guardarMatricula() {

	    try {

	        int codAlumno = Integer.parseInt(txxCodAlumno.getText().trim());
	        int codCurso = Integer.parseInt(txtCodCurso.getText().trim());
	        
	        if (gestorAlumnos.buscarAlumno(codAlumno) == null) {
	            JOptionPane.showMessageDialog(null, "No existe ese Código de Alumno");
	            return;
	        }

	        if (gestorCurso.buscarCurso(codCurso) == null) {
	            JOptionPane.showMessageDialog(null, "No existe ese Código de Curso");
	            return;
	        }

	        Matricula matriculaPrevia = gestorMatricula.buscarPorAlumno(codAlumno);
	        
	        if (matriculaPrevia != null) {
	            if (matriculaPrevia.getCodCurso() == codCurso) {
	                JOptionPane.showMessageDialog(null, "El alumno ya se encuentra matriculado en este curso.");
	            } else {

	                gestorMatricula.cambiarCursoMatriculado(matriculaPrevia.getNumMatricula(), codCurso);
	                JOptionPane.showMessageDialog(null, "¡El alumno ya estaba matriculado!\nSe ha cambiado su curso exitosamente.");
	                
	                listarMatriculas();
	                txxCodAlumno.setText("");
	                txtCodCurso.setText("");
	            }
	            return; 
	        }

	        int numMatricula = gestorMatricula.obtenerSiguienteCodigo();
	        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	        String hora = new SimpleDateFormat("HH:mm:ss").format(new Date());

	        Matricula nuevaMatricula = new Matricula(numMatricula, codAlumno, codCurso, fecha, hora);
	        
	        gestorMatricula.adicionar(nuevaMatricula);
	        gestorAlumnos.actualizarEstado(codAlumno, 1);

	        JOptionPane.showMessageDialog(null,"¡Matrícula nueva guardada exitosamente!");

	        listarMatriculas();
	        mostrarSiguienteCodigo(); 
	        txxCodAlumno.setText("");
	        txtCodCurso.setText("");
	        txxCodAlumno.requestFocus();

	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "Ingrese códigos numéricos válidos.", "Aviso", JOptionPane.ERROR_MESSAGE);
	    }
	}
	

	private void listarMatriculas() {
		
	    modelo.setRowCount(0);
	    ArrayList<Matricula> lista = gestorMatricula.obtenerMatriculas();

	    for (Matricula m : lista) {
	        Object[] fila = new Object[5];
	        
	        fila[0] = m.getNumMatricula();
	        fila[1] = m.getCodAlumno(); 
	        fila[2] = m.getCodCurso(); 
	        fila[3] = m.getFecha();
	        fila[4] = m.getHora();

	        modelo.addRow(fila);
	    }
	}
	

	private void mostrarDatos() {
		
		int fila = table.getSelectedRow();
		if(fila == -1) {
			return;
		}
		
		txtNumeroMatricula.setText(table.getValueAt(fila, 0).toString());
		txxCodAlumno.setText(table.getValueAt(fila, 1).toString());
		txtCodCurso.setText(table.getValueAt(fila, 2).toString());
		
		txxCodAlumno.setEditable(false);
	}
	
	private void mostrarSiguienteCodigo() {
	    txtNumeroMatricula.setText(String.valueOf(gestorMatricula.obtenerSiguienteCodigo()));
	    txtNumeroMatricula.setEditable(false);
	}

	private void limpiarCampos() {
	    txxCodAlumno.setText("");
	    txtCodCurso.setText("");
	    table.clearSelection();
	    txxCodAlumno.setEditable(true);
	    txxCodAlumno.requestFocus();
	}
	
	private void cancelarMatricula() {

	    int numMatricula = Integer.parseInt(txtNumeroMatricula.getText().trim());
	    int codigoAlumno = Integer.parseInt(txxCodAlumno.getText().trim());

	    Alumno alumno = gestorAlumnos.buscarAlumno(codigoAlumno);
	    
	    if(alumno == null) {
	    	JOptionPane.showMessageDialog(null, "No hay un alumno con ese codigo");
	    	return;
	    }
	    
	    if(alumno.getEstado() == 2) {
	    	JOptionPane.showMessageDialog(null, "El alumno ya se encuentra retirado");
	    	return;
	    }
	    
	    int respuesta = JOptionPane.showConfirmDialog(this,"¿Desea eliminar esta matrícula?","Confirmación",JOptionPane.YES_NO_OPTION);
	    if (respuesta == JOptionPane.YES_OPTION) {

	        if (gestorMatricula.eliminarMatricula(numMatricula)) {
	        	
	        	gestorAlumnos.actualizarEstado(codigoAlumno, 0);
	            JOptionPane.showMessageDialog(this, "Matrícula eliminada correctamente.");
	            listarMatriculas();
	            limpiarCampos();
	            mostrarSiguienteCodigo();
	        } else {
	            JOptionPane.showMessageDialog(this,"No se encontró la matrícula.");
	        }
	    }
	}
	
}