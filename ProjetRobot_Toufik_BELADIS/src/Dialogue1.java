import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dialogue1 extends JDialog {
	private static final long serialVersionUID = 4796014791726497652L;
	int nbL;
    int nbC;
    JTextField nbligne;
    JTextField nbcolonne;
    boolean estInitialised = false;

    
    public Dialogue1(MyWindow3 w) {
    	
		this.setLayout(new GridLayout(3,1));
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setTitle("Initialiser le monde");
		
		JPanel j1 = new JPanel();
		j1.setLayout(new GridLayout(1,2));
		JLabel label1 = new JLabel("Nombre de Lignes : ");
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		nbligne = new JTextField("0");
		nbligne.setHorizontalAlignment(JTextField.CENTER);
		JPanel nbligneJPanel = new JPanel();
		nbligne.setPreferredSize(new Dimension(100,40));
		nbligneJPanel.add(nbligne);
		
		j1.add(label1);
		j1.add(nbligneJPanel);
		this.add(j1);
		
		JPanel j2 = new JPanel(new BorderLayout());
		j2.setLayout(new GridLayout(1,2));
		JLabel label2 = new JLabel("Nombre de colonnes : ");
		label2.setHorizontalAlignment(JLabel.CENTER);
		
		nbcolonne = new JTextField("0");
		nbcolonne.setHorizontalAlignment(JTextField.CENTER);
		JPanel nbcolonneJPanel = new JPanel();
		nbcolonne.setPreferredSize(new Dimension(100,40));
		nbcolonneJPanel.add(nbcolonne);
		
		j2.add(label2);
		j2.add(nbcolonneJPanel);
		this.add(j2);
	    
	    JButton okButton = new JButton("OK");
	    JPanel okJPanel = new JPanel();
	    okButton.setPreferredSize(new Dimension(100,35));
	    okJPanel.add(okButton);
	    this.add(okJPanel);
	    
	    okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nbL = Integer.valueOf(nbligne.getText());
				nbC = Integer.valueOf(nbcolonne.getText());
				if(nbL>=2 && nbC>=2) {
					w.estInitialised = true;
		        	dispose();
		        	//w.m.setNbL(nbL);
		        	//w.m.setNbC(nbC);
		        	w.m = new Monde(nbL, nbC);
		    		w.matCenter = new JLabel[nbL][nbC];
		    		w.center = new JPanel();
		    		w.center.setLayout(new GridLayout(nbL,nbC));
		    		
		    		for(int i=0; i<nbL; i++) {
		    			for(int j=0; j<nbC; j++){
		    				w.matCenter[i][j] = new JLabel();
		    				w.matCenter[i][j].setOpaque(true);
		    				w.matCenter[i][j].setBackground(Color.lightGray);
		    				w.center.add(w.matCenter[i][j]);
		    				w.matCenter[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
		    			}
		    		}
		        	
		        	w.add(w.center, BorderLayout.CENTER);
		        	w.setVisible(true);
				}

				else {
					// dire qu'il faut donner un nbc >=2 et un nbL>=2
				}
				
				
				
				
			}
		});
	    
	    //setVisible(true);
	}
    
    // - - - - - - - - CENTER - - - - - - - - - - 

    
   
	
	public int getnbL() {
		return nbL;
	}
	
	public int getnbC() {
		return nbC;
	}
	
    // is initialiser ?
    public boolean isInitialised() {
		return estInitialised;
	}
	
}
