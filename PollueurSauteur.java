import java.util.Random;

public class PollueurSauteur extends Robot {
    RobotType type = RobotType.PollueurSauteur;
    public PollueurSauteur(Monde m){
        super(m);
    }
    public PollueurSauteur(int x, int y, Monde m){
        super(x, y, m);
    }

    public void afficher(){
        System.out.println(type);
        super.afficher();
    }
    
    public void parcourir(int ammo){}
    public void parcourir(int ammo, MyWindow3 w){
        //int x,y;
        for(int i=0; i<ammo; i++){
            posX = new Random().nextInt(mondeRobot.getnbL());
            posY = new Random().nextInt(mondeRobot.getnbC());
            mondeRobot.ajoutPapierGras(posX,posY);
            w.polluer(posX, posY);
        }
    }

}