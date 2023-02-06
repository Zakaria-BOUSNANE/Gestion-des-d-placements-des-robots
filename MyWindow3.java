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
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;

public class MyWindow3 extends JFrame {

	private static final long serialVersionUID = 801012339250797429L;
	public Monde m; // = new Monde();
	public JLabel matCenter[][];
	public JPanel center;
	JTextField txtEdit;
	public boolean estInitialised = false;
	boolean btnNDynamique = false;
	boolean btnPDynamique = false;
	int nbPmax = 3, nbPActuel=0;
	int nbNmax = 3, nbNActuel=0;
	int nbPapierGras = 0;
	public JLabel lblStatus2;
	
	NettoyeurDynamique pN[] = new NettoyeurDynamique[nbNmax];
	PollueurDynamique pD[] = new PollueurDynamique[nbPmax];
	public static final Color DARK_GREEN = new Color(0,153,0);
	public static final Color DARK_RED = new Color(240,0,0);
	Dialogue1 d1 = new Dialogue1(MyWindow3.this);
	Dialogue2 d2 = new Dialogue2();
	
	// - - - - - - - - - - - - - - - Constructeur de la fenêtre - - - - - - - - - - - - - - - -
	public MyWindow3(){
        super("Jeu de Robots");
        this.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
        this.setSize(1000, 600);
        this.setLocationRelativeTo( null );
        this.setLayout(new BorderLayout());
        
        // JPanel ContentPane = (JPanel) this.getContentPane();
        this.add(createNorth(), BorderLayout.NORTH);
        this.add(createWest(), BorderLayout.WEST);
        this.add(createEast(), BorderLayout.EAST);
        this.add(createSouth(), BorderLayout.SOUTH);
        //La partie centrale est créée après l'initialisation par l'utilisateur
        
        
        // Confirmation de la fermuture de la fenêtre principale !
        UIManager.put("OptionPane.yesButtonText", "Oui");
        UIManager.put("OptionPane.noButtonText", "Non");
        this.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		int ClickedButton = JOptionPane.showConfirmDialog(MyWindow3.this, 
        				"Êtes-vous sûr de quitter ?", "", JOptionPane.YES_NO_OPTION);
        		if(ClickedButton == JOptionPane.YES_OPTION) System.exit(0);
        		//MyWindow3.this.dispose();
        	}
		});
        
    }
	// - - - - - - - - - - - - - - - Fin constructeur de la fenêtre - - - - - - - - - - - - - - - -

	
	// - - - - - - - - - - - - - Méthodes pour la création de la fenêtre principale - - - - - - - - - 
	// - - - - - - - - NORTH - - - - - - - - - - 
    private JToolBar createNorth(){
        JToolBar toolBar = new JToolBar();
        //toolBar.setLayout(new GridLayout(1,6));
        
        JButton btninitialiser = new JButton("Initialiser");
        JButton btnPolluerTout = new JButton("Polluer Tout");
        JButton btnNettoyerTout = new JButton("Nettoyer Tout");
        txtEdit = new JTextField("Ecrire..");
        JButton btnAfficher = new JButton("Afficher");
        JButton btnHelp = new JButton("Assistant");
        
        btninitialiser.setPreferredSize(new Dimension(100,28));
        btnPolluerTout.setPreferredSize(new Dimension(100,28));
        btnNettoyerTout.setPreferredSize(new Dimension(100,28));
        btnHelp.setPreferredSize(new Dimension(100,28));
        btnAfficher.setPreferredSize(new Dimension(70,28));
        txtEdit.setPreferredSize(new Dimension(200,28));
        
        btninitialiser.addActionListener(this::btninitialiserListener);
        btnPolluerTout.addActionListener(this::btnPolluerToutListener);
        btnNettoyerTout.addActionListener(this::btnNettoyerToutListener);
        btnHelp.addActionListener(this::btnHelpListener);
        btnAfficher.addActionListener(this::btnAfficherListener);

        toolBar.add(btninitialiser);
        toolBar.add(btnPolluerTout);
        toolBar.add(btnNettoyerTout);
        toolBar.add(txtEdit);
        toolBar.add(btnAfficher);
        toolBar.add(btnHelp);

        btninitialiser.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btninitialiser.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btninitialiser.setForeground(Color.DARK_GRAY);} });
        
        btnPolluerTout.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btnPolluerTout.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btnPolluerTout.setForeground(Color.DARK_GRAY);} });
        
        btnNettoyerTout.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btnNettoyerTout.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btnNettoyerTout.setForeground(Color.DARK_GRAY);} });
        
        btnHelp.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btnHelp.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btnHelp.setForeground(Color.DARK_GRAY);} });
        
        btnAfficher.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btnAfficher.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btnAfficher.setForeground(Color.DARK_GRAY);} });
        
        txtEdit.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {txtEdit.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {txtEdit.setForeground(Color.DARK_GRAY);} });
        
        return toolBar;
    }
    // - - - - - - - - - - - - - - - - - - - - -  
    
    
	// - - - - - - - - WEST - - - - - - - - - - 
    private JPanel createWest() {
        JPanel panel = new JPanel(new GridLayout(5,1));
        
        JButton btnPollueurSauteur = new JButton("Pollueur Sauteur");
        JButton btnPollueurLibre = new JButton("Pollueur Libre");
        JButton btnPollueurDroit = new JButton("Pollueur Droit");
        JButton btnPollueurDynamique = new JButton("Pollueur Dynamique");
        JButton btnArretPDynamique = new JButton("Arrêter PDynamique");
        
        panel.add(btnPollueurSauteur);
        panel.add(btnPollueurLibre);
        panel.add(btnPollueurDroit);
        panel.add(btnPollueurDynamique);
        panel.add(btnArretPDynamique);
        
        btnPollueurSauteur.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btnPollueurSauteur.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btnPollueurSauteur.setForeground(DARK_RED);} });
        
        btnPollueurLibre.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btnPollueurLibre.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btnPollueurLibre.setForeground(DARK_RED);} });
        
        btnPollueurDroit.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btnPollueurDroit.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btnPollueurDroit.setForeground(DARK_RED);} });
        
        btnPollueurDynamique.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btnPollueurDynamique.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btnPollueurDynamique.setForeground(DARK_RED);} });
        
        btnArretPDynamique.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btnArretPDynamique.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btnArretPDynamique.setForeground(DARK_RED);} });
        
        btnPollueurSauteur.addActionListener(this::btnPollueurSauteurListener);
        btnPollueurLibre.addActionListener(this::btnPollueurLibreListener);
        btnPollueurDroit.addActionListener(this::btnPollueurDroitListener);
        btnPollueurDynamique.addActionListener(e -> {
			try {
				btnPollueurDynamiqueListener(e);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        btnArretPDynamique.addActionListener(this::btnArretPDynamiqueListener);
        
        return panel;
    }
    // - - - - - - - - - - - - - - - - - - - - -  
    
    
	// - - - - - - - - EAST - - - - - - - - - - 
    private JPanel createEast(){
        JPanel panel = new JPanel(new GridLayout(5,1));
        
        JButton btnNettoyeurSauteur = new JButton("Nettoyeur Sauteur");
        JButton btnNettoyeurLibre = new JButton("Nettoyeur Libre");
        JButton btnNettoyeurDroit = new JButton("Nettoyeur Droit");
        JButton btnNettoyeurDynamique = new JButton("Nettoyeur Dynamique");
        JButton btnArretNDynamique = new JButton("Arrêter NDynamique");
        
        panel.add(btnNettoyeurSauteur);
        panel.add(btnNettoyeurLibre);
        panel.add(btnNettoyeurDroit);
        panel.add(btnNettoyeurDynamique);
        panel.add(btnArretNDynamique);
        
        btnNettoyeurSauteur.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btnNettoyeurSauteur.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btnNettoyeurSauteur.setForeground(DARK_GREEN);} });
        
        btnNettoyeurLibre.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btnNettoyeurLibre.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btnNettoyeurLibre.setForeground(DARK_GREEN);} });
        
        btnNettoyeurDroit.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btnNettoyeurDroit.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btnNettoyeurDroit.setForeground(DARK_GREEN);} });
        
        btnNettoyeurDynamique.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btnNettoyeurDynamique.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btnNettoyeurDynamique.setForeground(DARK_GREEN);} });
        
        btnArretNDynamique.addMouseListener(new MouseAdapter() {
        	public void mouseExited(MouseEvent e) {btnArretNDynamique.setForeground(Color.black);}
        	public void mouseEntered(MouseEvent e) {btnArretNDynamique.setForeground(DARK_GREEN);} });
        
        btnNettoyeurSauteur.addActionListener(this::btnNettoyeurSauteurListener);
        btnNettoyeurLibre.addActionListener(this::btnNettoyeurLibreListener);
        btnNettoyeurDroit.addActionListener(this::btnNettoyeurDroitListener);
        btnNettoyeurDynamique.addActionListener(this::btnNettoyeurDynamiqueListener);
        btnArretNDynamique.addActionListener(this::btnArretNDynamiqueListener);
        
        return panel;
    }
    // - - - - - - - - - - - - - - - - - - - - - 
    
    
    // - - - - - - - - SOUTH - - - - - - - - - - 
    private JPanel createSouth(){
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lblStatus1 = new JLabel("Nombre de papiers gras : ");
        lblStatus1.setPreferredSize(new Dimension(170,30));
        statusBar.add(lblStatus1);

        lblStatus2 = new JLabel("0");
        lblStatus2.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus2);

        return statusBar;
    }
    // - - - - - - - - - - - - - - - - - - - - - 
    
    // - - - - - - - - CENTER - - - - - - - - - - 
    // le code se trouve dans la classe Dialogue1
    // Le monde est initialié uniquement si le button initialiser est cliqué et que 
    // l'utilisateur a entré les bonnes valeurs de nbL et nbC et a cliqué sur OK
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  
    
    
    // - - - - - - - - - - - - - Autres Méthodes - - - - - - - - - 
    // polluer matcenter[posX][posY]
    public void polluer(int posX, int posY) {
    	matCenter[posX][posY].setBackground(Color.black);
    }
    
    // Nettoyer matcenter[posX][posY]
    public void nettoyer(int posX, int posY) {
    	matCenter[posX][posY].setBackground(Color.lightGray);
    }
    // polluer tout le matcenter
    public void polluerTout() {
    	for(int i = 0; i<this.m.getnbL(); i++) {
    		for(int j = 0; j<this.m.getnbC(); j++) {
    			matCenter[i][j].setBackground(Color.black);
    		}
    	}
    }
    // nettoyer tout le matcenter
    public void nettoyerTout() {
    	for(int i = 0; i<this.m.getnbL(); i++) {
    		for(int j = 0; j<this.m.getnbC(); j++) {
    			matCenter[i][j].setBackground(Color.lightGray);
    		}
    	}
    }
    
    // 
    public void addPic(int x, int y, ImageIcon avatarIC){  		
        matCenter[x][y].setIcon(avatarIC);
  	}
    //
    public void removePic(int x, int y){  		
        matCenter[x][y].setIcon(null);
  	}

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// - - - - - - - - - - - - - - - - Listener functions - - - - - - - - - - - - - - -
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    
    // - - - - - - - - - - - - - - - - Listeners Boutons Nord - - - - - - - - - - - - - - -
    private void btninitialiserListener(ActionEvent event){
    	// sortir une boite de dialogue pour entrer nbL et nbC
    	d1.setLocationRelativeTo(this);
    	d1.setVisible(true);
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void btnPolluerToutListener(ActionEvent event){
        if(estInitialised) {
        	this.polluerTout();
        	this.m.ajoutPapierPartout();
        	nbPapierGras = this.m.nbrGras();
        	lblStatus2.setText(Integer.toString(nbPapierGras));
        	
        }
        else { 
        	d2.setLocationRelativeTo(this);
        	d2.setVisible(true);
        }
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void btnNettoyerToutListener(ActionEvent event){
        if(estInitialised) {
        	this.nettoyerTout(); 
        	this.m.nettoyerTout();
        	nbPapierGras = this.m.nbrGras();
        	lblStatus2.setText(Integer.toString(nbPapierGras));
        }
        else { 
        	d2.setLocationRelativeTo(this);
        	d2.setVisible(true);
        }
    }
    
    // ---------------------------------------------------------------
    private void btnAfficherListener(ActionEvent event){
    	String a = txtEdit.getText();
    	if(a.length()>0) {
	    	Bonus bonus = new Bonus(a, MyWindow3.this);
	    	bonus.display();
	    	bonus.fill();
	    	bonus.draw();
    	}
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void btnHelpListener(ActionEvent event){
    	// hcbdhbch
    }

    // - - - - - - - - - - - - - - - - Listeners Boutons Ouest - - - - - - - - - - - - - - -
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void btnPollueurSauteurListener(ActionEvent event){
        if(estInitialised) {
        	PollueurSauteur p1 = new PollueurSauteur(this.m);
        	int a = this.m.getnbL()*this.m.getnbC()/2;
        	int ammo = new Random().nextInt(a)/2;
	        p1.parcourir(ammo, MyWindow3.this);
        	nbPapierGras = this.m.nbrGras();
        	lblStatus2.setText(Integer.toString(nbPapierGras));
	        
        }
        else { 
        	d2.setLocationRelativeTo(this);
        	d2.setVisible(true);
        }
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void btnPollueurLibreListener(ActionEvent event){
        if(estInitialised) {
        	PollueurLibre p2 = new PollueurLibre(this.m);
        	int a = this.m.getnbL()*this.m.getnbC()/2;
        	int ammo = new Random().nextInt(a)/2;
	        p2.parcourir(ammo, MyWindow3.this);
        	nbPapierGras = this.m.nbrGras();
        	lblStatus2.setText(Integer.toString(nbPapierGras));
        }
        else { 
        	d2.setLocationRelativeTo(this);
        	d2.setVisible(true);
        }
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void btnPollueurDroitListener(ActionEvent event){
        if(estInitialised) {
        	PollueurToutDroit p3 = new PollueurToutDroit(this.m);
        	int a = this.m.getnbL()*this.m.getnbC()/2;
        	int ammo = new Random().nextInt(a)/2;
	        p3.parcourir(ammo, MyWindow3.this);
        	nbPapierGras = this.m.nbrGras();
        	lblStatus2.setText(Integer.toString(nbPapierGras));
        }
        else { 
        	d2.setLocationRelativeTo(this);
        	d2.setVisible(true);
        }
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void btnPollueurDynamiqueListener(ActionEvent event) throws InterruptedException{
        if(estInitialised) {
        	if(nbPActuel<nbPmax) {
            	pD[nbPActuel] = new PollueurDynamique(this.m);
            	pD[nbPActuel].begin(this);
            	nbPActuel++;
        	}
        }
        
        else { 
        	d2.setLocationRelativeTo(this);
        	d2.setVisible(true);
        }
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void btnArretPDynamiqueListener(ActionEvent event){
        if(estInitialised) {
        	if(nbPActuel>0) {         		
	    		pD[nbPActuel-1].stop();
	    		nbPActuel--;
        		}
        }
        else { 
        	d2.setLocationRelativeTo(this);
        	d2.setVisible(true);
        }
    }
    
    
    // - - - - - - - - - - - - - - - - Listeners Boutons Est - - - - - - - - - - - - - - -
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void btnNettoyeurSauteurListener(ActionEvent event){
        if(estInitialised) {
        	NettoyeurSauteur p1 = new NettoyeurSauteur(this.m);
        	int a = this.m.getnbL()*this.m.getnbC()/2;
        	int ammo = new Random().nextInt(a)/2;
	        p1.parcourir(ammo, MyWindow3.this);
        	nbPapierGras = this.m.nbrGras();
        	lblStatus2.setText(Integer.toString(nbPapierGras));
        }
        else { 
        	d2.setLocationRelativeTo(this);
        	d2.setVisible(true);
        }
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void btnNettoyeurLibreListener(ActionEvent event){
        if(estInitialised) {
        	NettoyeurLibre p2 = new NettoyeurLibre(this.m);
        	int a = this.m.getnbL()*this.m.getnbC()/2;
        	int ammo = new Random().nextInt(a)/2;
	        p2.parcourir(ammo, MyWindow3.this);
        	nbPapierGras = this.m.nbrGras();
        	lblStatus2.setText(Integer.toString(nbPapierGras));
        }
        
        else { 
        	d2.setLocationRelativeTo(this);
        	d2.setVisible(true);
        }
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void btnNettoyeurDroitListener(ActionEvent event){
        if(estInitialised) {
        	NettoyeurToutDroit p3 = new NettoyeurToutDroit(this.m);
        	int a = this.m.getnbL()*this.m.getnbC()/2;
        	int ammo = new Random().nextInt(a)/2;
	        p3.parcourir(ammo, MyWindow3.this);
        	nbPapierGras = this.m.nbrGras();
        	lblStatus2.setText(Integer.toString(nbPapierGras));
        }
        else { 
        	d2.setLocationRelativeTo(this);
        	d2.setVisible(true);
        }
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void btnNettoyeurDynamiqueListener(ActionEvent event){
        if(estInitialised) {
        	if(nbNActuel<nbNmax) {
            	pN[nbNActuel] = new NettoyeurDynamique(this.m);
            	pN[nbNActuel].begin(this);
            	nbNActuel++;
        	}
        }      
        else { 
        	d2.setLocationRelativeTo(this);
        	d2.setVisible(true);
        }
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void btnArretNDynamiqueListener(ActionEvent event){        
        if(estInitialised) {
        	if(nbNActuel>0) {         		
	    		pN[nbNActuel-1].stop();
	    		nbNActuel--;
    		}
        }
        else { 
        	d2.setLocationRelativeTo(this);
        	d2.setVisible(true);
        }
    }
    
    
    

}





// ----------