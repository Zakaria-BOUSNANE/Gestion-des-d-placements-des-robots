public class NettoyeurLibre extends Robot {
    RobotType type = RobotType.NettoyeurLibre;
    public int nbCleared = 0;
    
    public NettoyeurLibre(Monde m){
        super(m);
    }
    public NettoyeurLibre(int x, int y, Monde m){
        super(x, y, m);
    }


    public boolean isFinish(int a){
        if(nbCleared<a) return true;
        return false;
    }

    public void avancer(int ammo, MyWindow3 w){
    	//System.out.println("posX = "+posX);
    	//System.out.println("posY = "+posY);
    	//System.out.println(mondeRobot.getnbL()+","+mondeRobot.getnbC());
    	
        while(posY<mondeRobot.getnbC()){
            if(posY%2==0){
                while(posX>=0 && isFinish(ammo)){
                    mondeRobot.nettoyerGras(posX,posY);
                    w.nettoyer(posX, posY);
                    nbCleared++;
                    posX--;
                    //if(posX>0) posX--;
                }
                if(posX == -1) posX = 0;
            }
            else{
                while( posX<mondeRobot.getnbL() && isFinish(ammo) ){
                	//System.out.println(posX+","+posY);
                    mondeRobot.nettoyerGras(posX,posY);
                    w.nettoyer(posX, posY);
                    nbCleared++;
                    posX++;
                }
                if(posX == mondeRobot.getnbL()) posX = mondeRobot.getnbL()-1;
            }
            posY++;
        }
        
        if(posY==mondeRobot.getnbC() && isFinish(ammo)){
        	posX = mondeRobot.getnbL()-1;
        	posY=0;
        	avancer(ammo,w);
        }
    }

    public void afficher(){
        System.out.println(type);
        super.afficher();
    }

    public void parcourir(int ammo, MyWindow3 w){
        avancer(ammo, w);
    }
	@Override
	public void parcourir(int a) {}
	
}




