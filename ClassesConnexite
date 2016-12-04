import java.util.*;

class ClassesConnexite{
	ArrayList<Case> mesCases;
	int numClasse;

	public ClassesConnexite(int id){// doit etre unique
		//possibilité de faire un id automatique, mais ceci devrait etre inutile dans notre cas
		//pour le gymkhana, ils seront tous initialisés au début de jeu, puis nous n'aurons plus a nous en occuper

		mesCases = new ArrayList<Case>();
		numClasse = id;
	}

	public int getID(){
		return numClasse;
	}

	public void rajoutCase(Case maCase){
		mesCases.add(maCase);
	}

	public void enleveCase(Case maCase){
		mesCases.remove(maCase);
	}

	public void changerToutesLesCases(ClassesConnexite nouvelleClasse){
		for (int i = 0; i < mesCases.size() ;i++ ) {
			mesCases.get(i).setClasse(nouvelleClasse);
		}
	}

	public void vider(){
		mesCases.clear();
	}

	public void afficherCases(){
		System.out.println(mesCases.size());
		for (int i = 0; i < mesCases.size() ;i++ ) {

			System.out.println(mesCases.get(i));
		}
	}


}
