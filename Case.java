import java.util.*;


abstract class Case{

	private int coordx;
	private int coordy;
	protected int joueur;

	protected Case(){
		int coordx;
		int coordy;
		int joueur;
	}

	protected Case(int x,int y, int j){
		coordx = x;
		coordy = y;
		joueur = j;
	}

	public int getCoordx(){
		return coordx;
	}

	public int getCoordy(){
		return coordy;
	}

	public int getJoueur(){
		return joueur;
	}

	public void afficherJoueur(){
		System.out.print(joueur);
	}

	// public ClassesConnexite getClasseConnexite(){
	// 	return maClasse;
	// }

	abstract public String toString();
	abstract public boolean jeSuisUnNoeud();

}
