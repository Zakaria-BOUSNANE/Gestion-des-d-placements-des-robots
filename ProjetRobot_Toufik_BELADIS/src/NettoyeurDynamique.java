import java.awt.Image;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class NettoyeurDynamique extends Robot implements Runnable {
    RobotType type = RobotType.NettoyeurDynamique;
    // to stop the thread
    private boolean exit;
    Thread tN;
    MyWindow3 w;
    String imageName = "nettoyeur.PNG";
    ImageIcon avatarScaled;
    
    public NettoyeurDynamique(Monde m){
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
    
    public void parcourir(int ammo){}
    public void parcourir(){
    		hidePic(posX, posY);
            posX = new Random().nextInt(mondeRobot.getnbL());
            posY = new Random().nextInt(mondeRobot.getnbC());
            mondeRobot.nettoyerGras(posX,posY);
            w.addPic(posX, posY, avatarScaled);
            w.nettoyer(posX, posY);
            w.lblStatus2.setText(Integer.toString(w.m.nbrGras()));
    }
    
    // start the thread
    public void begin(MyWindow3 w) {
    	this.w = w;
    	getPic();
    	tN.start(); // Starting the thread
    }
    
    // execution of thread starts from run() method
    public void run() {
        while (!exit) {
        	parcourir();
            try { Thread.sleep(1200); }
            catch (InterruptedException e) { System.out.println("Caught:" + e); }
        }
        //System.out.println(" Stopped.");
    }
 
    // for stopping the thread
    public void stop()
    {
        exit = true;
        hidePic(posX, posY);
    }

}









