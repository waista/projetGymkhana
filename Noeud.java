import java.util.*;

class Noeud{
	private Arete arete1;
	private Arete arete2;
	private Arete arete3;
	private Arete arete4;

	public Noeud(){
		arete1 = null;
		arete2 = null;
		arete3 = null;
		arete4 = null;
	}

	public Noeud(Arete monArete){
		arete1 = monArete;
		arete2 = null;
		arete3 = null;
		arete4 = null;
	}

}
