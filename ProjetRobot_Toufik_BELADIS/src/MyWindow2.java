import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class MyWindow2 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public Monde m;
	private JButton btnPollueurSauteur;
	
	// le constructeur de la fenêtre
	public MyWindow2(Monde m){
        super("Jeu de Robots");
        this.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
        this.setSize(800, 500);
        this.setLocationRelativeTo( null );
        this.m = m;

        JPanel ContentPane = (JPanel) this.getContentPane();

        ContentPane.add(createNorth(), BorderLayout.NORTH);
        ContentPane.add(createWest(), BorderLayout.WEST);
        ContentPane.add(createEast(), BorderLayout.EAST);
        ContentPane.add(createSouth(), BorderLayout.SOUTH);
        ContentPane.add(createCenter(m), BorderLayout.CENTER);
        
        
        // Confirmation de la fermuture de la fenêtre 
        this.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		int ClickedButton = JOptionPane.showConfirmDialog(MyWindow2.this, 
        				"Êtes-vous sûr de quitter ?", "", JOptionPane.YES_NO_OPTION);
        		if(ClickedButton == JOptionPane.YES_OPTION) MyWindow2.this.dispose();
        	}
		});
        
        //btnPollueurSauteur.addActionListener(new PollueurSauteurListener());
        
        
    }
	// - - - - - - - - - - - - - - - Fin constructeur de la fenêtre - - - - - - - - - - - - - - - -
	
	
	
	
	// - - - - - - - - NORTH - - - - - - - - - - 
    private JToolBar createNorth(){
        JToolBar toolBar = new JToolBar();

        JButton btnPush = new JButton("push");
        btnPush.addActionListener( this::btnPushListener );

        JButton btnClick = new JButton("Click");
        btnClick.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnClick.setForeground(Color.black);
        	}
        	
        	@Override
        	public void mouseEntered(MouseEvent e) {
				btnClick.setForeground(Color.red);
			}
		});
        
        JCheckBox chkCheck = new JCheckBox("Check");
        JTextField txtEdit = new JTextField("Edit");
        txtEdit.setPreferredSize(new Dimension(140,30));

        toolBar.add(btnPush);
        toolBar.add(btnClick);
        toolBar.add(chkCheck);
        toolBar.add(txtEdit);

        return toolBar;
    }
    // - - - - - - - - - - - - - - - - - - - - -  
    
    
	// - - - - - - - - WEST - - - - - - - - - - 
    private JPanel createWest() {
        JPanel panel = new JPanel(new GridLayout(4,1));
        
        btnPollueurSauteur = new JButton("Pollueur Sauteur");
        JButton PollueurLibre = new JButton("Pollueur Libre");
        JButton PollueurDroit = new JButton("Pollueur Droit");
        JButton PolluerTout = new JButton("Polluer Tout");
        
        PollueurLibre.addActionListener(this::PollueurLibreListener);
        
        panel.add(btnPollueurSauteur);
        panel.add(PollueurLibre);
        panel.add(PollueurDroit);
        panel.add(PolluerTout);

        return panel;
    }
    // - - - - - - - - - - - - - - - - - - - - -  
    
    
	// - - - - - - - - EAST - - - - - - - - - - 
    private JPanel createEast(){
        JPanel panel = new JPanel(new GridLayout(4,1));

        panel.add(new JButton("Nettoyeur Sauteur"));
        panel.add(new JButton("Nettoyeur Libre"));
        panel.add(new JButton("Nettoyeur Droit"));
        panel.add(new JButton("Nettoyeur Tout"));

        return panel;
    }
    // - - - - - - - - - - - - - - - - - - - - - 
    
    
    // - - - - - - - - SOUTH - - - - - - - - - - 
    private JPanel createSouth(){
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lblStatus1 = new JLabel("Message 1");
        lblStatus1.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus1);

        JLabel lblStatus2 = new JLabel("Message 2");
        lblStatus2.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus2);

        JLabel lblStatus3 = new JLabel("Message 3");
        lblStatus3.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus3);

        return statusBar;
    }
    // - - - - - - - - - - - - - - - - - - - - - 
    
    
    // - - - - - - - - CENTER - - - - - - - - - - 
	private JPanel createCenter(Monde m) {
		int nbL = m.getnbL(), nbC = m.getnbC();
		
		JPanel matCenter[][] = new JPanel[nbL][nbC];
		JPanel center = new JPanel();
		
		center.setLayout(new GridLayout(nbL,nbC));
		
		for(int i=0; i<nbL; i++) {
			for(int j=0; j<nbC; j++){
				matCenter[i][j] = new JPanel();
				if(m.estGras(i, j)) matCenter[i][j].setBackground(Color.black);
				else matCenter[i][j].setBackground(Color.blue);
				center.add(matCenter[i][j]);
				matCenter[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
			}
		}
	    return center;
	}
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  
    
    
	
	// - - - - - - - - - - - - - - - - Listener functions - - - - - - - - - - - - - - -
	
    private void btnPushListener(ActionEvent event){
        System.out.println("btnPush clicked");
    }
   
    private void PollueurLibreListener(ActionEvent event){
        PollueurLibre p = new PollueurLibre(this.m);
        p.parcourir(20);
    	System.out.println("clicked");
    }
    
    


}


// ----------