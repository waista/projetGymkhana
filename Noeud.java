import java.util.*;

class Noeud extends Case {
	private int joueur;// joueur peut etre 1, 2 ou -1. Avec -1 etant une case vide
	private Arete arete1;
	private Arete arete2;
	private Arete arete3;
	private Arete arete4;
	private Arete[] mesAretes;

	public Noeud(){

	}
	public Noeud(Arete monArete){

	}

	public String toString(){
		return "*";
	}
}