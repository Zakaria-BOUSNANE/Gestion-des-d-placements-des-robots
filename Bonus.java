import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bonus {
	int nbL, nbC;
	private char[] monChar;
	private MyWindow3 w;
	Vector<Integer> lines = new Vector<Integer>();
	Vector<Integer> collumns = new Vector<Integer>();
	
	public Bonus(String monStr, MyWindow3 w) {
		this.monChar = monStr.toCharArray();
		this.w = w;
		resize();
		
		
	}
	
	// ----------------------------------------------------------------------------------
	public int numberSpaces(char[] a) {
		int k=0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==' ') k++;
		}
		return k;
	}
	
	public void resize() {
		//int a = numberSpaces(monChar);
		//this.nbC = 1 + 5*monChar.length +(monChar.length - 2*a - 1)*2+1;
		this.nbC = 7*monChar.length;
		this.nbL = 7*monChar.length;
		
		if(monChar.length>10) {
			nbC=70;
			nbL=(monChar.length%10 + 1)*13;
			System.out.println(nbL);
		}
		w.estInitialised = true;
    	w.m = new Monde(nbL, nbC);
		w.matCenter = new JLabel[nbL][nbC];
		w.center = new JPanel();
		w.center.setLayout(new GridLayout(nbL,nbC));
		
		for(int i=0; i<nbL; i++) {
			for(int j=0; j<nbC; j++){
				w.matCenter[i][j] = new JLabel();
				w.matCenter[i][j].setOpaque(true);
				w.matCenter[i][j].setBackground(Color.lightGray);
				w.center.add(w.matCenter[i][j]);
				w.matCenter[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
			}
		}
    	
    	w.add(w.center, BorderLayout.CENTER);
	}
	
	
	
	
	// ----------------------------------------------------------------------------------
	
	
	public void display() {
		w.setVisible(true);
	}
	
	public void draw() {
		PollueurDynamique pD = new PollueurDynamique(w.m);
		pD.aleatoire = false;
		pD.fill(lines, collumns);
		pD.begin(w);
	}
	
	public void fill() {
        int a = monChar.length;
        int i=1,j=1, nbLigne=0;
		int k = 0;
		
		while(k<a) {
			switch (monChar[k]) {
				case 'A': A(i, j); break;
				case 'B': B(i, j); break;
				case 'C': C(i, j); break;
				case 'D': D(i, j); break;
				case 'E': E(i, j); break;
				case 'F': F(i, j); break;
				case 'G': G(i, j); break;
				case 'H': H(i, j); break;
				case 'I': I(i, j); break;
				case 'J': J(i, j); break;
				case 'K': K(i, j); break;
				case 'L': L(i, j); break;
				case 'M': M(i, j); break;
				case 'N': N(i, j); break;
				case 'O': O(i, j); break;
				case 'P': P(i, j); break;
				case 'Q': Q(i, j); break;
				case 'R': R(i, j); break;
				case 'S': S(i, j); break;
				case 'T': T(i, j); break;
				case 'U': U(i, j); break;
				case 'V': V(i, j); break;
				case 'W': W(i, j); break;
				case 'X': X(i, j); break;
				case 'Y': Y(i, j); break;
				case 'Z': Z(i, j); break;
				case ' ': break;
				case '!': wow(i, j); break;
				case '?': what(i, j); break;
				case '.': dot(i, j); break;
				case ',': comma(i, j); break;
				case '(': parenthesisLeft(i, j); break; 
				case ')': parenthesisRight(i, j); break;
				case '0': zero(i, j); break;
				case '1': one(i, j); break;
				case '2': two(i, j); break;
				case '3': three(i, j); break;
				case '4': four(i, j); break;
				case '5': five(i, j); break;
				case '6': six(i, j); break;
				case '7': seven(i, j); break;
				case '8': eight(i, j); break;
				case '9': nine(i, j); break;
				
				default: what(i, j);break;
			}
			if(nbLigne==0) {
				if(monChar[k]==' ') j+=3;
				else j+=7;
			}
			
			if(nbC-j<7) {
				nbLigne++;
				j=1;
				i= 4 + nbLigne*7 + 3;
			}
			k++;
		 
		}
	}
	
	public void fillVertical(int i1, int i2, int j) {
		if(i1-i2<0) {
			for (int k = i1; k <= i2 ; k++) {
				lines.add(k);
				collumns.add(j);
			}
		}
		else {
			for (int k = i1; k >= i2 ; k--) {
				lines.add(k);
				collumns.add(j);
			}
		}
	}
	
	public void fillHorizontal(int i, int j1, int j2) {
		if(j1-j2<0) {
			for (int k = j1; k <= j2 ; k++) {
				lines.add(i);
				collumns.add(k);
			}
		}
		else {
			for (int k = j1; k >= j2 ; k--) {
				lines.add(i);
				collumns.add(k);
			}
		}
	}
	
	public void fillPoint(int i, int j) {
		lines.add(i); collumns.add(j);
	}
	
	//                            ---------------------------
	//                            -                         - 
	//                            -       Dot Matrix        -
	//                            -                         -
	//                            ---------------------------
	
	
	public void A(int i, int j) {
		lines.add(i+6);collumns.add(j);    lines.add(i+5);collumns.add(j);
		lines.add(i+4);collumns.add(j);    lines.add(i+3);collumns.add(j); 
		lines.add(i+2);collumns.add(j);    lines.add(i+1);collumns.add(j);
		lines.add(i);collumns.add(j+1);    lines.add(i);collumns.add(j+2);
		lines.add(i);collumns.add(j+3);    lines.add(i+1);collumns.add(j+4);
		lines.add(i+2);collumns.add(j+4);  lines.add(i+3);collumns.add(j+4);
		lines.add(i+4);collumns.add(j+4);  lines.add(i+5);collumns.add(j+4);
		lines.add(i+6);collumns.add(j+4);  lines.add(i+3);collumns.add(j+1);
		lines.add(i+3);collumns.add(j+2);  lines.add(i+3);collumns.add(j+3);
	}
	
	// ------------------------------------------------------------------------------------------------
	public void B(int i, int j) {
		lines.add(i+6);collumns.add(j);    lines.add(i+5);collumns.add(j);
		lines.add(i+4);collumns.add(j);	   lines.add(i+3);collumns.add(j);
		lines.add(i+2);collumns.add(j);    lines.add(i+1);collumns.add(j);
		lines.add(i);collumns.add(j);      lines.add(i);collumns.add(j+1);
		lines.add(i);collumns.add(j+2);    lines.add(i);collumns.add(j+3);
		lines.add(i+1);collumns.add(j+4);  lines.add(i+2);collumns.add(j+4);
		lines.add(i+4);collumns.add(j+4);  lines.add(i+5);collumns.add(j+4);
		lines.add(i+6);collumns.add(j+3);  lines.add(i+6);collumns.add(j+2);
		lines.add(i+6);collumns.add(j+1);  lines.add(i+3);collumns.add(j+1);
		lines.add(i+3);collumns.add(j+2);  lines.add(i+3);collumns.add(j+3);
	}
	
	// ------------------------------------------------------------------------------------------------
	public void C(int i, int j) {
		lines.add(i+1);collumns.add(j+4);    lines.add(i);collumns.add(j+3);
		lines.add(i);collumns.add(j+2);	   lines.add(i);collumns.add(j+1);
		lines.add(i+1);collumns.add(j);    lines.add(i+2);collumns.add(j);
		lines.add(i+3);collumns.add(j);      lines.add(i+4);collumns.add(j);
		lines.add(i+5);collumns.add(j);    lines.add(i+6);collumns.add(j+1);
		lines.add(i+6);collumns.add(j+2);  lines.add(i+6);collumns.add(j+3);
		lines.add(i+5);collumns.add(j+4);  
	}	
	
	// ------------------------------------------------------------------------------------------------
	public void D(int i, int j) {
		lines.add(i+6);collumns.add(j);    lines.add(i+5);collumns.add(j);
		lines.add(i+4);collumns.add(j);	   lines.add(i+3);collumns.add(j);
		lines.add(i+2);collumns.add(j);    lines.add(i+1);collumns.add(j);
		lines.add(i);collumns.add(j);      lines.add(i);collumns.add(j+1);
		lines.add(i);collumns.add(j+2);    lines.add(i);collumns.add(j+3);
		lines.add(i+1);collumns.add(j+4);  lines.add(i+2);collumns.add(j+4);
		lines.add(i+3);collumns.add(j+4);  lines.add(i+4);collumns.add(j+4);
		lines.add(i+5);collumns.add(j+4);  lines.add(i+6);collumns.add(j+3);
		lines.add(i+6);collumns.add(j+2);  lines.add(i+6);collumns.add(j+1);
	}
	
	// ------------------------------------------------------------------------------------------------
	public void E(int i, int j) {
		lines.add(i+6);collumns.add(j+4);    lines.add(i+6);collumns.add(j+3);
		lines.add(i+6);collumns.add(j+2);	   lines.add(i+6);collumns.add(j+1);
		lines.add(i+6);collumns.add(j);    lines.add(i+5);collumns.add(j);
		lines.add(i+4);collumns.add(j);	   lines.add(i+3);collumns.add(j);
		lines.add(i+2);collumns.add(j);    lines.add(i+1);collumns.add(j);
		lines.add(i);collumns.add(j);      lines.add(i);collumns.add(j+1);
		lines.add(i);collumns.add(j+2);    lines.add(i);collumns.add(j+3);
		lines.add(i);collumns.add(j+4);  lines.add(i+3);collumns.add(j+1);
		lines.add(i+3);collumns.add(j+2);  lines.add(i+3);collumns.add(j+3);
	}
	// ------------------------------------------------------------------------------------------------
	public void F(int i, int j) {
		lines.add(i+6);collumns.add(j);    lines.add(i+5);collumns.add(j);
		lines.add(i+4);collumns.add(j);	   lines.add(i+3);collumns.add(j);
		lines.add(i+2);collumns.add(j);    lines.add(i+1);collumns.add(j);
		lines.add(i);collumns.add(j);      lines.add(i);collumns.add(j+1);
		lines.add(i);collumns.add(j+2);    lines.add(i);collumns.add(j+3);
		lines.add(i);collumns.add(j+4);  lines.add(i+3);collumns.add(j+1);
		lines.add(i+3);collumns.add(j+2);  lines.add(i+3);collumns.add(j+3);
	}
	// ------------------------------------------------------------------------------------------------
	public void G(int i, int j) {
		fillPoint(i+1, j+4);
		fillHorizontal(i, j+3, j+1);
		fillVertical(i+1, i+5, j);
		fillHorizontal(i+6, j+1, j+3);
		fillVertical(i+5, i+3, j+4);
		fillHorizontal(i+3, j+3, j+2);
	}	
	// ------------------------------------------------------------------------------------------------
	public void H(int i, int j) {
		lines.add(i+6);collumns.add(j);    lines.add(i+5);collumns.add(j);
		lines.add(i+4);collumns.add(j);	   lines.add(i+3);collumns.add(j);
		lines.add(i+2);collumns.add(j);    lines.add(i+1);collumns.add(j);
		lines.add(i);collumns.add(j);      lines.add(i);collumns.add(j+4);
		lines.add(i+1);collumns.add(j+4);    lines.add(i+2);collumns.add(j+4);
		lines.add(i+3);collumns.add(j+4);  lines.add(i+4);collumns.add(j+4);
		lines.add(i+5);collumns.add(j+4);  lines.add(i+6);collumns.add(j+4);
		lines.add(i+3);collumns.add(j+1);  lines.add(i+3);collumns.add(j+2);
		lines.add(i+3);collumns.add(j+3);
	}
	// ------------------------------------------------------------------------------------------------
	public void I(int i, int j) {
		lines.add(i);collumns.add(j+1);    lines.add(i);collumns.add(j+3);
		lines.add(i);collumns.add(j+2);    lines.add(i+1);collumns.add(j+2);
		lines.add(i+2);collumns.add(j+2);	   lines.add(i+3);collumns.add(j+2);
		lines.add(i+4);collumns.add(j+2);    lines.add(i+5);collumns.add(j+2);
		lines.add(i+6);collumns.add(j+2);      lines.add(i+6);collumns.add(j+1);
		lines.add(i+6);collumns.add(j+3);    
	}
	// ------------------------------------------------------------------------------------------------
	public void J(int i, int j) {
		fillHorizontal(i, j, j+4);
		fillVertical(i+1, i+5, j+4);
		fillHorizontal(i+6, j+3, j+1);
		fillPoint(i+5, j);
	}
	// ------------------------------------------------------------------------------------------------
	public void K(int i, int j) {
		lines.add(i);collumns.add(j);    lines.add(i+1);collumns.add(j);
		lines.add(i+2);collumns.add(j);	   lines.add(i+3);collumns.add(j);
		lines.add(i+4);collumns.add(j);    lines.add(i+5);collumns.add(j);
		lines.add(i+6);collumns.add(j);      lines.add(i);collumns.add(j+4);
		lines.add(i+1);collumns.add(j+3);    lines.add(i+2);collumns.add(j+2);
		lines.add(i+3);collumns.add(j+1);  lines.add(i+4);collumns.add(j+2);
		lines.add(i+5);collumns.add(j+3);  lines.add(i+6);collumns.add(j+4);
	}
	// ------------------------------------------------------------------------------------------------
	public void L(int i, int j) {
		lines.add(i);collumns.add(j);    lines.add(i+1);collumns.add(j);
		lines.add(i+2);collumns.add(j);	   lines.add(i+3);collumns.add(j);
		lines.add(i+4);collumns.add(j);    lines.add(i+5);collumns.add(j);
		lines.add(i+6);collumns.add(j);      lines.add(i+6);collumns.add(j+1);
		lines.add(i+6);collumns.add(j+2);    lines.add(i+6);collumns.add(j+3);
		lines.add(i+6);collumns.add(j+4);
	}
	// ------------------------------------------------------------------------------------------------
	public void M(int i, int j) {
		fillVertical(i+6, i, j);
		lines.add(i+1);collumns.add(j+1); lines.add(i+2);collumns.add(j+2);
		lines.add(i+1);collumns.add(j+3); 
		fillVertical(i, i+6, j+4);
	}
	// ------------------------------------------------------------------------------------------------
	public void N(int i, int j) {
		fillVertical(i+6, i, j);
		lines.add(i+2);collumns.add(j+1); lines.add(i+3);collumns.add(j+2);
		lines.add(i+4);collumns.add(j+3); 
		fillVertical(i+6, i, j+4);
	}
	// ------------------------------------------------------------------------------------------------
	public void O(int i, int j) {
		fillHorizontal(i, j+1, j+3);
		fillVertical(i+1, i+5, j+4);
		fillHorizontal(i+6, j+3, j+1);
		fillVertical(i+5, i+1, j);
	}
	// ------------------------------------------------------------------------------------------------
	public void P(int i, int j) {
		fillVertical(i+6, i, j);
		fillHorizontal(i, j+1, j+3);
		fillVertical(i+1, i+2, j+4);
		fillHorizontal(i+3, j+3, j+1);
	}
	// ------------------------------------------------------------------------------------------------
	public void Q(int i, int j) {
		fillVertical(i+4, i+1, j+4);
		fillHorizontal(i, j+3, j+1);
		fillVertical(i+1, i+5, j);
		fillHorizontal(i+6, j+1, j+2);
		fillPoint(i+6, j+4);
		fillPoint(i+5, j+3);
		fillPoint(i+4, j+2);
	}
	// ------------------------------------------------------------------------------------------------
	public void R(int i, int j) {
		fillVertical(i+6, i, j);
		fillHorizontal(i, j+1, j+3);
		fillVertical(i+1, i+2, j+4);
		fillHorizontal(i+3, j+3, j+1);
		fillPoint(i+4, j+2);
		fillPoint(i+5, j+3);
		fillPoint(i+6, j+4);
	}
	// ------------------------------------------------------------------------------------------------
	public void S(int i, int j) {
		fillHorizontal(i, j+4, j+1);
		fillVertical(i+1, i+2, j);
		fillHorizontal(i+3, j+1, j+3);
		fillVertical(i+4, i+5, j+4);
		fillHorizontal(i+6, j+3, j);
	}
	// ------------------------------------------------------------------------------------------------
	public void T(int i, int j) {
		fillHorizontal(i, j, j+4);
		fillVertical(i+1, i+6, j+2);
	}
	// ------------------------------------------------------------------------------------------------
	public void U(int i, int j) {
		fillVertical(i, i+5, j);
		fillHorizontal(i+6, j+1, j+3);
		fillVertical(i+5, i, j+4);
	}
	// ------------------------------------------------------------------------------------------------
	public void V(int i, int j) {
		fillVertical(i, i+4, j);
		fillPoint(i+5, j+1);
		fillPoint(i+6, j+2);
		fillPoint(i+5, j+3);
		fillVertical(i+4, i, j+4);
	}
	// ------------------------------------------------------------------------------------------------
	public void W(int i, int j) {
		fillVertical(i, i+5, j);
		fillPoint(i+6, j+1);
		fillVertical(i+5, i+4, j+2);
		fillPoint(i+6, j+3);
		fillVertical(i+5, i, j+4);
	}
	// ------------------------------------------------------------------------------------------------
	public void X(int i, int j) {
		fillVertical(i, i+1, j);
		fillPoint(i+2, j+1);
		fillPoint(i+3, j+2);
		fillPoint(i+4, j+3);
		fillVertical(i+5, i+6, j+4);
		fillVertical(i, i+1, j+4);
		fillPoint(i+2, j+3);
		fillPoint(i+3, j+2);
		fillPoint(i+4, j+1);
		fillVertical(i+5, i+6, j);
	}
	// ------------------------------------------------------------------------------------------------
	public void Y(int i, int j) {
		fillVertical(i, i+1, j);
		fillPoint(i+2, j+1);
		fillPoint(i+3, j+2);
		fillPoint(i+2, j+3);
		fillVertical(i+1, i, j+4);
		fillVertical(i+4, i+6, j+2);
	}
	// ------------------------------------------------------------------------------------------------
	public void Z(int i, int j) {
		fillHorizontal(i, j, j+4);
		fillPoint(i+1, j+4);
		fillPoint(i+2, j+3);
		fillPoint(i+3, j+2);
		fillPoint(i+4, j+1);
		fillVertical(i+5, i+6, j);
		fillHorizontal(i+6, j+1, j+4);
	}
	// ------------------------------------------------------------------------------------------------
	public void wow(int i, int j) {
		fillVertical(i, i+4, j+2);
		fillPoint(i+6, j+2);
	}
	// ------------------------------------------------------------------------------------------------
	public void what(int i, int j) {
		fillVertical(i+2, i+1, j);
		fillHorizontal(i, j+1, j+3);
		fillVertical(i+1, i+2, j+4);
		fillPoint(i+3, j+3);
		fillPoint(i+4, j+2);
		fillPoint(i+6, j+2);
	}
	// ------------------------------------------------------------------------------------------------
	public void dot(int i, int j) {
		fillHorizontal(i+5, j+1, j+2);
		fillHorizontal(i+6, j+1, j+2);
	}
	// ------------------------------------------------------------------------------------------------
	public void comma(int i, int j) {
		fillHorizontal(i+4, j+1, j+2);
		fillPoint(i+5, j+2);
		fillPoint(i+6, j+1);
	}
	// ------------------------------------------------------------------------------------------------
	public void parenthesisLeft(int i, int j) {
		fillPoint(i, j+1);
		fillVertical(i+1, i+5, j);
		fillPoint(i+6, j+1);
	}
	// ------------------------------------------------------------------------------------------------
	public void parenthesisRight(int i, int j) {
		fillPoint(i, j+3);
		fillVertical(i+1, i+5, j+4);
		fillPoint(i+6, j+3);
	}
	// ------------------------------------------------------------------------------------------------
	public void zero(int i, int j) {
		fillHorizontal(i, j+3, j+1);
		fillVertical(i+1, i+5, j);
		fillHorizontal(i+6, j+1, j+3);
		fillVertical(i+5, i+1, j+4);
	}
	// ------------------------------------------------------------------------------------------------
	public void one(int i, int j) {
		fillPoint(i+1, j+1);
		fillVertical(i, i+5, j+2);
		fillHorizontal(i+6, j+3, j+1);
	}
	// ------------------------------------------------------------------------------------------------
	public void two(int i, int j) {
		fillPoint(i+1, j);
		fillHorizontal(i, j+1, j+3);
		fillVertical(i+1, i+2, j+4);
		fillHorizontal(i+3, j+3, j+2);
		fillPoint(i+4, j+1);
		fillVertical(i+5, i+6, j);
		fillHorizontal(i+6, j+1, j+4);
	}
	public void three(int i, int j) {
		fillHorizontal(i, j, j+3);
		fillVertical(i+1, i+2, j+4);
		fillHorizontal(i+3, j+3, j+2);
		fillVertical(i+4, i+5, j+4);
		fillHorizontal(i+6, j+3, j);
	}
	// ------------------------------------------------------------------------------------------------
	public void four(int i, int j) {
		fillPoint(i, j+3);
		fillPoint(i+1, j+2);
		fillPoint(i+2, j+1);
		fillVertical(i+3, i+4, j);
		fillHorizontal(i+4, j+1, j+4);
		fillVertical(i+1, i+6, j+3);
	}
	// ------------------------------------------------------------------------------------------------
	public void five(int i, int j) {
		fillHorizontal(i, j+4, j);
		fillVertical(i+1, i+2, j);
		fillHorizontal(i+3, j+1, j+3);
		fillVertical(i+4, i+5, j+4);
		fillHorizontal(i+6, j+3, j);
	}
	// ------------------------------------------------------------------------------------------------
	public void six(int i, int j) {
		fillPoint(i+1, j+4);
		fillHorizontal(i, j+3, j+1);
		fillVertical(i+1, i+5, j);
		fillHorizontal(i+6, j+1, j+3);
		fillVertical(i+5, i+4, j+4);
		fillHorizontal(i+3, j+3, j+1);
	}
	// ------------------------------------------------------------------------------------------------
	public void seven(int i, int j) {
		fillHorizontal(i, j, j+4);
		fillVertical(i+1, i+2, j+4);
		fillPoint(i+3, j+3);
		fillVertical(i+4, i+6, j+2);
	}
	// ------------------------------------------------------------------------------------------------
	public void eight(int i, int j) {
		fillHorizontal(i, j+3, j+1);
		fillVertical(i+1, i+2, j);
		fillHorizontal(i+3, j+1, j+3);
		fillVertical(i+4, i+5, j+4);
		fillHorizontal(i+6, j+3, j+1);
		fillVertical(i+5, i+4, j);
		fillVertical(i+2, i+1, j+4);
	}
	// ------------------------------------------------------------------------------------------------
	public void nine(int i, int j) {
		fillHorizontal(i+3, j+3, j+1);
		fillVertical(i+2, i+1, j);
		fillHorizontal(i, j+1, j+3);
		fillVertical(i+1, i+5, j+4);
		fillHorizontal(i+6, j+3, j+1);
		fillPoint(i+5, j);
	}
	
	
	
	
	
	
	
	
}
