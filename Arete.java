import java.util.*;

class Arete extends Case{
	private Noeud noeud1;//chaque arete relie deux noeuds, qui pointe chacune sur 3 aretes
	private Noeud noeud2;

	private int joueur;// joueur peut etre 1, 2 ou -1. Avec -1 etant une case vide
	private int estSurLeBord;//0 n'est pas sur un bord, 1 est sur le bord 1, 2 est sur le bord 2


	public Arete(){

		super();

		Noeud noeud1;//chaque arete relie deux noeuds, qui pointe chacune sur 3 aretes
		Noeud noeud2;

		int joueur;// joueur peut etre 1, 2 ou 0. Avec 0 etant une case vide
		int estSurLeBord;
	}


	public Arete(int x, int y, int j, Gymkhana jeu){//x et y coordonneés, j le joueur et jeu le plateau dans lequel il doit etre placé
		super(x,y);
		joueur = j;



	}

	public boolean caseVide(){
		if (joueur == -1) {
			return true;
		}else{
			return false;
		}
	}

	public int getJoueur(){
		return joueur;
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
	public void afficherJoueurArete(){
		System.out.print(joueur);
	}

	public String toString(){
		return String.valueOf(joueur);
	}


}