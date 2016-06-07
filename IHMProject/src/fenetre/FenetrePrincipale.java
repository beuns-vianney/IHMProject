package fenetre;

import java.awt.EventQueue;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;
import javax.swing.JLabel;


import java.awt.BorderLayout;
import java.awt.Color;

@SuppressWarnings("serial")
public class FenetrePrincipale extends JFrame {

	private JPanel mainPan;
	private JPanel contentPane;
	private int nbColor;
	private ArrayList<Color> couleursBase = new ArrayList<>();
	private ArrayList<JPanel> canvasC = new ArrayList<>();
	private ArrayList<JPanel> canvasG = new ArrayList<>();
	private final int width = 155;
	private final int height = 50;
	
	private final int xC = 70;
	
	private final int Y = 25;
	
	private final int xG = 450;
	
	
	public void setNbColor(int nbColor) {
		this.nbColor = nbColor;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipale frame = new FenetrePrincipale();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetrePrincipale() {
		couleursBase.add(new Color(0,0,0));
		couleursBase.add(new Color(153,152,80));
		couleursBase.add(new Color(25,182,54));
		couleursBase.add(new Color(50,0,205));
		couleursBase.add(new Color(255,180,130));
		couleursBase.add(new Color(200,50,80));
		this.setTitle("Convertisseur en gris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(700, 730));
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(40, 80));
		contentPane.add(panel, BorderLayout.NORTH);
		mainPan = new JPanel();
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 6, 1));
		panel.add(spinner);
		contentPane.add(mainPan, BorderLayout.CENTER);		
		
		spinner.addChangeListener(new MonChangeListener(this, spinner));
		mainPan.addMouseListener(new MonMouseEvent(this));
		this.nbColPrint();
		JLabel lblNombreDeCouleurs = new JLabel("Nombre de couleurs");
		panel.add(lblNombreDeCouleurs);
		this.pack();
	}
	
	public void nbColPrint(){
		mainPan.removeAll();
		if(nbColor<canvasC.size()){
			ArrayList<JPanel> tmp = new ArrayList<>();
			ArrayList<JPanel> tmp2 = new ArrayList<>();
			for(int i =0; i<nbColor;i++){
				tmp.add(canvasC.get(i));
				tmp2.add(canvasG.get(i));
			}
			canvasC.clear();
			canvasG.clear();
			for(JPanel p : tmp){
				canvasC.add(p);
			}
			for(JPanel p : tmp2){
				canvasG.add(p);
			}
		}else if(nbColor>canvasC.size()){
			for(int v = canvasC.size(); v<nbColor; v++){
				JPanel p = new JPanel();
				p.setBounds(xC, Y+100*v, width, height);
				p.setBackground(couleursBase.get(v));
				canvasC.add(p);
				int grey = (int) (0.3*p.getBackground().getRed()+0.59*p.getBackground().getGreen()+0.11*p.getBackground().getBlue());
				if(tooClose(grey)){
					JPanel warning = new JPanel();
					warning.setBounds(325, Y+10+100*v, 30, 30);
					warning.setBackground(Color.RED);
					mainPan.add(warning);
					JPanel warning2 = new JPanel();
					warning2.setBounds(325, Y+10+100*getTooClose(grey), 30, 30);
					warning2.setBackground(Color.RED);
					mainPan.add(warning2);
				}
				JPanel pan = new JPanel();
				pan.setBounds(xG, Y+100*v, width, height);
				pan.setBackground(new Color(grey, grey, grey));
				canvasG.add(pan);
			}
		}
		for(int i = 0; i<canvasC.size(); i++){
			mainPan.add(canvasC.get(i));				
			mainPan.add(canvasG.get(i));
		}
		repaint();
	}
	
	public void updateGris(ArrayList<JPanel> j){
		for(int p = 0; p<j.size(); p++){
			int grey = (int) (0.3*canvasC.get(p).getBackground().getRed()+0.59*canvasC.get(p).getBackground().getGreen()+0.11*canvasC.get(p).getBackground().getBlue());
			if(tooClose(grey)){
				JPanel warning = new JPanel();
				warning.setBounds(325, Y+10+100*p, 30, 30);
				warning.setBackground(Color.RED);
				mainPan.add(warning);
				JPanel warning2 = new JPanel();
				warning2.setBounds(325, Y+10+100*getTooClose(grey), 30, 30);
				warning2.setBackground(Color.RED);
				mainPan.add(warning2);
			}
			canvasG.get(p).setBackground(new Color(grey, grey, grey));
		}
	}
	
	private boolean tooClose(int i){
		for(int j =0; j<canvasG.size(); j++){
			if(i<=canvasG.get(j).getBackground().getRed() + 20 && i>= canvasG.get(j).getBackground().getRed()-20){
				return true;
			}
		}
		return false;
	}
	
	private int getTooClose(int i){
		for(int j =0; j<canvasG.size(); j++){
			if(i<=canvasG.get(j).getBackground().getRed() + 20 && i>= canvasG.get(j).getBackground().getRed()-20){
				return j;
			}
		}
		return -1;
	}
	public JPanel getMainPan() {
		return mainPan;
	}
	public ArrayList<JPanel> getCanvasC() {
		return canvasC;
	}
	public ArrayList<JPanel> getCanvasG() {
		return canvasG;
	}
	public int getxC() {
		// TODO Auto-generated method stub
		return this.xC;
	}
	public int getxG() {
		// TODO Auto-generated method stub
		return this.xG;
	}
}
