import java.util.*;

class Noeud extends Case {

	private ClassesConnexite maClasse;

	public Noeud(){
	}

	public Noeud(int x, int y,int j, ClassesConnexite cl){
		super(x,y,j);
		maClasse =	cl;
	}

	public String toString(){
		if (super.getJoueur() == 1) {
			return "R";
		}else{
			return "b";
		}
	}

	public boolean jeSuisUnNoeud(){
		return true;
	}

}
