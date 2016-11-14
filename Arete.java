import java.util.*;

class Arete{
	private Noeud noeud1;//chaque arete relie deux noeuds, qui pointe chacune sur 3 aretes
	private Noeud noeud2;

	private int coordx;
	private int coordy;

	private int joueur;// joueur peut etre 1, 2 ou -1. Avec -1 etant une case vide
	private int estSurLeBord;//0 n'est pas sur un bord, 1 est sur le bord 1, 2 est sur le bord 2

	public Arete(int x, int y, int j, Gymkhana jeu){//x et y coordonneés, j le joueur et jeu le plateau dans lequel il doit etre placé
		coordy = x;
		coordy = y;
		joueur = j;

		if (joueur != -1) {// si la case n'est pas vide, on crée réellement une Arete
			noeudExiste();
		}

	}

	public boolean caseVide(){
		if (joueur == -1) {
			
		}
	}

}
