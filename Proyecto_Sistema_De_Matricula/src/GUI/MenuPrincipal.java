package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panelContenedor;
	private CardLayout cardLayout;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal() {
		setTitle("Sistema de Matricula");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MenuPrincipal.class.getResource("/Imagenes/Logo/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100, 650);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(245, 247, 250));

		crearMenu();

		cardLayout = new CardLayout();
		panelContenedor = new JPanel(cardLayout);

		panelContenedor.add(new PanelAlumnos(), "ALUMNOS");
		panelContenedor.add(new PanelCursos(), "CURSOS");
		panelContenedor.add(new PanelMatricula(), "MATRICULA");
		panelContenedor.add(new PanelRetiros(), "RETIROS");
		panelContenedor.add(new PanelConsultaAlumnos(), "CONSULTA ALUMNOS");
		panelContenedor.add(new PanelConsultaCursos(), "CONSULTA CURSOS");
		panelContenedor.add(new PanelConsultaMatriculas(), "CONSULTA MATRICULAS");
		panelContenedor.add(new PanelConsultaRetiros(), "CONSULTA RETIROS");
		
		
		getContentPane().add(panelContenedor);

		cardLayout.show(panelContenedor, "ALUMNOS");
	}

	private void crearMenu() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(33, 37, 41));
		menuBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		setJMenuBar(menuBar);

		// MENÚ MANTENIMIENTO
		JMenu mnMantenimiento = crearMenuEstilizado("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/Iconos/mantenimiento.png")));
		menuBar.add(mnMantenimiento);

		JMenuItem itemAlumnos = crearItem("Alumnos");
		itemAlumnos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/Iconos/alumnos.png")));

		JMenuItem itemCursos = crearItem("Cursos");
		itemCursos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/Iconos/cursos.png")));

		mnMantenimiento.add(itemAlumnos);
		mnMantenimiento.add(itemCursos);

		// MENÚ REGISTRO
		JMenu mnRegistro = crearMenuEstilizado("Registro");
		mnRegistro.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/Iconos/registro.png")));
		menuBar.add(mnRegistro);

		JMenuItem itemMatricula = crearItem("Matricula");
		itemMatricula.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/Iconos/matricula.png")));

		JMenuItem itemRetiros = crearItem("Retiros");
		itemRetiros.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/Iconos/retiro.png")));

		mnRegistro.add(itemMatricula);
		mnRegistro.add(itemRetiros);

		// MENÚ CONSULTA
		JMenu mnConsulta = crearMenuEstilizado("Consulta");
		mnConsulta.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/Iconos/consulta.png")));
		menuBar.add(mnConsulta);

		JMenuItem itemConsultaAlumnos = crearItem("Alumnos");
		itemConsultaAlumnos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/Iconos/alumnos.png")));

		JMenuItem itemConsultaCursos = crearItem("Cursos");
		itemConsultaCursos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/Iconos/cursos.png")));

		JMenuItem itemConsultaMatriculas = crearItem("Matriculas");
		itemConsultaMatriculas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/Iconos/matricula.png")));

		JMenuItem itemConsultaRetiros = crearItem("Retiros");
		itemConsultaRetiros.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/Iconos/retiro.png")));

		mnConsulta.add(itemConsultaAlumnos);
		mnConsulta.add(itemConsultaCursos);
		mnConsulta.add(itemConsultaMatriculas);
		mnConsulta.add(itemConsultaRetiros);

		// MENÚ REPORTE
		JMenu mnReporte = crearMenuEstilizado("Reporte");
		mnReporte.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/Iconos/report.png")));
		menuBar.add(mnReporte);
		
		//Eventos
		itemAlumnos.addActionListener(e -> mostrarPanel("ALUMNOS"));
		itemCursos.addActionListener(e -> mostrarPanel("CURSOS"));
		itemMatricula.addActionListener(e -> mostrarPanel("MATRICULA"));
		itemRetiros.addActionListener(e -> mostrarPanel("RETIROS"));
		itemConsultaAlumnos.addActionListener(e -> mostrarPanel("CONSULTA ALUMNOS"));
		itemConsultaCursos.addActionListener(e -> mostrarPanel("CONSULTA CURSOS"));
		itemConsultaMatriculas.addActionListener(e -> mostrarPanel("CONSULTA MATRICULAS"));
		itemConsultaRetiros.addActionListener(e -> mostrarPanel("CONSULTA RETIROS"));
		
	}

	
	private void mostrarPanel(String nombrePanel) {
		cardLayout.show(panelContenedor, nombrePanel);
	}

	private JMenu crearMenuEstilizado(String texto) {
		JMenu menu = new JMenu(texto);
		menu.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
		menu.setForeground(Color.WHITE);
		menu.setOpaque(true);
		menu.setBackground(new Color(33, 37, 41));
		menu.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
		return menu;
	}

	private JMenuItem crearItem(String texto) {
		JMenuItem item = new JMenuItem(texto);
		item.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
		item.setBackground(Color.WHITE);
		item.setForeground(new Color(33, 37, 41));
		item.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
		return item;
	}
}