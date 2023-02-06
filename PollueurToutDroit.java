public class PollueurToutDroit extends Robot {
    //private int numCol;
    RobotType type = RobotType.PollueurToutDroit;

    public PollueurToutDroit(Monde m){
        super(0,-1, m);
    }

    public PollueurToutDroit(int numCol, Monde m){
        super(0,numCol, m);
    }

    public void parcourir(int a, MyWindow3 w){
        for(int i=0; i<mondeRobot.getnbL(); i++){
            mondeRobot.ajoutPapierGras(i,posY);
            w.polluer(i, posY);
        }
    }

    public void afficher(){
        System.out.println(type);
        super.afficher();
    }
    
    public void revenirCase0(){
        posX = 0;      
    }

	@Override
	public void parcourir(int a) {}
    
    }

