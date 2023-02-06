import java.awt.Image;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PollueurDynamique extends Robot implements Runnable {
    RobotType type = RobotType.PollueurDynamique;
    // to stop the thread
    private boolean exit;
    public boolean aleatoire = true;
    Thread tN;
    MyWindow3 w;
    String imageName = "pollueur.png";
    ImageIcon avatarScaled;
	Vector<Integer> lines = new Vector<Integer>();
	Vector<Integer> collumns = new Vector<Integer>();
    
    public PollueurDynamique(Monde m){
        super(m);
        tN = new Thread(this);
        exit = false;

    }
    /*public NettoyeurDynamique(int x, int y, Monde m){
        super(x, y, m);
    }*/

    
    public void getPic() {
    	Image avatarI;
    	int width = this.w.matCenter[0][0].getWidth();
    	int height = this.w.matCenter[0][0].getHeight();
		try { 
			avatarI = ImageIO.read(getClass().getResource(imageName));
			Image imgScale = avatarI.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			avatarScaled = new ImageIcon(imgScale);
			} 
		catch (IOException e) { e.printStackTrace(); }
	}
    
    
    public void hidePic(int x, int y) {
    	w.removePic(posX, posY);
	}
    
    public void afficher(){
        System.out.println(type);
        super.afficher();
    }
    //-----------------------------------------------------------------------
    public void parcourir(int ammo){}
    public void parcourir(){ // x et y aléatoires
    	hidePic(posX, posY);
        posX = new Random().nextInt(mondeRobot.getnbL());
        posY = new Random().nextInt(mondeRobot.getnbC());
        mondeRobot.ajoutPapierGras(posX,posY);
        w.addPic(posX, posY, avatarScaled);
        w.polluer(posX, posY);
    	w.lblStatus2.setText(Integer.toString(w.m.nbrGras()));
    }
    //--------------------------------------------------------------------
    // start the thread
    public void begin(MyWindow3 w) {
    	this.w = w;
    	getPic();
    	tN.start(); // Starting the thread
    }
    //------------------------------------------------------------------------
    
    //---------------------------------------------------------------------------
    
    //------------------------------------------------------------------------
    // execution of thread starts from run() method
	@Override
	public void run() {
		if(aleatoire) {
	        while (!exit) {
	        	parcourir();
	            try { Thread.sleep(800); }
	            catch (InterruptedException e) { System.out.println("Caught:" + e); }
	        }	
		}
        else draw();
	}
	//------------------------------------------------------------------------------------------
	
	public void fill(Vector<Integer> x, Vector<Integer> y) {
		for (int i = 0; i < x.size(); i++) {
			lines.add( x.get(i) );
			collumns.add( y.get(i) );		
		}
	}
	
	//-------------------------------------------------------------------------------------------
    public void draw() {
    	for (int i = 0; i < lines.size(); i++) {
    		hidePic(posX, posY);
    		this.deplacerRobot( lines.get(i) , collumns.get(i) );
            mondeRobot.ajoutPapierGras(posX,posY);
            w.addPic(posX, posY, avatarScaled);
            w.polluer(posX, posY);
            
            try { Thread.sleep(20); }
            catch (InterruptedException e) { System.out.println("Caught:" + e); }
    	}
    	hidePic(posX, posY);
    }
    //---------------------------------------------------------------------------------------------
 
    // for stopping the thread
    public void stop()
    {
        exit = true;
        hidePic(posX, posY);
    }




    
}









