package ec.apuntes.vistas.eventos;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
/**
 * 
 * @author jonathan.tayupanta
 *clase que sirve para cambiar a mayuscula cuando pierda el focus
 */
public class EventoMayuscula implements FocusListener {
	
	
	private JTextField txtConv;
	public EventoMayuscula(JTextField txtConv) {
		this.txtConv = txtConv;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		txtConv.setText(txtConv.getText().toUpperCase());
		
	}

}
