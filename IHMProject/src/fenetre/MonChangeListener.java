package fenetre;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MonChangeListener implements ChangeListener {

	FenetrePrincipale f;
	JSpinner spin;
	
	public MonChangeListener(FenetrePrincipale f, JSpinner sp) {
		// TODO Auto-generated constructor stub
		this.f = f;
		this.spin = sp;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		f.setNbColor((int)spin.getValue());
		f.nbColPrint();
		f.repaint();
	}
	
}
