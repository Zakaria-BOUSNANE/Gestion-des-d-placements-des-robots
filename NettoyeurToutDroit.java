public class NettoyeurToutDroit extends Robot {
    //private int numCol;
    RobotType type = RobotType.NettoyeurToutDroit;

    public NettoyeurToutDroit(Monde m){
        super(0,-1, m);
    }

    public NettoyeurToutDroit(int numCol, Monde m){
        super(0,numCol, m);
    }

    public void parcourir(int a, MyWindow3 w){
        for(int i=0; i<mondeRobot.getnbL(); i++){
            mondeRobot.nettoyerGras(i,posY);
            w.nettoyer(i, posY);
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

