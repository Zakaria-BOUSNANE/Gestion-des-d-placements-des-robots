public class PollueurLibre extends Robot {
    RobotType type = RobotType.PollueurLibre;
    public int nbPollued = 0;
    
    public PollueurLibre(Monde m){
        super(m);
    }
    public PollueurLibre(int x, int y, Monde m){
        super(x, y, m);
    }


    public boolean isFinish(int a){
        if(nbPollued<a) return true;
        return false;
    }

    public void avancer(int ammo, MyWindow3 w){
    	//System.out.println("posX = "+posX);
    	//System.out.println("posY = "+posY);
    	//System.out.println(mondeRobot.getnbL()+","+mondeRobot.getnbC());
    	
        while(posY<mondeRobot.getnbC()){
            if(posY%2==0){
                while(posX>=0 && isFinish(ammo)){
                    mondeRobot.ajoutPapierGras(posX,posY);
                    w.polluer(posX, posY);
                    nbPollued++;
                    posX--;
                    //if(posX>0) posX--;
                }
                if(posX == -1) posX = 0;
            }
            else{
                while( posX<mondeRobot.getnbL() && isFinish(ammo) ){
                	//System.out.println(posX+","+posY);
                    mondeRobot.ajoutPapierGras(posX,posY);
                    w.polluer(posX, posY);
                    nbPollued++;
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




