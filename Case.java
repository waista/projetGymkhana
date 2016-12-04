import java.util.*;


class Case{
	// a supprimer 
	private int coordx;//private
	private int coordy;//private
	private ClassesConnexite maClasse;//private
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

	protected Case(int x,int y, int j, ClassesConnexite cl){
		coordx = x;
		coordy = y;
		joueur = j;
		maClasse =	cl;
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

	public ClassesConnexite getClasseConnexite(){
		return maClasse;
	}

	//fonction de test
	public int getIDClasseConnexite(){
		if (maClasse != null) {
			return maClasse.getID();
		}else{
			return -1;
		}
	}

	public void afficherJoueur(){
		System.out.print(joueur);
	}

	public void setClasse(ClassesConnexite nouvelleClasse){
		maClasse = nouvelleClasse;
	}


	public String toString(){
		if (joueur == 1) {
			return "R";
		}else{
			return "b";
		}
	}


	public boolean jeSuisUnNoeud(){
		return false;
	}

}
