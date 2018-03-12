package ec.apuntes.vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;

import ec.apuntes.vistas.eventos.EventoMayuscula;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;

public class JIAutor extends JInternalFrame {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtPaisOr;
	private EventoMayuscula evMayuscula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIAutor frame = new JIAutor();
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
	public JIAutor() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Admin Autores");
		setBounds(100, 100, 450, 300);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pnlIngresarAut = new JPanel();
		tabbedPane.addTab("Ingresar Autor", null, pnlIngresarAut, null);
		pnlIngresarAut.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlDatAut = new JPanel();
		pnlDatAut.setBorder(new TitledBorder(null, "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlIngresarAut.add(pnlDatAut, BorderLayout.CENTER);
		GridBagLayout gbl_pnlDatAut = new GridBagLayout();
		gbl_pnlDatAut.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlDatAut.rowHeights = new int[]{0, 0, 30, 0, 0};
		gbl_pnlDatAut.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlDatAut.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDatAut.setLayout(gbl_pnlDatAut);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 0;
		pnlDatAut.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		evMayuscula = new EventoMayuscula(txtNombre);
	
		txtNombre.addFocusListener(evMayuscula);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 0;
		pnlDatAut.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 1;
		pnlDatAut.add(lblApellido, gbc_lblApellido);
		
		txtApellido = new JTextField();
		evMayuscula = new EventoMayuscula(txtApellido);
		
		txtNombre.addFocusListener(evMayuscula);
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.insets = new Insets(0, 0, 5, 0);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 1;
		pnlDatAut.add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 1;
		gbc_lblFechaDeNacimiento.gridy = 2;
		pnlDatAut.add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);
		
		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 2;
		pnlDatAut.add(dateChooser, gbc_dateChooser);
		
		JLabel lblPaisOrigen = new JLabel("Pais Origen:");
		GridBagConstraints gbc_lblPaisOrigen = new GridBagConstraints();
		gbc_lblPaisOrigen.anchor = GridBagConstraints.EAST;
		gbc_lblPaisOrigen.insets = new Insets(0, 0, 0, 5);
		gbc_lblPaisOrigen.gridx = 1;
		gbc_lblPaisOrigen.gridy = 3;
		pnlDatAut.add(lblPaisOrigen, gbc_lblPaisOrigen);
		
		txtPaisOr = new JTextField();
		GridBagConstraints gbc_txtPaisOr = new GridBagConstraints();
		gbc_txtPaisOr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPaisOr.gridx = 2;
		gbc_txtPaisOr.gridy = 3;
		pnlDatAut.add(txtPaisOr, gbc_txtPaisOr);
		txtPaisOr.setColumns(10);
		
		JPanel pnlConsAut = new JPanel();
		tabbedPane.addTab("Consultar Autor", null, pnlConsAut, null);
		
		JToolBar toolBarOpAut = new JToolBar();
		getContentPane().add(toolBarOpAut, BorderLayout.NORTH);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		toolBarOpAut.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		toolBarOpAut.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		toolBarOpAut.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		toolBarOpAut.add(btnEliminar);

	}

}
