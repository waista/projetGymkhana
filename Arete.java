import java.util.*;

class Arete extends Case{
	private Case noeud1;//chaque arete relie deux noeuds, qui pointe chacune sur 3 aretes
	private Case noeud2; //possiblement non necessaire

	public Arete(){

		super();

		Case noeud1;//chaque arete relie deux noeuds, qui pointe chacune sur 3 aretes
		Case noeud2;

	}

	public Arete(int x, int y, int j, Gymkhana jeu){//x et y coordonneés, j le joueur et jeu le plateau dans lequel il doit etre placé
		super(x,y,j);
	}

	public Arete(int x, int y, int j, Case n1, Case n2, Gymkhana jeu){//x et y coordonneés, j le joueur et jeu le plateau dans lequel il doit etre placé
		super(x,y,j);
		noeud1 = n1;
		noeud2 = n2;
		// a finir
	}

	public int estSurLeCote(int x, int y, int j){
		if (j == 1) {
			if (y==0 && x%2==0) {
				return 1;
			}
			if (y==4 && x%2==0) {
				return 2;
			}
			return 0;
		}else{
			if (x==0) {
				return 1;
			}
			if (x==8) {
				return 2;
			}
			return 0;
		}
	}

	/*
	---------------------------------------------------------------------------------------------------------------------------
													Fonctions utilitaires
	---------------------------------------------------------------------------------------------------------------------------
	*/

	public String toString(){
		if (joueur == 0) {
			return ".";
		}else{
			return String.valueOf(joueur);
		}
	}

	public boolean jeSuisUnNoeud(){
		return false;
	}



}
