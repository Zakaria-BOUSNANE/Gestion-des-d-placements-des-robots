public class Monde {
    private int nbL;
    private int nbC;
    private boolean [][] Mat;

    // constructeur sans paramètres
    public Monde(){
        nbL = 8;
        nbC = 8;
        boolean[][] newMat = new boolean[nbL][nbC];
        for(int i=0; i<nbL; i++){
            for(int j=0; j<nbC; j++){
                newMat[i][j] = false;
            }
        }
        Mat = newMat;
    }
    
    // Constructeur avec paramètres 
    public Monde(int L, int C){
        nbL = L;
        nbC = C;
        boolean[][] newMat = new boolean[nbL][nbC];
        for(int i=0; i<nbL; i++){
            for(int j=0; j<nbC; j++){
                newMat[i][j] = false;
            }
        }
        Mat = newMat;
    }

    // ajouter du papier gras (polluer)
    public void ajoutPapierGras(int i, int j){
    	//System.out.println(i+","+j);
        // on suppose pour l'instant que (i,j) est bien dans
        // le domaine 
        Mat[i][j] = true;
    }

    // ajouter du papier gras partout
    public void ajoutPapierPartout(){
    	for(int i = 0; i<nbL; i++) {
    		for(int j = 0; j<nbC; j++) {
    			Mat[i][j] = true;
    		}
    	}	
    }
    
    // nettoyer la case
    public void nettoyerGras(int i, int j){
        Mat[i][j] = false;
    }

    // nettoyer tout
    public void nettoyerTout(){
    	for(int i = 0; i<nbL; i++) {
    		for(int j = 0; j<nbC; j++) {
    			Mat[i][j] = false;
    		}
    	}	
    }
    // tester si la case contient du papier gras (true)
    public boolean estGras(int i, int j){
        if(Mat[i][j]){
            return true;
        }
        return false;
    }

    // calculer le nombre de cases avec papier gras
    public int nbrGras(){
        int nbr = 0;
        for(int i=0; i<nbL; i++){
            for(int j=0; j<nbC; j++){
                if(Mat[i][j]){
                    nbr++;
                }
            }
        }
        return nbr;
    }

    // affichage de la matrice Monde
    public void afficheMat(){
        for(int i=0; i<nbL; i++){
            for(int j=0; j<nbC; j++){
                System.out.println(Mat[i][j] + " (" + i + "," + j + ")");
            }
            System.out.println();
        }
    }

    // get nbL
    public int getnbL(){
        return nbL;
    }

    // get nbC
    public int getnbC(){
        return nbC;
    }
    
    // setnbL
public void setNbL(int nbL) {
	this.nbL = nbL;
    boolean[][] newMat = new boolean[nbL][nbC];
    for(int i=0; i<nbL; i++){
        for(int j=0; j<nbC; j++){
            newMat[i][j] = false;
        }
    }
    Mat = newMat;
}

    // setnbC
public void setNbC(int nbC) {
	this.nbC = nbC;
    boolean[][] newMat = new boolean[nbL][nbC];
    for(int i=0; i<nbL; i++){
        for(int j=0; j<nbC; j++){
            newMat[i][j] = false;
        }
    }
    Mat = newMat;
}
    /*public static void main(String[] args) {
        Monde monMonde = new Monde();
        monMonde.afficheMat();
        monMonde.ajoutPapierGras(0,2);
        monMonde.afficheMat();
    }*/	
}



