package ec.apuntes.vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class JIApuntes extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIApuntes frame = new JIApuntes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JIApuntes() {
		setTitle("Administraci\u00F3n Apuntes");
		setBounds(100, 100, 450, 300);

	}

}
