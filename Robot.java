import java.util.Random;

public abstract class Robot {

    protected int posX;
    protected int posY;
    protected Monde mondeRobot;

    // constructeur position passée en paramètres
    public Robot(int x, int y, Monde m){
        if (x >= 0) {
            if(y>=0){
                // x et y sont des données
                mondeRobot = m;
                posX = x;
                posY = y;
                }
            else{
                // x donné et y aléatoire
            	mondeRobot = m;
                posX = x;
                posY = new Random().nextInt(mondeRobot.getnbC());
                }
            }

        else{
            if(y>=0){
                // x aléatoire et y donné 
            	mondeRobot = m;
                posX = new Random().nextInt(mondeRobot.getnbL());
                posY = y;
                }
            else{
                // x et y aléatoire
            	mondeRobot = m;
                posX = new Random().nextInt(mondeRobot.getnbL());
                posY = new Random().nextInt(mondeRobot.getnbC());
                }
            }
    }

    // constructeur vide (aléatoire)
    public Robot(Monde m){
    	mondeRobot = m;
        int x = new Random().nextInt(mondeRobot.getnbL());
        int y = new Random().nextInt(mondeRobot.getnbC());
        posX = x;
        posY = y;
        
    }

    // se déplacer vers (i,j)
    public void deplacerRobot(int i, int j){
        this.posX = i;
        this.posY = j;
    }

    // Afficher les informations d'un robot
    public void afficher(){
        System.out.println("x = "+posY+" ; y = "+posX);
        System.out.println("- - - - - - - - - - - - - - - - -");

    }
    // set monde
	public void setMonde(Monde m) {
		this.mondeRobot = m;
	}
    // la méthode parcourir est abstraite
    abstract public void parcourir(int a);

}
