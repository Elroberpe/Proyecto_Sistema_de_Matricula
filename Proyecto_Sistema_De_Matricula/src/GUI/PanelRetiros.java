package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelRetiros extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelRetiros() {
		setLayout(new BorderLayout());
		setBackground(new Color(245, 247, 250));

		JLabel titulo = new JLabel("Módulo de Retiros", SwingConstants.CENTER);
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
		titulo.setForeground(new Color(33, 37, 41));

		add(titulo, BorderLayout.CENTER);
	}
}