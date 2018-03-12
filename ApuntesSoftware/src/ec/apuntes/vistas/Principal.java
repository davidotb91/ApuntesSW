package ec.apuntes.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;

import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JLabel lblUsuarioActual;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new SyntheticaClassyLookAndFeel()  );
					Principal frame = new Principal();
					frame.setExtendedState(MAXIMIZED_BOTH);
					
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
	public Principal() {
		setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 16));
		setTitle("Libro de Apuntes");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);
		
		JMenu mnAdministracion = new JMenu("Administracion");
		menuBar.add(mnAdministracion);
		
		JMenuItem mnApunte = new JMenuItem("Apunte");
		mnApunte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*	try {
				IJFrmUsuario ijfrmusuario = new IJFrmUsuario();
				ijfrmusuario.setVisible(true);
				desktopPane.add(ijfrmusuario);
					ijfrmusuario.setMaximum(true);
				} catch (EXC e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				
			}
		});
		mnAdministracion.add(mnApunte);
		
		JMenuItem mnAutor = new JMenuItem("Autor");
		mnAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JIAutor jIAutor = new JIAutor();
					jIAutor.setVisible(true);
					desktopPane.add(jIAutor);
					jIAutor.setMaximum(true);
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.err.println("error al cargar la vista de autores ");
				}
				
			}
		});
		
		mnAdministracion.add(mnAutor);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		lblUsuarioActual = new JLabel("Usuario-Administrador");
		lblUsuarioActual.setFont(new Font("Yu Gothic Light", Font.BOLD | Font.ITALIC, 12));
		contentPane.add(lblUsuarioActual, BorderLayout.SOUTH);
		lblUsuarioActual.setText("Bienvenido  Davwolf ");
	
	}

}
