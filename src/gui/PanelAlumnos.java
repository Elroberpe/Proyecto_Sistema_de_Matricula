package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


	private JComboBox<String> cboEstado;


	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JButton btnEliminar;


	private JTable table;

	private DefaultTableModel modelo;


	private GestorAlumnos gestor;



	public PanelAlumnos() {


		gestor = new GestorAlumnos();



		setLayout(new BorderLayout());

		setBackground(new Color(245,247,250));



		JPanel panelPrincipal = new JPanel();

		panelPrincipal.setLayout(new BorderLayout(16,0));

		panelPrincipal.setBackground(new Color(245,247,250));

		panelPrincipal.setBorder(
				BorderFactory.createEmptyBorder(16,16,16,16)
		);



		add(panelPrincipal, BorderLayout.CENTER);





		// ==============================
		// FORMULARIO
		// ==============================


		JPanel panelFormulario = new JPanel();

		panelFormulario.setPreferredSize(
				new Dimension(310,650)
		);

		panelFormulario.setBackground(Color.WHITE);

		panelFormulario.setLayout(null);

		panelFormulario.setBorder(
				BorderFactory.createLineBorder(
						new Color(210,215,220)
				)
		);



		panelPrincipal.add(
				panelFormulario,
				BorderLayout.WEST
		);




		JLabel titulo = new JLabel("Detalle del Alumno");

		titulo.setBounds(16,12,250,25);

		titulo.setFont(
				new Font("Segoe UI",Font.BOLD,13)
		);

		panelFormulario.add(titulo);



		JSeparator separador = new JSeparator();

		separador.setBounds(0,45,310,2);

		panelFormulario.add(separador);




		// CODIGO

		JLabel lblCodigo = new JLabel("CODIGO");

		lblCodigo.setBounds(16,62,120,20);

		panelFormulario.add(lblCodigo);



		txtCodigo = new JTextField();

		txtCodigo.setBounds(16,85,278,32);

		panelFormulario.add(txtCodigo);





		// NOMBRES


		JLabel lblNombres = new JLabel("NOMBRES");

		lblNombres.setBounds(16,130,120,20);

		panelFormulario.add(lblNombres);



		txtNombres = new JTextField();

		txtNombres.setBounds(16,153,278,32);

		panelFormulario.add(txtNombres);






		// APELLIDOS


		JLabel lblApellidos = new JLabel("APELLIDOS");

		lblApellidos.setBounds(16,198,120,20);

		panelFormulario.add(lblApellidos);



		txtApellidos = new JTextField();

		txtApellidos.setBounds(16,221,278,32);

		panelFormulario.add(txtApellidos);





		// DNI


		JLabel lblDni = new JLabel("DNI");

		lblDni.setBounds(16,266,120,20);

		panelFormulario.add(lblDni);



		txtDni = new JTextField();

		txtDni.setBounds(16,289,278,32);

		panelFormulario.add(txtDni);






		// EDAD


		JLabel lblEdad = new JLabel("EDAD");

		lblEdad.setBounds(16,334,120,20);

		panelFormulario.add(lblEdad);



		txtEdad = new JTextField();

		txtEdad.setBounds(16,357,278,32);

		panelFormulario.add(txtEdad);







		// CELULAR


		JLabel lblCelular = new JLabel("CELULAR");

		lblCelular.setBounds(16,402,120,20);

		panelFormulario.add(lblCelular);



		txtCelular = new JTextField();

		txtCelular.setBounds(16,425,278,32);

		panelFormulario.add(txtCelular);






		// ESTADO


		JLabel lblEstado = new JLabel("ESTADO");

		lblEstado.setBounds(16,470,120,20);

		panelFormulario.add(lblEstado);



		String estados[] = {

				"Registrado",
				"Matriculado",
				"Retirado"

		};



		cboEstado = new JComboBox<>(estados);

		cboEstado.setBounds(16,493,278,32);

		panelFormulario.add(cboEstado);







		// BOTONES


		btnGuardar = new JButton("GUARDAR");

		btnGuardar.setBounds(16,550,85,35);

		panelFormulario.add(btnGuardar);



		btnLimpiar = new JButton("LIMPIAR");

		btnLimpiar.setBounds(112,550,85,35);

		panelFormulario.add(btnLimpiar);



		btnEliminar = new JButton("ELIMINAR");

		btnEliminar.setBounds(208,550,86,35);

		panelFormulario.add(btnEliminar);









		// ==============================
		// TABLA
		// ==============================


		JPanel panelTabla = new JPanel();

		panelTabla.setLayout(new BorderLayout());

		panelTabla.setBackground(Color.WHITE);

		panelTabla.setBorder(
				BorderFactory.createLineBorder(
						new Color(210,215,220)
				)
		);



		panelPrincipal.add(
				panelTabla,
				BorderLayout.CENTER
		);




		JScrollPane scroll = new JScrollPane();

		scroll.setBorder(
				new EmptyBorder(0,0,0,0)
		);



		panelTabla.add(
				scroll,
				BorderLayout.CENTER
		);




		table = new JTable();



		modelo = new DefaultTableModel(

				new Object[][]{},

				new String[]{

						"Código",
						"Nombres",
						"Apellidos",
						"DNI",
						"Celular",
						"Estado"

				}

		){


			private static final long serialVersionUID = 1L;


			public boolean isCellEditable(int fila,int columna){

				return false;

			}


		};



		table.setModel(modelo);

		scroll.setViewportView(table);







		// ==============================
		// EVENTOS
		// ==============================


		btnGuardar.addActionListener(
				
				new ActionListener(){

					public void actionPerformed(ActionEvent e){

						guardarAlumno();

					}

				}

		);




		btnLimpiar.addActionListener(

				new ActionListener(){

					public void actionPerformed(ActionEvent e){

						limpiarCampos();

					}

				}

		);




		btnEliminar.addActionListener(

				new ActionListener(){

					public void actionPerformed(ActionEvent e){

						eliminarAlumno();

					}

				}

		);




		cargarTabla();



	}







	// =====================================
	// GUARDAR
	// =====================================


	private void guardarAlumno(){


		try{


			Alumno alumno = new Alumno(

					Integer.parseInt(txtCodigo.getText()),

					txtNombres.getText(),

					txtApellidos.getText(),

					txtDni.getText(),

					Integer.parseInt(txtEdad.getText()),

					Integer.parseInt(txtCelular.getText()),

					cboEstado.getSelectedIndex()+1

			);



			gestor.agregarAlumno(alumno);



			JOptionPane.showMessageDialog(
					this,
					"Alumno registrado"
			);



			cargarTabla();

			limpiarCampos();



		}catch(Exception e){


			JOptionPane.showMessageDialog(
					this,
					"Complete correctamente los datos"
			);


		}



	}









	// =====================================
	// CARGAR TABLA
	// =====================================


	private void cargarTabla(){



		modelo.setRowCount(0);



		for(Alumno a : gestor.listarAlumnos()){



			String estado="";


			switch(a.getEstado()){


			case 1:
				estado="Registrado";
				break;


			case 2:
				estado="Matriculado";
				break;


			case 3:
				estado="Retirado";
				break;

			}




			modelo.addRow(

					new Object[]{


							a.getCodAlumno(),

							a.getNombres(),

							a.getApellidos(),

							a.getDni(),

							a.getCelular(),

							estado


					}

			);


		}



	}









	// =====================================
	// LIMPIAR
	// =====================================


	private void limpiarCampos(){


		txtCodigo.setText("");

		txtNombres.setText("");

		txtApellidos.setText("");

		txtDni.setText("");

		txtEdad.setText("");

		txtCelular.setText("");

		cboEstado.setSelectedIndex(0);


	}









	// =====================================
	// ELIMINAR
	// =====================================


	private void eliminarAlumno(){



		int fila = table.getSelectedRow();



		if(fila==-1){


			JOptionPane.showMessageDialog(
					this,
					"Seleccione un alumno"
			);


			return;

		}



		int codigo = Integer.parseInt(

				modelo.getValueAt(
						fila,
						0
				).toString()

		);




		if(gestor.eliminarAlumno(codigo)){


			JOptionPane.showMessageDialog(
					this,
					"Alumno eliminado"
			);


			cargarTabla();


		}


	}


}