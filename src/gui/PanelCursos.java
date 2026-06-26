package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Bloque cambiado: Importaciones añadidas para eventos de mouse y gestión de matrículas
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import arreglos.GestorMatricula;
import clases.Matricula;
// Fin de bloque cambiado

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.GestorCursos;
import clases.Curso;

public class PanelCursos extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtCodigo;
	private JTextField txtCreditos;
	private JTextField txtHoras;

	private JComboBox<String> cboCiclo;

	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JButton btnEliminar;

	private JTable table;
	private DefaultTableModel modelo;

	private GestorCursos gestor;
	private JTextField txtAsignatura;
	// private JComboBox cboAsignatura;

	public PanelCursos() {

		gestor = new GestorCursos();

		setLayout(new BorderLayout());
		setBackground(new Color(245, 247, 250));

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(16, 0));
		panelPrincipal.setBackground(new Color(245, 247, 250));
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
		add(panelPrincipal, BorderLayout.CENTER);

		// PANEL FORMULARIO

		JPanel panelFormulario = new JPanel();
		panelFormulario.setPreferredSize(new Dimension(310, 650));
		panelFormulario.setBackground(Color.WHITE);
		panelFormulario.setBorder(BorderFactory.createLineBorder(new Color(210, 215, 220)));
		panelFormulario.setLayout(null);
		panelPrincipal.add(panelFormulario, BorderLayout.WEST);

		JLabel lblTitulo = new JLabel("Detalle del Curso");
		lblTitulo.setBounds(16, 12, 250, 25);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 13));
		panelFormulario.add(lblTitulo);
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 45, 310, 2);
		panelFormulario.add(separator);

		// CODIGO

		JLabel lblCodigo = new JLabel("CÓDIGO");
		lblCodigo.setBounds(16, 62, 120, 20);
		panelFormulario.add(lblCodigo);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(16, 85, 278, 32);
		panelFormulario.add(txtCodigo);

		// ASIGNATURA

		JLabel lblAsignatura = new JLabel("ASIGNATURA");
		lblAsignatura.setBounds(16, 130, 120, 20);
		panelFormulario.add(lblAsignatura);

		// CREDITOS

		JLabel lblCreditos = new JLabel("CRÉDITOS");
		lblCreditos.setBounds(16, 198, 120, 20);
		panelFormulario.add(lblCreditos);
		txtCreditos = new JTextField();
		txtCreditos.setBounds(16, 221, 278, 32);
		panelFormulario.add(txtCreditos);

		// HORAS

		JLabel lblHoras = new JLabel("HORAS");
		lblHoras.setBounds(16, 266, 120, 20);
		panelFormulario.add(lblHoras);
		txtHoras = new JTextField();
		txtHoras.setBounds(16, 289, 278, 32);
		panelFormulario.add(txtHoras);

		// CICLO

		JLabel lblCiclo = new JLabel("CICLO");
		lblCiclo.setBounds(16, 334, 120, 20);
		panelFormulario.add(lblCiclo);
		String ciclos[] = { "I Ciclo", "II Ciclo", "III Ciclo", "IV Ciclo", "V Ciclo", "VI Ciclo", "VII Ciclo",
				"VIII Ciclo", "IX Ciclo", "X Ciclo"

		};

		cboCiclo = new JComboBox<>(ciclos);
		cboCiclo.setBounds(16, 357, 278, 32);
		panelFormulario.add(cboCiclo);

		// BOTONES

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

		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(16, 152, 278, 35);
		panelFormulario.add(txtAsignatura);

		// PANEL TABLA

		// =======================
		// PANEL TABLA
		// =======================

		JPanel panelTabla = new JPanel();
		panelTabla.setLayout(new BorderLayout());
		panelTabla.setBackground(Color.WHITE);
		panelTabla.setBorder(BorderFactory.createLineBorder(new Color(210, 215, 220)));
		panelPrincipal.add(panelTabla, BorderLayout.CENTER);
		panelTabla.setBorder(BorderFactory.createLineBorder(new Color(210, 215, 220)));

		panelPrincipal.add(panelTabla, BorderLayout.CENTER);

		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(new EmptyBorder(0, 0, 0, 0));

		panelTabla.add(scroll, BorderLayout.CENTER);

		table = new JTable();
		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Código", "Asignatura", "Créditos", "Horas", "Ciclo" }

		) {

			/**
			 * 
			 */
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

		// Bloque añadido: MouseListener para cargar el curso seleccionado cuando se
		// hace clic en la tabla
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargarCursoSeleccionado();
			}
		});
		// Fin de bloque añadido

		scroll.setViewportView(table);

		// EVENTOS

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarCurso();
			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarCurso();
			}
		});
		cargarTabla();

	}

	// ==========================
	// GUARDAR CURSO (Bloque cambiado: ahora valida campos, maneja adición y
	// modificación, y limpia/recarga)
	// ==========================
	private void guardarCurso() {
		try {
			// Validar que el código sea de 4 dígitos numéricos
			String codigoStr = txtCodigo.getText().trim();
			if (!codigoStr.matches("\\d{4}")) {
				JOptionPane.showMessageDialog(this, "El código del curso debe tener exactamente 4 dígitos numéricos.");
				return;
			}
			int codigo = Integer.parseInt(codigoStr);

			// Validar asignatura no vacía
			String asignatura = txtAsignatura.getText().trim();
			if (asignatura.isEmpty()) {
				JOptionPane.showMessageDialog(this, "La asignatura no puede estar vacía.");
				return;
			}

			// Validar créditos como entero positivo
			int creditos;
			try {
				creditos = Integer.parseInt(txtCreditos.getText().trim());
				if (creditos <= 0) {
					JOptionPane.showMessageDialog(this, "El número de créditos debe ser un entero positivo.");
					return;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "El número de créditos debe ser un valor numérico entero.");
				return;
			}

			// Validar horas como entero positivo
			int horas;
			try {
				horas = Integer.parseInt(txtHoras.getText().trim());
				if (horas <= 0) {
					JOptionPane.showMessageDialog(this, "La cantidad de horas debe ser un entero positivo.");
					return;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "La cantidad de horas debe ser un valor numérico entero.");
				return;
			}

			int ciclo = cboCiclo.getSelectedIndex() + 1;

			// Crear objeto curso
			Curso curso = new Curso(codigo, asignatura, ciclo, creditos, horas);

			// Determinar si se adiciona o modifica según el estado editable del código
			if (txtCodigo.isEditable()) {
				// Modo: Adicionar
				boolean exito = gestor.agregarCurso(curso);
				if (exito) {
					JOptionPane.showMessageDialog(this, "Curso adicionado correctamente.");
				} else {
					JOptionPane.showMessageDialog(this, "Error: El código de curso ya está registrado.");
					return;
				}
			} else {
				// Modo: Modificar
				boolean exito = gestor.modificarCurso(curso);
				if (exito) {
					JOptionPane.showMessageDialog(this, "Curso modificado correctamente.");
				} else {
					JOptionPane.showMessageDialog(this, "Error al intentar modificar el curso.");
					return;
				}
			}

			cargarTabla();
			limpiarCampos();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado al guardar el curso.");
		}
	}
	// Fin de bloque cambiado

	// ==========================
	// CARGAR TABLA
	// ==========================
	private void cargarTabla() {
		modelo.setRowCount(0);
		for (Curso c : gestor.listarCursos()) {
			modelo.addRow(new Object[] { c.getCodCurso(), c.getAsignatura(), c.getCreditos(), c.getHoras(),
					c.getCiclo() + " Ciclo" });
		}
	}

	// ==========================
	// LIMPIAR (Bloque cambiado: restablece la editabilidad y color del código, y
	// limpia la selección)
	// ==========================
	private void limpiarCampos() {

		txtCodigo.setText("");
		txtCodigo.setEditable(true);
		txtCodigo.setBackground(Color.WHITE);
		txtAsignatura.setText("");
		txtCreditos.setText("");
		txtHoras.setText("");
		cboCiclo.setSelectedIndex(0);
		table.clearSelection();
	}
	// Fin de bloque cambiado

	// ==========================
	// ELIMINAR (Bloque cambiado: valida matrícula activa en GestorMatricula y pide
	// confirmación antes de borrar)
	// ==========================
	private void eliminarCurso() {
		int fila = table.getSelectedRow();
		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione un curso");
			return;
		}

		int codigo = Integer.parseInt(modelo.getValueAt(fila, 0).toString());

		// Validar que ningún alumno esté matriculado en este curso
		GestorMatricula gestorMat = new GestorMatricula();
		boolean tieneMatriculados = false;
		for (Matricula m : gestorMat.obtenerMatriculas()) {
			if (m.getCodCurso() == codigo) {
				tieneMatriculados = true;
				break;
			}
		}

		if (tieneMatriculados) {
			JOptionPane.showMessageDialog(this, "No se puede eliminar el curso porque hay alumnos matriculados en él.",
					"Acción denegada", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Solicitar confirmación previa antes de la eliminación física
		int confirmar = JOptionPane.showConfirmDialog(this,
				"¿Está seguro de eliminar físicamente este curso? Esta acción no se puede deshacer.",
				"Confirmar eliminación física", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (confirmar == JOptionPane.YES_OPTION) {
			if (gestor.eliminarCurso(codigo)) {
				JOptionPane.showMessageDialog(this, "Curso eliminado");
				cargarTabla();
				limpiarCampos();
			} else {
				JOptionPane.showMessageDialog(this, "Error al eliminar el curso.");
			}
		}
	}
	// Fin de bloque cambiado

	// ==========================
	// CARGAR CURSO SELECCIONADO (Bloque añadido: busca el curso por código y llena
	// el formulario, inhabilitando el código)
	// ==========================
	private void cargarCursoSeleccionado() {
		int fila = table.getSelectedRow();
		if (fila != -1) {
			int codigo = Integer.parseInt(modelo.getValueAt(fila, 0).toString());
			Curso c = gestor.buscarCurso(codigo);
			if (c != null) {
				txtCodigo.setText(String.valueOf(c.getCodCurso()));
				txtAsignatura.setText(c.getAsignatura());
				txtCreditos.setText(String.valueOf(c.getCreditos()));
				txtHoras.setText(String.valueOf(c.getHoras()));
				cboCiclo.setSelectedIndex(c.getCiclo() - 1);

				txtCodigo.setEditable(false);
				txtCodigo.setBackground(new Color(230, 230, 230));
			}
		}
	}
}