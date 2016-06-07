package fenetre;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class MonMouseEvent implements MouseListener{

	FenetrePrincipale f;
	
	public MonMouseEvent(FenetrePrincipale f) {
		// TODO Auto-generated constructor stub
		this.f = f;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JPanel clicked =  (JPanel) f.getMainPan().getComponentAt(e.getX(), e.getY());
		if(f.getCanvasC().contains(clicked)){
	//		int idx = f.getCanvasC().indexOf(clicked);
			JColorChooser colorChoose = new JColorChooser();
			Color c=JColorChooser.showDialog(colorChoose, "Color Picker", Color.BLACK);
			clicked.setBackground(c);
/*			JLabel color = new JLabel("R:"+clicked.getBackground().getRed()+" G:"+clicked.getBackground().getGreen()+" B:"+clicked.getBackground().getBlue());
			color.setBounds(f.getxC()+10, f.getY()+ f.getHeight()+100*idx, 150, 10);
			f.getMainPan().add(color);
			JLabel gris = new JLabel("R:"+f.getCanvasG().get(idx).getBackground().getRed()+" G:"+f.getCanvasG().get(idx).getBackground().getGreen()+" B:"+f.getCanvasG().get(idx).getBackground().getBlue());
			gris.setBounds(f.getxG()+10, f.getY()+ f.getHeight()+100*idx, 150, 10);
			f.getMainPan().add(gris);*/
			f.updateGris(f.getCanvasC());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
